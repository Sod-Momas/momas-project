package cc.momas.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.customer.ws.IShopWs;
import cc.momas.customer.ws.Users;
import cc.momas.dms.pojo.QpNoticebill;
import cc.momas.dms.pojo.QpNoticebillExample;
import cc.momas.dms.service.IQpNoticebillService;
import cc.momas.util.Pager;

@Controller
@RequestMapping("/notice")
public class NoticeBillController {

	@Autowired
	private IQpNoticebillService nbSvc;
	@Autowired
	private IShopWs shopWs ;

	@RequestMapping("query")
	@ResponseBody
	private Object querybyPager(QpNoticebill noticeBill,int rows,int page,Pager<QpNoticebill,QpNoticebillExample> pager) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(noticeBill);
		return nbSvc.queryByPager(pager);
	}
	
	
	
	@RequestMapping("findCustomerByTelephone")
	@ResponseBody
	private Users findCustomerByTelephone(String telephone) {
		Users u = shopWs.queryByPhone(telephone);
		return u;
	}
	//添加 新单
	@RequestMapping("add")
	private String add(QpNoticebill nb,Integer decidedzoneId) {
		nbSvc.save(nb,decidedzoneId);
		return "qupai/noticebill_add";
	}
	
//	//批量添加 新单
//	@RequestMapping("adds")
//	@ResponseBody
//	private int addBatch(QpNoticebill [] nbs,Integer decidedzoneId) {
//		return nbSvc.save(nbs,decidedzoneId);
//	}
	
	//操作工单
	@RequestMapping("noticebill")
	private void noticebill() {
		
	}
	
}
