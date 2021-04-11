<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sun.org.apache.regexp.internal.REUtil"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@page import="cc.momas.test.newportal.dao.INewsDAO"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="java.sql.Date"%>
<%@ include file="checkLogin.jsp"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");

//添加一条新闻的代码 
    //1.获取参数
	String ntitle = request.getParameter("ntitle");
	String ncontent = request.getParameter("ncontent");
	String nsummary = request.getParameter("nsummary");
	String sntid = request.getParameter("ntid");
	//2.验证合法
	if( ncontent == null || ntitle == null || sntid == null){
		response.sendRedirect(request.getContextPath()+"/view/add.jsp?err=1");
	}
	Integer ntid = Integer.parseInt(sntid);
	
	//3.调用服务
	INewsService newsService = (INewsService) BeanFactory.getBean("newsService");
	newsService.setNewsDao((INewsDAO)BeanFactory.getBean("newsDao"));
	
	News news =new News();
	news.setNauthor(nu.getUname());
	news.setNcontent(ncontent);
	news.setNcreateDate(new Date(System.currentTimeMillis()));
	news.setNpicPath(null);
	news.setNsummary(nsummary);
	news.setNtid(ntid);
	news.setNtitle(ntitle);
	
	//4.执行操作
	newsService.insert(news);
	response.sendRedirect(request.getContextPath()+"/controller/doQuerypage.jsp");
	
%>