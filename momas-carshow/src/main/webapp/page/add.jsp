<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=UTF-8">
		<title>添加汽车</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
		<script type="text/javascript">
			var ctx='${pageContext.request.contextPath}';
			var isSearch = false;
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/carinfoadd" method="post">
			<table id="addtable" border="1px" rules="rows" cellspacing="5" cellpadding="10">
				<tr>
					<td><label for="carname">汽车名</label></td>
					<td>
						<input type="text" name="carinfo.carname" id="carname" value="" />
					</td>
				</tr>
				<tr>
					<td><label for="carcolor">汽车颜色</label></td>
					<td>
						<input type="text" name="carinfo.carcolor" id="carcolor" value="" />
					</td>
				</tr>
				<tr>
					<td><label for="cardisplacement">汽车排量</label></td>
					<td>
						<input type="text" name="carinfo.cardisplacement" id="cardisplacement" value="" />
					</td>
				</tr>
				<tr>
					<td><label for="carclutch">变速器类型</label></td>
					<td>
						<input type="text" name="carinfo.carclutch" id="carclutch" value="" />
					</td>
				</tr>
				<tr>
					<td><label for="carprice">价格</label></td>
					<td>
						<input type="text" name="carinfo.carprice" id="carprice" value="" />
					</td>
				</tr>
				<tr>
					<td><label for="brand">品牌</label></td>
					<td>
						<select name="brand" id="brand">
							<option value="">不限</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="modal">型号</label></td>
					<td>
						<select name="carinfo.carmodal.modelid" id="modal">
							<option value="">不限</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="确认添加"/>
					</td>
				</tr>
			</table>
		
		</form>
	</body>
</html>