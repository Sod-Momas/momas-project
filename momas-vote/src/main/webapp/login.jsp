<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="GBK">
		<script src="js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<title>登录页</title>
		<script type="text/javascript">
			function passwordRight(){
				var p1 = document.getElementById("registerpassword");
				var p2 = document.getElementById("registerconfirmpassword");
				if(p1.value==p2.value)
					return true;
				alert('密码不一致！请检查！');
				return false;
			}
		</script>
	</head>

	<body
		style="background: url(img/background.jpg) no-repeat; background-size: cover">
		<div class="container">
			<nav class="nav navbar-fixed-top"
				style="background-color: rgba(100,100,100,0.5); height: 50px;"></nav><!-- 顶部灰条 -->
			<div class="row" style="margin-top: 100px;">

				<div class="panel panel-default col-md-4 col-md-offset-4">
					<div class="panel-body">
						<div class="tabbable" id="tabs-box">
							<ul class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#panel-148912" data-toggle="tab">登录</a>
								</li>
								<li>
									<a href="#panel-249423" data-toggle="tab">注册</a>
								</li>
							</ul>
							<!-- 选项卡标签 -->
							<div class="tab-content">
								<div class="tab-pane active" id="panel-148912">
									<form role="form" method="post" action="${pageContext.request.contextPath}/servlet/user?code=1">
										<div class="form-group">
											<label for="exampleInputEmail1">
												电子邮箱
											</label>
											<input type="email" class="form-control" name="email" id="exampleInputEmail1" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">
												密码
											</label>
											<input type="password" class="form-control" name="password" id="exampleInputPassword1" />
										</div>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="rememberme" />
												记住我的登录
											</label>
										</div>
										<button type="submit" class="btn btn-primary">
											登录
										</button>
									</form>
								</div>
								<!-- 登录表单 -->
								<div class="tab-pane" id="panel-249423">
									<form role="form" method="post" action="${pageContext.request.contextPath}/servlet/user?code=2" onsubmit="return passwordRight()">
										<div class="form-group">
											<label for="username">
												用户名
											</label>
											<input type="text" class="form-control" name="username" id="uusername" />
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">
												电子邮箱
											</label>
											<input type="email" class="form-control" name="email" id="exampleInputEmail1" />
										</div>
										<div class="form-group">
											<label for="registerpassword">
												密码
											</label>
											<input type="password" class="form-control" id="registerpassword" />
										</div>
										<div class="form-group">
											<label for="registerconfirmpassword">
												确认密码
											</label>
											<input type="password" class="form-control" name="password" id="registerconfirmpassword" />
										</div>
										<button type="submit" class="btn btn-primary">
											注册
										</button>
									</form>
								</div>
								<!-- 注册表单 -->
							</div>
							<!-- 选项卡内容页 -->
						</div>
					</div>
				</div>


			</div>


		</div>
	</body>

</html>