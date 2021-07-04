<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<base href="${pageContext.request.contextPath}/"/>
		<script src="easyui/jquery.min.js"></script>
		<script src="easyui/jquery.easyui.min.js"></script>
		<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
		<title>修改会员</title>
		<style type="text/css">
			.addtable{
				width: 490px;
			}
			.addtable .text-box{
				width: 80px;
			}
		</style>
	</head>
	<body>
		<form action="member/updatemember" target="_parent">
			<input type="hidden" name="memcardsId" value="${card.memcardsId }" />
			<table class="addtable" align="center" cellpadding="3" cellspacing="2">
				<tr>
					<td><label for="memcardsCardid">会员卡号</label></td>
					<td colspan="3">
						<input class="text-box sing-line" id="memcardsCardid" name="memcardsCardid" type="text" value="${card.memcardsCardid }" />
					</td>
				</tr>
				<tr>
					<td><label for="memcardsName">会员姓名：</label></td>
					<td><input class="text-box sing-line" id="memcardsName" name="memcardsName" type="text"value="${card.memcardsName }" /></td>
					<td><label for="memcardsMobile">手机号码：</label></td>
					<td><input class="text-box sing-line" id="memcardsMobile" name="memcardsMobile" type="text" value="${card.memcardsMobile }" /></td>
				</tr>
				<tr>
					<td><label for="LXR1">卡片密码：</label></td>
					<td><input class="text-box sing-line" id="LXR1" type="password" /></td>
					<td><label for="LXR">确定密码:</label></td>
					<td><input class="text-box sing-line" id="LXR" name="memcardsPassword" type="password" /></td>
				</tr>
				<tr>
					<td><label >会员性别：</label></td>
					<td>
						<select name="memcardsSex">
							<option value="不公开" <c:if test="${card.memcardsSex eq '不公开' }">selected</c:if> >不公开</option>
							<option value="男" <c:if test="${card.memcardsSex eq '男' }">selected</c:if>>男</option>
							<option value="女" <c:if test="${card.memcardsSex eq '女' }">selected</c:if>>女</option>
						</select>
					</td>
					<td><label for="DJ">会员等级：</label></td>
					<td>
						<select id="DJ" name="cardlevelsId">
							<c:forEach items="${levels }" var="l">
							 	<option value="${l.cardlevelsId}"
							 	<c:if test="${l.cardlevelsId eq card.cardlevelsId }">selected</c:if>
							 	>${l.cardlevelsLevelname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>会员生日</td>
					<td>
						<label><input type="radio" value="1" name="memcardsBirthdaytype" checked="checked" />公历</label>
						<label><input type="radio" value="0" name="memcardsBirthdaytype" />农历</label>
					</td>
					<td colspan="2">
						<input type="text" class="text-box" name="memcardsBirthdayMonth" value="${card.memcardsBirthdayMonth }" />月
						<input type="text" class="text-box" name="memcardsBirthdayDay" value="${card.memcardsBirthdayDay }" />日
					</td>
				</tr>
				<tr>
					<td colspan="3"><label><input name="memcardsIspast" type="checkbox" value="1" <c:if test="${card.memcardsIspast eq 1}">checked</c:if>/>设置卡片过期时间(到期则此卡自动失效)</label></td>
					<td>
						<input type="date" class="text-box" name="memcardsPasttime" value="${card.memcardsPasttime }" />
					</td>
				</tr>
				<tr>
					<td>卡片状态</td>
					<td>
						<select id="ZT" name="memcardsState">
							<c:forEach items="${states }" var="s">
							 	<option value="${s.categoryId}"
							 	<c:if test="${s.categoryId eq card.memcardsState }">selected</c:if>
							 	>${s.categoryTitle}</option>
							</c:forEach>					
						</select>
					</td>
					<td>卡片付费：</td>
					<td>
						<input type="text" name="memcardsTotalmoney" class="text-box" value="${card.memcardsTotalmoney }"/>
					</td>
				</tr>
				<tr>
					<td colspan="4"><hr /></td>
				</tr>
				<tr>
					<td>积分数量：</td>
					<td><input type="text" class="text-box" name="memcardsPoint"  value="${card.memcardsPoint }"/></td>
					<td colspan="2">
						<label><input type="checkbox" name="memcardsIspointauto" value="1" <c:if test="${card.memcardsIspointauto eq 1}">checked</c:if> />积分是否可以自动转换为等级？</label>
					</td>
				</tr>
				<tr>
					<td>推荐人：</td>
					<td><input type="text" name="memcardsRefererid" class="text-box" /><a href="javascript:search(this)" class="easyui-linkbutton">查找</a> </td>
					<td>推荐人姓名：</td>
					<td>
						<input type="text" name="memcardsReferername" class="text-box" value="${card.memcardsReferername }"/>
						<input type="hidden" name="memcardsReferercard" />
					</td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" class="easyui-linkbutton" style="width:100px" value="确认修改" /> </td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			function search(element){
				var memcardsRefererid = $("input[name=memcardsRefererid]").val();
				$.post(
						"${pageContext.request.contextPath}/member/queryById", 
						{ memcardsRefererid : memcardsRefererid},
						function(data){
							$("input[name=memcardsReferername]").val(data.memcardsName);
							$("input[name=memcardsReferercard]").val(data.memcardsCardid);
						}
				);
			}
		</script>
		<script type="text/javascript">
			$(function () {
				$("form").submit(function(){
					if($("#cardpassword").val() != $("#memcardsPassword").val()){
						$.messager.alert("提示", "两个密码不一致", "warning");
						return false;
					}
					return true;
				})
				/*
				/* 等级的异步  
				 $("#DJ").append("<option value='0'>--请选择--</option>");
				$.post("${pageContext.request.contextPath}/cardlevel/queryAllDj", 
						function(data){
							$.each( data, function(i, d){
									$("#DJ").append("<option value='" +d.cardlevelsId + "'>" +d.cardlevelsLevelname + "</option>")
								});
					 });
				/* 状态 
			 	$("#ZT").append("<option value='0'>--请选择--</option>");
					$.post("${pageContext.request.contextPath}/car/queryAllZT", 
						function(data){
							$.each(data, function(i, d){
									$("#ZT").append("<option value='" +d.categoryId + "'>" +d.categoryTitle + "</option>")
							});
					 });
					$('.text-box').textbox({});
					$('select').combobox({}); 
				*/
			});
		</script> 
	</body>
</html>