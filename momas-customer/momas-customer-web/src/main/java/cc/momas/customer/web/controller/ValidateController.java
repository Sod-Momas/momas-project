package cc.momas.customer.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Users;
import cc.momas.customer.service.IUsersService;

@Controller
public class ValidateController {
	
	@Autowired
	private IUsersService userSvc;
	
	@RequestMapping(value = "/login")
	public ModelAndView login(String username, String password,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (username == null || "".equals(username) || "".equals(password) || password == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		Users user = userSvc.findLogin(new Users() {{
			setUsersLoginname(username);
			setUsersPassword(password);
			}});
		if(user != null) {
			session.setAttribute("LOGIN_USER", user);
			mv.setViewName("redirect:/index");
		} else {
			mv.addObject("msg", "请输入正确的用户名和密码");
			mv.setViewName("forward:/");
		}
		return mv;
	}

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpSession session) {
		return new ModelAndView("index");
	}
}
