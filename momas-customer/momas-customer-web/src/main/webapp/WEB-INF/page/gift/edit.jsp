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
	<form action="${pageContext.request.contextPath }/gift/updategift" method="post" target="_PARENT">
		<input type="hidden" name="exchanggiftsId" value="${gift.exchanggiftsId}"/>
		<table border="0" cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="exchanggiftsGiftcode">礼品代号</label></td>
				<td><input type="text" id="exchanggiftsGiftcode" name="exchanggiftsGiftcode" required="required" value="${gift.exchanggiftsGiftcode}"/></td>
			</tr>
			<tr>
				<td><label for="exchanggiftsGiftname">礼品名称</label></td>
				<td><input type="text" id="exchanggiftsGiftname" name="exchanggiftsGiftname" required="required" value="${gift.exchanggiftsGiftname}"/></td>
			</tr>
			<tr>
				<td><label for="exchanggiftsPhoto">礼品图片</label></td>
				<td><input type="text" id="exchanggiftsPhoto" name="exchanggiftsPhoto" value="${gift.exchanggiftsPhoto}" /></td>
			</tr>
			<tr>
				<td><label for="exchanggiftsPoint">所需积分</label></td>
				<td><input type="number"  id="exchanggiftsPoint" name="exchanggiftsPoint" required="required" value="${gift.exchanggiftsPoint}"/></td>
			</tr>
			<tr>
				<td><label for="exchanggiftsInteger">礼品数量</label></td>
				<td><input type="number"  id="exchanggiftsInteger" name="exchanggiftsInteger" required="required" value="${gift.exchanggiftsInteger}"/></td>
			</tr>
			<tr>
				<td><label for="exchanggiftsRemark">备注</label></td>
				<td><input type="text"  id="exchanggiftsRemark" name="exchanggiftsRemark" value="${gift.exchanggiftsRemark}"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="确认修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>