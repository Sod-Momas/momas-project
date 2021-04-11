<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@ include file="/controller/checkLogin.jsp"%>
<% News_users nu = (News_users) session.getAttribute("LOGIN_USER"); %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../res/index.css"/>
	</head>
	<body>
		<div id="body">
			<div id="head">
				<p>
					欢迎光临莫莫砂新闻门户
				</p>
			</div>
				<span style="text-align: right;font-size:small;">
					<%=nu.getUname() %>
					<a href="<%=request.getContextPath()+"/controller/doLogout.jsp" %>">退出登录</a>
				</span>
			<hr width="700px" />
			<div id="content">
			<p><a href="<%=request.getContextPath() %>/view/add.jsp">添加一条新闻</a></p>
				<table rules="none" cellpadding="10" >
					<tr>
						<th>
							标题
						</th>
						<th>
							操作
						</th>
					</tr>
					<%
						List<News> nList = (List<News>) request.getAttribute("newsList");
						for (News n : nList) {
					%>
					<tr>
						<td>
							<a href="doQueryOne.jsp?newsid=<%=n.getNid()%>"><%=n.getNtitle()%></a>
						</td>
						<td>
							<a href="doUpdate.jsp?newsid=<%=n.getNid()%>">修改</a>
							<a href="doDelete.jsp?newsid=<%=n.getNid()%>" 
								onclick="return confirm('确认删除吗?')">删除</a>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>

		</div>
	</body>
</html>