package cc.momas.vote.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import cc.momas.vote.entity.Vote;
import cc.momas.vote.service.IVoteService;
import cc.momas.vote.utils.BeanFactory;

public class VoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_PAGE = "error.jsp";
	private static final String INDEX_PAGE = "index.jsp";
	private static final String ADD_PAGE = "tianjia.jsp";
	private static final String UPDATE_PAGE = "weihu.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		
		//PrintWriter out = response.getWriter();
		//ServletContext application = this.getServletContext();
		//HttpSession session = request.getSession();
				
		/*
		 * code值与功能
		 * 1.查询所有
		 * 2.添加
		 * 3.修改(维护)
		 */
		String c = request.getParameter("code");
		if (c == null || "".equals(c)) {
			c = "1";
		}
		String root = request.getContextPath();
		IVoteService voteService = (IVoteService) BeanFactory.getBean("voteService");
		Vote vote = null;
		Integer vid = null;
		Integer vType = null;
		String vTitle = null;
		
		switch(Integer.parseInt(c)){
		// 1.查询所有
		case 1:
			List<Vote> voteList = null;
			try {
				voteList = voteService.getAllList();
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("ERR", e.getMessage());
				request.getRequestDispatcher("/"+ERROR_PAGE).forward(request, response);
				return;
			}
			request.setAttribute("voteList", voteList);
			request.getRequestDispatcher("/"+INDEX_PAGE).forward(request, response);
			break;
		// 2.添加一个投票
		case 2:
			
			request.getRequestDispatcher("/"+ADD_PAGE).forward(request, response);
			break;
			
		case 3:
			
			request.getRequestDispatcher("/"+UPDATE_PAGE).forward(request, response);
			break;
		}
		
	}

}
