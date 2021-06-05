<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-eye-open"></span>
		查看用户
	</h2>

	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<td class="text-center">用户id</td>
						<td>${user.userId }</td>
					</tr>
					<tr>
						<td class="text-center">用户名</td>
						<td>${user.userName }</td>
					</tr>
					<tr>
						<td class="text-center">用户角色</td>
						<td>${user.userRole }</td>
					</tr>
					<tr>
						<td class="text-center">生日</td>
						<td>${user.birthday }</td>
					</tr>
					<tr>
						<td class="text-center">性别</td>
						<td>${user.gender }</td>
					</tr>
					<tr>
						<td class="text-center">手机号码</td>
						<td>${user.phone }</td>
					</tr>
					<tr>
						<td class="text-center">用户编码</td>
						<td>${user.userCode }</td>
					</tr>
					<tr>
						<td class="text-center">用户密码</td>
						<td>${user.userPassword }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="../page-footer.jsp" %>