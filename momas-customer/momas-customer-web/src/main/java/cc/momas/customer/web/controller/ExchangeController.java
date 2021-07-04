package cc.momas.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Exchanglogs;
import cc.momas.customer.pojo.ExchanglogsExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IExchanglogsService;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

	@Autowired
	private IExchanglogsService exlogSvc;
	
	
	//分页查询记录
	@RequestMapping("queryByCardIdOrMobile")
	@ResponseBody
	public Object queryByCardIdOrMobile(
			@RequestParam(value="id",required=false)String id,
			@RequestParam(value="rows")int rows,
			@RequestParam(value="page")int pageNo
			) {
		Pager<Exchanglogs, ExchanglogsExample>  pager = exlogSvc.queryOrderByMemberCardInPager(id,rows,pageNo);
		return pager;
	}
	
	
	
	//去积分兑换礼物
	@RequestMapping(value="exchange")
	@ResponseBody
	public Object exchange(Memcards card,String rows) {
		return exlogSvc.addLog(card,rows);
	}
	
	//去积分兑换礼物
	@RequestMapping(value="toexchange")
	public ModelAndView toManage() {
		return new ModelAndView("exchange/exchange");
	}
	//去积分返现
	@RequestMapping(value="toscoretomoney")
	public ModelAndView toscoretomoney() {
		return new ModelAndView("exchange/scoretomoney");
	}
	//去兑换历史记录
	@RequestMapping("tohistory")
	public ModelAndView toHistory() {
		return new ModelAndView("exchange/history");
	}
	
}
