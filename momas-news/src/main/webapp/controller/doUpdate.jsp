<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@page import="cc.momas.test.newportal.dao.INewsDAO"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.utils.DateUtils"%>
<%@page import="java.sql.Date"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%
	request.setCharacterEncoding("utf-8");
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");
	//1.接收参数
	String nauthor = request.getParameter("nauthor");
	String ncontent = request.getParameter("ncontent");
	String ncreateDate = request.getParameter("ncreateDate");
	String nid = request.getParameter("nid");
	String nsummary = request.getParameter("nsummary");
	String ntid = request.getParameter("ntid");
	String ntitle = request.getParameter("ntitle");
	//2./3./4.验证合法,打包数据,调用业务层
	INewsService newsService = (INewsService) BeanFactory.getBean("newsService");
	newsService.setNewsDao((INewsDAO)BeanFactory.getBean("newsDao"));
	News news =new News();
	news.setNauthor(nu.getUname());
	news.setNcontent(ncontent);
	news.setNcreateDate(DateUtils.getDateFromString(ncreateDate,"yyyy-MM-dd"));
	news.setNid(Integer.parseInt(nid));
	news.setNmodifyDate(new Date(System.currentTimeMillis()));
	news.setNpicPath(null);
	news.setNsummary(nsummary);
	news.setNtid(Integer.parseInt(ntid));
	news.setNtitle(ntitle);
	
	int successful =  newsService.update(news);
	response.sendRedirect(request.getContextPath()+"/controller/doQuerypage.jsp?successful="+successful);
%>