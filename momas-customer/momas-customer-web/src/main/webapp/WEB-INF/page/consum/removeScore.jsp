<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会员减积分</title>
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
				<td>
					<label for="number">卡号/手机号 : </label> 
					<input type="text" name="number" id="number" value="" />
					<a href="javascript:search(this)" class="easyui-linkbutton">查找</a>
				</td>
				<td>消费时间 : <span id="currentTime">time</span></td>
			</tr>
			<tr>
				<td><label for="memcardsName">姓名 : </label><span
					id="memcardsName"></span></td>
				<td><label for="cardlevelsLevelname">等级 : </label><span
					id="cardlevelsLevelname"></span></td>
			</tr>
			<tr>
				<td><label for="memcardsPoint">当前积分 : </label><span
					id="memcardsPoint"></span></td>
				<td><label for="memcardsTotalmoney">累计消费 : $</label><span
					id="memcardsTotalmoney"></span></td>
			</tr>
		</table>
	</fieldset>
	<fieldset id="">
		<legend>减积分信息</legend>
		<table border="0" cellspacing="2" cellpadding="2">
			<tr>
				<td><label for="score">扣除积分 : </label> </td>
				<td><input type="number" name="score" id="score" value="" /></td>
			</tr>
			<tr>
				<td><label for="remark">备注: </label></td>
				<td><input type="text" name="remark" id="remark" /></td>
			</tr>
		</table>
	</fieldset>
	<input type="button" name="justdoit" id="justdoit" value="马上扣除" onclick="complete()" />
	<input type="hidden" id="memcardsId" name="memcardsId" value=""/>
	<input type="hidden" id="memcardsCardid" name="memcardsCardid" value=""/>
	<input type="hidden" name="memcardsPoint" value=""/>
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
					$("input[name=memcardsPoint]").val(data.memcardsPoint);
					$("#cardlevelsLevelname").text(data.cardlevels.cardlevelsLevelname);
					$("#memcardsTotalmoney").text(data.memcardsTotalmoney==null? 0 : data.memcardsTotalmoney);
					$("#cardlevelsPercent").val(data.cardlevels.cardlevelsPercent);
					$("#cardlevelsPoint").val(data.cardlevels.cardlevelsPoint);
					$("#memcardsId").val(data.memcardsId);
					$("#memcardsCardid").val(data.memcardsCardid);
				}
			)
		}
		
		function complete(){
			if($("#memcardsId").val()==""){
				$.messager.alert("提示", "请先选择会员", "warning");
				return;
			}
			if($("#score").val()==""){
				$.messager.alert("提示", "请先输入扣除的积分", "warning");
				return;
			}
			//在这里写提交数据的方法
			$.get(
					"${pageContext.request.contextPath}/consum/removescore",
					{ 
						memcardsId : $("input[name=memcardsId]").val(),
						ori_score : $("input[name=memcardsPoint]").val(),
						score : $("input[name=score]").val(),
						remark : $("input[name=remark]").val(),
						memcardsCardid : $("input[name=memcardsCardid]").val()
					},
			 	 	function(data){
						$.messager.show({
							title:'提示',
							msg: data,
							timeout:5000,
							showType:'slide'
						});
						
						$("#memcardsName").text('');
						$("#memcardsPoint").text("");
						$("#cardlevelsLevelname").text('');
						$("#memcardsTotalmoney").text("");
						$("#cardlevelsPercent").val('');
						$("#cardlevelsPoint").val('');
						$("input[name=memcardsId]").val('');
						$("input[name=score]").val('');
						$("input[name=remark]").val('');
						$("input[name=memcardsCardid]").val('');
					}
				);
		}
		
	</script>
</body>
</html>