<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-eye-open"></span>
		查看订单
	</h2>

	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<td class="text-center">订单编号</td>
						<td>${bill.billCode }</td>
					</tr>
					<tr>
						<td class="text-center">产品名</td>
						<td>${bill.productName }</td>
					</tr>
					<tr>
						<td class="text-center">产品数量</td>
						<td>${bill.productCount }</td>
					</tr>
					<tr>
						<td class="text-center">产品单位</td>
						<td>${bill.productUnit }</td>
					</tr>
					<tr>
						<td class="text-center">产品描述</td>
						<td>${bill.productDesc }</td>
					</tr>
					<tr>
						<td class="text-center">产品供应商</td>
						<td>${bill.providerId }</td>
					</tr>
					<tr>
						<td class="text-center">总价格(元)</td>
						<td>${bill.totalPrice }</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="../page-footer.jsp" %>