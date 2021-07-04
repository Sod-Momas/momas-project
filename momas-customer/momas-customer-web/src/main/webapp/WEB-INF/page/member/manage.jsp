<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<a href="#" class="easyui-linkbutton Lock l-btn l-btn-small" data-options="iconCls:'icon-lock'" >挂失/锁定</a>
						<a href="#" class="easyui-linkbutton Transfer l-btn l-btn-small" data-options="iconCls:'icon-redo'" >会员转账</a>
						<a href="#" class="easyui-linkbutton Exchange l-btn l-btn-small" data-options="iconCls:'icon-reload'" >会员换卡</a>
						<a href="export.xls" class="easyui-linkbutton Export l-btn l-btn-small" data-options="iconCls:'icon-ok'" >导出Excel</a>
						<a href="#" class="easyui-linkbutton Import l-btn l-btn-small" data-options="iconCls:'icon-ok'" >导入Excel</a>
						<!-- 
						<form id="fileImport" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/member/import">
							<input type="file" name="file" title="导入excel"><input type="submit" value="导入Excel"/>
						</form>
						 -->
				</div>
				<div>
					<label for="memcardsId">会员卡号</label>
					<input type="text" name="memcardsId" id="memcardsId" value=""/>
					<label for="memcardsName">会员姓名</label>
					<input type="text" name="memcardsName" id="memcardsName" value=""/>
					<label for="memcardsMobile">电话</label>
					<input type="text" name="memcardsMobile" id="memcardsMobile" value=""/>
					<label for="cardlevelsId">会员等级</label>
					<select name="cardlevelsId" id="cardlevelsId">
						<option value="">-请选择会员等级-</option>
						<c:forEach items="${levels }" var="l">
							<option value="${l.cardlevelsId }">${l.cardlevelsLevelname }</option>
						</c:forEach>
					</select>
					<label for="memcardsState">状态</label>
					<select name="memcardsState" id="cardlevelsId">
						<option value="">-请选择会员状态-</option>
						<c:forEach items="${states }" var="s">
							<option value="${s.categoryId }">${s.categoryTitle }</option>
						</c:forEach>
					</select>
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
			$(".Import").click(function() {
				var form = '<form id="fileImport" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/member/import"><input type="file" name="file"><input type="submit" value="导入Excel"/></form>';
				$(form).dialog({width : 300,height : 200})
				.dialog("setTitle", "上传文件")
				.dialog("open");
			});
			$(".Exchange").click(
					function() {
						var row = $("#dg").datagrid("getSelected");
						if (row != null) {
							$("#dlg").dialog({
								width : 500,
								height : 300
							}).dialog("setTitle", "会员换卡").dialog("open");
							$("#frm1").attr(
									"src",
									"${pageContext.request.contextPath}/member/toExchange?memcardsId="
											+ row.memcardsId);
						} else {
							$.messager.alert("提示", "请选择需要编辑的行", "warning");
						}
					});
			$(".Lock").click(
					function() {
						var row = $("#dg").datagrid("getSelected");
						if (row != null) {
							$("#dlg").dialog({
								width : 300,
								height : 200
							}).dialog("setTitle", "挂失、锁定").dialog("open");
							$("#frm1").attr(
									"src",
									"${pageContext.request.contextPath}/member/toLock?memcardsId="
											+ row.memcardsId);
						} else {
							$.messager.alert("提示", "请选择需要编辑的行", "warning");
						}
					});

			$(".Transfer").click(
					function() {
						var row = $("#dg").datagrid("getSelected");
						if (row != null) {
							$("#dlg").dialog({
								width : 400,
								height : 500
							}).dialog("setTitle", "转账").dialog("open");
							$("#frm1").attr(
									"src",
									"${pageContext.request.contextPath}/member/toTransfer?memcardsId="
											+ row.memcardsId);
						} else {
							$.messager.alert("提示", "请选择需要编辑的行", "warning");
						}
					});

			$(".Search").click(function() {
				$('#dg').datagrid('load', {
					memcardsId : $('#memcardsId').val(),
					memcardsName : $('#memcardsName').val(),
					memcardsMobile : $('#memcardsMobile').val(),
					cardlevelsId : $('#cardlevelsId').val(),
					memcardsState : $('select[name=memcardsState]').val()
				});
			});
			$(".Update").click(
					function() {
						var row = $("#dg").datagrid("getSelected");
						if (row != null) {
							$("#dlg").dialog({
								width : 600,
								height : 500
							}).dialog("setTitle", "修改会员").dialog("open");
							$("#frm1").attr(
									"src",
									"${pageContext.request.contextPath}/member/toEdit?memcardsId="
											+ row.memcardsId);
						} else {
							$.messager.alert("提示", "请选择需要编辑的行", "warning");
						}
					});
			$(".Insert")
					.click(
							function() {
								$("#dlg").dialog({
									width : 600,
									height : 500,
									closed : true,
									closable : true,
									modal : true,
								}).dialog("setTitle", "添加会员").dialog("open");
								$("#frm1")
										.attr("src",
												"${pageContext.request.contextPath}/member/toAdd");
							});
			$(".Delete")
					.click(
							function() {
								var row = $("#dg").datagrid("getSelected");
								if (row != null) {
									$.messager
											.confirm(
													"提示",
													"是否删除该条信息",
													function(r) {
														if (r) {
															$
																	.get(
																			"${pageContext.request.contextPath}/member/deletemember",
																			{
																				memcardsId : row.memcardsId
																			},
																			function(
																					data) {
																				$.messager
																						.alert(
																								"提示",
																								data,
																								"info");
																				$(
																						"#dg")
																						.datagrid(
																								"reload");
																			});
														}
													});
								} else {
									$.messager.alert("提示", "请选择需要删除的行",
											"warning");
								}
							});

			$("#dg").datagrid({
				fitColumns : true,
				toolbar : "#tb", //toolbar:通过选择器指定的工具栏。
				pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
				fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
				singleSelect : true, //如果为true，则只允许选择一行。
				rownumbers : true, //如果为true，则显示一个行号列。
				url : "${pageContext.request.contextPath}/member/query", //url:设置能够返回JSON数据的Controller所对应的路径
				columns : [ [ {
					field : 'memcardsCardid',
					title : '会员卡号',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsCardid;
					}
				}, {
					field : 'memcardsName',
					title : '会员姓名',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsName;
					}
				}, {
					field : 'memcardsMobile',
					title : '手机号码',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsMobile;
					}
				}, {
					field : 'memcardsTotalcount',
					title : '累计消费',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsTotalcount;
					}
				}, {
					field : 'memcardsState',
					title : '会员卡状态',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						if(row.memberCardState){
							return row.memberCardState.categoryTitle;
						}else{
							return value;
						}
					}
				}, {
					field : 'memcardsPoint',
					title : '当前积分',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return  value ? row.memcardsPoint : 0;
					}
				}, {
					field : 'memcardsSex',
					title : '性别',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						return row.memcardsSex;
					}
				}, {
					field : 'memcardsCreatetime',
					title : '登记时间',
					width : 200,
					align : "center",
					formatter : function(value, row) {
						//var d = new Date(row.memcardsCreatetime);
						//return d.toLocaleFormat();
						return row.memcardsCreatetime;
					}
				}, {
					field : 'shopCreatetime',
					title : '当前等级',
					width : 150,
					align : "center",
					formatter : function(value, row) {
						if(row.cardlevels.cardlevelsLevelname){
							return row.cardlevels.cardlevelsLevelname;
						}else{
							return value;
						}
					}
				},

				] ]
			});

		});
	</script>
</body>

</html>