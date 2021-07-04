<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="js no-flexbox flexbox-legacy canvas canvastext no-webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths panel-fit">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
	<title>店铺列表</title>
	<!-- <link href="css/site.css" rel="stylesheet"> -->
	<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />
	<!-- <script src="js/modernizr/modernizr.custom.2.8.3.js"></script> -->
</head>

<body class="panel-noscroll">
	<div>
		<div>
			<div id="tb" style="padding: 5px">
				<div style="margin-bottom: 5px">
						<a href="#" class="easyui-linkbutton Insert l-btn l-btn-small" data-options="iconCls:'icon-add'" >新增</a>
						<a href="#" class="easyui-linkbutton Update l-btn l-btn-small" data-options="iconCls:'icon-edit'" >修改</a>
						<a href="#" class="easyui-linkbutton Delete l-btn l-btn-small" data-options="iconCls:'icon-remove'" >删除</a>
						<a href="#" class="easyui-linkbutton AddUser l-btn l-btn-small" data-options="iconCls:'icon-ok'" >分配管理员</a>
				</div>
				<div>
					<label for="shopName">店铺名称:</label>
					<input type="text" name="shopName" id="shopName" value=""/>
					<label for="contact">联系人:</label>
					<input type="text" name="shopContactname" id="shopContactname" value=""/>
					<label for="address">店铺地址:</label>
					<input type="text" name="shopAddress" id="shopAddress" value=""/>
					<a href="#" class="easyui-linkbutton Search l-btn l-btn-small" data-options="iconCls:'icon-search'" >查询</a>
				</div>
			</div>
			<div style="height:100%">
				<table id="dg" style="display: none;"></table>
			</div>
		</div>
	</div>

	<div style="display: none; margin: 0 auto;">
		<div id="dlg">
			<div>
				<iframe id="frm1" width="99%" height="99%"  frameborder="0"></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#dg").datagrid({
				fitColumns : true,
				toolbar : "#tb", //toolbar:通过选择器指定的工具栏。
				pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
				fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				url : "${pageContext.request.contextPath}/shop/queryPage", //url:设置能够返回JSON数据的Action所对应的路径
				columns : [ [ {
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
			});
			//$('#dg').datagrid('load'); //这个会导致重复加载
			$(".Insert").click(function() {
				$("#dlg").dialog({
					width : 400,
					height : 300,
					closed : true,
					closable : true,
					modal : true,
				}).dialog("setTitle", "添加店铺").dialog("open");
				$("#frm1").attr("src", "${pageContext.request.contextPath}/shop/toAdd");
			});
			$(".Delete").click(function() {
				var row = $("#dg").datagrid("getSelected");
				if (row != null) {
					if (row.shopIshassetadmin) {
						$.messager.alert("警告","请删除店铺管理员后再删除店铺!","warning");
						return false;
					} 			
					$.messager.confirm("提示", "是否删除该条店铺信息", function(r) {
						if (r) {
							$.get("${pageContext.request.contextPath}/shop/deleteShop", {
								shopId : row.shopId
							}, function(data) {
								$.messager.alert("提示", data, "info");
								$("#dg").datagrid("reload");
							});
						}
					});
				} else {
					$.messager.alert("提示", "请选择需要删除的行", "warning");
				}
			});
			$(".Update").click(function() {
				var row = $("#dg").datagrid("getSelected");
				if (row != null) {
					$("#dlg").dialog({
						width : 400,
						height : 400
					}).dialog("setTitle", "修改店铺").dialog("open");
					$("#frm1").attr("src", "${pageContext.request.contextPath}/shop/toEdit?shopId=" + row.shopId);
				} else {
					$.messager.alert("提示", "请选择需要编辑的行", "warning");
				}
			});
			$(".AddUser").click(function() {
					var row = $("#dg").datagrid("getSelected");
					if (row != null) {
						if (!row.shopIshassetadmin) {
							$("#dlg").dialog({
								width : 400,
								height : 400
							}).dialog("setTitle", "分配管理员").dialog("open");
							$("#frm1").attr("src","${pageContext.request.contextPath}/shop/toSetAdmin?shopId=" + row.shopId);
						} else {
							$.messager.alert("提示", "该店铺已分配管理员", "warning");
						}

					} else {
						$.messager.alert("提示", "请选择需要操作的行", "warning");
					}
				});
			$(".Search").click(function() {
				$('#dg').datagrid('load', {
					shopName : $('#shopName').val(),
					shopContactname : $('#shopContactname').val(),
					shopAddress : $('#shopAddress').val()
				});
			});
		});
	</script>
</body>

</html>