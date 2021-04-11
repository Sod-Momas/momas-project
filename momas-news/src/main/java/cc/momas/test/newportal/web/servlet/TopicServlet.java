package cc.momas.test.newportal.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.momas.test.newportal.entity.News_users;
import cc.momas.test.newportal.entity.Topic;
import cc.momas.test.newportal.service.ITopicService;
import cc.momas.test.newportal.utils.BeanFactory;

public class TopicServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	
		News_users nu = (News_users) request.getSession().getAttribute("LOGIN_USER");
		//验证登录
		if(nu==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
		String c = request.getParameter("code");

		if (c == null || "".equals(c)) {
			c = "1";// 如果没值就默认为1
		}
		int code = Integer.parseInt(c);

		//公共变量
		ITopicService topicService = (ITopicService)BeanFactory.getBean("topicService");
		List<Topic> topicList = null;
		
		String tid = null;//主题id
		String tname = null;//主题名
		
		tid = request.getParameter("tid");
		tname =request.getParameter("tname");
		
		Topic topic = new Topic();
		
		/*
		 * 1.查看主题
		 * 2.增加主题
		 * 3.修改主题
		 * 4.删除主题
		 * 
		 */
		switch(code){
		//1.查看主题
		case 1:
			{
				 topicList = topicService.queryAll();
				 request.setAttribute("topicList", topicList);
				 request.getRequestDispatcher("/alltopic.jsp").forward(request, response);
			}
			break;
		//2.增加主题
		case 2:
			{
				topic.setTname(tname);
				topicService.insert(topic);
			}
			break;
		//3.修改主题
		case 3:
			{
				topic.setTid(Integer.parseInt(tid));
				topic.setTname(tname);
				topicService.update(topic);
			}
			break;
		// 4.删除主题
		case 4:
			{
				topicService.delete(Integer.parseInt(tid));
			}
			break;
		}
		response.sendRedirect(request.getContextPath()+"/alltopic.jsp");
		
	}
}
