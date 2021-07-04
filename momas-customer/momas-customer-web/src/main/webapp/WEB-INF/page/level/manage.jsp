<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="js no-flexbox flexbox-legacy canvas canvastext no-webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths panel-fit">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
	<title>店铺列表</title>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />
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
					<label for="cardlevelsLevelname">等级名称:</label>
					<input type="text" name="cardlevelsLevelname" id="cardlevelsLevelname" value=""/>
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
				url : "${pageContext.request.contextPath}/level/query", //url:设置能够返回JSON数据的Controller所对应的路径
				columns : [ [ {
					field : 'cardlevelsId',
					title : '等级编号',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.cardlevelsId;
					}
				},  {
					field : 'cardlevelsLevelname',
					title : '等级名称',
					width : 150,
					align : "center",
					formatter : function(value, row) {
					/* 	if (row.categories) {
							return row.categories.categoryName;
						} */
						return row.cardlevelsLevelname;
					}
				},{
					field : 'cardlevelsNeedpoint',
					title : '所需最大积分',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.cardlevelsNeedpoint;
					}
				}, {
					field : 'cardlevelsPoint',
					title : '兑换比例',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.cardlevelsPoint;
					}
				},{
					field : 'cardlevelsPercent',
					title : '折扣比例',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.cardlevelsPercent;
					}
				},
				] ]
			});
			$(".Insert").click(function() {
				$("#dlg").dialog({
					width : 600,
					height : 500,
					closed : true,
					closable : true,
					modal : true,
				}).dialog("setTitle", "添加等级").dialog("open");
				$("#frm1").attr("src", "${pageContext.request.contextPath}/level/toAdd");
			});
			$(".Delete").click(function() {
				var row = $("#dg").datagrid("getSelected");
				if (row != null) {
					$.messager.confirm("提示", "是否删除该等级", function(r) {
						if (r) { 
							$.get("${pageContext.request.contextPath}/level/deletelevel", {
								cardlevelsId : row.cardlevelsId
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
						width : 600,
						height : 500
					}).dialog("setTitle", "修改礼品").dialog("open");
					$("#frm1").attr("src", "${pageContext.request.contextPath}/level/toEdit?cardlevelsId=" + row.cardlevelsId);
				} else {
					$.messager.alert("提示", "请选择需要编辑的行", "warning");
				}
			});
			$(".Search").click(function() {
				$('#dg').datagrid('load', {
					cardlevelsLevelname : $('#cardlevelsLevelname').val(),
				});
			});
		});
	</script>
</body>

</html>