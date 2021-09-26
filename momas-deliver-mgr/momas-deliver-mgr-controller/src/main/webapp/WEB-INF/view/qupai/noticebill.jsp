<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务通知单</title>
<%@include file="../common/importJsAndCss.jsp" %>
<script type="text/javascript">
	
	function doRepeat(){
		var rows=$("#grid").datagrid("getSelections");
		if(rows.length==0){
			//没有选择是提示
			$.messager.alert("提示信息","请选择需要追单的取派员！","warning");
		}else {
			//选中友情提示
			$.messager.confirm("删除确定","你确定要追单？",function(r){
				if(r){
					var array=new Array();
					//发出请求
					for(var i=0;i<rows.length;i++){
						var staff=rows[i];//json对象
						var id=staff.workbillId;
						array.push(id);
					}  
					var ids=array.join(",");//1,2,3,4,5
					location.href="${pageContext.request.contextPath}/workbiil/repeat/" + ids;
				}
			});
		}

	}
	
	function doCancel(){
		var rows=$("#grid").datagrid("getSelections");
		if(rows.length==0){
			//没有选择是提示
			$.messager.alert("提示信息","请选择需要追单的取派员！","warning");
		}else {
			//选中友情提示
			$.messager.confirm("删除确定","你确定要销单?",function(r){
				if(r){
					var array=new Array();
					//发出请求
					for(var i=0;i<rows.length;i++){
						var staff=rows[i];//json对象
						var id=staff.workbillId;
						array.push(id);
					}  
					var ids=array.join(",");//1,2,3,4,5
					location.href="${pageContext.request.contextPath}/workbiil/cancel/" + ids;
				}
			});
		}
	}
	
	function doSearch(){
		$('#searchWindow').window("open");
	}
	
	//工具栏
	var toolbar = [ {
		id : 'button-search',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doSearch
	}, {
		id : 'button-repeat',
		text : '追单',
		iconCls : 'icon-redo',
		handler : doRepeat
	}, {
		id : 'button-cancel',	
		text : '销单',
		iconCls : 'icon-cancel',
		handler : doCancel
	}];
	// 定义列
	var columns = [ [ {
		field : 'workbillId',
		checkbox : true,
	}, {
		field : 'noticebillId',
		title : '通知单号',
		width : 120,
		align : 'center'
	},{
		field : 'type',
		title : '工单类型',
		width : 120,
		align : 'center'
	}, {
		field : 'pickstate',
		title : '取件状态',
		width : 120,
		align : 'center'
	}, {
		field : 'buildtime',
		title : '工单生成时间',
		width : 120,
		align : 'center'
	}, {
		field : 'attachbilltimes',
		title : '追单次数',
		width : 120,
		align : 'center'
	}, {
		field : 'staff.name',
		title : '取派员',
		width : 100,
		align : 'center',
		formatter:function(value,row,index){
			return row.staff.name;
		}
	}, {
		field : 'staff.telephone',
		title : '联系方式',
		width : 100,
		align : 'center',
		formatter:function(value,row,index){
			return row.staff.telephone;
		}
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 收派标准数据表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : true,
			rownumbers : true,
			striped : true,
			pageList: [10,20,30,40,50],
			pagination : true,
			toolbar : toolbar,
			url :  "${pageContext.request.contextPath}/workbiil/query",
			idField : 'id',
			columns : columns,
			singleSelect: true,
			onDblClickRow : doDblClickRow
		});
		
		// 查询分区
		$('#searchWindow').window({
	        title: '查询分区',
	        width: 400,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 400,
	        resizable:false
	    });
		$("#btn").click(function(){
			$("#grid").datagrid('reload',{
				telephone : $('#telephone').val(),
				staff : $('#staff').val(),
				buildtime : $('#buildtime').val()
			})
			$("#searchForm").get(0).reset();// 重置查询表单
			$("#searchWindow").window("close"); // 关闭窗口
		});
	});

	function doDblClickRow(){
		alert("双击表格数据...");
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	
	<!-- 查询分区 -->
	<div class="easyui-window" title="查询窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="searchForm">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">查询条件</td>
					</tr>
					<tr>
						<td>客户电话</td>
						<td><input type="text" id="telephone" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>取派员</td>
						<td><input type="text" id="staff" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>受理时间</td>
						<td><input type="text" id="buildtime" class="easyui-datebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>