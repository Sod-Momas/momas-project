<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快速消费</title>
	<base href="${pageContext.request.contextPath}/"/>
	<script src="easyui/jquery.min.js"></script>
	<script src="easyui/jquery.easyui.min.js"></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<style type="text/css">
		fieldset{
			border: 1px solid lightblue;
		}
	</style>
</head>
<body>
	<fieldset id="">
		<legend>查找会员</legend>
		<table border="0" cellspacing="2" cellpadding="2">
			<tr>
				<td><label for="number">卡号/手机号 : </label>
					<input type="text" name="number" id="number" value=""/>
					<a href="javascript:search(this)" class="easyui-linkbutton">查找</a>
				</td>
				<td>消费时间 : <span id="currentTime">time</span></td>
			</tr>
			<tr>
				<td><label for="memcardsName">姓名 : </label><span id="memcardsName"></span></td>
				<td><label for="cardlevelsLevelname">等级 : </label><span id="cardlevelsLevelname"></span></td>
			</tr>
			<tr>
				<td><label for="memcardsPoint">当前积分 : </label><span id="memcardsPoint"></span></td>
				<td><label for="memcardsTotalmoney">累计消费 : $</label><span id="memcardsTotalmoney"></span></td>
			</tr>
		</table>
	</fieldset>
	<fieldset id="">
		<legend>优惠活动</legend>
		<p style="color: red;">暂无优惠活动</p>
	</fieldset>
	<div>
		<table border="0" cellspacing="2" cellpadding="2">
			<tr>
				<td>请输入消费金额 : </td>
				<td><input type="number" min="0" id="money" value="" /></td>
				<td colspan="2"> <small>此处输入金额会按会员等级自动打折</small></td>
			</tr>
			<tr>
				<td>折后总金额 : </td>
				<td><input type="text" name="fee" id="fee" value="" readonly /></td>
				<td>可自动累计积分数量 : </td>
				<td><input type="text" name="integral" id="integral" value="" readonly="readonly" /></td>
			</tr>
			<tr>
				<td colspan="2">付费方式 : <label><input type="radio" name="" id="" value="" checked="checked" />现金支付</label></td>
				<td colspan="2">优惠活动 : <span style="color: red;">暂无</span></td>
			</tr>
		</table>
	</div>
	<input type="hidden" id="memcardsId" name="memcardsId" value=""/>
	<input type="hidden" id="cardlevelsPercent" value="cardlevelsPercent"/><!-- 会员折扣 -->
	<input type="hidden" id="cardlevelsPoint" value="cardlevelsPoint"/><!-- 积分折扣 -->
	<fieldset id="">
		<legend>说明</legend>
		<p>输入实际的消费金额,系统会自动按照会员等级中的设置按照一定比例计算积分并累计到会员账户<br />
			在"系统管理"->"会员等级管理"中可设置RMB和积分的兑换比例<br />
			在"系统管理"->"会员等级管理"中可设置是否允许直接输入折后总金额<br />
			在"系统管理"->"会员等级管理"中可设置是否允许直接输入累计积分数量
		</p>
	</fieldset>
	<p>
		<a href="javascript:complete()" class="easyui-linkbutton" style="width:100px; height:32px;">马上结算</a>
	</p>
	<script>
		document.getElementById("currentTime").innerText = new Date().toLocaleString();
		function search(elememt){
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
				}
			)
		}
		$("#money").keyup(function(){
			if(!$("#money").val()){ return; }
			var memberOff = $("#cardlevelsPercent").val();//会员折扣
			var integralOff = $("#cardlevelsPoint").val();//积分折扣
			$("#fee").val($("#money").val() * memberOff);
			$("#integral").val($("#fee").val() * integralOff);
		});
		function complete(){
			if($("#memcardsId").val()==""){
				$.messager.alert("提示", "请先选择会员", "warning");
				return;
			}
			if($("#money").val()==""){
				$.messager.alert("提示", "请先输入消费金额", "warning");
				return;
			}
			$(document).load(
					"${pageContext.request.contextPath}/consum/fastconsum", 
					{
						memcardsId: $("#memcardsId").val(),//消费的会员id
						fee : $("#fee").val(),//折后总金额
						integral : $("#integral").val(),//累加的积分 
						money : $("#money").val()//消费金额
					}, 
					function(data){
						$.messager.alert("提示", data, "warning");
						$("input").val("");
						$("#memcardsName").text("");
						$("#memcardsPoint").text('');
						$("#cardlevelsLevelname").text('');
						$("#memcardsTotalmoney").text('');
					}
			);
		}
	</script>
</body>
</html>