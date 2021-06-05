<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-tag"></span>
		添加用户
	</h2>

	<form method="post" class="col-md-6 col-md-offset-3 form-horizontal">
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control readonly" id="userName"
					value="${LOGIN_USER.userName }" name="userName" placeholder="用户名"
					readonly />
			</div>
		</div>
		<div class="form-group">
			<label for="userPassword" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="userPassword"
					name="userPassword" placeholder="密码" required />
			</div>
		</div>
		<div class="form-group">
			<label for="reNewPassword" class="col-sm-2 control-label">密码确认</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="reNewPassword"
					name="reNewPassword" placeholder="请再输入一次密码" required /><span
					id="repwdmsg" style="color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">确认添加</button>
			</div>
		</div>
	</form>

</div>

<%@ include file="../page-footer.jsp" %>