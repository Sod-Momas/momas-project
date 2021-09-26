<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理分区</title>
	<base href="${pageContext.request.contextPath }/" />
	<%@include file="../common/importJsAndCss.jsp"%>
	<style>
		#saveDecidedForm td,
		#editForm td{
			min-width:60px;
		}
	</style>
	</head>
<body>
	<!-- 展示数据的表格 -->
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center'">
			<!-- 数据表格 -->
			<table id="grid"></table>
		</div>
		<div data-options="region:'south',split:true" style="height: 350px;">
			<div class="easyui-tabs" style="height: 100%;">
				<div title="关联分区" data-options="fit:true">
					<table id="subAreaGrid" class="easyui-datagrid" style=" min-height:200px;"></table>
					<script>
						$(function(){
							$("#subAreaGrid").datagrid({
								fitColumns:true,
								singleSelect:true,
								fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
								url : '${pageContext.request.contextPath}/subarea/queryByDecidedId',
								border : true,
								rownumbers : true,
								striped : false,
								idField : 'subareaId',
								columns : subAreaCols
							})
						});
						
					</script>
				</div>
				<div id="associateShopsParent" title="关联客户" data-options="fit:true"></div>
			</div>
		</div>
	</div>

	<!-- 关联客户窗口 -->
	<div id="associateDecidedWindow" class="easyui-window" title="关联客户" style="width:600px;height:400px" data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false, maximizable:false,closed: true">
			<!-- 按钮 -->
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<div class="datagrid-toolbar">
					<a id="associationBtn" icon="icon-save" href="javascript:void(0)" class="easyui-linkbutton" plain="true">关联客户</a>
				</div>
			</div>
			<!-- 两个下拉列表 -->
			<div region="center" style="overflow:auto;padding:5px;" border="false">

				<div style="overflow: hidden;padding: 5px;border: none;">
					<form id="customerForm" action="${pageContext.request.contextPath}/decidedzone/assigncustomerstodecidedzone" method="post">
						<table border="0" cellspacing="5" cellpadding="5" class="table-edit" width="80%" align="center">
							<caption>关联客户</caption>
							<tr>
								<td>
									<input type="hidden" id="customerDecidedZoneId" name="decidedzoneId" value="">
									<input type="hidden" name="shops" id="shops" value="" />
									<select id="noassociationSelect" multiple="multiple" style="width:150px;height:150px"></select>
								</td>
								<td>
									<input type="button" id="toRight" value="-=&gt;" /><br/>
									<input type="button" id="toLeft" value="&lt;=-" />
									<script type="text/javascript">
										$(function() {
											//为左右移动按钮绑定事件
											$('#toRight').click(function() {
												$('#associationSelect').append($('#noassociationSelect option:selected'));
											});
											$('#toLeft').click(function() {
												$('#noassociationSelect').append($('#associationSelect option:selected'));
											});
											//为关联客户按钮绑定事件
											$('#associationBtn').click(function() {
												var rows = $('#grid').datagrid('getSelections');
												var id = rows[0].decidedzoneId;
												//为隐藏域(存放定区id)赋值
												$('#customerDecidedZoneId').val(id);
												
												//提交表单之前,需要将右下拉框中所有被选中的选项的value拼接成"1,2,5"格式的字符串提交到服务器
												var ids = "";
												$.each($('#associationSelect option'), function(i, d) {
													ids += (i > 0 ? "," : '') + $(d).val();
												});
												$('#shops').val(ids);
												$('#customerForm').submit();
											})
										})
									</script>
								</td>
								<td>
									<select id="associationSelect" name="shopsId" multiple="multiple" style="width:150px;height:150px"></select>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

	<!-- 添加定区窗口 -->
	<div id="addDecidedWindow" class="easyui-window" title="添加定区" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false, maximizable:false,closed: true">
	
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:void(0)" class="easyui-linkbutton" plain="true">添加</a>
				<script type="text/javascript">
					$(function(){
						//为修改按钮绑定事件
						$("#save").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#saveDecidedForm").form("validate");
							if(v){
								$('#saveDecidedForm').submit();
							}
						});
					})
				</script>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="saveDecidedForm" action="${pageContext.request.contextPath}/decidedzone/add" method="post" style="width: 300px;">
				<table class="table-edit" align="center" border="0" cellspacing="5" cellpadding="5">
					<caption>
						定区信息
					</caption>
					<tr>
						<td>选择取派员</td>
						<td>
							<input  class="easyui-combobox" name="staffId"  
							data-options="valueField:'staffId',textField:'name',mode:'remote',url:'${pageContext.request.contextPath}/staff/listajax'"
							 />
						</td>
					</tr>
					<tr>
						<td>定区名</td>
						<td>
							<input type="text" name="name" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>关联分区</td>
						<td>
							<table class="easyui-datagrid" style="width:400px;height:250px"   
						        data-options="url:'${pageContext.request.contextPath }/subarea/queryNotBeAssociated',fitColumns:true">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'subareaId',checkbox:true">编码</th>  
						            <th data-options="field:'position',width:100">位置</th>   
						        </tr>   
						    </thead>   
						</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	
	</div>
	
	<!-- 修改定区窗口 -->
	<div id="editWindow" class="easyui-window" title="添加定区" style="width:600px;height:400px"   
        data-options="iconCls:'icon-edit',modal:true,collapsible:false,minimizable:false, maximizable:false,closed: true">
	
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="btn-edit" icon="icon-edit" href="javascript:void(0)" class="easyui-linkbutton" plain="true">添加</a>
				<script type="text/javascript">
					$(function(){
						//为修改按钮绑定事件
						$("#btn-edit").click(function(){
							//表单校验,如果通过,提交表单
							var v = $("#editForm").form("validate");
							if(v){
								$('#editForm').submit();
							}
						});
					})
				</script>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editForm" action="${pageContext.request.contextPath}/decidedzone/update" method="post" style="width: 300px;">
				<input type="hidden" name="decidedzoneId">
				<table class="table-edit" width="80%" align="center" border="0" cellspacing="5" cellpadding="5">
					<caption>定区信息</caption>
					<tr>
						<td>选择取派员</td>
						<td>
							<input  class="easyui-combobox" name="staffId"  
							data-options="valueField:'staffId',textField:'name',mode:'remote',url:'${pageContext.request.contextPath}/staff/listajax'"
							 />
						</td>
					</tr>
					<tr>
						<td>定区名</td>
						<td>
							<input type="text" name="name" class="easyui-validatebox" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>关联分区<br/>(会清空以前的关联)</td>
						<td>
							<table class="easyui-datagrid" style="width:400px;height:250px"   
						        data-options="url:'${pageContext.request.contextPath }/subarea/queryNotBeAssociated',fitColumns:true">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'subareaId',checkbox:true">编码</th>  
						            <th data-options="field:'position',width:100">位置</th>   
						        </tr>   
						    </thead>
						</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	
	</div>

	<!-- DOM还没加载完成就要定义的变量和方法 -->
	<script type="text/javascript">
		function doAssociations() {
			//获取当前数据表格所有选中的行,返回数组
			var rows = $('#grid').datagrid("getSelections");
			if(rows.length != 1) {
				$.messager.alert("提示信息", "请选择一个定区操作", "warnning");
			} else {
				//选中了一个定区
				$('#associateDecidedWindow').window('open');
				//清理下拉框
				$('#noassociationSelect').empty();
				$('#associationSelect').empty();
				//发送Ajax请求,请求定区Controller,在定区controller中通过customer代理对象完成对于customer服务远程调用获取当前未关联定区的店铺数据
				var url = "${pageContext.request.contextPath}/decidedzone/queryListNotAssociation";
				
				$.post(url, function(data) {
					//遍历json数组
					for(var i = 0; i < data.length; i++) {
						var id = data[i].shopId;
						var name = data[i].shopName;
						var address = data[i].shopAddress;
						name = name + "(" + address + ")";
						$('#noassociationSelect').append("<option value=" + id + ">" + name + "</option>");
					}
				});
	
				//发送AJAX请求,请求定区Controlelr,在定区Controller里面通过customer代理对象完成对于customer服务远程调用获取当前定区所关联的客户数据
				var dzId = rows[0].decidedzoneId;
				$('#customerDecidedZoneId').val(dzId);
				url = "${pageContext.request.contextPath}/decidedzone/queryListAssociation/" + dzId;
				$.post(url, function(data) {
					//遍历json数组
					for(var i = 0; i < data.length; i++) {
						var id = data[i].shopId;
						var name = data[i].shopName;
						var address = data[i].shopAddress;
						name = name + "(" + address + ")";
						var op = $("<option>");
						op.val(id);
						op.text(name);
						$('#associationSelect').append(op);
					}
				})
			}
		}
		
		function doDblClickRow(rowIndex,rowData){
			$("#subAreaGrid").datagrid('load',{
				id : rowData.decidedzoneId
			});
			$("#associateShopsParent").empty().append($("<table id='associateShops'>"));
			$("#associateShops").datagrid({
				fitColumns : true,
				fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				url : "${pageContext.request.contextPath}/decidedzone/queryListAssociation/" + rowData.decidedzoneId,
				columns : shopsCols,
			});
			
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
				//打开修改区域窗口
				$('#editWindow').window('open'); 
				//使用form表彰对象的load方法回显数据
				$("#editForm").form("load",rows[0]);
				
			}
		};
		
		function doAdd(){
			$('#addDecidedWindow').window("open");
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
							var dz = rows[i];//json对象
							var id = dz.decidedzoneId;
							array.push(id);
						}
						var ids = array.join(",");//将id们变成字符串,用逗号连接
						location.href= "${pageContext.request.contextPath}/decidedzone/delete/"+ ids;
					}
				});
				
			}
		};
		
	</script>
	<!-- dom加载完成后触发的事件 -->
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
				pageList : [10,20,30],
				pagination : true,
				toolbar : toolbar,
				url : "${pageContext.request.contextPath}/decidedzone/queryByPager",
				idField : 'decidedzoneId',
				columns : columns,
				onDblClickRow : doDblClickRow
			});
		
		})
	</script>
	<!-- 各个按钮 -->
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
			id : 'button-cutomer',
			text : '关联客户',
			iconCls : 'icon-reload',
			handler : doAssociations
		} ];
		
		
		
		var columns = [ [ {
			field : 'decidedzoneId',
			checkbox : true,
		},
		/*  {
			field : 'decidedzoneId',
			title : '定区编号',
			width : 120,
			align : 'center'
		},  */
		{
			field : 'name',
			title : '定区名称',
			width : 120,
			align : 'center'
		}, {
			field : 'staffId',
			title : '取派员编号',
			width : 120,
			align : 'center'
		},{
			field : 'staff.name',
			title : '负责人',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return row.staff.name;
			}
		},{
			field : 'staff.telephone',
			title : '联系电话',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return row.staff.telephone;
			}
		},{
			field : 'staff.station',
			title : '所属公司',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return row.staff.station;
			}
		}, ] ];
		

		var subAreaCols = [ [ {
			field : 'subareaId',
			checkbox : true,
		}, {
			field : 'decidedzoneId',
			title : '定区分拣编号',
			width : 120,
			align : 'center',
			formatter : function(data, row, index) {
				if (!data) {
					return "(未指定)"
				} else {
					return data;
				}
			}
		}, {
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
				switch (data) {
				case "0":
					return "单双号";
					break;
				case "1":
					return "单号";
					break;
				case "2":
					return "双号";
					break;
				}
			}
		}, {
			field : 'position',
			title : '位置',
			width : 120,
			align : 'center'
		}, ] ];
		
		
		var shopsCols = [ [ {
			field : 'shopId',
			title : '店铺编号',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				return row.shopId;
			}
		}, {
			field : 'shopName',
			title : '店铺名称',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				return row.shopName;
			}
		}, {
			field : 'categories',
			title : '店铺类别',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				if (row.categories) {
					return row.categories.categoryTitle;
				}
				return value;
			}
		}, {
			field : 'shopContactname',
			title : '联系人',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				return row.shopContactname;
			}
		}, {
			field : 'shopContacttel',
			title : '联系电话',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				return row.shopContacttel;
			}
		}, {
			field : 'shopAddress',
			title : '店铺地址',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				return row.shopAddress;
			}
		}, {
			field : 'shopRemark',
			title : '备注',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				if(row.shopRemark){
					return row.shopRemark;
				}else{
					return "(无)";
				}
			}
		}, {
			field : 'shopIshassetadmin',
			title : '是否已分配管理员',
			width : 150,
			align : "center",
			formatter : function(value, row) {
				if (row.shopIshassetadmin) {
					return "是";
				} else {
					return "否";
				}
			}
		}, {
			field : 'shopCreatetime',
			title : '加盟时间',
			width : 150,
			align : "center",
			formatter : function(value, row) {

				return row.shopCreatetime;
			}
		},

		] ]
	</script>

</body>
</html>