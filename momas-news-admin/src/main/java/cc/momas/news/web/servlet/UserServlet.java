package cc.momas.news.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.momas.news.constant.NewsStatusConstant;
import cc.momas.news.constant.UserConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import cc.momas.news.common.BeanFactory;
import cc.momas.news.entity.User;
import cc.momas.news.service.UserService;
import cc.momas.news.web.ResponseEntity;

@WebServlet(value = { "/user" }, description = "用户相关Servlet", displayName = "UserServlet", name = "UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = (UserService) BeanFactory.getBean(BeanFactory.SERVICE_USER);

	/**
	 * 查询用户列表,用于管理员管理其它用户
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = httpRequest.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再查看用户");
		}
		Object isAdminObject = httpRequest.getSession().getAttribute(UserConstant.IS_ADMIN);
		if (null == isAdminObject) {
			throw new ServletException("只有管理员可以查看用户");
		}

		// 接收参数
		String pageStartString = httpRequest.getParameter("pageStart");
		String pageCountString = httpRequest.getParameter("pageCount");
		// 验证参数
		int pageStart = NumberUtils.toInt(pageStartString, 0); // 默认第一页,第0条
		int pageCount = NumberUtils.toInt(pageCountString, 10); // 默认一页1条
		// 调用业务
		List<User> userList = userService.listPage(pageStart, pageCount);

		// 处理用户密码,避免泄露
		for (User user : userList) {
			user.setPassword("[ PROTECTED ]");
		}

		// 返回结果
		ResponseEntity<List<User>> resp = new ResponseEntity<>();
		resp.data = userList;
		response.getWriter().println(resp);
	}

	/**
	 * 添加一个用户 一般用于注册
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = httpRequest.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再添加用户");
		}
		Object isAdminObject = httpRequest.getSession().getAttribute(UserConstant.IS_ADMIN);
		if (null == isAdminObject) {
			throw new ServletException("只有管理员可以添加用户");
		}

		// 接收参数
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		String isAdminString = httpRequest.getParameter("isAdmin");

		// 验证参数
		// Blank 指空白字符,例如 \n,\r
		// Empty 指长度为0的字符串,就算是空白字符串也不算Empty
		if (StringUtils.isBlank(StringUtils.trim(username))) {
			throw new IllegalArgumentException("用户名不能空");
		}
		if (StringUtils.isBlank(StringUtils.trim(password))) {
			throw new IllegalArgumentException("密码不能为空");
		}
		if (password.length() < 6) {
			throw new IllegalArgumentException("密码长度不能小于6");
		}
		boolean isAdmin = "1".equals(isAdminString); // 1 表示是, 其他是否

		userService.registe(username, password, isAdmin, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());
	}

	/**
	 * 修改一个用户 一般用于修改个人资料
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = httpRequest.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再修改用户资料");
		}

		// 接收参数
		String idString = httpRequest.getParameter("id");
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		String isAdminString = httpRequest.getParameter("isAdmin");
		String statusString = httpRequest.getParameter("status");

		// 验证参数
		Integer id = NumberUtils.toInt(idString, -1);
		// 如果指定了 1 ,则为true,空为保留null,其他为false
		Boolean isAdmin = StringUtils.isBlank(isAdminString) ? null : "1".equals(isAdminString);
		// null 表示不修改数据库, 0 是有意义的,转换失败的时候将状态变为审核中
		Byte status = StringUtils.isBlank(statusString) ? null
				: NumberUtils.toByte(statusString, NewsStatusConstant.AUDIT);

		userService.update(id, username, password, isAdmin, status, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());

	}

	/**
	 * 删除一个用户 一般用于用户删除
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = httpRequest.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再删除用户");
		}
		Object isAdminObject = httpRequest.getSession().getAttribute(UserConstant.IS_ADMIN);
		if (null == isAdminObject) {
			throw new ServletException("只有管理员可以删除用户");
		}
		// 接收参数
		String idString = httpRequest.getParameter("id");
		// 验证参数
		if (StringUtils.isBlank(idString)) {
			throw new IllegalArgumentException("未指定要删除的评论");
		}
		Integer id = NumberUtils.toInt(idString, -1);
		if (((User) loginUserObject).getId().equals(id)) {
			throw new ServletException("用户不可删除自己");
		}
		userService.delete(id, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());
	}
}
