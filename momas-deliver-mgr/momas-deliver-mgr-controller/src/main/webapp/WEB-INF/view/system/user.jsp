<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../common/importJsAndCss.jsp" %>
<title>用户管理</title>
</head>
<body>
	<table id="grid"></table>
	
	<script type="text/javascript">
			var columns= [[{
				field : 'userId',
				title : '用户编号',
				width : 100
			},{
				field : 'username',
				title : '用户名',
				width : 100,
			},{
				field : 'salary',
				title : '工资',
				width : 100
			},{
				field : 'birthday',
				title : '生日',
				width : 100,
				formatter : function(value,row,index){
					return isNaN(value) ? value : new Date(value);
				}
			},{
				field : 'gender',
				title : '性别',
				width : 100,
				formatter : function(value,row,index){
					if(value == '0'){
						return '女';
					}else{
						return '男';
					}
				}
			},{
				field : 'station',
				title : '工作单位',
				width : 200,
				formatter : function(value,row,index){
					return value ? value : "(无)";
				}
			},{
				field : 'telephone',
				title : '联系电话',
				width : 100,
				formatter : function(value,row,index){
					return value ? value : "(无)";
				}
			},{
				field : 'remark',
				title : '备注',
				width : 100
			},
			]];
			var toolbar = [{
				text : '添加用户',
				iconCls : 'icon-add',
				fit : true,
				handler : function(){
					//添加权限事件
					$("#addUserWindow").dialog('open');
				}
			}];
		</script>
	<script type="text/javascript">
		$(function(){
			$("#grid").datagrid({
				singleSelect : true,
				fit : true, 
				toolbar : toolbar,
				url : '${pageContext.request.contextPath}/user/queryByPager',
				columns : columns,
			});
		});
	</script>
		
	<div id="addUserWindow" class="easyui-dialog" title="添加用户"  data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<div class="easyui-layout" style="width:600px;height:400px;">
			<div data-options="region:'north',split:false" style="height:31px;overflow:hidden;">
				<div class="datagrid-toolbar">
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
					<script type="text/javascript">
						$("#save").click(function(){
							var confirm = $("#addUserForm").form('validate');
							if(confirm){
								$("#addUserForm").submit();
							}else{
								$.message.alert('请填写必填选项');
							}
						})
					</script>
				</div>
			</div>   
		    <div data-options="region:'center'" style="padding:5px;background:#eee;">
			    <form action="${pageContext.request.contextPath }/user/add" id="addUserForm" method="post">
					<table >
						<caption>员工信息</caption>
						<tr>
							<td>用户名</td>
							<td>
								<input class="easyui-validatebox easyui-textbox" name="username" data-options="required:true" />  
							</td>
							<td>口令</td>
							<td>
								<input class="easyui-validatebox easyui-passwordbox" name="password" data-options="required:true" />  
							</td>
						</tr>
						<caption>其他信息</caption>
						<tr>
							<td>工资</td>
							<td>
								<input type="text" class="easyui-numberbox" value="100" data-options="min:1,precision:2" name="salary"/>
							<td>生日</td>
							<td>
								<input type="text" class = "easyui-datebox" name="birthday"/>
							</td>
						</tr>
						<tr>
							<td>性别</td>
							<td>
								<select  class="easyui-combobox" name="gender" style="width:100px;">   
								   	<option value="1">男</option>
									<option value="0">女</option>  
								</select>  
							</td>
							<td>单位</td>
							<td>
								<select  class="easyui-combobox" name="station" style="width:100px;">   
									<option value="分公司">分公司</option>
								   	<option value="总公司">总公司</option>
									<option value="某部门">某部门</option>  
								</select> 
							</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td colspan="3">
								<input type="text" class="easyui-validatebox easyui-textbox" name="telephone" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>备注</td>
							<td colspan="3">
								<textarea name="remark" class="easyui-textbox" data-options="multiline:true"></textarea>
							</td>
						</tr><tr>
							<td>选择角色</td>
							<td colspan="3">
								<input class="easyui-combobox" name="roleid" 
									data-options="valueField:'roleId',textField:'name',url:'${pageContext.request.contextPath }/role/queryAll'" /> 
							</td>
						</tr>
					</table>
				</form>
		    </div> 
		</div>
	</div>
</body>
</html>