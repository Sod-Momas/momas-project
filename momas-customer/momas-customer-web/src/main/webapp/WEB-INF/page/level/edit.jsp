<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
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
	.linkbutton{
		text-decoration: none;
		display: inline-block;
		overflow: hidden;
		margin: 0;
		padding: 0;
		cursor: pointer;
		outline: none;
		text-align: center;
		vertical-align: middle;
		line-height: normal;
		color: #444;
		background: #fafafa;
		background-repeat: repeat-x;
		border: 1px solid #bbb;
		background: -webkit-linear-gradient(top,#ffffff 0,#eeeeee 100%);
		background: -moz-linear-gradient(top,#ffffff 0,#eeeeee 100%);
		background: -o-linear-gradient(top,#ffffff 0,#eeeeee 100%);
		background: linear-gradient(to bottom,#ffffff 0,#eeeeee 100%);
		background-repeat: repeat-x;
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#eeeeee,GradientType=0);
		-moz-border-radius: 5px 5px 5px 5px;
		-webkit-border-radius: 5px 5px 5px 5px;
		border-radius: 5px 5px 5px 5px;
	}
	.linkbutton:hover{
		background: #eaf2ff;
		color: #000000;
		border: 1px solid #b7d2ff;
		filter: none;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/level/updatelevel" method="post" target="_PARENT">
		<input type="hidden" name="cardlevelsId" value="${level.cardlevelsId }"/>
		<table border="0" cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="cardlevelsLevelname">等级名称</label></td>
				<td><input type="text" id="cardlevelsLevelname" name="cardlevelsLevelname" value="${level.cardlevelsLevelname }" required="required" class="text-box"/></td>
			</tr>
			<tr>
				<td><label for="cardlevelsNeedpoint">所需最大积分</label></td>
				<td>
					<input type="number" step="1" min="1" id="cardlevelsNeedpoint"  name="cardlevelsNeedpoint" value="${level.cardlevelsNeedpoint }" required="required" class="text-box" />
				</td>
			</tr>
			<tr>
				<td><label for="cardlevelsPoint">兑换比例</label></td>
				<td>
					<input type="number" step="1" max="9" min="10" id="cardlevelsPoint" name="cardlevelsPoint" value="${level.cardlevelsPoint }"  required="required" class="text-box"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><p style="color:red">注:消费xx人民币兑换1分,默认:10人民币=1积分</p></td>
			</tr>
			<tr>
				<td><label for="cardlevelsPercent">折扣比例</label></td>
				<td><input type="number"  step="0.01" max="1" min="0.01"  id="cardlevelsPercent" name="cardlevelsPercent" value="${level.cardlevelsPercent }" required="required" class="text-box"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><p style="color:red">注:达到此等级时享受的折扣,如:0.8表示打八折,1表示不打折</p></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="修改" class="linkbutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>