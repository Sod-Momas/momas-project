<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cc.momas.test.newportal.entity.Topic"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<!DOCTYPE html>
<html>
	<head>
		<title>添加新闻 - ${sessionScope.LOGIN_USER.uname}</title>
		<link rel="stylesheet" type="text/css" href="../res/add.css" />
	</head>
	<body onbeforeunload="return confirm('系统不会保留当前编辑内容哦!确认离开 ?')" >
		<form method="post" action="${requestScope.contextPath}/servlet/newsServlet?code=6"  >
			<input type="hidden" name="nid" value="${requestScope.news.nid}"/>
			<input type="hidden" name="ncreateDate" value="${requestScope.news.ncreateDate}"/>"
			<div id="body">
				<div id="head">
					<p>
						<input type="text" name="ntitle" id="ntitle" value="${requestScope.news.ntitle}" placeholder="标题" />
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
						<textarea name="ncontent" id="Ncontent" placeholder="新闻内容">${requestScope.news.ncontent}</textarea><br />
						<div class="summary">
							<textarea name="nsummary" value="" placeholder="概要">${requestScope.news.nsummary }</textarea>
						</div>
					</article>
					<select name="ntid">
						<c:forEach items="${requestScope.topicList}" begin="1" step="1" varStatus="s" var="t"
						end="${fn:length(requestScope.topicList)}">
							<option value="${t.tid}"
								<c:if test="${t.tid eq requestScope.news.ntid}">selected="selected"</c:if>
							>${t.tname}</option>
						</c:forEach>
					</select><br />
					<input type="submit" id="submit" value="提交修改" />
				</div>
			</div>
		</form>
	</body>
</html>
