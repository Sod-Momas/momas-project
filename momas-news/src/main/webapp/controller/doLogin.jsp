<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="cc.momas.test.newportal.dao.impl.News_usersDAOImpl"%>
<%@page import="cc.momas.test.newportal.dao.INews_usersDAO"%>
<%@page import="cc.momas.test.newportal.service.impl.News_usersServiceImpl"%>
<%@page import="cc.momas.test.newportal.service.INews_usersService"%>
<%
	request.setCharacterEncoding("UTF-8");
	//1.获取参数
	String name = request.getParameter("uname");
	String pass = request.getParameter("upwd");
	String rememberme = request.getParameter("rememberme");
	//2.判断合法
	if (null == name || null == pass || name.trim().length() < 1
			|| pass.trim().length() < 1) {
		response.sendRedirect(request.getContextPath() + "/?err=1");
		return;
	}
	//3.根据参数取出数据
	INews_usersService srv = new News_usersServiceImpl();
	News_users nu = srv.login(name, pass);

	//4.保存登录信息
	if(nu==null){
		//登录失败重新登录
		response.sendRedirect(request.getContextPath() + "/?err=2");
		return;
	}
	session.setAttribute("LOGIN_USER", nu);

	//如果勾选了记住我,就把用户名存起来 
	if ("true".equals(rememberme)) {
		response.addCookie(new Cookie("LOGIN_USER", name));
	}

	//response.sendRedirect(request.getContextPath() + "/view/index.jsp");
	response.sendRedirect(request.getContextPath()+"/servlet/newsServlet?code=1");
%>