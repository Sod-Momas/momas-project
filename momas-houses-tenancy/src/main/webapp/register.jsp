<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>租房 - 用户注册</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			$(function(){
				
				
				
			})
			function validate(){
				//清空所有消息
				$("input+span").html("");
				
				if($("#name").val() == ""){
					$("#nameMsg").html("<font color='red' >登录名不能为空</font>");
					return false;
				}
				if($("#password").val() == ""){
					$("#passwordMsg").html("<font color='red' >密码不能为空</font>");
					return false;
				}
				if($("#username").val() == ""){
					$("#usernameMsg").html("<font color='red' >用户名不能为空</font>");
					return false;
				}
				if($("#password").val() != $("#repassword").val()){
					$("#repasswordMsg").html("<font color='red' >密码不一致!</font>");
					return false;
				}
				return true;
			}
		</script>		
		
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="${pageContext.request.contextPath}/images/logo.gif" />
			</div>
		</div>
		<div id="regLogin" class="wrap">
			<div class="dialog">
				<dl class="clearfix">
					<dt>
						新用户注册
					</dt>
					<dd class="past">
						填写个人信息
					</dd>
				</dl>
				<div class="box">
					<form action="${pageContext.request.contextPath}/users/userregister" method="post" onsubmit="return validate(this)">
						<div class="infos">
							<table class="field">
								<tr>
									<td class="field">
										用 户 名：
									</td>
									<td>
										<input type="text" class="text" name="users.name" id="name" />
										<span id="nameMsg"></span>
									</td>
								</tr>
								<tr>
									<td class="field">
										密 码：
									</td>
									<td>
										<input type="password" class="text" name="users.password" id="password" />
										<span id="passwordMsg"></span>
									</td>
								</tr>
								<tr>
									<td class="field">
										确认密码：
									</td>
									<td>
										<input type="password" class="text" name="repassword" id="repassword" />
										<span id="repasswordMsg"></span>
									</td>
								</tr>
								<tr>
									<td class="field">
										电 话：
									</td>
									<td>
										<input type="text" class="text" name="users.telephone" id="telephone" />
										<span id="telephoneMsg"></span>
									</td>
								</tr>
								<tr>
									<td class="field">
										用户姓名：
									</td>
									<td>
										<input type="text" class="text" name="users.username" id="username" />
										<span id="usernameMsg"></span>
									</td>
								</tr>
							</table>
							<div class="buttons">
								<input type="submit" name="submit" value="立即注册" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="footer" class="wrap">
			<dl>
				<dt>
					租房 &copy; 2010 京ICP证1000001号
				</dt>
				<dd>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</dd>
			</dl>
		</div>
	</body>
</html>

