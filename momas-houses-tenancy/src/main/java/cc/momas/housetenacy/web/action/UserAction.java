package cc.momas.housetenacy.web.action;

import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cc.momas.housetenacy.entity.Users;
import cc.momas.housetenacy.service.IUsersService;
import cc.momas.housetenacy.utils.BeanFactory;

@Entity
public class UserAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nextDispose;
	private IUsersService usersService = (IUsersService) BeanFactory.getBean("usersService");
	private Users users;
	private String code;
	
	
	public String register() {
		if(usersService.register(users)){
			System.out.println("注册成功啦");
		}else{
			System.out.println("注册失败了...");
		}
		return "regsuccess";
	}

	public String login() {
		//验证码必需
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("cache-control", "nocache");
		response.setHeader("Pragma", "nocache");
		response.setHeader("Expires", "0");
		String c = (String) ServletActionContext.getContext().getSession().get("VALIDATE_CODE");
		if (c == null || "".equals(c)) {
			this.addFieldError("code", "验证码不能为空");
			return LOGIN;
		} else if (!c.equals(code)) {
			this.addFieldError("code", "验证码错误");
			return LOGIN;
		}
		
		//正常登录
		users = usersService.login(users);
		String forward = "";
		if(users != null){
			//把登录成功的用户放进session
			Map<String, Object> session = getSession();
			session.put("LOGIN_USER", users);
			
			forward ="loginsuccess";
		}else{
			forward = "login";
		}
		return forward;
	}
	
	public String logout(){
		Map<String, Object> session = getSession();
		Object u = session.get("LOGIN_USER");
		if(u != null){
			session.remove("LOGIN_USER");
		}
		return LOGIN;
	}

	public void setNextDispose(String nextDispose) {
		this.nextDispose = nextDispose;
	}

	public String getNextDispose() {
		return nextDispose;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
