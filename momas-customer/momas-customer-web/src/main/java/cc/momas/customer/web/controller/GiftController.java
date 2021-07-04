package cc.momas.customer.web.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Exchanggifts;
import cc.momas.customer.pojo.ExchanggiftsExample;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IExchanggiftsService;

@Controller
@RequestMapping(value="/gift")
public class GiftController {
	
	@Autowired
	private IExchanggiftsService giftSvc;
	
	//添加礼品
	@RequestMapping(value="addgift")
	public ModelAndView addGift(Exchanggifts gift) {
		gift.setExchanggiftsExchangnum(0);
		int count = giftSvc.addGift(gift);
		return new ModelAndView("redirect:/gift/tomanage","msg",count > 0 ? "添加成功" : "添加失败");
	}
	//删除礼品
	@RequestMapping(value="deletegift")
	@ResponseBody
	public Object deletefgift(@RequestParam(value="exchanggiftsId")int id) throws UnsupportedEncodingException {
		int count = giftSvc.deleteById(id);
		return count > 0 ? "删除成功".getBytes("UTF-8") : "删除失败".getBytes("UTF-8");
	}
	//修改礼品
	@RequestMapping(value="updategift")
	public ModelAndView editGift(Exchanggifts gift) {
		int count = giftSvc.updateGift(gift);
		return new ModelAndView("redirect:/gift/tomanage","msg",count > 0 ? "修改成功" : "修改失败");
	}
	
	//分页查询
	@RequestMapping(value="query")
	@ResponseBody
	public Object queryByPage(Exchanggifts gift,@RequestParam(value="page") int page,@RequestParam("rows")int rows){
		Pager<Exchanggifts, ExchanggiftsExample> pager = new Pager<>();
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(gift);
		pager = giftSvc.queryByPager(pager);
		return pager;
	}
	
	//进入首页
	@RequestMapping(value="tomanage")
	public ModelAndView index() {
		return new ModelAndView("gift/manage");
	}
	
	//去添加礼品
	@RequestMapping(value="toAdd")
	public ModelAndView toAdd() {
		return new ModelAndView("gift/add");
	}
	//去修改一个礼品,根据id
	@RequestMapping(value="toEdit")
	public ModelAndView toUpdate(@RequestParam(value="exchanggiftsId")int id) {
		Exchanggifts gift = giftSvc.queryById(id);
		return new ModelAndView("gift/edit","gift",gift);
	}

}
