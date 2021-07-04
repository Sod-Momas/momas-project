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
				<td colspan="2">
					<label for="number">卡号/手机号 : </label> 
					<input type="text" name="number" id="number" value="" />
					<a href="javascript:search(this)" class="easyui-linkbutton">查找</a>
				</td>
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
		<legend>积分返现</legend>
		
		<table>
			<tr>
				<td colspan="2">
					<label>兑换日期:</label>
					<input type="text" name="" value="" class="time"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>兑换积分:</label>
					<input name=""/>
				</td>
				<td>
					<label>积分反现:</label>
					<input name=""/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label>剩余积分:</label>
					<input name=""/>
				</td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset id="">
	<legend>积分返现</legend>
		<p>
		操作过程中,只需要输入操作的会员卡号/手机查询对应会员,再输入兑换积分,系统将自动计算.<br>
		在"管理"->"其他设置"中可以设置会员积分返现的兑换比例
		</p>
	</fieldset>
		
		
	<input type="button" name="justdoit" id="justdoit" value="马上返现"  />
	<input type="hidden" id="memcardsId" name="memcardsId" value=""/>
	<script>
		//document.getElementById("currentTime").innerText = new Date().toLocaleString();
		$(".time").val(new Date().toLocaleString());
		
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
					$("#memcardsTotalmoney").text(data.memcardsTotalmoney==null? 0 : data.memcardsTotalmoney);
					$("#cardlevelsPercent").val(data.cardlevels.cardlevelsPercent);
					$("#cardlevelsPoint").val(data.cardlevels.cardlevelsPoint);
					$("#memcardsId").val(data.memcardsId);
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
						score : $("input[name=score]").val(),
						remark : $("input[name=remark]").val()
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
					}
				);
		}
		
	</script>
</body>
</html>