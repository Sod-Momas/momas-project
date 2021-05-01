<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>租房 - 用户登录</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript">
		function change(S){
				S.src = "${pageContext.request.contextPath }/code/validate?s="+Math.random();
			}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<h4>用户登录</h4>
			<form action="${pageContext.request.contextPath}/users/userlogin" method="post">
			
				<div class="infos">
				
					<table class="field">					
						
						
						<tr>
							<td colspan="2" >${message}</td>
						</tr>
						<tr>
							<td class="field">用 户 名：</td>
							<td><!-- <input type="text" class="text" name="name" /> -->
								<s:textfield name="users.name" cssClass="text" required="true"/>
							</td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td><!-- <input type="password" class="text" name="password" /> -->
							<s:password name="users.password" cssClass="text" required="true"/>
							</td>
						</tr>
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="code" />
								<img alt="验证码" 
									src="${pageContext.request.contextPath }/code/validate" 
									onclick="change(this)" >
									<s:fielderror value="code"></s:fielderror>
							</td>
						</tr>
					</table>
					<div class="buttons">
						<input type="submit" value="立即登录" />
						<input type='button' value='注册' onclick='document.location="${pageContext.request.contextPath}/register.jsp"'/>
					</div>
				</div>
			
			</form>
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


