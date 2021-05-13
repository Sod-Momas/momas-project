package cc.momas.news.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.momas.news.constant.NewsStatusConstant;
import cc.momas.news.constant.UserConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import cc.momas.news.common.BeanFactory;
import cc.momas.news.entity.Comment;
import cc.momas.news.entity.User;
import cc.momas.news.service.CommentService;
import cc.momas.news.web.ResponseEntity;

@WebServlet(value = { "/comment" }, description = "评论相关", displayName = "CommentServlet", name = "CommentServlet")
public class CommentServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private CommentService commentService = (CommentService) BeanFactory.getBean(BeanFactory.SERVICE_COMMENT);

	/**
	 * 用于获取评论
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收参数
		String pageStartString = request.getParameter("pageStart");
		String pageCountString = request.getParameter("pageCount");
		String newsIdString = request.getParameter("newsId");
		// 验证参数
		int pageStart = NumberUtils.toInt(pageStartString, 0); // 默认第一页,第0条
		int pageCount = NumberUtils.toInt(pageCountString, 10); // 默认一页10条
		Integer newsId = NumberUtils.isDigits(newsIdString) ? NumberUtils.toInt(newsIdString, -1) : null;
		// 调用业务
		List<Comment> commentList = commentService.listPage(newsId, pageStart, pageCount);
		// 返回结果
		ResponseEntity<List<Comment>> resp = new ResponseEntity<>();
		resp.data = commentList;
		response.getWriter().println(resp);
	}

	/**
	 * 用于新增评论
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = request.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再发表评论");
		}

		// 接收参数
		String content = request.getParameter("content");
		String newsIdString = request.getParameter("newsId");
		String ip = request.getRemoteAddr(); // 获取远程客户端地址

		// 验证参数
		if (StringUtils.isBlank(StringUtils.trim(content))) {
			// Blank 指空白字符,例如 \n,\r
			// Empty 指长度为0的字符串,就算是空白字符串也不算Empty
			throw new IllegalArgumentException("评论内容不能为空白");
		}
		Integer newsId = NumberUtils.toInt(newsIdString);

		commentService.add(content, ip, newsId, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());
	}

	/**
	 * 用于修改评论
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = request.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再修改评论");
		}

		// 接收参数
		String idString = request.getParameter("id");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		String statusString = request.getParameter("status");

		// 验证参数
		Integer id = NumberUtils.toInt(idString, -1);
		// null 表示不修改数据库, 0 是有意义的,转换失败的时候将状态变为审核中
		Byte status = StringUtils.isBlank(statusString) ? null
				: NumberUtils.toByte(statusString, NewsStatusConstant.AUDIT);

		commentService.update(id, content, ip, status, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());
	}

	/**
	 * 用于删除评论
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证登录
		Object loginUserObject = request.getSession().getAttribute(UserConstant.LOGIN_USER);
		if (loginUserObject == null) {
			throw new ServletException("请您登录后再修改评论");
		}

		// 接收参数
		String idString = request.getParameter("id");
		// 验证参数
		if (StringUtils.isBlank(idString)) {
			throw new IllegalArgumentException("未指定要删除的评论");
		}
		Integer id = NumberUtils.toInt(idString, -1);
		commentService.delete(id, (User) loginUserObject);
		response.getWriter().print(ResponseEntity.ok());
	}

}
