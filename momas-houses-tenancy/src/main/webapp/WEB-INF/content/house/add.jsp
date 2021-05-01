<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>租房 -发布房屋信息</title>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.12.4.js"></script>
		<script>var ctx = '${ctx}';var isSearch = false;</script>
		<script type="text/javascript" src="${ctx}/js/commoms.js"></script>
	</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${ctx}/images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新房屋信息发布</dt>
			<dd class="past">填写房屋信息</dd>

		</dl>
		<div class="box">
			<s:form action="houseadd" enctype="multipart/form-data">
				<div class="infos">
					<table class="field">
						<tr>
							<td colspan="2">
								<s:fielderror></s:fielderror>
							</td>
						</tr>
						<tr>
							<td class="field">标　　题：</td>
							<td>
								<s:textfield cssClass="text" key="house.title" name="house.title"/>
							</td>
						</tr>
						<tr>
							<td class="field">户　　型：</td>
							<td>
								<select  class="text" name="house.types.id">
									<s:iterator value="typesList" var="type">
										<option value='<s:property value="#type.id"/>'>
											<s:property value="#type.name"/>
										</option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td class="field">面　　积：</td>
							<td><s:textfield cssClass="text" key="house.floorage" name="house.floorage"/></td>
						</tr>
						<tr>
							<td class="field">价　　格：</td>
							<td>
								<s:textfield cssClass="text" key="house.price" name="house.price"/>
							</td>
						</tr>
						 <tr>
							<td class="field">图　　片：</td>
							<td>
								<s:file cssClass="text" key="pic" name="pic"></s:file>
							</td>
						</tr>
						<tr>
							<td class="field">房产证日期：</td>
							<td><s:textfield cssClass="text" key="house.pubdate" name="house.pubdate"/></td>
						</tr>
						
                        <tr>
							<td class="field">位　　置：</td>
							<td>
								地区是:
								<select class="text" name="house.street.district.id" id="district_id">
									<option>请选择地区</option>
								</select>
                            	街道是:
                            	<select  class="text" name="house.street.id" id="street_id">
	                            	<option>请选择地区</option>
                            	</select>
                            
                            </td>
						</tr>
                        <tr>
							<td class="field">联系方式：</td>
							<td>
								<s:textfield cssClass="text" key="house.contact" name="house.contact"/>
							</td>
						</tr>
                        <tr>
							<td class="field">详细信息：</td>
							<td><textarea name="house.description"></textarea></td>
						</tr>
					</table>
					<div class="buttons">
						<s:submit value="立即发布"/>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>租房 &copy; 2010  京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>