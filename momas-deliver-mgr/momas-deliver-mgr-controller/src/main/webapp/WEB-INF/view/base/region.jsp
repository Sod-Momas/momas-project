<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>区域设置</title>
	<base href="${pageContext.request.contextPath }/" />
	<%@include file="../common/importJsAndCss.jsp"%>
</head>
<body style="visibility: hidden;" >
	<table id="grid"></table>
	
	<!-- 添加区域 -->
	<div id="addRegionWindow" class="easyui-window" title="对区域进行添加" collapsible="false" minimizable="false" maximizable="false" style="width: 300px;" data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:void(0)" class="easyui-linkbutton" plain="true">保存</a>
				<script type="text/javascript">
					$(function(){
						//为保存按钮绑定事件
						$("#save").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#addregionForm").form("validate");
							if(v){
								$('#addregionForm').submit();
							}
						});
					})
				</script>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addregionForm" action="${pageContext.request.contextPath }/region/add" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">区域信息</td>
					</tr>
					<tr>
						<td>省</td>
						<td>
							<input type="text" name="province" class="easyui-validatebox" required="true" />
						</td> 
					</tr>
					<tr>
						<td>市</td>
						<td>
							<input type="text" name="city" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>区</td>
						<td>
						<input type="text" name="district" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>邮编</td>
						<td>
							<input type="text" name="postcode" class="easyui-validatebox" required="true" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- 编辑区域 -->
	<div id="editRegionWindow" class="easyui-window" title="对区域进行添加" collapsible="false" minimizable="false" maximizable="false" style="width: 300px;" data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-edit" href="javascript:void(0)" class="easyui-linkbutton" plain="true">修改</a>
				<script type="text/javascript">
					$(function(){
						//为修改按钮绑定事件
						$("#edit").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#editRegionForm").form("validate");
							if(v){
								$('#editRegionForm').submit();
							}
						});
					})
				</script>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editRegionForm" action="${pageContext.request.contextPath }/region/update" method="post">
				<input type="hidden" name="regionId" />
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">区域信息</td>
					</tr>
					<tr>
						<td>省</td>
						<td>
							<input type="text" name="province" class="easyui-validatebox" required="true" />
						</td> 
					</tr>
					<tr>
						<td>市</td>
						<td>
							<input type="text" name="city" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>区</td>
						<td>
						<input type="text" name="district" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>邮编</td>
						<td>
							<input type="text" name="postcode" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>简码</td>
						<td>
							<input type="text" name="shortcode" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>城市编码</td>
						<td>
							<input type="text" name="citycode" class="easyui-validatebox" required="true" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function doDblClickRow(rowIndex,rowData){
			//打开修改区域窗口
			$('#editRegionWindow').window('open'); 
			//使用form表彰对象的load方法回显数据
			$("#editRegionForm").form("load",rowData);
			
		};
		
		function doEdit(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length < 1 || 1 < rows.length){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				if(rows.length < 1 ){
					//没有选中记录
					$.messager.alert("提示","请选择需要编辑的区域","warnning");
				}
				if(1 < rows.length){
					//没有选中记录
					$.messager.alert("提示","只能同时编辑一行哦!","warnning");
				}
			}else{
				//选中了区域,弹出确认框
				doDblClickRow(null,rows[0]);
			}
		};
		
		function doAdd(){
			$('#addRegionWindow').window("open");
		};
		
		function doDelete(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length == 0){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				//没有选中记录
				$.messager.alert("提示","请选择需要删除的区域","warnning");
			}else{
				//选中了区域,弹出确认框
				$.messager.confirm("删除确认","你确定要删除选中的区域吗?",function(r){
					if(r){
						var array = new Array();
						//确定,发送请求
						//获取所有选中的区域id
						for(var i =0;i<rows.length;i++){
							var region = rows[i];//json对象
							var id = region.regionId;
							array.push(id);
						}
						var ids = array.join(",");//将id们变成字符串,用逗号连接
						location.href= "${pageContext.request.contextPath}/region/delete/"+ ids;
					}
				});
				
			}
		};
	</script>
	<script type="text/javascript">
		function doExportExcel(){
			window.location.href = '${pageContext.request.contextPath}/region/exportExcel';
		}
		$(function() {
			//先将body隐藏,再显示,不会出现页面刷新效果
			$("body").css({ visibility : 'visible' });
	
			//区域信息表格
			$("#grid").datagrid({
				fit : true,
				border : true,
				rownumbers : true,
				striped : false,
				pageList : [10],
				pagination : true,
				toolbar : toolbar,
				url : "${pageContext.request.contextPath}/region/queryByPager",
				idField : 'regionId',
				columns : columns,
				onDblClickRow : doDblClickRow
			});
			$("#button-import").upload({
				action:'${pageContext.request.contextPath}/region/importExcel',
				name:'file',
				onComplete:function(data,self,element){
					if(!data || data =="0"){
						$.messager.alert("提示信息","数据导入失败!","warnning");
					}else{
						$.messager.alert("提示信息","数据导入成功!一共导入"+data+"条数据","warnning");
					}
					//上传结束后刷新结果
					$('#grid').datagrid('reload');
					//location.reload();
				}
				
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
			id : 'button-edit',
			text : '修改',
			iconCls : 'icon-edit',
			handler : doEdit
		}, {
			id : 'button-import',
			text : '导入',
			iconCls : 'icon-redo',
		}, {
			id : 'button-export',
			text : '导出',
			iconCls : 'icon-redo',
			handler : doExportExcel
		},  ];
		var columns = [ [ {
			field : 'regionId',
			checkbox : true,
		}, {
			field : 'province',
			title : '省',
			width : 120,
			align : 'center'
		}, {
			field : 'city',
			title : '市',
			width : 120,
			align : 'center'
		}, {
			field : 'district',
			title : '区',
			width : 120,
			align : 'center'
		}, {
			field : 'postcode',
			title : '邮编',
			width : 120,
			align : 'center'
		}, {
			field : 'shortcode',
			title : '简码',
			width : 120,
			align : 'center'
		}, {
			field : 'citycode',
			title : '城市编码',
			width : 120,
			align : 'center'
		},] ];
	</script>
</body>
</html>