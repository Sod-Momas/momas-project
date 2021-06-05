<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if(null == session.getAttribute("LOGIN_USER")){
	response.sendRedirect(request.getContextPath()+"/login");
}
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>    
		<base href="<%=basePath%>">
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商店订单管理系统</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/ie10-viewport-bug-workaround.css"/>
		<link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
		<script type="text/javascript">var path='<%=path %>'</script> 
	</head>
	<body>
	
	 <nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container-fluid">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">导航条开关</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="main"><span class="glyphicon glyphicon-shopping-cart"></span>商店订单管理系统</a>
	        </div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<p class=" navbar-text " >
							<strong> 
								下午好,<a href="javascript:void(0)" class="navbar-link">${LOGIN_USER.userName }</a>,欢迎您!
							</strong>
						</p>
					</li>					
					<li><a href="logout">退出登录</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default">发送</button>
						</span>
					</div>
				</form>
			</div>
	      </div>
	    </nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar hidden-sm hidden-md hidden-lg">
					<li class="active"><a href="javascript:fold(this);">收起菜单</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><p class="text-center">功能列表</p></li>
					<li><a href="bill">订单管理</a></li>
					<li><a href="provider">供应商管理</a></li>
					<li><a href="user">用户管理</a></li>
					<li><a href="user/password">密码修改</a></li>
					<li><a href="logout">退出登录</a></li>
				</ul>
			</div>
			<a class="btn-fold-menu hidden-sm hidden-md hidden-lg"
				href="javascript:unfold(this);" title="展开菜单"
				data-event="toggle_sidebar"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>