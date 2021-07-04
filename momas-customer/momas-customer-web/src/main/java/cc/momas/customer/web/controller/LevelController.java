package cc.momas.customer.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Cardlevels;
import cc.momas.customer.pojo.CardlevelsExample;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.ICardlevelsService;

@Controller
@RequestMapping(value="/level")
public class LevelController {
	
	@Autowired
	private ICardlevelsService lvSvc;
	
	//添加等级
	@RequestMapping(value="addlevel")
	public ModelAndView addLevel(Cardlevels level) {
		if(10 <= level.getCardlevelsPercent() ) {
			level.setCardlevelsPercent(9.99F);
		}
		if(level.getCardlevelsPercent() < 0.01) {
			level.setCardlevelsPercent(0.01F);
		}
		if(10 <= level.getCardlevelsPoint() ) {
			level.setCardlevelsPoint(9.99F);
		}
		if(level.getCardlevelsPoint() < 0.01) {
			level.setCardlevelsPoint(0.01F);
		}
		int count = lvSvc.addLevel(level);
		return new ModelAndView("redirect:/level/manage","msg",count > 0 ? "添加成功" : "添加失败");
	}
	//删除等级
	@RequestMapping(value="deletelevel")
	@ResponseBody
	public Object deleteLevel(@RequestParam("cardlevelsId")int id) throws UnsupportedEncodingException {
		int count = lvSvc.deleteLevelById(id);
		return count > 0 ? "删除成功".getBytes("UTF-8") : "删除失败".getBytes("UTF-8");
	}
	//修改等级
	@RequestMapping(value="updatelevel")
	public ModelAndView updateLevel(Cardlevels level) {
		int count = lvSvc.updateLevel(level);
		return new ModelAndView("redirect:/level/manage","msg",count > 0 ? "修改成功" : "修改失败");
	}
	
	//分页查询
	@RequestMapping(value="query")
	@ResponseBody
	public Object queryByPager(@RequestParam(value="rows")int rows,@RequestParam(value="page")int pageNo,Cardlevels level) {
		Pager<Cardlevels, CardlevelsExample> pager = new Pager<>();
		pager.setEntity(level);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setPageNo(pageNo < 1 ? 1 : pageNo);
		pager = lvSvc.queryByPager(pager);
		return pager;
	}
	@RequestMapping("queryAll")
	@ResponseBody
	public Object queryAll() {
		List<Cardlevels> list = lvSvc.queryAll();
		return list;
	}
	
	//去管理页面,进入首页
	@RequestMapping(value="manage")
	public ModelAndView toManage() {
		return new ModelAndView("level/manage");
	}
	//去添加页面
	@RequestMapping(value="toAdd")
	public ModelAndView toAdd() {
		return new ModelAndView("level/add");
	}
	//去修改页面,根据id
	@RequestMapping(value="toEdit")
	public ModelAndView toUpdate(@RequestParam(value="cardlevelsId")int id) {
		Cardlevels level = lvSvc.queryById(id);
		return new ModelAndView("level/edit","level",level);
	}
	
}
