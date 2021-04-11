package cc.momas.vote.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.momas.vote.entity.User;
import cc.momas.vote.service.IUserService;
import cc.momas.vote.utils.BeanFactory;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_PAGE = "error.jsp";
	private static final String INDEX_PAGE = "index.jsp";
	private static final String LOGIN_PAGE = "login.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		
		//PrintWriter out = response.getWriter();
		//ServletContext application = this.getServletContext();
		HttpSession session = request.getSession();

		/*
		 * code模块功能
		 * 
		 * 1.登录 
		 * 2.注册
		 * 3.退出登录
		 */

		String c = request.getParameter("code");
		if (c == null || "".equals(c)) {
			c = "1";
		}
		String root = request.getContextPath();
		IUserService userService = (IUserService) BeanFactory.getBean("userService");
		User user = null;
		String email = null;
		String password = null;
		String username = null;

		switch (Integer.parseInt(c)) {
		case 1:
			//登录
			email = request.getParameter("email");
			password = request.getParameter("password");

			try {
				user = userService.login(email, password);
			} catch (Exception e) {
				request.setAttribute("ERR", e.getMessage());
				request.getRequestDispatcher("/"+ERROR_PAGE).forward(request, response);
				return;
			}

			session.setAttribute("USER", user);

			response.sendRedirect(root + "/" + INDEX_PAGE);
			break;

		case 2:
			//注册
			email = request.getParameter("email");
			username = request.getParameter("username");
			password = request.getParameter("password");
			user = new User();
			user.setUid(null);
			user.setUemail(email);
			user.setUpassword(password);
			user.setUusername(username);

			try {
				userService.register(user);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("ERR", e.getMessage());
				request.getRequestDispatcher("/"+ERROR_PAGE).forward(request, response);
				return;
			}

			response.sendRedirect(root + "/" + LOGIN_PAGE);
			break;
			
		case 3:
			// 退出登录
			session.invalidate();
			response.sendRedirect(root + "/" + INDEX_PAGE);
			break;
		}

	}

}
