<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/"/>
		<meta charset="UTF-8">
		<script src="easyui/jquery.min.js"></script>
		<script src="easyui/jquery.easyui.min.js"></script>
		<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
		<title>修改会员</title>
		<title>会员换卡</title>
	</head>
	<body>
		<fieldset id="">
			<legend>会员基本信息</legend>
			<p><label for="">会员姓名:</label><span id="">${card.memcardsName }</span></p>
			<p><label for="">会员等级:</label><span id="">${card.cardlevelsId }</span></p>
			<p><label for="">登记日期:</label><span id="">${card.memcardsCreatetime }</span></p>
		</fieldset>
		<form action="">
			<input type="hidden" name="memcardsId" value="${card.memcardsId }" />
			<fieldset id="">
				<legend>换卡信息</legend>
				<table cellspacing="3" cellpadding="3">
					<tr>
						<td><label for="memcardsPassword">请输入此卡密码</label></td>
						<td><input type="text" name="memcardsPassword" value="" id="memcardsPassword" required/></td>
					</tr>
					<tr>
						<td><label for="memcardsCardid">新会员卡号</label></td>
						<td><input type="text" name="memcardsCardid" value="" id="memcardsCardid" required/></td>
					</tr>
					<tr>
						<td><label for="">新会员卡密码</label></td>
						<td><input type="password" name="" value="" id="" required/></td>
					</tr>
					<tr>
						<td><label for="newpassword">确认密码</label></td>
						<td><input type="password" name="newpassword" value="" id="" required/></td>
					</tr>
					<tr>
						<td><label for=""></label></td>
						<td><input type="submit" value="换卡" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>
