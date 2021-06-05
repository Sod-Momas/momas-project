package cc.momas.smbms.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.smbms.entity.Provider;
import cc.momas.smbms.entity.User;
import cc.momas.smbms.service.IProviderService;

@Controller
public class ProviderController {

	@Autowired
	private IProviderService proSvc;
	
	/**欢迎页*/
	@RequestMapping("/provider")
	public ModelAndView welcome() {
		List<Provider> plist = proSvc.queryAll();
		return new ModelAndView("provider", "providerList", plist);
	}
	
	/**添加供应商*/
	@RequestMapping(value="/provider/add",method=RequestMethod.POST)
	public ModelAndView add(HttpSession session, Provider provider) {
		User user = (User) session.getAttribute("LOGIN_USER");
		provider.setCreatedBy(user.getUserId());
		provider.setCreationDate(new Date());
		int success = proSvc.add(provider);
		return new ModelAndView("redirect:/provider","msg",success>0?"成功":"失败");
	}
	
	// TODO 后期要改post方法,使用AJAX技术,更安全,防止误操作
	/**删除供应商*/
	@RequestMapping(value="/provider/del",method=RequestMethod.GET)
	public ModelAndView delete(Provider provider) {
		int success = proSvc.delete(provider);
		return new ModelAndView("redirect:/provider","msg",success>0?"成功":"失败");
	}
	
	/**查看一个供应商*/
	@RequestMapping(value="/provider/query",method=RequestMethod.GET)
	public ModelAndView queryOne(Integer proId) {
		if(proId == null) {
			return new ModelAndView();
		}
		Provider provider= proSvc.queryById(proId);
		return new ModelAndView("provider/query","provider",provider);
	}
	
	/**去添加供应商*/
	@RequestMapping(value="/provider/add",method=RequestMethod.GET)
	public ModelAndView toAdd() {
		return new ModelAndView("provider/add");
	}
	
	/**去修改供应商*/
	@RequestMapping(value="/provider/update",method=RequestMethod.GET)
	public ModelAndView toUpdate(Integer proId) {
		if(proId == null) {
			return new ModelAndView("error");
		}
		Provider provider = proSvc.queryById(proId);
		ModelAndView mv = new ModelAndView("provider/update");
		mv.addObject("provider",provider);
		return mv;
	}
	
	/**修改供应商*/
	@RequestMapping(value="/provider/update",method=RequestMethod.POST)
	public ModelAndView update(Provider provider) {
		if(null == provider || null == provider.getProId()) {
			return new ModelAndView("error");
		}
		int success = proSvc.update(provider);
		return new ModelAndView("redirect:/provider","msg",success > 0 ?"成功":"失败");
	}
}
