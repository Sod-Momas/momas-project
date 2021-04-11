<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="checkLogin.jsp"%>
<%@page import="cc.momas.test.newportal.service.ITopicService"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@page import="cc.momas.test.newportal.dao.ITopicDAO"%>
<%@page import="cc.momas.test.newportal.entity.Topic"%>
<%
	//1.接收参数并验证
	//2.验证参数
	//3.查数据
	ITopicService topicService = (ITopicService) BeanFactory.getBean("topicService");
	topicService.setTopicDao((ITopicDAO) BeanFactory.getBean("topicDao"));
	List<Topic> tList = topicService.queryAll();

	//4.打包数据
	request.setAttribute("topicList", tList);

	//5.发送数据
	request.getRequestDispatcher("/view/add.jsp").forward(request,response);
%>