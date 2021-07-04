<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会员消费统计</title>
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
			<legend>查询</legend>
			<label for="starttime">消费日期 : </label>
			<input type="date" id="starttime" />
			<label for="endtime">至</label>
			<input type="date" id="endtime"/>
			<label for="id">卡号/手机号 : </label>
			<input type="text" id="id" />
			<label for="type">消费类型 : </label>
			<select name="" id="feecondition">
				<option value="1">不限类型</option>
				<option value="2">&lt;</option>
				<option value="3">&gt;</option>
				<option value="4">&lt;=</option>
				<option value="5">&gt;=</option>
			</select>
			<button>查询</button>
		</fieldset>
		<div>
			<table  id="datagrid1"></table>
			<div style="color:red;font-weight:bold;font-size:10px;">总金额合计:$0.00</div>
		</div>
		<div>
			<table  id="datagrid2"></table>
			<div style="color:red;font-weight:bold;font-size:10px;">总金额合计:$0.00，总积分合计：￥0.00</div>
		</div>
		<script type="text/javascript">
			$("#datagrid1").datagrid({
				//url : '${pageContext.request.contextPath}/consum/queryByMemberCardId',
				height : 210,
				fitColumns : true,
				pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
				//fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [ {
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
					field : 'consumeordersId',
					title : '累计消费',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.consumeordersId;
					}
				},
				] ]
			});
			
			$("#datagrid2").datagrid({
				//url : '${pageContext.request.contextPath}/consum/queryByMemberCardId',
				height : 210,
				fitColumns : true,
				pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
				//fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [ { 
					field : 'memcardsCardid',
					title : '订单编号',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsCardid;
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
					field : 'consumeordersId',
					title : '消费金额',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.consumeordersId;
					}
				}, {
					field : 'memcardsCardid',
					title : '获得积分',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsCardid;
					}
				},  {
					field : 'memcardsCardid',
					title : '消费时间',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsCardid;
					}
				},  {
					field : 'memcardsCardid',
					title : '支付方式',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsCardid;
					}
				}, 
				] ]
			});
			
		
		</script>
	</body>

</html>