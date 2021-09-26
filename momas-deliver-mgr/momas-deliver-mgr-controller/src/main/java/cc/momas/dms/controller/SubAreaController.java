package cc.momas.dms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
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

import cc.momas.dms.pojo.BcSubarea;
import cc.momas.dms.pojo.BcSubareaExample;
import cc.momas.dms.pojo.ProvCount;
import cc.momas.dms.service.ISubAreaService;
import cc.momas.util.FileUtil;
import cc.momas.util.Pager;

@Controller
@RequestMapping(value="/subarea")
public class SubAreaController {

	@Autowired
	private ISubAreaService subSvc;
	
	
	//根据定区id查询
	@RequestMapping("queryByDecidedId")
	@ResponseBody
	private Object queryByDecidedId(Integer id){
		if(null == id) {
			return "rows:\"null\"";
		}
		Pager<BcSubarea,BcSubareaExample>pager = new Pager<BcSubarea,BcSubareaExample>();
		pager.setList( subSvc.queryByDecidedId(id));
		return pager;
	}
	
	// 饼图
	/* findSubareasGroupByProvince */
	@RequestMapping("findSubareasGroupByProvince")
	@ResponseBody
	public Object findSubareasGroupByProvince() {
		List<ProvCount> list = subSvc.findSubareasGroupByProvince();
		return list;
	}

	
	//查询未被关联的分区
	@RequestMapping(value="queryNotBeAssociated")
	@ResponseBody
	private Object queryNotBeAssociated() {
		List<BcSubarea> list =  subSvc.queryNotBeAssociated();
		return list;
	}
	
	
	//添加
	@RequestMapping(value="add")
	private String addSubArea(BcSubarea sub) {
		subSvc.add(sub);
		return "base/subarea";
	}

	//修改
	@RequestMapping("update")
	private String upateSubAre(BcSubarea sub) {
		subSvc.update(sub);
		return "base/subarea";
	}
	
	//批量删除
	@RequestMapping("delete/{ids}")
	private String deleteSubArea(@PathVariable("ids")String ids) {
		subSvc.deleteBatch(ids);
		return "base/subarea";
	}
	
	//分页查询
	@RequestMapping(value="queryByPager")
	@ResponseBody
	private Object queryByPager(Pager<BcSubarea, BcSubareaExample> pager,int page,int rows,BcSubarea subarea) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(subarea);
		return subSvc.queryByPager(pager);
	}
	
	//导出Excel
	@RequestMapping(value="exportExcel")
	private void exportExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<BcSubarea> list = subSvc.queryAll();
		
		//第一步创建一个webbook，创建一个Excel文件
		HSSFWorkbook wb=new HSSFWorkbook();
		
		//第二，在webbook添加一个sheet，在Excel文件中的sheet
		HSSFSheet sheet=wb.createSheet("Sheet1");
		
		//第三步，在sheet中添加表示第0行
		//第四步，创建单元格
		HSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("分区编号");
		row.createCell(1).setCellValue("定区编号");
		row.createCell(2).setCellValue("区域编号");
		row.createCell(3).setCellValue("关键字");
		row.createCell(4).setCellValue("起始号");
		row.createCell(5).setCellValue("终止号");
		row.createCell(6).setCellValue("单双号");
		row.createCell(7).setCellValue("位置信息");
		row.createCell(8).setCellValue("省市区");

		//第五步，写入实体
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i+1);
			BcSubarea sub = list.get(i);
			row.createCell(0).setCellValue(sub.getSubareaId());
			row.createCell(1).setCellValue(String.valueOf(sub.getDecidedzoneId()));
			row.createCell(2).setCellValue(String.valueOf(sub.getRegionId()));
			row.createCell(3).setCellValue(sub.getAddresskey());
			row.createCell(4).setCellValue(sub.getStartnum());
			row.createCell(5).setCellValue(sub.getEndnum());
			row.createCell(6).setCellValue(sub.getSingle());
			row.createCell(7).setCellValue(sub.getPosition());
			row.createCell(8).setCellValue(null == sub.getRegion() ? "" : sub.getRegion().getName());
		}
		//第六步，下载文件
		String filename = "分区数据.xls";
		String contentType = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(contentType);
		ServletOutputStream out = response.getOutputStream();
		
		//获取客户端浏览器类型
		String agent = request.getHeader("User-Agent");
		filename = FileUtil.encodeDownloadFilename(filename,agent);
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		wb.write(out);
		return ;
	}
	
	

	@RequestMapping("importExcel")
	private String importExcel(@RequestParam("file")MultipartFile excelFile) {
		List<BcSubarea> sublist = new ArrayList<>(0);
		
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(excelFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//根据名称获得指定Sheet对象
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if(rowNum == 0) {
				continue;
			}
			Integer subareaId = Integer.valueOf(row.getCell(0).getStringCellValue());
			Integer decidedzoneId= Integer.valueOf(row.getCell(1).getStringCellValue());
			Integer regionId =  Integer.valueOf(row.getCell(2).getStringCellValue());
			String addresskey = row.getCell(3).getStringCellValue();
			String startnum = row.getCell(4).getStringCellValue();
			String endnum = row.getCell(5).getStringCellValue();
			String single = row.getCell(6).getStringCellValue();
			String position = row.getCell(7).getStringCellValue();
			
			//包装成一个Region对象
			BcSubarea subarea = new BcSubarea(subareaId, decidedzoneId, regionId, addresskey, startnum, endnum, single, position, null, null);
			sublist.add(subarea);
		}
		subSvc.importExcel(sublist);
		return "base/subarea";
	}
}
