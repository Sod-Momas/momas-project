<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.service.impl.NewsServiceImpl"%>
<%@page import="cc.momas.test.newportal.dao.impl.NewsDAOImpl"%>
<%@ include file="checkLogin.jsp"%>
<%
	//request.setCharacterEncoding("utf-8");

	//1.获取参数
	String s = request.getParameter("newsid");
	Integer newsId = null;
	try {
		newsId = Integer.parseInt(s);

		//2.验证合法
		if (newsId == null) {
			response.sendRedirect("doQuery.jsp");
			return;
		}
		//3.根据参数取值
		INewsService srv = new NewsServiceImpl();
		srv.setNewsDao(new NewsDAOImpl());
		int count = srv.delete(newsId);

	} catch (Exception e) {

	} finally {
		//4.转发给表示层ui
		response.sendRedirect("doQuerypage.jsp?pageNo=1");
	}
%>