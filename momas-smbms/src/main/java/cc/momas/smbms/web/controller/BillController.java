package cc.momas.smbms.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.smbms.entity.Bill;
import cc.momas.smbms.entity.Provider;
import cc.momas.smbms.entity.User;
import cc.momas.smbms.service.IBillService;
import cc.momas.smbms.service.IProviderService;

@Controller
public class BillController {

	@Autowired
	private IBillService billSvc;
	
	@Autowired
	private IProviderService proSvc;
	
	/**添加订单*/
	@RequestMapping(value="/bill/add",method=RequestMethod.POST)
	public ModelAndView add(HttpSession session, Bill bill) {
		User user = (User) session.getAttribute("LOGIN_USER");
		bill.setCreatedBy(user.getUserId());
		bill.setCreationDate(new Date());
		int success =  billSvc.add(bill);
		return new ModelAndView("redirect:/bill","msg",success>0?"成功":"失败");
	}
	
	/**欢迎页面*/
	@RequestMapping("/bill")
	public ModelAndView billsManage() {
		List<Bill> blist = billSvc.queryAll();
		return new ModelAndView("bill", "billList", blist);
	}
	
	// TODO 后期要改post方法,使用AJAX技术,更安全,防止误操作
	/**删除订单*/
	@RequestMapping(value="/bill/del",method=RequestMethod.GET)
	public String deleteBill(Bill bill) {
		billSvc.delete(bill);
		return "redirect:/bill";
	}
	
	/**查看一个订单*/
	@RequestMapping(value="/bill/query",method=RequestMethod.GET)
	public ModelAndView queryOne(Integer id) {
		if(id == null) {
			return new ModelAndView("redirect:bill");
		}
		Bill bill= billSvc.queryById(id);
		return new ModelAndView("bill/query","bill",bill);
	}
	
	/**去添加订单*/
	@RequestMapping(value="/bill/add",method=RequestMethod.GET)
	public ModelAndView toAddBill() {
		List<Provider> plist = proSvc.queryAll();
		return new ModelAndView("bill/add","plist",plist);
	}
	
	/**去修改订单*/
	@RequestMapping(value="/bill/update",method=RequestMethod.GET)
	public ModelAndView toUpdate(Integer id) {
		if(id == null) {
			return new ModelAndView("error");
		}
		Bill bill = billSvc.queryById(id);
		List<Provider> plist = proSvc.queryAll();
		ModelAndView mv = new ModelAndView("bill/update");
		mv.addObject("bill",bill);
		mv.addObject("plist",plist);
		return mv;
	}
	
	/**修改订单*/
	@RequestMapping(value="/bill/update",method=RequestMethod.POST)
	public ModelAndView update(Bill bill) {
		if(null == bill || null == bill.getBillId()) {
			return new ModelAndView("error");
		}
		int success = billSvc.update(bill);
		return new ModelAndView("bill/add","msg",success>0?"成功":"失败");
	}
	

}
