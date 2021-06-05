<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-tag"></span>
		修改订单
	</h2>
	<form method="post" class="col-md-6 col-md-offset-3 form-horizontal">
		<input type="hidden" name="proId" value="${provider.proId }" class="sr-only"/>
		<div class="form-group">
			<label for="proCode" class="col-sm-2 control-label">商家编号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proCode" value="${provider.proCode }"
				 name="proCode" placeholder="商家编号"/>
			</div>
		</div>
		<div class="form-group">
			<label for="proName" class="col-sm-2 control-label">商家名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proName"value="${provider.proName }"
				 name="proName"	placeholder="商家名称"/>
			</div>
		</div>
		<div class="form-group">
			<label for="proDesc" class="col-sm-2 control-label">商家描述</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proDesc" name="proDesc" value="${provider.proDesc }"
					placeholder="商家描述">
			</div>
		</div>
		<div class="form-group">
			<label for="proContact" class="col-sm-2 control-label">商家联系方式</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proContact" name="proContact" value="${provider.proContact }"
					placeholder="商家联系方式">
			</div>
		</div>
		<div class="form-group">
			<label for="proPhone" class="col-sm-2 control-label">商家手机</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proPhone" name="proPhone" value="${provider.proPhone }"
					placeholder="商家手机">
			</div>
		</div>
		<div class="form-group">
			<label for="proAddress" class="col-sm-2 control-label">商家地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proAddress" name="proAddress" value="${provider.proAddress }"
					placeholder="商家地址" />
			</div>
		</div>
		<div class="form-group">
			<label for="proFax" class="col-sm-2 control-label">商家传真</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="proFax" name="proFax" value="${provider.proFax }"
					placeholder="商家传真" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">确认修改</button>
			</div>
		</div>
	</form>

</div>

<%@ include file="../page-footer.jsp" %>