<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
	<base href="${pageContext.request.contextPath}/"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加用户</title>
	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<style type="text/css">
		.text-box{
			font-size: 12px;
			border: 1px solid lightblue;;
			margin: 0;
			padding: 4px;
			white-space: normal;
			vertical-align: top;
			outline-style: none;
			resize: none;
			-moz-border-radius: 5px 5px 5px 5px;
			-webkit-border-radius: 5px 5px 5px 5px;
			border-radius: 5px 5px 5px 5px;
		}
	
	</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/level/addlevel" method="post" target="_PARENT" >
		<table border="0" cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="cardlevelsLevelname">等级名称</label></td>
				<td><input type="text" id="cardlevelsLevelname" value="" name="cardlevelsLevelname" required="required" class="text-box"/></td>
			</tr>
			<tr>
				<td><label for="cardlevelsNeedpoint">所需最大积分</label></td>
				<td>
					<input type="number" step="1" id="cardlevelsNeedpoint"  name="cardlevelsNeedpoint" required="required"  class="text-box"/>
				</td>
			</tr>
			<tr>
				<td><label for="cardlevelsPoint">兑换比例</label></td>
				<td>
					<input type="number" step="1" max="9" min="1" id="cardlevelsPoint" name="cardlevelsPoint" value="1" required="required"  class="text-box"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><p style="color:red">注:消费x人民币兑换1分,默认:1人民币=1积分</p></td>
			</tr>
			<tr>
				<td><label for="cardlevelsPercent">折扣比例</label></td>
				<td><input type="number" step="0.01" max="1" min="0.01"  id="cardlevelsPercent" name="cardlevelsPercent" value="1" required="required" class="text-box" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><p style="color:red">注:达到此等级时享受的折扣,如:0.8表示打八折,1表示不打折</p></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="新增" class="easyui-linkbutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>