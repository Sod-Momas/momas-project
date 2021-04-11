<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cc.momas.test.newportal.entity.Topic"%>
<%@page import="cc.momas.test.newportal.entity.News"%>
<%@page import="cc.momas.test.newportal.entity.News_users"%>
<!DOCTYPE html>
<html>
	<head>
		<title>添加新闻 - ${sessioinScope.LOGIN_USER.uname}</title>
		<link rel="stylesheet" type="text/css" href="../res/add.css" />
	</head>
	<body onbeforeunload="return confirm('系统不会保留当前编辑内容哦!确认离开 ?')" >
		<form enctype="multipart/form-data" method="post" action="${request.contextPath}/servlet/newsServlet?code=3" >
			<div id="body">
				<div id="head">
					<p>
						<input type="text" name="ntitle" id="ntitle" value="" placeholder="标题" />
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
						<textarea name="ncontent" id="Ncontent" placeholder="新闻内容"></textarea><br />
						<div class="summary">
							<textarea name="nsummary" placeholder="概要"></textarea>
						</div>
					</article>
					<select name="ntid">
						<c:forEach items="${request.topicList}" var="t" begin="1" step="1" varStatus="s" >
							<option value="${t.tid}">${t.tname}</option>
						</c:forEach>
					</select><br />
					<input type="file" name ="nfile"/>
					<br/>
					<input type="submit" id="submit" value="提交新闻" />
				</div>
			</div>
		</form>
		<c:if test="${not empty request.param.err}">
			<script type="text/javascript">alter("请将标题/内容填写完整!");</script>
		</c:if>
	</body>

</html>
