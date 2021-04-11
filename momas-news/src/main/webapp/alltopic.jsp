<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn" %>


<!DOCTYPE html>
<html>
  <head>    
    <title>查看所有主题</title>
    <meta charset="gbk"/>
  </head>
  
  <body>
    <div style="width:200px;margin:0 auto;">
    	<form method="post" action="${pageContext.request.contextPath}/servlet/TopicServlet?code=2">
    		=<input type="text" name="tname"/>
    		<input type="submit" value="添加一个新主题"/>
    	</form>
    	<ol>
    		<c:forEach items="${topicList}" var="t" varStatus="status">
	    		<li>
	    			<span style="padding:1em;">${t.tname}</span>
	    			<a href="${pageContext.request.contextPath}/servlet/TopicServlet?code=3&tid=${t.tid}">修改</a>&nbsp;
	    			<a href="${pageContext.request.contextPath}/servlet/TopicServlet?code=4&tid=${t.tid}">删除</a>
	    		</li>
    		</c:forEach>
    	</ol>
    </div>
  </body>
</html>
