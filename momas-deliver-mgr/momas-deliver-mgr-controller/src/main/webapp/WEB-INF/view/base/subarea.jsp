<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理分区</title>
	<base href="${pageContext.request.contextPath }/" />
	<%@include file="../common/importJsAndCss.jsp"%>
	<style type="text/css">
		body{
			margin:0;
			padding:0;
			height:100%;
		}
		td:nth-child(2n-1){
			text-align: right;
		}
	
	</style>
</head>
<body>

	<table id="grid"></table>
	
	<!-- 添加分区小窗口 -->
	<div id="addSubAreaWindow" class="easyui-window" title="对区域进行添加" collapsible="false" minimizable="false" maximizable="false"  data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:void(0)" class="easyui-linkbutton" plain="true">添加</a>
				<script type="text/javascript">
					$(function(){
						//为修改按钮绑定事件
						$("#save").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#manageSubAreaForm").form("validate");
							if(v){
								$('#manageSubAreaForm').submit();
							}
						});
					})
				</script>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="manageSubAreaForm" action="${pageContext.request.contextPath }/subarea/add" method="post" style="width: 300px;">
				<table class="table-edit" width="80%" align="center" border="0" cellspacing="5" cellpadding="5">
					<caption>
						分区信息
					</caption>
					<tr>
						<td>选择区域</td>
						<td>
							<input  class="easyui-combobox" name="regionId"  
							data-options="valueField:'regionId',textField:'name',mode:'remote',url:'${pageContext.request.contextPath}/region/listajax'"
							 />
						</td> 
					</tr>
					<tr>
						<td>关键字</td>
						<td>
							<input type="text" name="addresskey" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>起始号</td>
						<td>
						<input type="text" name="startnum" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>终止号</td>
						<td>
							<input type="text" name="endnum" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>单双号</td>
						<td>
							<select id="cc" class="easyui-combobox" name="single" style="width:150px;">   
							    <option value="0">单双号</option>   
							    <option value="1">单号</option>  
							    <option value="2">双号</option>  
							</select> 
						</td>
					</tr>
					<tr>
						<td>位置信息</td>
						<td>
							<input type="text" name="position" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- 修改分区小窗口 -->
	<div id="editSubAreaWindow" class="easyui-window" title="对区域进行修改" collapsible="false" minimizable="false" maximizable="false"  data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-edit" href="javascript:void(0)" class="easyui-linkbutton" plain="true">修改</a>
				<script type="text/javascript">
					$(function(){
						//为修改按钮绑定事件
						$("#edit").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#editSubAreaForm").form("validate");
							if(v){
								$('#editSubAreaForm').submit();
							}else{
								$.message.show("提示","请填写完整");
							}
						});
					})
				</script>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editSubAreaForm" action="${pageContext.request.contextPath }/subarea/update" method="post" style="width: 300px;">
				<input type="hidden" name="subareaId" value="">
				<table class="table-edit" width="80%" align="center" border="0" cellspacing="5" cellpadding="5">
					<caption>
						分区信息
					</caption>
					<tr>
						<td>选择区域</td>
						<td>
							<input  class="easyui-combobox" name="regionId"  
							data-options="valueField:'regionId',textField:'name',mode:'remote',url:'${pageContext.request.contextPath}/region/listajax'"
							 />
						</td> 
					</tr>
					<tr>
						<td>关键字</td>
						<td>
							<input type="text" name="addresskey" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>起始号</td>
						<td>
						<input type="text" name="startnum" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>终止号</td>
						<td>
							<input type="text" name="endnum" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>单双号</td>
						<td>
							<select id="cc" class="easyui-combobox" name="single" style="width:150px;">   
							    <option value="0">单双号</option>   
							    <option value="1">单号</option>  
							    <option value="2">双号</option>  
							</select> 
						</td>
					</tr>
					<tr>
						<td>位置信息</td>
						<td>
							<input type="text" name="position" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
				</table>
			</form>
		</div>
			
	
	</div>
	<!-- 修改查询分区条件小窗口 -->
	<div id="searchSubAreaWindow" class="easyui-window" title="对区域进行查询" collapsible="false" minimizable="false" maximizable="false"  data-options="closed: true">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="saveQuery" icon="icon-edit" href="javascript:void(0)" class="easyui-linkbutton" plain="true">添加</a>
				<a id="clearConditions" icon="icon-remove" href="javascript:void(0)" class="easyui-linkbutton" plain="true">清除条件</a>
				<script type="text/javascript">
				$(function(){
					//为保存查询条件按钮绑定事件
					$("#saveQuery").click(function(){
						window.subArea.regionId = $('#conditionForm input[name=regionId]').val();
						window.subArea.addresskey = $('#conditionForm input[name=addresskey]').val();
						window.subArea.startnum = $('#conditionForm input[name=startnum]').val();
						window.subArea.single = $('#conditionForm input[name=single]').val();
						window.subArea.position = $('#conditionForm input[name=position]').val();
						
						// console.log($('#conditionForm input[name=regionId]').val());//这个是个下拉列表,但被eayui改变成input了
						// console.log($('#conditionForm input[name=addresskey]').val());
						// console.log($('#conditionForm input[name=startnum]').val());
						// console.log($('#conditionForm input[name=single]').val());//这个是个下拉列表,但被eayui改变成input了
						// console.log($('#conditionForm input[name=position]').val());
						
						$("#grid").datagrid('reload',{
							regionId : window.subArea.regionId,
							addresskey : window.subArea.addresskey,
							startnum : window.subArea.startnum ,
							single : window.subArea.single ,	
							position : window.subArea.position
						})
						
						$('#searchSubAreaWindow').window('close');
					});
					
					//为清除按钮绑定事件
					$("#clearConditions").click(function(){
						//表单校验,如果通过,提交表单
						$("#conditionForm").form("clear");
						window.subArea.regionId = '';
						window.subArea.addresskey = '';
						window.subArea.startnum = '';
						window.subArea.single = '';
						window.subArea.position = '';
					});
				})
				</script>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="conditionForm" method="post" style="width: 300px;">
				<table class="table-edit" width="80%" align="center" border="0" cellspacing="5" cellpadding="5">
					<caption>
						分区信息
					</caption>
					<tr>
						<td>选择区域</td>
						<td>
							<input  class="easyui-combobox" name="regionId"  
							data-options="valueField:'regionId',textField:'name',mode:'remote',url:'${pageContext.request.contextPath}/region/listajax'"
							 />
						</td> 
					</tr>
					<tr>
						<td>关键字</td>
						<td>
							<input type="text" name="addresskey" class="easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>起始号</td>
						<td>
						<input type="text" name="startnum" class="easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>终止号</td>
						<td>
							<input type="text" name="endnum" class="easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>单双号</td>
						<td>
							<select id="cc" class="easyui-combobox" name="single" style="width:150px;">   
								<option value="">不限号</option>
							    <option value="0">单双号</option>   
							    <option value="1">单号</option>  
							    <option value="2">双号</option>  
							</select> 
						</td>
					</tr>
					<tr>
						<td>位置信息</td>
						<td>
							<input type="text" name="position" class="easyui-validatebox" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- 区域分布图 -->
	<div id="distributionMap" class="easyui-window" data-options="title:'区域分布图',closed:true,collapsible:false,minimizable:false,maximizable:false">
		<div class="map" style="width:300px;height:300px;"></div>
	</div>
	
	
	<script type="text/javascript">
		window.subArea = {
				regionId : "",
				addresskey  : "",
				startnum : "",
				single : "",
				position : ""
		}
		
		function displayDistribution(){
			$("#distributionMap").window('open');
			$.getJSON("${pageContext.request.contextPath}/subarea/findSubareasGroupByProvince",function(data){
				var dataArray=new Array();
				$.each(data,function(i,d){
					dataArray.push([d.name,d.data]);
				});
				var chart=$("#distributionMap .map").highcharts({
					title:{
						text:"区域分布图"
					},
					series:[{
						type:"pie",
						name:"区域分布图",
						data:dataArray
					}]
				});
			});
		}
		
		function doExportExcel(){
			window.location.href = '${pageContext.request.contextPath}/subarea/exportExcel';
		}
		
		function doSearch(){
			$("#searchSubAreaWindow").window('open');
		}
		
		function doDblClickRow(rowIndex,rowData){
			//打开修改区域窗口
			$('#editSubAreaWindow').window('open'); 
			//使用form表彰对象的load方法回显数据
			$("#editSubAreaForm").form("load",rowData);
		};
		
		function doEdit(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length < 1 || 1 < rows.length){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				if(rows.length < 1 ){
					//没有选中记录
					$.messager.alert("提示","请选择需要编辑的行","warnning");
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
			$('#addSubAreaWindow').window("open");
		};
		
		function doDelete(){
			//获取数据表格中所有选中的行,返回数组对象
			var rows = $("#grid").datagrid("getSelections");
			if(rows.length == 0){//这个判断 是不是有问题?如果rows为空怎么办?是不是可以换成if(rows.length)?
				//没有选中记录
				$.messager.alert("提示","请选择需要删除的行","warnning");
			}else{
				//选中了区域,弹出确认框
				$.messager.confirm("删除确认","你确定要删除选中行吗?",function(r){
					if(r){
						var array = new Array();
						//确定,发送请求
						//获取所有选中的行的id
						for(var i =0;i<rows.length;i++){
							var subarea = rows[i];//json对象
							var id = subarea.subareaId;
							array.push(id);
						}
						var ids = array.join(",");//将id们变成字符串,用逗号连接
						location.href= "${pageContext.request.contextPath}/subarea/delete/"+ ids;
					}
				});
				
			}
		};
	</script>
	<script type="text/javascript">
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
				url : "${pageContext.request.contextPath}/subarea/queryByPager",
				queryParams : {
					regionId : window.subArea.regionId,
					addresskey : window.subArea.addresskey,
					startnum : window.subArea.startnum ,
					single : window.subArea.single ,	
					position : window.subArea.position
				},
				idField : 'regionId',
				columns : columns,
				onDblClickRow : doDblClickRow
			});
			
			$("#button-import").upload({
				action:'${pageContext.request.contextPath}/subarea/importExcel',
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
		var toolbar = [  {
			id : 'button-search',
			text : '按条件查询',
			iconCls : 'icon-search',
			handler : doSearch
		}, {
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
			iconCls : 'icon-undo',
		},  {
			id : 'button-export',
			text : '导出',
			iconCls : 'icon-redo',
			handler : doExportExcel
		}, {
			id : 'button-distribution',
			text : '显示区域分布图',
			iconCls : 'icon-search',
			handler : displayDistribution
		},  ];
		
		
		var columns = [ [ {
			field : 'subareaId',
			checkbox : true,
		}, {
			field : 'decidedzoneId',
			title : '定区分拣编号',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				if(!data){
					return "(未指定)"
				}else{
					return data;
				}
			}
		},{
			field : 'region.province',
			title : '省',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				return row.region.province;
			}
		}, {
			field : 'region.city',
			title : '市',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				return row.region.city;
			}
		}, {
			field : 'region.district',
			title : '区',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				return row.region.district;
			}
		}, {
			field : 'addresskey',
			title : '关键字',
			width : 120,
			align : 'center'
		}, {
			field : 'startnum',
			title : '起始码',
			width : 120,
			align : 'center'
		}, {
			field : 'endnum',
			title : '终止号',
			width : 120,
			align : 'center'
		}, {
			field : 'single',
			title : '单双号',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				switch(data){
				case "0": return "单双号";break;
				case "1": return "单号";break;
				case "2": return "双号";break;
				}
			}
		},  {
			field : 'position',
			title : '位置',
			width : 120,
			align : 'center'
		},] ];
	</script>
</body>
</html>