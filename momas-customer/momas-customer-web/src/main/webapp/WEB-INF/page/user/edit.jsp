<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<style type="text/css">
table {
	width: 300px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/editUser" method="post" target="_PARENT">
		<input type="hidden" name="usersId" id="usersId" value="${user.usersId}" />
		<table cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="usersLoginname">登录名</label></td>
				<td><input type="text" name="usersLoginname" id="usersLoginname" value="${user.usersLoginname}" /></td>
			</tr>
			<tr>
				<td><label for="usersRealname">真实姓名</label></td>
				<td><input type="text" name="usersRealname" id="usersRealname" value="${user.usersRealname}" /></td>
			</tr>
			<tr>
				<td><label>性别</label></td>
				<td>
					<label><input type="radio" name="usersSex" value="男" <c:if test="${user.usersSex eq '男' }">checked</c:if> />男</label>
					<label><input type="radio" name="usersSex" value="女" <c:if test="${user.usersSex eq '女' }">checked</c:if>/>女</label>
				</td>
			</tr>
			
			<tr>
				<td><label for="usersTelephone">联系电话</label></td>
				<td><input type="tel" name="usersTelephone" id="usersTelephone" value="${user.usersTelephone}" /></td>
			</tr>
			<tr>
				<td><label for="usersRole">角色</label></td>
				<td>
					<select name="usersRole">
						<c:if test="${ not empty roles}">
							<c:forEach items="${roles }" var="r">
								<option value="${r.categoryId}" 
								<c:if test="${r.categoryId eq user.usersRole }">checked</c:if>
								>${r.categoryTitle}</option>
							</c:forEach>
						</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="usersCandelete">是否可以删除</label></td>
				<td><label><input type="checkbox" name="usersCandelete" id="usersCandelete"  value="${user.usersCandelete}" />是</label></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="新增" /></td>
			</tr>
		</table>
	</form>
</body>
</html>