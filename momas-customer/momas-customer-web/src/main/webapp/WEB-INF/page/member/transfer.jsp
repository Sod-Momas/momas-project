<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<base href="${pageContext.request.contextPath}/"/>
		<script src="easyui/jquery.min.js"></script>
		<script src="easyui/jquery.easyui.min.js"></script>
		<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
		<title>转账页面</title>
		<style type="text/css">
			table{
				border: 1px lightblue solid;
				width: 300px;
			}
		</style>
	</head>
	<body>
		<div>转出会员</div>
		<table cellspacing="4" cellpadding="4">
			<tr>
				<td>卡号: <span>${card.memcardsCardid }</span></td>
				<td>姓名:<span>${card.memcardsName }</span></td>
			</tr>
			<tr>
				<td>账户积分:<span>${card.memcardsPoint }</span></td>
				<td>累计消费:$<span>${card.memcardsTotalmoney }</span></td>
			</tr>
		</table>
		<div>
			<p>
				<small>点击查找获取当前输入会员信息</small><br/>
				<input type="text" name="memcardsCardid" placeholder="请输入会员卡号" class="text-box" required/>
				<a href="javascript:search()" class="easyui-linkbutton">查找</a>
			</p>
		</div>
		<div><p>转入会员</p></div>
		<table  cellspacing="4" cellpadding="4">
			<tr>
				<td>卡号: <span id="memcardsCardid"></span></td>
				<td>姓名:<span id="memcardsName"></span></td>
			</tr>
			<tr>
				<td>账户积分:<span id="memcardsPoint"></span></td>
				<td>累计消费:<span id="memcardsTotalmoney"></span></td>
			</tr>
		</table>
		<form action="${pageContext.request.contextPath }/transfer/transfer" target="_parent" method="post">
			<input type="hidden" name="outter" value="${card.memcardsId }"/>
			<input type="hidden" name="inner" value=""/>
			<div><label for="money">转账金额:</label><input type="text" name="money" id="money" value="" required class="easyui-textbox"/></div>
			<div><label for="money">备 注 : </label><input type="text" name="remark" id="remark" value="" class="easyui-textbox"/></div>
			<div><input type="submit" class="easyui-linkbutton" /></div>
		</form>
		<script type="text/javascript">
			function search(){
				var memcardsCardid = $("input[name=memcardsCardid]").val();
				$.post(
						"${pageContext.request.contextPath}/member/queryByCardId", 
						{ memcardsCardid : memcardsCardid},
						function(data){
							$("#memcardsCardid").text(data.memcardsCardid);
							$("#memcardsName").text(data.memcardsName);
							$("#memcardsPoint").text(data.memcardsPoint);
							$("#memcardsTotalmoney").text('$' + data.memcardsTotalmoney);
							$("input[name=inner]").val(data.memcardsId);
						}
				);
			}
		</script>
	</body>
</html>
