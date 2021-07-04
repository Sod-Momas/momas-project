<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="js no-flexbox flexbox-legacy canvas canvastext no-webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths panel-fit">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
	<title>兑换礼品</title>
	<!-- <link href="css/site.css" rel="stylesheet"> -->
	<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />
	<!-- <script src="js/modernizr/modernizr.custom.2.8.3.js"></script> -->
	<style type="text/css">
		fieldset{
			border: 1px solid lightblue;
		}
		body>div{
			padding-left:10px;
			margin-top:10px;
		}
	</style>
</head>

<body class="panel-noscroll">
	<div>
		<fieldset >
			<legend>查找会员</legend>
			<table border="0" cellspacing="2" cellpadding="2">
				<tr>
					<td colspan="2">
						<label for="number">卡号/手机号 : </label> 
						<input type="text" name="number" id="number" value="" /> 
						<a href="javascript:search()" class="easyui-linkbutton">查找</a>
					</td>
				</tr>
				<tr>
					<td>
						<label for="memcardsName">姓名 : </label>
						<span id="memcardsName"></span>
					</td>
					<td>
						<label for="cardlevelsLevelname">等级 : </label>
						<span id="cardlevelsLevelname"></span>
					</td>
				</tr>
				<tr>
					<td>
						<label for="memcardsPoint">当前积分 : </label>
						<span id="memcardsPoint"></span>
					</td>
					<td>
						<label for="memcardsTotalmoney">累计消费 : $</label>
						<span id="memcardsTotalmoney"></span>
					</td>
				</tr>
			</table>
			<input type="hidden" id="memcardsId" name="memcardsId" value=""/><!-- 会员id -->
			<input type="hidden" id="memcardsCardid" name="memcardsCardid" value=""/><!-- 会员卡号 -->
			<input type="hidden" id="cardlevelsPercent" value="cardlevelsPercent"/><!-- 会员折扣 -->
			<input type="hidden" id="cardlevelsPoint" value="cardlevelsPoint"/><!-- 积分折扣 -->
			<script type="text/javascript">
				function search(){
					if($("#number").val() == ""){
						$.messager.show({
							title:'警告',
							msg:'请输入卡号或手机号码作为查询条件!',
							timeout:5000,
							showType:'slide'
						});
						return;
					}
					var value = document.getElementById("number");
					$.post(
						"${pageContext.request.contextPath}/member/queryByCardIdOrMobile",
						{
							id : $("#number").val()
						},
						function(data){
							if(data == 'null'){
								$.messager.show({
									title:'警告',
									msg:'没有找到相关会员!',
									timeout:5000,
									showType:'fade'
								});
								return;
							}
							$("#memcardsName").text(data.memcardsName);
							$("#memcardsPoint").text(data.memcardsPoint);
							$("#cardlevelsLevelname").text(data.cardlevels.cardlevelsLevelname);
							$("#memcardsTotalmoney").text(data.memcardsTotalmoney);
							$("#cardlevelsPercent").val(data.cardlevels.cardlevelsPercent);
							$("#cardlevelsPoint").val(data.cardlevels.cardlevelsPoint);
							$("#memcardsId").val(data.memcardsId);
							$("#memcardsCardid").val(data.memcardsCardid);
						}
					)
				}
			
			</script>		
		</fieldset>
	</div>
	<div>
		<table id="dg" style="min-height:200px;"></table>
		<script type="text/javascript">
			$(function() {
				$("#dg").datagrid({
					fitColumns : true,
					pagination : true, //pagination:如果为true，则在DataGrid控件底部显示分页工具栏。
					//fit : true, //fit:当设置为true的时候面板大小将自适应父容器。
					//singleSelect : false, //如果为true，则只允许选择一行。
					rownumbers : true, //如果为true，则显示一个行号列。
					onDblClickCell : function(rowIndex,field,value){
						var selectedRow = $(this).datagrid('getSelected');
						$("#dg").datagrid('endEdit',lastIndex);
						$("#dg").datagrid('beginEdit',rowIndex);
						lastIndex = rowIndex;
					},
				/* 	onAfterEdit : function(index,row,changes){
						$("#dg").datagrid('endEdit',index);
					}, */
					url : "${pageContext.request.contextPath}/gift/query", //url:设置能够返回JSON数据的Action所对应的路径
					columns : [ [ {
						field : 'ck',
						checkbox : true
					},{
						field : 'exchanglogsNumber',
						title : '兑换数量',
						align : "center",
						editor : 'numberbox',
						width : 150
						
					}, {
						field : 'exchanggiftsId',
						title : '礼品编号',
						width : 150,
						align : "center"
					},  {
						field : 'exchanggiftsGiftcode',
						title : '礼品代号',
						width : 150,
						align : "center"
					}, {
						field : 'exchanggiftsGiftname',
						title : '礼品名称',
						width : 150,
						align : "center"
					}, {
						field : 'exchanggiftsPoint',
						title : '所需积分',
						width : 150,
						align : "center"
					},{
						field : 'exchanggiftsInteger',
						title : '礼品数量',
						width : 150,
						align : "center"
					}, {
						field : 'exchanggiftsExchangnum',
						title : '已兑换数量',
						width : 150,
						align : "center"
					},{
						field : 'exchanggiftsRemark',
						title : '备注',
						width : 150,
						align : "center"
					},
					] ]
				});
			});
		</script>
	</div>
	<div>
		<p style="color:red"> 双击"兑换数量"的单元格可以修改兑换的数量.<br> 如果还未设置礼品请点击[礼品管理] </p>
		<input type="button" value="马上兑换" id="exchange" class="easyui-linkbutton">
		<script>
			var lastIndex = 0;//存储了上一次编辑的行号(datagrid)
			$("#dg").keypress(function(event){
				if(event.keyCode == 13){
					$("#dg").datagrid('endEdit',lastIndex);
				}
			})
			$("#exchange").click(function(){
				//检查会员是否已经查找
				if($("input[name=memcardsId]").val() == ""){
					$.messager.alert({
						title:'警告',
						msg:'请输入兑换会员!',
						timeout:3000
					});
					return;
				}
				//判断是否选中某行
				var row = $("#dg").datagrid("getSelected");
				if(row == null){
					$.messager.alert('提示','请选择礼品','warning');
					return;
				}
				//关闭最后编辑的单元格
				$("#dg").datagrid('endEdit',lastIndex); 
				//存储总积分
				var point = 0; 
				var rows = $("#dg").datagrid("getSelections");
				for(var i = 0; i <rows.length; i++){
					//$("#dg").datagrid('endEdit',i);
					if(rows[i].exchanglogsNumber == null || "" == rows[i].exchanglogsNumber){
						$.messager.alert('提示','请输入所选礼品的数量!','warning');
						return;
					}
					point += (rows[i].exchanglogsNumber * rows[i].exchanggiftsPoint);
				}
				
				if(point > 0){
					if(point <= $("#memcardsPoint").text()){
						$.ajax({
							cache : false,
							type : "POST",
							url :'${pageContext.request.contextPath}/exchange/exchange',
							data : {
								rows : JSON.stringify(rows),
								memcardsId : $("#memcardsId").val(),
								memcardsName : $("#memcardsName").text(),
								memcardsCardid : $("#memcardsCardid").val(),
								memcardsPoint : $("#memcardsPoint").text()
							},
							success : function(data){
								$("#dg").datagrid('reload');
								$("#memcardsPoint").text($("#memcardsPoint").text() - point);
								$.messager.alert({
									title:'提示',
									msg:'兑换成功!',
									timeout:3000,
									showType : 'fade',
									style : {
										right : '',
										bottom : ''
									}
								});
							}
						})
					} else{
						$.messager.alert('提示','用户当前积分不够哦!','warning');
					}
				}
			});
		
		</script>
	</div>
</body>

</html>