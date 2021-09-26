package cc.momas.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.dms.pojo.TUser;
import cc.momas.dms.pojo.TUserExample;
import cc.momas.dms.service.IUserService;
import cc.momas.util.MD5Util;
import cc.momas.util.Pager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userSvc;

	// 添加用户
	@RequestMapping("add")
	private String addUser(TUser user, int roleid) {
		 userSvc.save(user,roleid) ;
		 return "system/user";
	}
	
	
	@RequestMapping("queryByPager")
	@ResponseBody
	private Object queryByPager(
			Pager<TUser,TUserExample> pager,
			TUser user,
			@RequestParam(value = "rows",defaultValue="0")int rows,
			@RequestParam(value = "page",defaultValue="0")int page
			) {
		pager.setPageNo(page == 0 ? 1 : page);
		pager.setPageSize(rows == 0 ? 10 : rows);
		pager.setEntity(user);
		pager = userSvc.queryByPager(pager);
		return pager;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	private ModelAndView tologin() {
		return new ModelAndView("/");
	}
	
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	private Object login2(HttpServletRequest request, HttpSession session, String validate, String name, String password) {
		Message msg = new Message();
		msg.setSuccess(false);
		//从session获取生成的验证码
		String code = (String) session.getAttribute("regcode");
		//校验验证码是否输入正确
		if(code == null || !code.equals(validate)) {
			msg.setMessage("验证码错误");
			return msg;
		}
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			msg.setMessage("请填写用户名和密码");
			return msg;
		}
	
		//使用shiro框架提供的方式进行认证操作
		Subject subject = SecurityUtils.getSubject();//获得当前用户对象,状态为未认证
		AuthenticationToken token = new UsernamePasswordToken(name,MD5Util.md5(password));
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			System.out.println("用户名或密码错误");
			//认证 失败会出异常
			e.printStackTrace();
			msg.setMessage("用户名密码错误");
			return msg;
		}
		TUser nuser = (TUser) subject.getPrincipal();
		session.setAttribute("LOGIN_USER", nuser);
		msg.setSuccess(true);
		msg.setMessage("登录成功,即将跳转");
		return msg;
	}
	
	@SuppressWarnings("unused")
	private Object login(String name, String password,String validate,HttpSession session) {
		Message msg = new Message();
		msg.setSuccess(false);
		String code = (String) session.getAttribute("regcode");
		if(code == null || !code.equals(validate)) {
			msg.setMessage("验证码错误");
			return msg;
		}

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			msg.setMessage("请填写用户名和密码");
		}
		//验证登录
		TUser user = userSvc.queryLogin(name,password);
		if (null != user) {
			msg.setSuccess(true);
			msg.setMessage("登录成功,即将跳转到主页");
			session.setAttribute("LOGIN_USER", user);
		} else {
			msg.setMessage("用户名密码错误");
		}
		return msg;

		// ModelAndView mv = new ModelAndView();
		// if(StringUtils.isEmpty(user) || StringUtils.isEmpty(password)) {
		// mv.addObject("msg","请填写用户名和密码");
		// }
		// if("admin".equals(user) && "admin".equals(password)) {
		// mv.setViewName("index");
		// }else {
		// mv.addObject("msg","用户名密码错误");
		// }
		// return mv;
	}

	@RequestMapping("logout")
	private String logout (HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * 登录的时候需要用到某格式化JSON,用这个类转为JSON,没有其他作用
	 * @author Administrator
	 *
	 */
	class Message {
		private boolean success;
		private String message;

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
