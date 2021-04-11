<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="cc.momas.test.newportal.utils.Pager"%>
<%@page import="cc.momas.test.newportal.entity.News_users" %>

<!DOCTYPE html>
<html>
	<head>
		<title>查询页面 - ${sessionScope.LOGIN_USER.uname}</title>
		<link rel="stylesheet" type="text/css" href="../res/index.css" />
	</head>
	<body>
		<div id="body">
			<div id="head">
				<p>t欢迎光临莫莫砂新闻门户 </p>
			</div>
			<span style="text-align: right; font-size: small;">
				<a href="${pageContext.request.contextPath}/servlet/newsServlet?code=8">退出登录</a>
			</span>
			<hr width="700px" />
			<div id="content">
				<p>
					<a href="${pageContext.request.contextPath}/servlet/newsServlet?code=2">添加一条新闻</a>
					&nbsp;
					<a href="${pageContext.request.contextPath}/servlet/TopicServlet?code=1">添加一个主题</a>
				</p>
				<table rules="none" cellpadding="10">
					<thead>
						<tr>
							<th>
								标题
							</th>
							<c:if test="${sessionScope.LOGIN_USER.uisadmin == 1}">
								<th>
									操作
								</th>
							</c:if>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<td colspan="2" id="pager">
								<span>
									<c:if test="${requestScope.newspager.pageNo eq 1}">
										首页
									</c:if>
									<c:if test="${requestScope.newspager.pageNo != 1}">
										<a href="?code=1&pageNo=1">首页</a>
									</c:if>
								</span>
								
								<span> 
								<c:if test="${requestScope.newspager.pageNo ==1}">
									上一页 
								</c:if>
								<c:if test="${requestScope.newspager.pageNo != 1}">
									<a href="?code=1&pageNo=${requestScope.newspager.pageNo - 1}">上一页 </a>
								</c:if>
							 	</span>
							 	
								<span>当前第${requestScope.newspager.pageNo }页	(共${requestScope.newspager.totalPageCount}页)</span>
								
								<span> 
								<c:if test="${requestScope.newspager.pageNo eq requestScope.newspager.totalPageCount}">
									下一页 
								</c:if>
								<c:if test="${requestScope.newspager.pageNo != requestScope.newspager.totalPageCount}">
									<a href="?code=1&pageNo=${requestScope.newspager.pageNo + 1}">下一页 </a>
								</c:if>
							 	</span>
								
								<span> 
								<c:if test="${requestScope.newspager.pageNo == requestScope.newspager.totalPageCount}">
									末页 
								</c:if>
								<c:if test="${requestScope.newspager.pageNo != requestScope.newspager.totalPageCount}">
									<a href="?code=1&pageNo=${requestScope.newspager.pageNo - 1}">末页 </a>
								</c:if>
							 	</span>
							</td>
						</tr>
					</tfoot>
					<tbody>
						<c:if test="${empty requestScope.newspager.list}">
							<tr>
								<td colspan="2">
									<font color="gary">没有相关内容</font>
								</td>
							</tr>
						</c:if>
						
						<c:forEach items="${requestScope.newspager.list}" var="n" begin="0" 
							 step="1" end="${fn:length(requestScope.newspager.list)}" varStatus="status">
							<tr>
								<td>
									<a href="${pageContext.request.contextPath}/servlet/newsServlet?code=4&newsid=${n.nid}">${n.ntitle}</a>
								</td>
								<c:if test="${sessionScope.LOGIN_USER.uisadmin == 1}">
									<td>
										<a href="${pageContext.request.contextPath}/servlet/newsServlet?code=5&newsid=${n.nid}">修改</a>
										<a href="${requestScope.contextPath}/servlet/newsServlet?code=7&newsid=${n.nid}"
											onclick="return confirm('确认删除吗?')">删除</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</body>
</html>