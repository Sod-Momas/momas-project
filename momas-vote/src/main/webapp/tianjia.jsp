<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加投票界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=BGK" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/webjars/jquery/1.11.1/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
							<li role="presentation">
								<a href="${pageContext.request.contextPath }/servlet/vote?code=1">
									<span class="glyphicon glyphicon-home" aria-hidden="true"></span> 主页列表
								</a>
							</li>
							<li role="presentation" class="active">
								<a >
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
						<h4 style="font-weight: bold;"><img src="img/xiao22.jpg">&nbsp;&nbsp;&nbsp;添加投票</h4>
						<div class="row">
							<!--下面是投票内容-->
							<ul style="list-style:none; margin-left:-20px; width:450px;">
								<li class="alert alert-info">投票内容:<input type="text" class="form-control" placeholder="请输入新的投票内容"></li>
								<li class="alert alert-info">投票类型:&nbsp;&nbsp;&nbsp;
									<label><input type="radio" name="xuan" checked="checked" />单选 </label>
									<label><input type="radio" name="xuan" />多选</label>
								</li>
								<li>
									投票选项:
									<div class="input-group">
										<input type="text" class="form-control" placeholder="这是选项的内容" />
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">删除</button>
										</span>
									</div>
								</li>
								<li id="options">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="这是选项的内容" />
										<span class="input-group-btn">
								            <button class="btn btn-default" type="button" >删除</button>
								      </span>
									</div>
								</li>
							</ul>
							<button type="submit" class="btn btn-info col-md-offset-1">确定</button>
							<button type="button" class="btn btn-success" value="添加" onclick="addOption()">添加选项</button>
							<button type="button" class="btn btn-default">取消操作</button>
						</div>
					</div>

				</div>
			</div>
			<hr/>
		</div>
		<script>
			function addOption() {
				//获取投票选项的DD控件
				var ops = document.getElementById("options");
				//创建p对象
				var pElement = document.createElement("p");

				//创建input对象，并设置其type与name属性
				var inputElement = document.createElement("input");
				inputElement.type = "text";
				inputElement.name = "vsop";
				inputElement.className = "form-control";

				//创建a对象

				var aElement = document.createElement("button");

				aElement.type = "button";
				aElement.className = "btn btn-default";

				aElement.innerText = "删除";
				//判断是否为IE浏览器，添加事件的方式不同
				if(!!document.all) {
					//IE
					aElement.attachEvent("onclick", deleteOption);
				} else {
					//非IE
					aElement.addEventListener("click", deleteOption, false);
				}

				//将input对象放入p对象中
				pElement.appendChild(inputElement);

				//将a标签放到input的后面
				pElement.appendChild(aElement);

				//将p对象放入投票选项的DD控件中
				ops.appendChild(pElement);
			}

			function deleteOption(e) {

				//获取事件对象
				if(!e) e = window.event;
				//获取触发事件的对象，当前应该是a对象
				var a = e.srcElement || e.target;
				//获取a对象的父结点，当前是p对象
				var obj = a.parentNode;
				//调用p对象的父结点，把p结点删除。
				obj.parentNode.removeChild(obj);
			}
		</script>
		</body>
</html>
