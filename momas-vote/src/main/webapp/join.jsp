<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>参加投票</title>
    
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
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/webjars/jquery/1.11.1/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
     <div class="container-fluid" >
        <div class="container-fluid" style="background: rgba(0,0,0,0.1); height:80px; ">
            <h3 style="font-weight: bold; text-shadow:#999 2px 1px; color:#fff; margin:40px 0 0 100px; font-size: 30px;">网上投票系统</h3>
        </div>
        <!--下面是导航条 -->       
        <div class="col-md-6 col-md-offset-3">
            <br />
            <br />
            <ul class="nav nav-tabs " class="col-md-1">
                <li class="class=" "></li>
                <li><a href="#">你好:小明!</a></li>
                <li role="presentation"><a href="zhuye.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 主页列表</a></li>
                <li role="presentation"><a><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加新投票</a></li>
                <li role="presentation"><a href="weihuzhuye.jsp"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 维护</a></li>
                <li role="presentation"><a href="index.jsp"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 退出</a></li>
            </ul>
            <h4 style="font-weight: bold;"><img src="img/xiao22.jpg">&nbsp;&nbsp;&nbsp;参加投票</h4>
            <div class="row">           
            <!--下面是投票内容-->
                <ul style="list-style:none; margin-left:-20px; width:450px;">
                    <li class="alert alert-info">投票内容:<input type="text" class="form-control"></li>
					<li class="alert alert-info">选项:
						<ol>
							<li><input type="radio" name="xuan"/>香蕉 </li>
							<li><input type="radio" name="xuan"/>桃子</li>
							<li><input type="radio" name="xuan"/>桃子</li>
						</ol>
					<li> 	
                </ul>
                <button type="submit" class="btn btn-info col-md-offset-1">确定</button>              
                <button type="button" class="btn btn-default">取消投票</button>
            </div>
            <hr/>     
       </div>  
    </div>
</body>
</html>
