<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="page-header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">
		<small><span class="glyphicon glyphicon-user"></span></small>用户模块
	</h1>

	<div class="row placeholders">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th class="text-center">用户编号</th>
						<th class="text-center">用户名</th>
						<th class="text-center">用户角色</th>
						<th class="text-center">性别</th>
						<th class="text-center">地址</th>
						<th class="text-center">生日</th>
						<th class="text-center">手机</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList }" var="user">
						<tr>
							<td>${user.userCode }</td>
							<td>${user.userName }</td>
							<td>${user.userRole }</td>
							<td>${user.gender }</td>
							<td>${user.address }</td>
							<td>${user.birthday }</td>
							<td>${user.phone }</td>
							<td><a role="button" title="查看"
								class="btn btn-xs btn-success"
								href="javascript:user.query(${user.userId })"><span
									class="glyphicon glyphicon-eye-open"></span></a> <a role="button"
								title="修改" class="btn btn-xs btn-primary"
								href="javascript:user.update(${user.userId })"><span
									class="glyphicon glyphicon-edit"></span></a> <a role="button"
								title="删除" class="btn btn-xs btn-danger"
								href="javascript:user.del(${user.userId })"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div>
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="javascript:void(0)" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li><a href="javascript:void(0)">1</a></li>
					<li><a href="javascript:void(0)">2</a></li>
					<li><a href="javascript:void(0)">3</a></li>
					<li><a href="javascript:void(0)" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span></a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<%@ include file="page-footer.jsp" %>