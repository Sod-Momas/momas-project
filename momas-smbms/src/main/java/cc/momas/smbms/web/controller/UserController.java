package cc.momas.smbms.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.smbms.entity.User;
import cc.momas.smbms.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userSvc;

	/** 添加用户 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView add(HttpSession session, User user) {
		User loginUser = (User) session.getAttribute("LOGIN_USER");
		user.setCreatedBy(loginUser.getUserId());
		user.setCreationDate(new Date());
		int result = userSvc.add(user);
		String msg = result > 0 ? "成功" : "失败";
		return new ModelAndView("redirect:/user", "msg", msg);
	}

	/** 删除用户 */
	@RequestMapping(value = "/user/del", method = RequestMethod.GET)
	public String delete(User user) {
		userSvc.delete(user);
		return "redirect:/user";
	}

	/** 登录 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, User user) {
		System.err.println("login user<================: " + user.getUserName());
		user = userSvc.login(user);
		if (null != user) {
			session.setAttribute("LOGIN_USER", user);
			return new ModelAndView("redirect:main");
		}
		System.err.println("result user<================ : " + user);
		return new ModelAndView("login", "msg", "请填写正确的用户名密码哦");
	}

	/** 注销账户 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (null != session.getAttribute("LOGIN_USER")) {
			session.removeAttribute("LOGIN_USER");
		}
		return "redirect:login";
	}

	/** 查看一个用户 */
	@RequestMapping(value = "/user/query", method = RequestMethod.GET)
	public ModelAndView queryOne(Integer userId) {
		if (userId == null) {
			return new ModelAndView();
		}
		User user = userSvc.queryById(userId);
		return new ModelAndView("user/query", "user", user);
	}

	/** 修改密码 */
	@RequestMapping(value = "/user/password", method = RequestMethod.POST)
	public ModelAndView repassword(HttpSession session, User user, String newPassword) {
		ModelAndView mv = new ModelAndView();
		if (null == newPassword || "".equals(newPassword)) {
			mv.addObject("msg", "请输入新密码");
			return mv;
		}
		if (null == user) {
			return mv;
		}
		User loginUser = (User) session.getAttribute("LOGIN_USER");
		if (!loginUser.getUserPassword().equals(user.getUserPassword())) {
			mv.addObject("msg", "请输入正确的旧密码");
			return mv;
		}
		loginUser.setUserPassword(newPassword);
		if (0 < userSvc.update(loginUser)) {
			mv.setViewName("login");
			mv.addObject("msg", "修改成功,请重新登录");
		} else {
			mv.addObject("msg", "修改失败");
		}
		return mv;
	}

	/** 去添加用户 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		return new ModelAndView("user/add");
	}

	/** 去登录 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String tologin() {
		return "login";
	}

	/** 去修改密码 */
	@RequestMapping(value = "/user/password", method = RequestMethod.GET)
	public String toRepassword() {
		return "/user/password";
	}

	/** 去修改用户 */
	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public ModelAndView toupdate(Integer userId) {
		if (null == userId) {
			return new ModelAndView();
		}
		User user = userSvc.queryById(userId);
		if (user == null) {
			return new ModelAndView();
		}

		return new ModelAndView("user", "user", user);
	}

	/** 去修改用户 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ModelAndView update(User user) {
		if (null == user || user.getUserId() == null) {
			return new ModelAndView();
		}
		int success = userSvc.update(user);
		return new ModelAndView("user/update", "msg",success>0?"成功":"失败");
	}
	

	/** 用户模块欢迎页 */
	@RequestMapping("/user")
	public ModelAndView welcome() {
		List<User> ulist = userSvc.queryAll();
		return new ModelAndView("user", "userList", ulist);
	}

}
