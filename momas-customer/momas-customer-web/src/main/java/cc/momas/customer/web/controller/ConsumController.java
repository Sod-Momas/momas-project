package cc.momas.customer.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Consumeorders;
import cc.momas.customer.pojo.ConsumeordersExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IConsumeordersService;
import cc.momas.customer.service.IMemcardsService;

@Controller
@RequestMapping("/consum")
public class ConsumController {

	@Autowired
	private IConsumeordersService orderSvc;
	@Autowired
	private IMemcardsService cardSvc;
	
	
	//分页查询记录
	@RequestMapping("queryByCardIdOrMobile")
	@ResponseBody
	public Object queryByCardIdOrMobile(
			@RequestParam(value="id",required=false)String id,
			@RequestParam(value="rows")int rows,
			@RequestParam(value="page")int pageNo
			) {
		Pager<Consumeorders, ConsumeordersExample>  pager = orderSvc.queryOrderByMemberCardInPager(id,rows,pageNo);
		return pager;
	}
	
	//会员减积分
	@RequestMapping("removescore")
	@ResponseBody
	public Object removeScore(
			@RequestParam("memcardsId")int memcardsId,
			@RequestParam("ori_score")float ori_score,
			@RequestParam("score")float score,
			@RequestParam("remark")String remark
			) {
		Consumeorders order = new Consumeorders();
		order.setMemcardsCardid(String.valueOf(memcardsId));
		order.setConsumeordersRemark("会员减积分");
		order.setConsumeordersTotalmoney(score);
		order.setConsumeordersCreatetime(new Date());
		int count = orderSvc.add(order);
		
		Memcards m = new Memcards();
		m.setMemcardsId(memcardsId);
		m.setMemcardsPoint((int) (ori_score - score));
		count += cardSvc.updateMemberCard(m);
		return count > 1 ? "成功" : "失败";
		
	}
	
	/**
	 * 快速消费
	 *  
	 * @param id 消费的会员id
	 * @param integral 累加的积分 
	 * @param fee 折后总金额
	 * @param money 消费金额
	 * @return
	 */
	@RequestMapping("fastconsum")
	@ResponseBody
	public Object fastconsum(
			@RequestParam("memcardsId")int id,
			@RequestParam("integral")float integral,
			@RequestParam("fee")float fee,
			@RequestParam("money")float money
			) {
		Consumeorders order = new Consumeorders();
		//order.setConsumeordersId();
		order.setMemcardsId(id);
		order.setConsumeordersTotalmoney(money);
		order.setConsumeordersDiscountmoney(fee);
		order.setConsumeordersGavepoint((int)integral);
		order.setConsumeordersRemark("快速消费");
		int count = orderSvc.add(order);
		//这里需要对该会员进行操作,减少金钱增加积分什么的
		Memcards card = cardSvc.queryById(id);
		card.setMemcardsPoint((int) (card.getMemcardsPoint() + integral));
		card.setMemcardsTotalmoney(card.getMemcardsTotalmoney() == null ? money : card.getMemcardsTotalmoney() + money);
		card.setMemcardsTotalcount(card.getMemcardsTotalcount() == null ? 1 : card.getMemcardsTotalcount() + 1);
		count += cardSvc.updateMemberCard(card);
		return count > 1 ? "添加成功" : "添加失败";
	}
	
	//去快速消费
	@RequestMapping("tofastconsum")
	public ModelAndView tomanage() {
		return new ModelAndView("consum/fastconsum");
	}
	
	//去会员减积分
	@RequestMapping("toremovescore")
	public ModelAndView toRemoveScore() {
		return new ModelAndView("consum/removeScore");
	}
	//去查历史消费
	@RequestMapping("tohistory")
	public ModelAndView toHistory() {
		return new ModelAndView("consum/history");
	}
}
