<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页维护模式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    
    <script src="${pageContext.request.contextPath}/js/jqurey-3.2.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
  </head>
  <body>
  		<div class="container-fluid" style=" ">   
		<div class="container-fluid" style="background: rgba(0,0,0,0.1); height:80px; ">
			<h3 style="font-weight: bold; text-shadow:#999 2px 1px; color:#fff; margin:40px 0 0 100px; font-size: 30px;">网上投票系统</h3>
		</div>	           
             <!--下面是导航条-->
			<div class="col-md-6 col-md-offset-3">
           		<br/>
                <br />
					<ul class="nav nav-tabs "class="col-md-1">
						   <li class="class=" "></li>
						   <li ><a >你好:小明!!</a></li>	
						   <li role="presentation"><a href="zhuye.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 主页列表</a></li>
                           <li role="presentation" ><a href="tianjia.jsp"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加新投票</a></li>
                           <li role="presentation" class="active"><a ><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 维护</a></li>
                           <li role="presentation"><a href="index.jsp"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 退出</a></li>
						 <!--<li role="presentation"><input type="text" class="form-control" placeholder="搜你想要的"></li>
						 <li role="presentation"> <button type="submit" class="btn btn-primary">搜索</button></li>-->
			   
					</ul>
				<h4  style="font-weight: bold;"><img src="img/xiao22.jpg">&nbsp;&nbsp;&nbsp;投票列表</h4>	
				<!--下面是列表投票 -->	       	    	
				<ul class="list-group">
					    <li class="list-group-item"><span class="glyphicon glyphicon-flag" style=" padding-right:10px ; "></span><a href="#">你喜欢吃什么水果</a><br/><small>共有n个选项，已有n人投票</small><a href="weihu.jsp" type="submit" class="btn btn-warning glyphicon glyphicon-wrench col-md-offset-6"style="height:30px">维护</a></li>
				</ul>
				<!--下面是分页-->				
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
						<hr/>
			  </div>
		</div>
  </body>
</html>
