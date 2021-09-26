<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<%@include file="../common/importJsAndCss.jsp" %>
</head>
<body>
		<table id="grid" style="min-height:100px"></table>
		<script type="text/javascript">
			var columns= [[{
				field : 'authFuctionId',
				title : '权限编号',
				width : 100
			},{
				field : 'pid',
				title : '父权限',
				width : 100,
				formatter : function(value,row,index){
					if(row.parentFunc){
						return row.parentFunc.name;
					}else{
						return "(无)";
					}
				}
			},{
				field : 'name',
				title : '权限名',
				width : 100
			},{
				field : 'code',
				title : '权限关键字',
				width : 100,
				formatter : function(value,row,index){
					return value ? value : "(无)";
				}
			},{
				field : 'description',
				title : '描述',
				width : 100,
				formatter : function(value,row,index){
					return value ? value : "(无)";
				}
			},{
				field : 'page',
				title : '页面地址',
				width : 200,
				formatter : function(value,row,index){
					return value ? value : "(无)";
				}
			},{
				field : 'generatemenu',
				title : '是否生成菜单',
				width : 100,
				formatter : function(value,row,index){
					return value=='0' ? '否' : "是";
				}
			},{
				field : 'zindex',
				title : '顺序',
				width : 100
			},
			]];
			var toolbar = [{
				text : '添加权限',
				iconCls : 'icon-add',
				handler : function(){
					//添加权限事件
					$("#addAuthFuncWindow").dialog('open');
				}
			}]
		</script>
		<script type="text/javascript">
			$(function(){
				$("#grid").datagrid({
					singleSelect : true,
					toolbar : toolbar,
					fit : true,
					url : '${pageContext.request.contextPath}/function/queryByPager',
					columns : columns,
				});
			});
		</script>
	<div id="addAuthFuncWindow" class="easyui-dialog" title="添加权限"  data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<div class="easyui-layout" style="width:400px;height:300px;">
			<div data-options="region:'north',split:false" style="height:31px;overflow:hidden;">
				<div class="datagrid-toolbar">
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
					<script type="text/javascript">
						$("#save").click(function(){
							var confirm = $("#addFunctionForm").form('validate');
							if(confirm){
								$("#addFunctionForm").submit();
							}else{
								$.message.alert('请填写必填选项');
							}
						})
					</script>
				</div>
			</div>   
		    <div data-options="region:'center'" style="padding:5px;background:#eee;">
			    <form action="${pageContext.request.contextPath }/function/add" id="addFunctionForm" method="post">
					<table >
						<caption>权限信息</caption>
						<tr>
							<td>父权限</td>
							<td>
								<input id="cc" class="easyui-combobox" name="pid"
    								data-options="valueField:'authFuctionId',textField:'name',url:'${pageContext.request.contextPath }/function/queryAllfunction'" />    
							</td>
						</tr>
						<tr>
							<td>关键字</td>
							<td>
								<input class="easyui-validatebox easyui-textbox" name="code" data-options="required:true" />  
							</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>
								<input class="easyui-validatebox easyui-textbox" name="name" data-options="required:true" />  
							</td>
						</tr>
						<tr>
							<td>描述</td>
							<td>
								<textarea name="description" class="easyui-textbox" data-options="multiline:true"></textarea>  
							</td>
						</tr>
						<tr>
							<td>授权页面</td>
							<td>
								<input class="easyui-validatebox easyui-textbox" name="page"  />
							</td>
						</tr>
						<tr>
							<td>是否生成菜单</td>
							<td>
								<select name="generatemenu ">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>菜单排列顺序</td>
							<td>
								<input class="easyui-numberbox" name="zindex" data-options="min:0,precision:1"></ />
							</td>
						</tr>
					</table>
				</form>
		    </div> 
		</div>
	</div>
</body>
</html>