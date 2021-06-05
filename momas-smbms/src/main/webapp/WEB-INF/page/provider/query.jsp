<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-eye-open"></span>
		查看供应商
	</h2>

	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<td class="text-center">Id</td>
						<td>${provider.proId }</td>
					</tr>
					<tr>
						<td class="text-center">编号</td>
						<td>${provider.proCode }</td>
					</tr>
					<tr>
						<td class="text-center">供应商名称</td>
						<td>${provider.proName }</td>
					</tr>
					<tr>
						<td class="text-center">描述</td>
						<td>${provider.proDesc }</td>
					</tr>
					<tr>
						<td class="text-center">联系方式</td>
						<td>${provider.proContact }</td>
					</tr>
					<tr>
						<td class="text-center">手机</td>
						<td>${provider.proPhone }</td>
					</tr>
					<tr>
						<td class="text-center">地址</td>
						<td>${provider.proAddress }</td>
					</tr>
					<tr>
						<td class="text-center">传真</td>
						<td>${provider.proFax }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="../page-footer.jsp" %>