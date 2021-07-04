<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>消费历史记录</title>
	<base href="${pageContext.request.contextPath}/"/>
	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<style type="text/css">
		fieldset{
			border: 1px solid lightblue;
		}
	</style>
</head>
<body>

	<fieldset id="">
		<legend>查找会员</legend>
		<label for="id">卡号/手机号 : </label> 
		<input type="text" name="id" id="id" value="" /> 
		<a href="javascript:load()" class="easyui-linkbutton">查找</a> 
	</fieldset>

	<fieldset >
		<legend>消费记录列表</legend>
		<table id="dg" style=" min-height: 300px;"></table>  
	</fieldset>
	
	<script>
		
		function load(){
			if($("#id").val() == ""){
				$.messager.alert('警告',"请输入卡号/手机号以作查询哦");
				return;
			}
			$('#dg').datagrid('load',{ id : $("input[name=id]").val() });
		}
		
		$("#dg").datagrid({
			url : '${pageContext.request.contextPath}/consum/queryByCardIdOrMobile',
			fitColumns : true,
			pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
			fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
			singleSelect : true, //如果为true，则只允许选择一行。
			rownumbers : true, //如果为true，则显示一个行号列。
			columns : [ [ {
				field : 'consumeordersId',
				title : '订单号',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersId;
				}
			}, {
				field : 'memcardsCardid',
				title : '会员卡号',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.memcardsCardid;
				}
			}, {
				field : 'memberCard.memcardsName',
				title : '会员姓名',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.memberCard == null? '(无)' : row.memberCard.memcardsName;
				}
			}, {
				field : 'consumeordersTotalmoney',
				title : '额度',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersTotalmoney;
				}
			}, {
				field : 'consumeordersTotalmoney',
				title : '实际支付',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersTotalmoney;
				}
			}, {
				field : 'consumeordersRecash',
				title : '积分',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersRecash;
				}
			}, {
				field : 'consumeordersRecash',
				title : '返现金',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersRecash;
				}
			}, {
				field : 'consumeordersOrdertype',
				title : '类型',
				width : 150,
				align : "center",
				formatter : function(value, row) {
					return row.consumeordersOrdertype;
				}
			},
			] ]
		});
	</script>
</body>
</html>