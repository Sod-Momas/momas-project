<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
		<script type="text/javascript">
			var ctx='${pageContext.request.contextPath}';
			var isSearch = true;
			function toadd(){
				window.location.href='${pageContext.request.contextPath}/carinfotoadd';
			}
		</script>
	</head>
	<body>
		<table border="1" cellspacing="5" cellpadding="10" style="width: 700px;margin:auto 0;text-align: center; " >
			<tr>
				<td colspan="5">
					<form action="${pageContext.request.contextPath}/carinfosearch" method="post">
						<span>汽车品牌:</span>
						<select id="brand" >
							<option value="">不限</option>
						</select>
						<span>汽车车型号:</span>
						<select name="qc.modalId" id="modal">
							<option value="">不限</option>
						</select>
						<span>价格:</span>
						<input type="text" name="qc.minPrice" id="minPrice" size="5" />
						<span>万-</span>
						<input type="text" name="qc.maxPrice" id="maxPrice" size="5"  />
						<span>万</span>
						<input type="submit" value="查询" />
					</form>
				</td>
			</tr>
			<tr>
				<th>汽车型号</th>
				<th>颜色</th>
				<th>排量</th>
				<th>变速器类型</th>
				<th>价格(万元)</th>
			</tr>
			
			<s:if test="infolist == null or infolist.size <1">
				<tr>
					<td colspan="5">没有内容</td>
				</tr>
			</s:if>
				<s:else>
					<s:iterator value="infolist" var="info">
						<tr>
							<td>
								<s:property value="#info.carmodal.modalname"/>
							</td>
							<td>
								<s:property value="#info.carcolor"/>
							</td>
							<td>
								<s:property value="#info.cardisplacement"/>
							</td>
							<td>
								<s:property value="#info.carclutch"/>
							</td>
							<td>
								<s:property value="#info.carprice"/>
							</td>
						</tr>
					</s:iterator>
				</s:else>
					
			<tr>
				<td  colspan="5" style="text-align: center;">
					<button onclick="toadd()">添加</button>
				</td>
			</tr>
		</table>
	</body>
</html>