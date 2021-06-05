<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/ie10-viewport-bug-workaround.css"/>
	<link rel="stylesheet" type="text/css" href="css/signin.css"/>
		  
  </head>
  
  <body>
   
    <div class="container">

      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading"><span class="glyphicon glyphicon-user"></span>请登录</h2>
        <c:if test="${not empty msg }">
        	<div class="alert alert-warning">
        		${msg }
        	</div>
        </c:if>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" name="userName" id="inputUsername" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->
	<script src="js/jquery.min-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/ie-emulation-modes-warning.js" type="text/javascript" charset="utf-8"></script>
  </body>
</html>
