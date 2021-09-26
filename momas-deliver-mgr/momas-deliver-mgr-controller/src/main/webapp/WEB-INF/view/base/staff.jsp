<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>取派员设置</title>
	<base href="${pageContext.request.contextPath }/" />
	<%@include file="../common/importJsAndCss.jsp"%>
</head>
<body style="visibility: hidden;" >
	<table id="grid"></table>
	
	<div id="addStaffWindow" class="easyui-window" title="对取派员进行添加" collapsible="false" minimizable="false" maximizable="false" style="width: 300px;" data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:void(0)" class="easyui-linkbutton" plain="true">保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addStaffForm" action="${pageContext.request.contextPath }/staff/add" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>
							<input type="text" name="name" class="easyui-validatebox" required="true" />
						</td> 
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script type="text/javascript">
								$(function(){										
									//为保存按钮绑定事件
									$("#save").click(function(){
										//表单校验,如果通过,提交表单
										var v = $("#addStaffForm").form("validate");
										if(v){
											$('#addStaffForm').submit();
										}
									});
									var reg = /^1[3|4|5|7|8][0-9]{9}/;
									//扩展手机号校验规则
									$.extend($.fn.validatebox.defaults.rules,{
										telephone: {
											validator:function(value,param){
												return reg.test(value);
											},
											message:"手机号码输入有误 !"
										}
									});
								})
							</script>
							<input type="text" data-options="validType:'telephone'" name="telephone" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>单位</td>
						<td>
							<input type="text" name="station" calss="easyui-validatebox" required="true" /> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<label><input type="checkbox" name="haspda" value="1"/>是否有PDA</label>
						</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" calss="easyui-validatebox" required="true"/>
						</td>
					</tr>
				
				</table>
			</form>
		</div>
	</div>
	
	<div id="editStaffWindow" class="easyui-window" title="对取派员进行修改" collapsible="false" minimizable="false" maximizable="false" style="width: 300px;" data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="updateStaff" icon="icon-edit" href="javascript:void(0)" class="easyui-linkbutton" plain="true">修改</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editStaffForm" action="${pageContext.request.contextPath }/staff/update" method="post">
				<input name="staffId" type="hidden" value=""/>
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>
							<input type="text" name="name" class="easyui-validatebox" required="true" />
						</td> 
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script type="text/javascript">
								$(function(){										
									//为保存按钮绑定事件
									$("#updateStaff").click(function(){
										//表单校验,如果通过,提交表单
										var v = $("#editStaffForm").form("validate");
										if(v){
											$('#editStaffForm').submit();
										}
									});
								})
							</script>
							<input type="text" data-options="validType:'telephone'" name="telephone" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>单位</td>
						<td>
							<input type="text" name="station" calss="easyui-validatebox" required="true" /> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<label><input type="checkbox" name="haspda" value="1"/>是否有PDA</label>
						</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" calss="easyui-validatebox" required="true"/>
						</td>
					</tr>
				
				</table>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		function doDblClickRow(rowIndex,rowData){
			//打开修改取派员窗口
			$('#editStaffWindow').window('open'); 
			//使用form表彰对象的load方法回显数据
			$("#editStaffForm").form("load",rowData);
			
		};
		
		function doAdd(){
			$('#addStaffWindow').window("open");
		};
		function doDelete(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length == 0){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				//没有选中记录
				$.messager.alert("提示","请选择需要删除的取派员","warnning");
			}else{
				//选中了取派员,弹出确认框
				$.messager.confirm("删除确认","你确定要删除选中的取派员吗?",function(r){
					if(r){
						var array = new Array();
						//确定,发送请求
						//获取所有选中的取派员id
						for(var i =0;i<rows.length;i++){
							var staff = rows[i];//json对象
							var id = staff.staffId;
							array.push(id);
						}
						var ids = array.join(",");//将id们变成字符串,用逗号连接
						location.href= "${pageContext.request.contextPath}/staff/delete/"+ ids;
					}
				});
				
			}
		};
		function doRestore(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length == 0){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				//没有选中记录
				$.messager.alert("提示","请选择需要还原的取派员","warnning");
			}else{
				//选中了取派员,弹出确认框
				$.messager.confirm("删除确认","你确定要还原选中的取派员吗?",function(r){
					if(r){
						var array = new Array();
						//确定,发送请求
						//获取所有选中的取派员id
						for(var i =0;i<rows.length;i++){
							var staff = rows[i];//json对象
							var id = staff.staffId;
							array.push(id);
						}
						var ids = array.join(",");//将id们变成字符串,用逗号连接
						location.href= "${pageContext.request.contextPath}/staff/restore/"+ ids;
					}
				});
				
			}
			
		};
		
		
	</script>
	<script type="text/javascript">
		$(function() {
			//先将body隐藏,再显示,不会出现页面刷新效果
			$("body").css({ visibility : 'visible' });
	
			//取派员信息表格
			$("#grid").datagrid({
				fit : true,
				border : true,
				rownumbers : true,
				striped : false,
				pageList : [10],
				pagination : true,
				toolbar : toolbar,
				url : "${pageContext.request.contextPath}/staff/queryByPager",
				idField : 'staffId',
				columns : columns,
				onDblClickRow : doDblClickRow
			});
			
		})
	</script>
	<script type="text/javascript">
		var toolbar = [ {
			id : 'button-remove',
			text : '删除',
			iconCls : 'icon-remove',
			handler : doDelete
		}, {
			id : 'button-add',
			text : '增加',
			iconCls : 'icon-add',
			handler : doAdd
		}, {
			id : 'button-restore',
			text : '还原',
			iconCls : 'icon-redo',
			handler : doRestore
		} ];
		var columns = [ [ {
			field : 'staffId',
			checkbox : true,
		}, {
			field : 'name',
			title : '姓名',
			width : 120,
			align : 'center'
		}, {
			field : 'telephone',
			title : '手机号',
			width : 120,
			align : 'center'
		}, {
			field : 'haspda',
			title : '是否在PDA',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				if (data == "1") {
					return "有";
				} else {
					return "无";
				}
			}
		}, {
			field : 'deltag',
			title : '是否删除',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				if (data == "0") {
					return "正常使用";
				} else {
					return "已删除";
				}
			}
		}, {
			field : 'standard',
			title : '取派标准',
			width : 120,
			align : 'center'
		}, {
			field : 'station',
			title : '所有单位',
			width : 120,
			align : 'center'
		}, ] ];

	
	</script>
</body>
</html>