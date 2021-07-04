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
	<form action="${pageContext.request.contextPath }/user/setAdmin" method="post" target="_PARENT">
		<input type="hidden" value="${shopId }" name="shopId"/>
		<table cellspacing="5" cellpadding="5">
			<tr>
				<td><label for="usersLoginname">管理员名称</label></td>
				<td><input type="text" name="usersLoginname" id="usersLoginname" value=""  required/></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight:bold;color:red;">
					注意:默认密码是 123456 
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="确认" /></td>
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