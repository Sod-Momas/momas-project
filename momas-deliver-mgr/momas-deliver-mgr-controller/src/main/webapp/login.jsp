<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<base href="${pageContext.request.contextPath }/">
		<meta charset="UTF-8">
		<title>用户登录</title>
		<%@include file="WEB-INF/view/common/importJsAndCss.jsp"%>
		<style type="text/css">
			body {
				background-color: black;
			}
		</style>
	</head>

	<body>
		<div style="width: 400px;margin: 200px auto;">
			<div class="easyui-panel" title="用户登录" style="width:100%;margin: 0 auto;max-width:400px;padding:30px 60px;">
				<c:if test="${not empty msg}">
					<p style="text-align: center;color: red;">msg</p>
				</c:if>
				<form id="ff" method="post">
					<div style="margin-bottom:20px">
						<input class="easyui-textbox" name="name" style="width:100%" data-options="label:'用户名:',required:true">
					</div>
					<div style="margin-bottom:20px">
						<input class="easyui-passwordbox" name="password" style="width:100%" data-options="label:'密码:',required:true">
					</div>
					<div style="margin-bottom:20px">
						<input class="easyui-textbox" name="validate" style="width:100%" data-options="label:'验证码:',required:true">
						<img src="${pageContext.request.contextPath}/validatecode.jsp" onclick="refreshValidateCode(this)" width="70px" height="30px" alt="点击更换验证码" align="right" />
					</div>
					<div style="margin:20px 0;">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="loadLocal()">匿名登录</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登录</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重填</a>
					</div>
				</form>
			</div>

		</div>
		<script>
			function refreshValidateCode(e){
				e.src="${pageContext.request.contextPath}/validatecode.jsp?s="+ Math.random();
			}
			function loadLocal() {
				$('#ff').form('load', {
					name: 'admin',
					password: '123456',
					validate:'${sessionScope.regcode}',
					language: 'cn'
				});
			}
			function submitForm() {
				$('#ff').form('submit', {
					url: "${pageContext.request.contextPath}/user/login",
					onSubmit: function() {
						var isValid = $(this).form('validate');
						if(!isValid) {
							$.messager.progress('close'); // 如果表单是无效的则隐藏进度条
						}
						return isValid; // 返回false终止表单提交
					},
					success: function() {
						window.open('${pageContext.request.contextPath}/index/common/index','_parent');
					} 
				});
				 // $("#ff").submit(); 
			}
			function clearForm() {
				$('#ff').form('clear');
			}
		</script>
	</body>

</html>