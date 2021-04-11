<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看投票</title>
    
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
    <div class="container-fluid" style=" ">
        <div class="container-fluid" style="background: rgba(0,0,0,0.1); height:80px; ">
            <h3 style="font-weight: bold; text-shadow:#999 2px 1px; color:#fff; margin:40px 0 0 100px; font-size: 30px;">网上投票系统</h3>
        </div>
        <!--下面是导航条-->
        <div class="col-md-6 col-md-offset-3">
            <br />
            <br />
            <ul class="nav nav-tabs " class="col-md-1">
                <li class="class=" "></li>
                <li><a>你好:小明!!</a></li>
                 <li role="presentation"><a href="zhuye.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 主页列表</a></li>
                <li role="presentation" ><a href="tianjia.jsp"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加新投票</a></li>
                <li role="presentation"><a href="weihuzhuye.jsp"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 维护</a></li>
                <li role="presentation"><a href="index.jsp"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 退出</a></li>

                    <!--<li role="presentation"><input type="text" class="form-control" placeholder="搜你想要的"></li>                                                               <li role="presentation"> <button type="submit" class="btn btn-primary">搜索</button></li>-->
            </ul>   
            <h4 style="font-weight: bold;"><img src="img/xiao22.jpg">&nbsp;&nbsp;&nbsp;查看投票</h4> 
            <div><span class="glyphicon glyphicon-flag" ></span> 你喜欢吃什么水果<br /><small>共有n个选择，已有n人投票</small>
            </div>
            <!-- 下面选项控件 -->
         <table>        
	         <tr>
		         <td>1.西瓜</td>
		         <td style="width:600px;padding:15px 0 0 10px;"><div class="progress"> 
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
						  </div>
					      </div>
				 </td>
	         </tr> 
	         <tr>
		         <td>2.桃子</td>
		         <td style="width:600px;padding:15px 0 0 10px;"><div class="progress"> 
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
						  </div>
					      </div>
				 </td>
	         </tr>       
	         <tr>
		         <td>3.葡萄</td>
		         <td style="width:600px;padding:15px 0 0 10px;">an<div class="progress"> 
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
						  </div>
					      </div>
				 </td>
	         </tr>             
         </table>
            <button type="button" class="btn btn-info col-md-offset-1"><span class="glyphicon glyphicon-arrow-left"></span>返回投票</button>
        </div> 
    </div>
  </body>
</html>
