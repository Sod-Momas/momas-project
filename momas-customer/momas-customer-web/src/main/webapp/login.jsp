<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>登录</title>

		<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />

		<style>
			.panel {
				margin: 100px auto;
			}
			
			#submit {
				float: right;
				margin-right: 20px;
			}
		</style>
	</head>

	<body>
		<form id="login-panel" action="${pageContext.request.contextPath }/login" method="post" style="padding: 20px;">
			<c:if test="${not empty msg }">
				<p style="text-align:center;color:red;">
					${msg }
				</p>
			</c:if>
			<p>
				<input id="username" name="username" type="text" >
			</p>
			<p>
				<input id="password" name="password" type="password" >
			</p>
			<div id="btn-div">
				<input id="submit" type="submit" value="登录"/>
			</div>
		</form>
		<script>
$(function() {
	$('#login-panel').panel({
		width: 290,
		height: 250,
		title: '登录',
		iconCls: 'icon-man'
	});
	//验证	
	$('#username').validatebox({   
	    required: true,  
		validType: 'text',
		missingMessage: '请填写用户名',
		invalidMessage: '请填写用户名'
	});
	$('#password').validatebox({  
	    required: true,  
		validType: 'text',
		missingMessage: '请填写密码',
		invalidMessage: '请填写密码'
	});

	$('#username').textbox({ 
		//外观
		width: 230,
		height: 30,
	   	label: '账号',
		labelPosition: 'before',
		labelWidth: 30,
		iconCls: 'icon-man',
		prompt: '请输入您的用户名',
		iconAlign: 'right'    ,
		//验证
		required: true,  
		validType: 'text',
		missingMessage: '请填写用户名',
		invalidMessage: '请填写用户名'
	});
	$('#password').textbox({  
		//外观
		width: 230,
		height: 30,
	   	label: '密码',
		labelPosition: 'before',
		labelWidth: 30,
		iconCls: 'icon-lock',
		prompt: '请输入您的密码',
		iconAlign: 'right'    ,
		//验证
		required: true,  
		validType: 'text',
		missingMessage: '请填写密码',
		invalidMessage: '请填写密码'
	});

	
	$('#login-panel').submit( function () {   
		if(!$('#username').validatebox('isValid')){
			$('#username').focus();
			return false;
		}
		if(!$('#password').validatebox('isValid')){
			$('#password').focus();
			return false;
		}
		return true;  
	}); 
	
	$('#submit').linkbutton({   
		width: 50,
		height: 30,
		text: '登录'
	}); 
	


})
		</script>
	</body>

</html>