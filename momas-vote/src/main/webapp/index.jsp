<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>首页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body style="width:920px;margin:0 auto;">
		<div class="container-fluid">   
			
			<!-- 顶部导航条 -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<!-- 顶部导航条左边 -->
						<ul class="nav navbar-nav navbar-left">
							<li>
								<a class="navbar-brand" href="${pageContext.request.contextPath }/vote">网上投票系统</a>
							</li>
						</ul>
						<!-- 顶部导航条右边 -->
						<ul class="nav navbar-nav navbar-right">
							<li>
								<p class="navbar-text">
									<c:choose>
										<c:when test="${not empty sessionScope.USER}">
											<a href="${pageContext.request.contextPath }/servlet/user?code=3">${sessionScope.USER.uusername } 退出登录</a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath }/login.jsp">用户登录</a>
										</c:otherwise>
									</c:choose>	
								</p>
							</li>
						</ul>
						<!-- end导航条右边 -->
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		        
	        <div class="container-fluid">
				<div class="row clearfix">
			        <!--下面是导航条-->
					<div class="col-md-12 column">
						<ul class="nav nav-pills">
							<li role="presentation" class="active">
								<a>
									<span class="glyphicon glyphicon-home" aria-hidden="true"></span> 主页列表
								</a>
							</li>
							<li role="presentation" >
								<a href="${pageContext.request.contextPath }/servlet/vote?code=2">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加新投票
								</a>
							</li>
							<li role="presentation">
								<a href="${pageContext.request.contextPath }/servlet/vote?code=3">
									<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 维护
								</a>
							</li>
						<!--
							<li role="presentation"><input type="text" class="form-control" placeholder="搜你想要的"></li>
							<li role="presentation"> 
								<button type="submit" class="btn btn-primary">搜索</button>
							</li>
						-->
	
						</ul>
					</div>
					
					<!--下面是列表投票-->
					<div class="col-md-12 column">
						<ul class="list-group">
							<li class="list-group-item">
								<span class="glyphicon glyphicon-flag" style=" padding-right:10px ; "></span>
								<a href="#">你喜欢吃什么水果</a><br/>
								<!-- <small>共有n个选项，已有n人投票</small> -->
							</li>
						</ul>
					</div>	
					       	    	
					<!--下面是分页-->
					<div class="col-md-6 col-md-offset-3">
						<nav aria-label="Page navigation">
							<ul class="pagination">		        
								<li>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>	
									</a>		        
								</li>		        
								<li><a href="#">1</a></li>
						        <li><a href="#">2</a></li>
						        <li><a href="#">3</a></li>
						        <li><a href="#">4</a></li>
						        <li><a href="#">5</a></li>		        
						        <li>
						        	<a href="#" aria-label="Next">
						        		<span aria-hidden="true">&raquo;</span>
									</a>
								</li>		      
							</ul>		    
						</nav>	
					</div><!--END分页-->
					
				</div>
			</div><hr/>				
		</div>

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
        <script src="/webjars/jquery/1.11.1/jquery.min.js"></script>
        <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
        <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>
