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
				</div>
				<div>
					<label for="usersLoginname">登录名:</label>
					<input type="text" name="usersLoginname" id="usersLoginname" value=""/>
					<label for="usersRealname">真实姓名:</label>
					<input type="text" name="usersRealname" id="usersRealname" value=""/>
					<label for="usersTelephone">联系电话:</label>
					<input type="text" name="usersTelephone" id="usersTelephone" value=""/>
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
				url : "${pageContext.request.contextPath}/user/query", //url:设置能够返回JSON数据的Action所对应的路径
				columns : [ [ {
					field : 'usersId',
					title : '用户编号',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.usersId;
					}
				},  {
					field : 'usersLoginname',
					title : '登录名',
					width : 150,
					align : "center",
					formatter : function(value, row) {
					/* 	if (row.categories) {
							return row.categories.categoryName;
						} */
						return row.usersLoginname;
					}
				},{
					field : 'usersRealname',
					title : '真实姓名',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.usersRealname;
					}
				}, {
					field : 'usersSex',
					title : '性别',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.usersSex;
					}
				},{
					field : 'usersTelephone',
					title : '电话',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.usersTelephone;
					}
				}, {
					field : 'shopId',
					title : '店铺编号',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.shopId?row.shopId:"无";
					}
				}, {
					field : 'usersRole',
					title : '用户角色',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.usersRole;
					}
				},{
					field : 'usersCandelete',
					title : '是否可以删除',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						if(value == 1){
							return "是";
						}else{
							return "否";
						}
						//return row.usersCandelete;
					}
				}, 

				] ]
			});
			//$('#dg').datagrid('load'); //这个会导致重复加载
			$(".Insert").click(function() {
				$("#dlg").dialog({
					width : 400,
					height : 400,
					closed : true,
					closable : true,
					modal : true,
				}).dialog("setTitle", "添加用户").dialog("open");
				$("#frm1").attr("src", "${pageContext.request.contextPath}/user/toAdd");
			});
			$(".Delete").click(function() {
				var row = $("#dg").datagrid("getSelected");
				if (row != null) {
					$.messager.confirm("提示", "是否删除该用户", function(r) {
						if (r) { 
							$.get("${pageContext.request.contextPath}/user/deleteUser", {
								usersId : row.usersId
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
					}).dialog("setTitle", "修改用户").dialog("open");
					$("#frm1").attr("src", "${pageContext.request.contextPath}/user/toEdit?usersId=" + row.usersId);
				} else {
					$.messager.alert("提示", "请选择需要编辑的行", "warning");
				}
			});
			$(".Search").click(function() {
				$('#dg').datagrid('load', {
					usersLoginname : $('#usersLoginname').val(),
					usersRealname : $('#usersRealname').val(),
					usersTelephone : $('#usersTelephone').val()
				});
			});
		});
	</script>
</body>

</html>