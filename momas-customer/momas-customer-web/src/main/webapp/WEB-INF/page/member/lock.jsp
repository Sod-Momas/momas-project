<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
<title>挂失/锁定</title>
</head>
<body>
	<div style="width: 221px;margin:0 auto">
		<form action="member/updatemember" method="post" target="_parent">
			<table ellspacing="2" cellpadding="2">
				<tr>
					<td><label for="memcardsId">会员卡号</label></td>
					<td><input class="easyui-textbox" type="text" name="memcardsId" id="memcardsId" value="${card.memcardsId }" required/></td>
				</tr>
				<tr>
					<td><label for="">状态</label></td>
					<td>
						<select name="memcardsState">
							<c:forEach items="${states }" var="s">
							 	<option value="${s.categoryId}"
							 	<c:if test="${s.categoryId eq card.memcardsState }">selected</c:if>
							 	>${s.categoryTitle}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" class="easyui-linkbutton" value="修改"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
	
	
	
	
	
	
	