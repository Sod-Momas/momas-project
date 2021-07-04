<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改个人资料</title>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />

</head>
<body >
	<form action="${pageContext.request.contextPath }/user/updatePersonProfile" target="_parent">
		<input type="hidden" name="usersId" value="${LOGIN_USER.usersId}" />
		<table align="center">
			<tr>
				<td>
					登陆名:
				</td>
				<td>
					<input class="easyui-textbox"  id="PName" name="usersLoginname" type="text" value="${LOGIN_USER.usersLoginname }" required="required" />
				</td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input class="easyui-textbox" id="Name"
					name="usersRealname" type="text"
					value="${LOGIN_USER.usersRealname }" required="required"  />
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<label><input type="radio" name="usersSex" value="男" <c:if test="${LOGIN_USER.usersSex eq '男' }">checked</c:if> />男 </label>
					<label><input type="radio" name="usersSex" value="女" <c:if test="${LOGIN_USER.usersSex eq '女' }">checked</c:if> /> 女</label>
				</td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td>
					<input class="easyui-textbox" id="Adrr" name="usersTelephone" type="text" value="${LOGIN_USER.usersTelephone }" required="required"  />
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit"  value="修改" class="easyui-linkbutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>