package cc.momas.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.service.ITransferlogsService;

@Controller
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	private ITransferlogsService trSvc;
	
	@RequestMapping("transfer")
	public ModelAndView transfer(
			@RequestParam("outter")Integer outId,
			@RequestParam("inner")Integer inId,
			@RequestParam("money")Float money,
			@RequestParam("remark")String remark
			) {
		ModelAndView mv = new ModelAndView("redirect:/member/tomanage");
		if(money == null  || money < 0) {
			mv.addObject("msg","金额不能为空");
			return mv;
		}
		int count = trSvc.addTransferTest(outId,inId,money,remark);
		mv.addObject("msg", count > 0 ? "转账成功" : "转账失败");
		return mv;
	}
}
