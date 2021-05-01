<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>租房 - 注册成功</title>
<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${ctx}/images/logo.gif" /></div>
	<div class="login"><a href="${ctx}/register.jsp">注册</a> <a href="${ctx}/login.jsp">登录</a></div>
	<div class="search">
		<form method="get">
			<input class="text" type="text" name="keywords" />
			<label class="ui-green"><input type="button" name="search" value="搜索房屋" /></label>
		</form>
	</div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<div class="msg">
				<p>恭喜：注册成功！</p>
			</div>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>租房 &copy; 2010  京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>

