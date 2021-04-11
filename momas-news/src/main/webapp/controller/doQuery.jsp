<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.dao.impl.NewsDAOImpl"%>
<%@page import="cc.momas.test.newportal.dao.INewsDAO"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.utils.DBHelper"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.service.impl.NewsServiceImpl"%>
<%@ include file="checkLogin.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	//1.获取参数并验证合法
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");
	
	//2.获取 
	INewsService newsService = new NewsServiceImpl();
	newsService.setNewsDao(new NewsDAOImpl());
	List<News> nList = (List<News>) newsService.queryAll();
	
	//3.将内容保存
	request.setAttribute("newsList",nList);
	
	//4.转发给表示层
	request.getRequestDispatcher("/view/index.jsp").forward(request,response);
	

%>