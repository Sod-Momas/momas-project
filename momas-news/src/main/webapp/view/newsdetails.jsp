<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");
	News news = (News) request.getAttribute("news");
%>
<!DOCTYPE html>
<html>
	<head>
		<title><%=news.getNtitle()%></title>
		<link rel="stylesheet" type="text/css" href="../res/index.css" />
	</head>

	<body>
		<div id="body">
			<div id="head">
				<p><%=news.getNtitle()%> 
				<br></p>
			</div>
			<div>
				<span style="float:left; font-size: small;"> 
					<a href="javascript:history.go(-1);">后退</a> 
				</span>
			</div>
			<hr width="700px" />
			<div id="content">
				<article>
					<%=news.getNcontent()%>
					<br/>
					<%if(news.getNpicPath()!=null)
						{%>
						<div style="width:90%;">
							<img width="560px" src="<%=request.getContextPath() + "/upload/news/" + news.getNpicPath() %>"/>
						</div>
					<%}%>
					<div class="summary">
						<%=news.getNsummary()%>
					</div>
					<span class="author">作者: <font color="red"><%=news.getNauthor()%></font>
					</span>
					<span class="date">创建日期: <font><%=news.getNcreateDate()%></font>
					</span>
				</article>
			</div>
		</div>
	</body>
</html>
