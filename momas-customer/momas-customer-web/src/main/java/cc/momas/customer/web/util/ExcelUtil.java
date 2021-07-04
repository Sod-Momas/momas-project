package cc.momas.customer.web.util;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static final String excel2003L = ".xls";
	private static final String excel2007U = ".xlsx";

	/**
	 * 描述:获取IO流中的数据,转化成List<List<Object>>对象
	 * @param inputStream
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> getBankListByExcel(FileInputStream inputStream, String fileName) throws Exception {
		List<List<Object>> list = null;
		
		//创建Excel工作薄
		Workbook workbook = getWorkbook(inputStream,fileName);
		if(null == workbook) {
			throw new Exception("创建Excel工作薄为空");
		}
		
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		
		list = new ArrayList<List<Object>>();
		//遍历Excel中所有的sheet
		for(int i = 0; i < workbook.getNumberOfSheets();i++) {
			sheet = workbook.getSheetAt(i);
			if(sheet == null) {continue;}
			
			//遍历当前sheet所有行
			for(int j = sheet.getFirstRowNum();j <= sheet.getLastRowNum();j++) {
				row = sheet.getRow(j);
				if(row == null || row.getFirstCellNum() == j || "会员卡号".equals(row.getCell(0).getStringCellValue())) {
					continue;
				}
				
				//遍历所有的列
				List<Object> li = new ArrayList<Object>();
				for(int y = row.getFirstCellNum();y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					li.add(getCellValue(cell));
				}
				list.add(li);
			}
		}
		//workbook.close();
		return list;
	}


	/**
	 * 根据文件后缀,自动识别上传的文件版本
	 * 
	 * @param fileInputStream
	 * @param fileName
	 * @return
	 * @throws Exception 
	 */
	private static Workbook getWorkbook(FileInputStream fileInputStream, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf('.'));
		if(excel2003L.equals(fileType)) {
			wb = new HSSFWorkbook(fileInputStream);//2003 excel
		}else if(excel2007U.equals(fileType)) {
			wb = new XSSFWorkbook(fileInputStream);//2007 excel
		}else {
			throw new Exception("文件格式错误!");
		}
		return wb;
	}
	
	//获取cell里的数据
	public static Object getCellValue(Cell cell) {
	    if(cell == null) {
	    	return "";
	    }
		Object value=null;
		DecimalFormat df=new DecimalFormat("0");//格式number String 字符串
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		DecimalFormat df2=new DecimalFormat("0.00");
		switch (cell.getCellType()) {//字符串
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:// 数值类型
			value = df.format(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN://
			value = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:// 空白
			value = "";
			break;
		}
		return value;
	}



}
