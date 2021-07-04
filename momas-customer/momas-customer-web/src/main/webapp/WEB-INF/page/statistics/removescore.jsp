<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>减积分统计</title>
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
			<table cellpadding="2">
				<tr>
					<td><label for="starttime">消费日期 : </label></td>
					<td><input type="date" id="starttime" /></td>
					<td><label for="endtime">至</label></td>
					<td><input type="date" id="endtime"/></td>
				</tr>
				<tr>
					<td><label for="id">卡号/手机号 : </label></td>
					<td><input type="text" id="id" /></td>
					<td><label for="">按会员等级 : </label></td>
					<td>
						<select id="cardlevelsId" name="cardlevelsId">
							<c:forEach items="${levels }" var="l">
							 	<option value="${l.cardlevelsId}">${l.cardlevelsLevelname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="logid">订单号 : </label></td>
					<td><input type="text" id="logid"/></td>
					<td><label for="">消费金额 : </label></td>
					<td>
						<select name="" id="feecondition">
							<option value="1">=</option>
							<option value="2">&lt;</option>
							<option value="3">&gt;</option>
							<option value="4">&lt;=</option>
							<option value="5">&gt;=</option>
						</select>
						<input type="number" id="fee" />
						<button id="search">查询</button>
					</td>
				</tr>
			</table>
		</fieldset>
		<div style="min-height:300px;margin-top:10px;">
			<table id="dg"></table>
		</div>
		<script type="text/javascript">
			$("#search").click(function(){
				$('#dg').datagrid('load',{ 
					starttime : $('#starttime').val(),//开始时间
					endtime : $('#endtime').val(),//结束时间
					id : $("#id").val(),//卡号/手机号
					level : $("#cardlevelsId").val(),//会员等级
					logid: $("#logid").val(),//订单号
					feecondition : $("#feecondition").val(),//大于/小于/。。。
					fee : $("#fee").val()//消费金额
					
					});
			})
			
			$("#dg").datagrid({
				//url : '${pageContext.request.contextPath}/statistics/fastconsum',
				fitColumns : true,
				pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
				fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [ {
					field : 'consumeordersId',
					title : '订单号',
					align : "center",
				}, {
					field : 'memcardsCardid',
					title : '会员卡号',
					align : "center",
				}, {
					field : 'memberCard.memcardsName',
					title : '会员姓名',
					align : "center",
				}, {
					field : 'consumeordersTotalmoney',
					title : '减去积分',
					align : "center",
				}, {
					field : 'consumeordersTotalmoney',
					title : '消费时间',
					align : "center",
				},
				] ]
			});
		</script>
	</body>

</html>