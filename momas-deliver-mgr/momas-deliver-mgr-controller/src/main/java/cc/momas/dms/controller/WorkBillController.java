package cc.momas.dms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cc.momas.dms.pojo.QpWorkbill;
import cc.momas.dms.pojo.QpWorkbillExample;
import cc.momas.dms.service.IWorkBillService;
import cc.momas.util.FileUtil;
import cc.momas.util.Pager;

@Controller
@RequestMapping("/workbiil")
public class WorkBillController {

	@Autowired
	private IWorkBillService wbSvc;
	
	/*
	 * 工作单Excel模板下载
	 */
	@RequestMapping("templet")
	private void getTemplet(@RequestParam(value="filename",defaultValue="模板") String filename,HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建Excel文件(工作簿)
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet();
		//创建行
		HSSFRow row = sheet.createRow(0);
		//创建格子
		int count = 0;
		row.createCell(count++).setCellValue("提醒单单号");
		row.createCell(count++).setCellValue("员工编号");
		row.createCell(count++).setCellValue("工单类型");
		row.createCell(count++).setCellValue("取件状态");
		row.createCell(count++).setCellValue("追单次数");
		row.createCell(count++).setCellValue("备注");
		
		//文件名有可能乱码,用自定义方法解决
		filename = FileUtil.encodeDownloadFilename(filename, request.getHeader("User-Agent"));
		//设置输出类型为Excel
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		workbook.write(response.getOutputStream());
	}
	
	//工作单指导入
	@RequestMapping("importExcel")
	@ResponseBody
	private String importExcel(@RequestParam("file") MultipartFile file) {
		// 准备好一个工作簿
		HSSFWorkbook wb = null;
		try {
			// InputStream is = new FileInputStream(file); 
			wb = new HSSFWorkbook(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return "文件内容错误,请下载模板重新填写";
		}
		//获取Sheet
		HSSFSheet sheet = wb.getSheetAt(0);
		//装进List里面
		List<QpWorkbill> list = new ArrayList<>(20);
		for (Row row : sheet) {
			if(row.getRowNum() == 0) {
				continue;
			}
			QpWorkbill workbill = new QpWorkbill(
					null, 
					//通知单号
					(int)row.getCell(0).getNumericCellValue(),
					//员工编号
					(int)row.getCell(1).getNumericCellValue(),
					//工单类型
					row.getCell(2).getStringCellValue(),
					//取件状态
					row.getCell(3).getStringCellValue(),
					//取件日期
					new Date(),
					// 追单次数
					(int)row.getCell(4).getNumericCellValue(),
					//备注
					row.getCell(5).getStringCellValue(),
					null);
			list.add(workbill);
//			对照
//			row.createCell(count++).setCellValue("提醒单单号");
//			row.createCell(count++).setCellValue("员工编号");
//			row.createCell(count++).setCellValue("工单类型");
//			row.createCell(count++).setCellValue("取件状态");
//			row.createCell(count++).setCellValue("追单次数");
//			row.createCell(count++).setCellValue("备注");
		}
		
		int count = wbSvc.addBatch(list);
		System.out.println("一共导入了" + count + "条数据");
		return "导入成功,一共导入了" + count + "数据";
	}
	
	
	@RequestMapping("query")
	@ResponseBody
	private Pager<QpWorkbill, QpWorkbillExample> querybyPager(QpWorkbill workBill,int rows,int page,Pager<QpWorkbill,QpWorkbillExample> pager) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(workBill);
		return wbSvc.queryByPager(pager);
	}
	
	//添加
	@RequestMapping(value="add")
	private int add(QpWorkbill wb) {
		// wb.setStaff(null);
		// wb.setStaffId(0);
		wb.setType(QpWorkbill.TYPE_1);//新单
		wb.setPickstate(QpWorkbill.PICKSTATE_NO);//未取件
		wb.setBuildtime(new Date());
		wb.setAttachbilltimes(0);//追单次数
		return wbSvc.save(wb);
	}
	
	/*追单  zuidan*/
	@RequestMapping("repeat/{ids}")
	public String zuidan(@PathVariable("ids") String ids) {
		wbSvc.updateRepeat(ids);
		return  "qupai/noticebill";
	}
	
	/*毁单*/
	@RequestMapping("cancel/{ids}")
	public String xiaohui(@PathVariable("ids") String ids) {
		wbSvc.updateCancel(ids);
		return  "qupai/noticebill";
	}
	
}
