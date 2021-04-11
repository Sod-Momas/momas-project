<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@page import="cc.momas.test.newportal.service.impl.NewsServiceImpl"%>
<%@page import="cc.momas.test.newportal.dao.impl.NewsDAOImpl"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@ include file="checkLogin.jsp"%>
<%
	//1.接收参数 
	Integer uid = new Integer(request.getParameter("newsid"));

	//2.验证合法性 
	if (null == uid) {
		response.sendRedirect(request.getContextPath()
				+ "/controller/doQuery.jsp");
		return;
	}
	//3.取值
	//这里取值不好的话,极其可能出现空指针,请注意 
	INewsService newsService = (NewsServiceImpl) BeanFactory.beans.get("newsService");
	newsService.setNewsDao((NewsDAOImpl) BeanFactory.beans.get("newsDao"));
	News n = newsService.queryById(uid);

	//4.打包发送
	request.setAttribute("news", n);
	request.getRequestDispatcher("/view/newsdetails.jsp").forward(request, response);
%>
