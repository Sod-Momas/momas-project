<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<%@include file="../common/importJsAndCss.jsp" %>
</head>
<body >
	<table id="grid"></table>
	<div id="addRoleWindow" class="easyui-dialog" title="添加角色"  data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<div class="easyui-layout" style="width:800px;height:600px;">
			<div data-options="region:'north',split:false" style="height:31px;overflow:hidden;">
				<div class="datagrid-toolbar">
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
					<script type="text/javascript">
						$("#save").click(function(){
							var v = $("#save").form("validate")
							
							var treeObj = $.fn.zTree.getZTreeObj("authzList");
							var nodes = treeObj.getCheckedNodes(true);
							console.table(nodes);
							var ids = new Array();
							for (var i = 0; i < nodes.length; i++) {
								ids.push(nodes[i].authFuctionId);
							}
							console.log(ids);
							$("#authFuctionId").val(ids);
							
							if(v){
								// alert('提交表单');
								$("#addRoleForm").submit();
								$('#addRoleWindow').dialog('close');
							}else{
								$.messager.alert('提示','请填写完整')
							}
						})
					</script>
				</div>
			</div>   
		    <div data-options="region:'center'" style="padding:5px;background:#eee;">
			    <form action="${pageContext.request.contextPath }/role/add" id="addRoleForm" method="post">
					<table >
						<caption>角色信息</caption>
						<tr>
							<td>关键字</td>
							<td>
								<input class="easyui-validatebox" name="code" data-options="required:true" />  
							</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>
								<input class="easyui-validatebox" name="name" data-options="required:true" />  
							</td>
						</tr>
						<tr>
							<td>描述</td>
							<td>
								<textarea name="description"></textarea>  
							</td>
						</tr>
						<tr>
							<td>授权</td>
							<td>
								<input type="hidden" name="authFuctionId" id="authFuctionId" value="">
								<ul id="authzList"  class="ztree"></ul> 
							</td>
						</tr>
					</table>
				</form>
		    </div> 
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#grid").datagrid({
				singleSelect : true,
				fit : true,
				toolbar : [ {
					text : '添加角色',
					iconCls : 'icon-add',
					handler : function() {
						// 弹出窗口
						$('#addRoleWindow').dialog('open');
						// 加载权限列表
						$.ajax({
							url : '${pageContext.request.contextPath}/function/queryAllfunction',
							type : 'POST',
							dataType :'json',
							success : function(data){
								window.ztree = $.fn.zTree.init(
									$("#authzList"), 
									{
										check: {
											enable: true,
											chkStyle: "checkbox"
										},
										data:{
											simpleData: {
												enable: true,
												idKey: "authFuctionId",
												pIdKey: "pid",
												rootPId: 0, 
											}
										}
									},
									data
								);
							},
							error:function(msg){
								$.messager.alert('警告','授权列表加载异常');
							}
						});
					}
				} ],
				columns : [ [ {
					field : 'roleId',
					title : '角色编号',
					width : 100
				}, {
					field : 'name',
					title : '角色名',
					width : 100
				}, {
					field : 'code',
					title : '角色关键字',
					width : 100
				}, {
					field : 'description',
					title : '角色描述',
					width : 100
				}, 
				] ],
				url : '${pageContext.request.contextPath}/role/queryByPager'
			});
			
			
		})
	</script>
</body>
</html>