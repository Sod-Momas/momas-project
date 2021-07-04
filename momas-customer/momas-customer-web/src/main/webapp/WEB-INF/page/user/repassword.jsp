<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />
	<style type="text/css">
		form{
			
			width: 300px;
			margin: 0 auto;
		}
	</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/repassword" method="post" onsubmit="return validating()">
		<input type="hidden" name="usersId" id="usersId" value="${sessionScope.LOGIN_USER.usersId}" />
		<table border="0" cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="usersLoginname">用户名</label></td>
				<td><input readonly type="text" name="ddd" value="${sessionScope.LOGIN_USER.usersLoginname }" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td><label for="usersPassword">旧密码</label></td>
				<td><input required type="password" id="usersPassword" name="usersPassword" class="easyui-passwordbox" prompt="旧密码"/></td>
			</tr>
			<tr>
				<td><label for="n1">新密码</label></td>
				<td><input required type="password" id="n1" class="easyui-passwordbox" prompt="新密码"/></td>
			</tr>
			<tr>
				<td><label for="newPassword">确认密码</label></td>
				<td><input required type="password" id="newPassword" name="newPassword" class="easyui-passwordbox" prompt="确认密码"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="确认修改" class="easyui-linkbutton"/>
					<input type="reset" value="重置" class="easyui-linkbutton"/>
				</td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function validating() {
			var pwd = document.getElementById("n1");
			var newPwd = document.getElementById("newPassword");
			if (pwd.value != newPwd.value) {
				//newPwd.setCustomValidity("密码不一致");
				$.messager.alert("警告","新密码和确认密码不一致","warning");
				$("#newPassword").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>