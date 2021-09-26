package cc.momas.dms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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

import cc.momas.dms.pojo.BcRegion;
import cc.momas.dms.pojo.BcRegionExample;
import cc.momas.dms.service.IRegionService;
import cc.momas.util.FileUtil;
import cc.momas.util.Pager;
import cc.momas.util.PinYin4jUtil;

@RequestMapping(value="/region")
@Controller
public class RegionController {

	@Autowired
	private IRegionService regionSvc;

	//下拉列表的模糊查询
	@RequestMapping(value="listajax")
	@ResponseBody
	private Object regionAjax(@RequestParam(value="q",defaultValue="")String tj) {
		List<BcRegion> list = null;
		if(StringUtils.isNoneBlank(tj)) {
			list = regionSvc.findListByTj(tj);//根据输入的条件查询
		}else {
			list = regionSvc.findAll();//查询全部
		}
		return list;
	}
	
	@RequestMapping(value="update")
	//修改 region
	private String updteRegion(BcRegion region) {
		regionSvc.updateById(region);
		return "redirect:/index/base/region";
	}
	
	//查询region
	@RequestMapping(value="queryByPager")
	@ResponseBody
	private Object queryByPager(Pager<BcRegion, BcRegionExample> pager,int page,int rows) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager = regionSvc.queryByPager(pager);
		return pager;
	}
	
	//添加 region
	@RequestMapping(value="add")
	private String addRegion(BcRegion region) {
		String info = region.getProvince() + region.getCity() + region.getDistrict();
		String [] headByString = PinYin4jUtil.getHeadByString(info);
		String shortcode = StringUtils.join(headByString);
		//城市编码 -->>hubei
		String citycode = PinYin4jUtil.hanziToPinyin(region.getCity(),"");
		
		region.setShortcode(shortcode);
		region.setCitycode(citycode);
		regionSvc.save(region);
		return "redirect:/index/base/region";
	}
	
	//删除region
	@RequestMapping(value="delete/{ids}")
	private String deleteBatch(@PathVariable("ids")String ids) {
		if(ids != null && 0 < ids.length()) {
			regionSvc.deleteBatch(ids);
		}
		return "redirect:/index/base/region";
	}
	
	//导入Excel
	@RequestMapping(value="importExcel")
	@ResponseBody
	private Object importExcel(@RequestParam("file")MultipartFile excelFile) {
		//文件转换成列表的代码 
		List<BcRegion> regionlist = new ArrayList<>();
		//使用POI解析Excel文件 
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
			int id = (int)row.getCell(0).getNumericCellValue();
			String provice = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			//包装成一个Region对象
			BcRegion region = new BcRegion(id,provice,city,district,postcode,null,null);
			
			provice = provice.substring(0, provice.length()-1);
			city = city.substring(0, city.length()-1);
			district = district.substring(0, district.length()-1);
			
			String info = provice+city+district;
			String [] headByString = PinYin4jUtil.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//城市编码 -->>hubei
			String citycode = PinYin4jUtil.hanziToPinyin(city,"");
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			regionlist.add(region);
		}
		return regionSvc.importExcel(regionlist);
	}

	//导出Excel
	@RequestMapping("exportExcel")
	private void exportExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<BcRegion> list = regionSvc.queryAll();
		
		//第一步创建一个webbook，创建一个Excel文件
		HSSFWorkbook wb=new HSSFWorkbook();
		
		//第二，在webbook添加一个sheet，在Excel文件中的sheet
		HSSFSheet sheet=wb.createSheet("Sheet1");
		
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("区域编号");
		row.createCell(1).setCellValue("省");
		row.createCell(2).setCellValue("市");
		row.createCell(3).setCellValue("区");
		row.createCell(4).setCellValue("邮编");
		row.createCell(5).setCellValue("短码");
		row.createCell(6).setCellValue("城市简码");
		row.createCell(7).setCellValue("城市名");

		//第五步，写入实体
		for (int i = 1; i < list.size(); i++) {
			BcRegion reg = list.get(i);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(reg.getRegionId());
			row.createCell(1).setCellValue(reg.getProvince());
			row.createCell(2).setCellValue(reg.getCity());
			row.createCell(3).setCellValue(reg.getDistrict());
			row.createCell(4).setCellValue(reg.getPostcode());
			row.createCell(5).setCellValue(reg.getShortcode());
			row.createCell(6).setCellValue(reg.getCitycode());
			row.createCell(7).setCellValue(reg.getName());
		}
		//第六步，下载文件
		String filename = "区域数据.xls";
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
}
