<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.dao.INewsDAO"%>
<%@page import="cc.momas.test.newportal.entity.Topic"%>
<%@page import="cc.momas.test.newportal.service.ITopicService"%>
<%@page import="cc.momas.test.newportal.dao.ITopicDAO"%>
<%	//1.获取参数,验证合法
	String snid = request.getParameter("newsid");
	if(snid ==null || "".equals(snid)){
		response.sendRedirect(request.getContextPath()+"/");
		return;
	}
	//2.调用业务逻辑层完成查询
	Integer nid = Integer.parseInt(snid);
	INewsService newsService = (INewsService) BeanFactory.getBean("newsService");
	newsService.setNewsDao((INewsDAO) BeanFactory.getBean("newsDao"));
	
	//查询需要修改的新闻对象
	News news = newsService.queryById(nid);
	//修改页面上要指定的话题列表
	ITopicService topicService = (ITopicService)BeanFactory.getBean("topicService");
	topicService.setTopicDao((ITopicDAO) BeanFactory.getBean("topicDao"));
	List<Topic> topicList = topicService.queryAll();
	
	//3.保存数据到request,转发到指定视图层显示
	request.setAttribute("news",news);
	request.setAttribute("topicList",topicList);
	request.getRequestDispatcher("/view/updateNews.jsp").forward(request,response);
%>