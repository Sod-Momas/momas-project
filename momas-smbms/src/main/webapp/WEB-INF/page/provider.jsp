<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="page-header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header"><small><span class="glyphicon glyphicon-globe"></span></small>供应商模块</h1>

	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th class="text-center">商户编号</th>
						<th class="text-center">商户名</th>
						<th class="text-center">商户描述</th>
						<th class="text-center">联系方式</th>
						<th class="text-center">商户电话</th>
						<th class="text-center">商户地址</th>
						<th class="text-center">商户传真</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${providerList }" var="provider">
						<tr>
							<td>${provider.proCode }</td>
							<td>${provider.proName }</td>
							<td>${provider.proDesc }</td>
							<td>${provider.proContact }</td>
							<td>${provider.proPhone }</td>
							<td>${provider.proAddress }</td>
							<td>${provider.proFax }</td>
							<td>
								<a role="button" title="查看" class="btn btn-xs btn-success" href="javascript:provider.query(${provider.proId })"><span class="glyphicon glyphicon-eye-open"></span></a>
								<a role="button" title="修改" class="btn btn-xs btn-primary" href="javascript:provider.update(${provider.proId })"><span class="glyphicon glyphicon-edit"></span></a>
								<a role="button" title="删除" class="btn btn-xs btn-danger" href="javascript:provider.del(${provider.proId })"><span class="glyphicon glyphicon-trash"></span></a>
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
<script src="js/provider.js" type="text/javascript" charset="utf-8"></script>
<%@ include file="page-footer.jsp" %>