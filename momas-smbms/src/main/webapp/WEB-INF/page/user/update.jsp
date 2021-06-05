<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../page-header.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-tag"></span> 修改用户
	</h2>
	<form method="post" class="col-md-6 col-md-offset-3 form-horizontal">
		<input type="hidden" name="userId" value="${user.userId }" class="sr-only" />
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control readonly" id="userName"
					value="${user.userName }" name="userName" placeholder="用户名" />
			</div>
		</div>
		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">用户地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control readonly" id="address"
					value="${user.address }" name="address" placeholder="用户地址" />
			</div>
		</div>
		<div class="form-group">
			<label for="birthday" class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="birthday"
					name="birthday" value="${user.birthday }" placeholder="生日" />
			</div>
		</div>
		<div class="form-group">
			<label for="gender" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="gender" name="gender"
					value="${user.gender }" placeholder="性别">
			</div>
		</div>
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">手机</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="phone" name="phone"
					value="${user.phone }" placeholder="手机">
			</div>
		</div>
		<div class="form-group">
			<label for="userCode" class="col-sm-2 control-label">编号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userCode"
					name="userCode" value="${user.userCode }" placeholder="编号">
			</div>
		</div>
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userName"
					name="userName" value="${user.userName }" placeholder="用户名" />
			</div>
		</div>
		<div class="form-group">
			<label for="userRole" class="col-sm-2 control-label">角色</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userRole"
					name="userRole" value="${user.userRole }" placeholder="角色" />
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
					placeholder="请再输入一次密码" required /><span id="repwdmsg"
					style="color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">确认修改</button>
			</div>
		</div>
	</form>

</div>

<%@ include file="../page-footer.jsp"%>