<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">修改密码</h1>

	<div class="row placeholders">
		<form method="post" id="rePassword" class="col-md-6 col-md-offset-3 form-horizontal">
		<input type="hidden" name="userId" value="${LOGIN_USER.userId }"/>
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control readonly" id="userName" value="${LOGIN_USER.userName }" name="userName" placeholder="用户名" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="userPassword" class="col-sm-2 control-label">旧密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="旧密码" required/>
			</div>
		</div>
		<div class="form-group">
			<label for="newPassword" class="col-sm-2 control-label">新密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="新密码" required/>
			</div>
		</div>
		<div class="form-group">
			<label for="reNewPassword" class="col-sm-2 control-label">新密码确认</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="reNewPassword" name="reNewPassword" placeholder="请再输入一次新密码" required/><span id="repwdmsg" style="color:red"></span>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">确认修改</button>
				<button type="reset" class="btn btn-link">重填</button>
			</div>
		</div>
	</form>
	
		
	</div>
</div>
<script type="text/javascript">
<!--
window.onload=function (){
	var rePasswordForm = document.getElementById('rePassword');
	rePasswordForm.onsubmit=function(){
		var p1 = document.getElementById('newPassword');
		var p2 = document.getElementById('reNewPassword');
		var msg = document.getElementById('repwdmsg');
		if(p1.value == null || p1.value != p2.value){
			// msg.innerTEXT='<!>两次密码不一致';
			alert('<!>两次密码不一致');
			return false;
		}
		msg.innerTEXT = '';
		return true;
	}
}

//-->
</script>

<%@ include file="../page-footer.jsp" %>