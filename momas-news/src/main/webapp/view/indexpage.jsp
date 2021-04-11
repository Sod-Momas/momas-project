<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%@page import="cc.momas.test.newportal.utils.Pager"%>
<%@ include file="/controller/checkLogin.jsp"%>
<%
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");

	Pager<News> pager = (Pager<News>) request.getAttribute("newspager");
	List<News> nList = pager != null ? pager.getList() : null;
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../res/index.css" />
	</head>
	<body>
		<div id="body">
			<div id="head">
				<p>
					欢迎光临莫莫砂新闻门户
				</p>
			</div>
			<span style="text-align: right; font-size: small;"> <%=nu.getUname()%>
				<a href="<%=request.getContextPath() + "/controller/doLogout.jsp"%>">退出登录</a>
			</span>
			<hr width="700px" />
			<div id="content">
				<p>
					<a href="<%=request.getContextPath()%>/controller/doQueryForInsert.jsp">添加一条新闻</a>
				</p>
				<table rules="none" cellpadding="10">

					<%
						//如果没有内容呈现,则出现相关提示
						if (pager == null) {
					%>
					<tr>
						<td colspan="2">
							<font color="gary">没有相关内容</font>
						</td>
					</tr>
					<%
						return;
						}
					%>

					<thead>
						<tr>
							<th>
								标题
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="2" id="pager">
								<span> <%=pager.getPageNo() == 1 ? "首页": " <a href=\"?pageNo=1\">首页</a> "%>
								</span>
								<span> <%
							 	if (pager.getPageNo() == 1) {
							 %> 上一页 <%
							 	} else {
							 %> <a href="?pageNo=<%=pager.getPageNo() - 1%>">上一页</a> <%
							 	}
							 %> </span>
								<span>当前第<%=pager.getPageNo()%>页(共<%=pager.getTotalPageCount()%>页)</span>
								<span> <%
							 	if (pager.getPageNo() == pager.getTotalPageCount()) {
							 %>
																下一页 <%
							 	} else {
							 %> <a href="?pageNo=<%=pager.getPageNo() + 1%>">下一页</a>
									<%
										}
									%> </span>
								<span> <%
							 	if (pager.getPageNo() == pager.getTotalPageCount()) {
							 %>
								末页 <%
							 	} else {
							 %> <a
								href="?pageNo=<%=pager.getTotalPageCount()%>">末页</a> <%
							 	}
							 %> </span>
							</td>
						</tr>
					</tfoot>




					<%
						for (News n : nList) {
					%>
					<tr>
						<td>
							<a href="doQueryOne.jsp?newsid=<%=n.getNid()%>"><%=n.getNtitle()%></a>
						</td>
						<td>
							<a href="doQueryForUpdate.jsp?newsid=<%=n.getNid()%>">修改</a>
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