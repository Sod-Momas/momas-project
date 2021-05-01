<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>租房 - 用户登录</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<script type="text/javascript" src="scripts/function.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.gif" />
			</div>
		</div>
		<div id="regLogin" class="wrap">
			<div class="dialog">
				<div class="box">
					<h4>
						登录失败
					</h4>
					<form action="login.action">
						<div class="infos">
							<table class="field">
								<!--<tr>
							<td class="field">用 户 名：</td>
							<td><input type="text" class="text" name="name" /></td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td><input type="password" class="text" name="password" /></td>
						</tr>
						
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						-->
								<tr>
									<td>
										${message}，<a href="page/login_struts2.jsp">返回</a>
									</td>
								</tr>
							</table>

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


