package cc.momas.customer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("statistics")
@Controller
public class StatisticsController {

	// 去快速消费统计
	@RequestMapping("fastconsum")
	public ModelAndView fastconsum() {

		return new ModelAndView("statistics/fastconsum");
	}

	// 去会员消费情况统计
	@RequestMapping("consums")
	public ModelAndView consums() {

		return new ModelAndView("statistics/consums");
	}

	// 去减积分统计
	@RequestMapping("removescore")
	public ModelAndView removescore() {

		return new ModelAndView("statistics/removescore");
	}

	// 去积分返现统计
	@RequestMapping("score")
	public ModelAndView score() {

		return new ModelAndView("statistics/score");
	}

	// 去礼品兑换统计
	@RequestMapping("giftex")
	public ModelAndView giftex() {

		return new ModelAndView("statistics/giftex");
	}

}
