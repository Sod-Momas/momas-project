<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="page-header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-tag"></span>
		订单管理
		<button class="pull-right btn btn-success" onclick="javascript:bill.add(path)" title="添加订单">
			<span class="glyphicon glyphicon-plus"></span>
		</button>
	</h2>
	<div class="clearfix"></div>
	<div class="sr-only">
		<ol class="breadcrumb inline">
			<li><a href="javascript:void(0)">Home</a></li>
			<li class="active">Data</li>
		</ol>
	</div>
	<c:if test="${ not empty msg }">
		<div class="alert alert-warning alert-dismissible fade" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			 ${msg }
		</div>
	</c:if>
	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th class="text-center">订单编号</th>
						<th class="text-center">产品名</th>
						<th class="text-center">产品数量</th>
						<th class="text-center">产品单位</th>
						<th class="text-center">产品描述</th>
						<th class="text-center">产品供应商</th>
						<th class="text-center">总价格(元)</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${billList }" var="bill">
						<tr>
							<td>${bill.billCode }</td>
							<td>${bill.productName }</td>
							<td>${bill.productCount }</td>
							<td>${bill.productUnit }</td>
							<td>${bill.productDesc }</td>
							<td>${bill.providerId }</td>
							<td>${bill.totalPrice }</td>
							<td>
								<a role="button" title="查看" class="btn btn-xs btn-success" href="javascript:bill.watch(${bill.billId })"><span class="glyphicon glyphicon-eye-open"></span></a>
								<a role="button" title="修改" class="btn btn-xs btn-primary" href="javascript:bill.update(${bill.billId })"><span class="glyphicon glyphicon-edit"></span></a>
								<a role="button" title="删除" class="btn btn-xs btn-danger" href="javascript:bill.del(${bill.billId })"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div>
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li>
						<a href="javascript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
					</li>
					<li><a href="javascript:void(0)">1</a></li>
					<li><a href="javascript:void(0)">2</a></li>
					<li><a href="javascript:void(0)">3</a></li>
					<li>
						<a href="javascript:void(0)" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<script src="js/bill.js" type="text/javascript" charset="utf-8"></script>
<%@ include file="page-footer.jsp" %>