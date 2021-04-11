<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.momas.test.newportal.entity.Topic"%>
<%@ include file="/controller/checkLogin.jsp"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<%
	News_users nu = (News_users) session.getAttribute("LOGIN_USER");
	News news = (News) request.getAttribute("news");
	List<Topic> topicList = (List<Topic>) request.getAttribute("topicList");
	
%><!DOCTYPE html>
<html>
	<head>
		<title>添加新闻 -<%= nu.getUname() %></title>
		<link rel="stylesheet" type="text/css" href="../res/add.css" />
	</head>
	<body onbeforeunload="return confirm('系统不会保留当前编辑内容哦!确认离开 ?')" >
		<form method="post" action="<%=request.getContextPath()+"/controller/doUpdate.jsp" %>" >
			<input type="hidden" name="nid" value="<%=news.getNid() %>"/>
			<input type="hidden" name="ncreateDate" value="<%=news.getNcreateDate() %>"/>"
			<div id="body">
				<div id="head">
					<p>
						<input type="text" name="ntitle" id="ntitle" value="<%=news.getNtitle() %>" placeholder="标题" />
					</p>
				</div>
				<div>
					<span style="float:left; font-size: small;"> 
					 	<a href="javascript:history.go(-1);" >后退</a> 
					</span>
				</div>
				<hr width="700px" />
				<div id="content">
					<article>
						<textarea name="ncontent" id="Ncontent" placeholder="新闻内容"><%=news.getNcontent() %></textarea><br />
						<div class="summary">
							<textarea name="nsummary" value="" placeholder="概要"><%=news.getNsummary() %></textarea>
						</div>
					</article>
					<select name="ntid">
						<%for(Topic t : topicList){ %>
						<option value="<%=t.getTid() %>"
						<%
							if(t.getTid()==news.getNtid()){	
						 %>
						 selected="selected"
						 <%
						 	}
						  %>
						><%=t.getTname() %></option>
						<%} %>
					</select><br />
					<input type="submit" id="submit" value="提交修改" />
				</div>
			</div>
		</form>
<%
	if(request.getParameter("err")!=null)
	{
		%>
		<script type="text/javascript">alter("请将标题/内容填写完整!");</script>
		<%
	}
 %>
	</body>

</html>
