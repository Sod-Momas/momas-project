<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加店铺页面</title>
<style type="text/css">
table {
	width: 300px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/shop/addShop" method="post" target="_PARENT">
		<table cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="shopName">店铺名称</label></td>
				<td><input type="text" name="shopName" id="shopName" value="" required /></td>
			</tr>
			<tr>
				<td><label for="shopCategoryId">店铺类型</label></td>
				<td>
					<select name="shopCategoryId">
						<!-- <option value="">--请选择店铺类型--</option> -->
						<c:forEach items="${categories }" var="c">
							<option value="${c.categoryId }">${c.categoryTitle }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="shopContactname">联系人</label></td>
				<td><input type="text" name="shopContactname" id="shopContactname" value="" /></td>
			</tr>
			<tr>
				<td><label for="shopContacttel">联系电话</label></td>
				<td><input type="text" name="shopContacttel" id="shopContacttel" value="" /></td>
			</tr>
			<tr>
				<td><label for="shopAddress">店铺地址</label></td>
				<td><input type="text" name="shopAddress" id="shopAddress" value="" /></td>
			</tr>
			<tr>
				<td><label for="shopRemark">备注</label></td>
				<td><input type="text" name="shopRemark" id="shopRemark" value="" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="新增" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		/* $.getJSON("url", function(data) {
			$.each(data.items, function(i, item) {
				$("select").appendTo(item);
			});
		}); */
	</script>
</body>
</html>