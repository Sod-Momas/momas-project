<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.dao.impl.NewsDAOImpl"%>
<%@page import="cc.momas.test.newportal.dao.INewsDAO"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.utils.DBHelper"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="cc.momas.test.newportal.service.INewsService"%>
<%@page import="cc.momas.test.newportal.service.impl.NewsServiceImpl"%>
<%@page import="cc.momas.test.newportal.utils.Pager"%>
<%@page import="cc.momas.test.newportal.utils.BeanFactory"%>
<%@ include file="checkLogin.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	//1.获取参数并验证合法
	String s = request.getParameter("pageNo");
	Integer pageNo = null;
	if (s == null) {
		pageNo = 1;
	} else {
		pageNo = Integer.parseInt(s);
		if(pageNo < 2)
		{
			pageNo=1;
		}
	}
	Integer pageSize = 10;//每页10条记录

	Pager<News> pager = new Pager<News>();
	pager.setPageNo(pageNo);
	pager.setPageSize(pageSize);

	//2.获取 
	INewsService newsService = (INewsService) BeanFactory
			.getBean("newsService");
	newsService.setNewsDao((INewsDAO) BeanFactory.getBean("newsDao"));
	pager = newsService.queryByPager(pager);
	
	pager.setTotalRecoredCount(newsService.queryCountAll());//这一步很关键设置全部页数

	//3.将内容保存
	request.setAttribute("newspager", pager);

	//4.转发给表示层
	request.getRequestDispatcher("/view/indexpage.jsp").forward(
			request, response);
%>