package cc.momas.customer.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Cardlevels;
import cc.momas.customer.pojo.Categories;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.MemcardsExample;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.ICardlevelsService;
import cc.momas.customer.service.ICategoriesService;
import cc.momas.customer.service.IMemcardsService;
import cc.momas.customer.web.util.DateConvertUtil;
import cc.momas.customer.web.util.ExcelUtil;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private IMemcardsService cardSvc;
	@Autowired
	private ICardlevelsService lvSvc;
	@Autowired
	private ICategoriesService cateSvc;
	
	//根据卡号或者手机号查询用户
	@RequestMapping("queryByCardIdOrMobile")
	@ResponseBody
	private Object queryByCardIdOrMobile(@RequestParam("id")String id) throws UnsupportedEncodingException {
		Memcards u = null;
		u = cardSvc.queryByCardId(id);
		if(u == null) {
			u =cardSvc.queryByMobile(id);
		}
		return u == null ? "null" : u;
	}
	
	//导出Excel
	@RequestMapping("export")
	private void export(HttpServletRequest request,HttpServletResponse response) {
		List<Memcards> list = cardSvc.queryAll();
		//第一步创建一个webbook，电影一个Ecel文件
		HSSFWorkbook wb=new HSSFWorkbook();
		//第二，在webbook添加一个sheet，在Excel文件中的sheet
		HSSFSheet sheet=wb.createSheet("会员信息表");
		//设置单元宽度
		sheet.setColumnWidth(0, 256*18+184);
		sheet.setColumnWidth(1, 256*18+184);
		sheet.setColumnWidth(2, 256*18+184);
		sheet.setColumnWidth(3, 256*18+184);
		sheet.setColumnWidth(4, 256*18+184);
		sheet.setColumnWidth(5, 256*18+184);
		sheet.setColumnWidth(6, 256*18+184);
		sheet.setColumnWidth(7, 256*18+184);
		//第三步，在sheet中添加表示第0行
		HSSFRow row=sheet.createRow(0);
		//第四步，创建单元格
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//创建一个居中格
		
		HSSFCell cell=row.createCell(0);
		
		cell.setCellValue("会员卡号");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("性别");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("电话");
		cell.setCellStyle(style);
		cell=row.createCell(4);
		cell.setCellValue("月");
		cell.setCellStyle(style);
		cell=row.createCell(5);
		cell.setCellValue("日");
		cell.setCellStyle(style);
		cell=row.createCell(6);
		cell.setCellValue("登记时间");
		cell.setCellStyle(style);
		cell=row.createCell(7);
		cell.setCellValue("会员等级");
		cell.setCellStyle(style);
		//第五步，写入实体
		for (int i = 0; i < list.size(); i++) {
			row=sheet.createRow(i+1);
			Memcards mem=list.get(i);
			row.createCell(0).setCellValue(mem.getMemcardsCardid());
			row.createCell(1).setCellValue(mem.getMemcardsName());
			row.createCell(2).setCellValue(mem.getMemcardsSex());
			row.createCell(3).setCellValue(mem.getMemcardsMobile());
			row.createCell(4).setCellValue(	mem.getMemcardsBirthdayMonth()	);
			row.createCell(5).setCellValue(	mem.getMemcardsBirthdayDay()	);
			row.createCell(6).setCellValue(mem.getMemcardsCreatetime()!=null? new SimpleDateFormat("yyyy-MM-dd").format(mem.getMemcardsCreatetime()):""	);
			row.createCell(7).setCellValue(	mem.getCardlevels().getCardlevelsLevelname()	);
		}
		//第六步，下载文件
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		String filename=cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1 )+cal.get(Calendar.DAY_OF_MONTH) + "_会员列表.xls";
		try {
			filename=encoding4ChineseDownload(request,filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content_disposotion", filename);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content_disposotion", "attachment;filename="+filename);
		response.setHeader("Pragme", "No-cache");
		OutputStream outputStream=null;
		try {
			outputStream=response.getOutputStream();
			wb.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				outputStream.flush();
			} catch (IOException e2) {
				 e2.printStackTrace();
			}
			
			try {
				 outputStream.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ;
	}

	//导入Excel
	@RequestMapping("import")
	public String importExcel(HttpServletRequest request,@RequestParam(value="file",required=false)MultipartFile excelFile) {
		/*文件上传	*/
		File targetFile = null;
        if (excelFile != null) {
            String targetDir = request.getSession().getServletContext().getRealPath("/upload/excel");
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            String filename = cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1)
                    + cal.get(Calendar.DAY_OF_MONTH) + "_会员列表.xls";

            File filerDir = new File(targetDir);
            if (filerDir.exists()) {
                filerDir.delete();
            }
            filerDir.mkdirs();
            targetFile = new File(filerDir, filename);
            try {
                excelFile.transferTo(targetFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        } 
        /*读取上传文件*/
		List<List<Object>> objects = null;
		try {
			objects = ExcelUtil.getBankListByExcel(new FileInputStream(targetFile), targetFile.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		 try {
			List<Memcards> memcardsList = transferToMemberCards(objects);
			 cardSvc.importExcel(memcardsList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		return "member/manage";
	}
	
	private List<Memcards> transferToMemberCards(List<List<Object>> objects) throws ParseException{
		List<Memcards> memberCardList = new ArrayList<>();
		List <Object> lo = null;
		for (int i = 0; i < objects.size(); i++) {
			lo = objects.get(i);
			
			Memcards m = new Memcards();
			m.setMemcardsCardid((String) lo.get(0));
			m.setMemcardsName((String) lo.get(1));
			m.setMemcardsSex((String) lo.get(2));
			m.setMemcardsMobile((String) lo.get(3));
			m.setMemcardsBirthdaytype("公历".equals(lo.get(4)) ? 1 : 0);
			m.setMemcardsBirthdayMonth(Integer.parseInt((String) lo.get(5)));
			m.setMemcardsBirthdayDay(Integer.parseInt((String) lo.get(6)));
			m.setMemcardsCreatetime(DateConvertUtil.getDate((String)lo.get(7),"yyyy-MM-dd"));
			m.setCardlevelsId(Integer.parseInt((String)lo.get(8)));
			m.setMemcardsState(Integer.parseInt((String)lo.get(10)));
			m.setMemcardsTotalcount(0);
			m.setMemcardsTotalmoney(0F);
			memberCardList.add(m);
		}
		return memberCardList;
	}
	
	
	
	
		
	//会员换卡
	@RequestMapping("exchangecard")
	private ModelAndView exchangeCard(Memcards card,String memcardsCardid,String newpassword) {
		int count = -1;
		Memcards oldcard = cardSvc.queryById(card.getMemcardsId());
		if(oldcard == null) {
			return null;
		}
		if(oldcard.getMemcardsPassword().equals(card.getMemcardsPassword())) {
			card.setMemcardsId(oldcard.getMemcardsId());
			count = cardSvc.updateMemberCard(card);
		}
		
		return new ModelAndView("redirect:/member/tomanage","msg", count > 0 ? "添加成功" : "添加失败");
	}
	
	//添加会员
	@RequestMapping("addmember")
	public ModelAndView addmember(Memcards card) {
		card.setMemcardsCreatetime(new Date());
		card.setMemcardsMoney(0.0F);//累计消费
		card.setMemcardsTotalcount(0);//累计消费次数
		int count = cardSvc.addMemberCard(card);
		return new ModelAndView("redirect:/member/tomanage","msg",count > 0 ? "添加成功" : "添加失败");
	}
	
	//删除会员
	@RequestMapping("deletemember")
	@ResponseBody
	public Object deleteMember(@RequestParam("memcardsId")int memcardsId) throws UnsupportedEncodingException {
		int count = cardSvc.deleteById(memcardsId);
		return count > 0 ? "删除成功".getBytes("UTF-8") : "删除失败".getBytes("UTF-8");
	}
	
	//修改会员
	@RequestMapping("updatemember")
	public ModelAndView updateMember(Memcards card) {
		int count = cardSvc.updateMemberCard(card);
		return new ModelAndView("redirect:/member/tomanage","msg",count > 0 ? "修改成功" : "修改失败");
	}
	
	//根据id查询
	@RequestMapping("queryById")
	@ResponseBody
	public Object qeuryById(@RequestParam("memcardsRefererid")Integer memcardsRefererid) {
		Memcards card = cardSvc.queryById(memcardsRefererid);
		return card;
	}
	//根据卡号查询
	@RequestMapping("queryByCardId")
	@ResponseBody
	public Object queryByCardId(@RequestParam("memcardsCardid")String memcardsCardid) {
		Memcards card = cardSvc.queryByCardId(memcardsCardid);
		return card;
	}
	//分页查询
	@RequestMapping("query")
	@ResponseBody
	public Object queryByPager(@RequestParam(value="rows")int rows,@RequestParam(value="page")int pageNo,Memcards card) {
		Pager<Memcards, MemcardsExample> pager = new Pager<>();
		pager.setEntity(card);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setPageNo(pageNo < 1 ? 1 : pageNo);
		pager = cardSvc.queryByPager(pager);
		return pager;
	}
	
	//进入首页
	@RequestMapping("tomanage")
	public ModelAndView tomanage() {
		ModelAndView mv = new ModelAndView("member/manage");
		List<Cardlevels> levellist = lvSvc.queryAll();
		List<Categories> statelist = cateSvc.queryAllCardState();
		mv.addObject("levels", levellist);
		mv.addObject("states",statelist);
		return mv;
	}

	//去添加
	@RequestMapping("toAdd")
	public ModelAndView toAdd() {
		ModelAndView mv = new ModelAndView("member/add");
		List<Cardlevels> levellist = lvSvc.queryAll();
		List<Categories> statelist = cateSvc.queryAllCardState();
		mv.addObject("levels", levellist);
		mv.addObject("states",statelist);
		return mv; 
	}
	//去修改
	@RequestMapping("toEdit")
	public ModelAndView toEdit(@RequestParam("memcardsId")int memcardsId) {
		ModelAndView mv = new ModelAndView("member/edit");
		Memcards card = cardSvc.queryById(memcardsId);
		List<Cardlevels> levellist = lvSvc.queryAll();
		List<Categories> statelist = cateSvc.queryAllCardState();
		mv.addObject("levels", levellist);
		mv.addObject("states",statelist);
		mv.addObject("card",card);
		return mv;
	}
	//去挂失/锁定
	@RequestMapping("toLock")
	public ModelAndView toLock(@RequestParam("memcardsId")int memcardsId) {
		ModelAndView mv = new ModelAndView("member/lock");
		Memcards card = cardSvc.queryById(memcardsId);
		List<Categories> statelist = cateSvc.queryAllCardState();
		mv.addObject("states",statelist);
		mv.addObject("card",card);
		return mv;
	}
	//去转账
	@RequestMapping("toTransfer")
	public ModelAndView toTransfer(@RequestParam("memcardsId")int memcardsId) {
		ModelAndView mv = new ModelAndView("member/transfer");
		Memcards card = cardSvc.queryById(memcardsId);
		mv.addObject("card",card);
		return mv;
	}
	//去换卡
	@RequestMapping("toExchange")
	public ModelAndView toExchange(@RequestParam("memcardsId")int memcardsId) {
		ModelAndView mv = new ModelAndView("member/exchangecard");
		Memcards card = cardSvc.queryById(memcardsId);
		mv.addObject("card",card);
		return mv;
	}

	private String encoding4ChineseDownload(HttpServletRequest request, String pfilename) throws UnsupportedEncodingException {
		String filename = null;
		String agent = request.getHeader("USER-AGENT");
		if (null != agent) {
			if (-1 != agent.indexOf("Firefox")) {
				filename = "=?UTF-8?B?"
						+ (new String(Base64.encodeBase64(pfilename.getBytes("UTF-8"))))
						+ "?=";
			} else if (-1 != agent.indexOf("Chrome")) {
				filename = new String(pfilename.getBytes(), "ISO8859-1");
			} else {
				filename = URLEncoder.encode(pfilename, "Utf-8");
				filename = filename.replace("+", "%20");
			}
		} else {
			filename = pfilename;
		}

		return filename;
	}
}
