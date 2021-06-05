<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../page-header.jsp" %>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">
		<span class="small glyphicon glyphicon-tag"></span>
		修改订单
	</h2>
	<form method="post" class="col-md-6 col-md-offset-3 form-horizontal">
		<input type="hidden" name="billId" value="${bill.billId }" class="sr-only"/>
		<div class="form-group">
			<label for="billCode" class="col-sm-2 control-label">订单编号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control readonly" id="billCode" value="${bill.billCode }" name="billCode" placeholder="订单编号" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="productName" class="col-sm-2 control-label">产品名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="productName"  name="productName" value="${bill.productName }" placeholder="产品名称"/>
			</div>
		</div>
		<div class="form-group">
			<label for="productDesc" class="col-sm-2 control-label">产品描述</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="productDesc" name="productDesc" value="${bill.productDesc }" placeholder="产品描述">
			</div>
		</div>
		<div class="form-group">
			<label for="productUnit" class="col-sm-2 control-label">产品单位</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="productUnit" name="productUnit" value="${bill.productUnit }" placeholder="产品单位">
			</div>
		</div>
		<div class="form-group">
			<label for="productCount" class="col-sm-2 control-label">产品数量</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="productCount" name="productCount" value="${bill.productCount }" placeholder="产品数量">
			</div>
		</div>
		<div class="form-group">
			<label for="totalPrice" class="col-sm-2 control-label">产品总价格</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="totalPrice" name="totalPrice" value="${bill.totalPrice }" placeholder="产品总价格" />
			</div>
		</div>
		<div class="form-group">
			<label for="isPayment" class="col-sm-2 control-label">是否已经付款</label>
			<div class="col-sm-10">
				<label><input type="radio" id="isPaymenty" value='0' name="isPayment" <c:if test="${0 eq bill.isPayment}">checked</c:if> />否</label>  
				<label><input type="radio" id="isPaymentn" value='1' name="isPayment" <c:if test="${1 eq bill.isPayment}">checked</c:if> />是</label>
			</div>
		</div>
		<div class="form-group">
			<label for="providerId" class="col-sm-2 control-label">供应商</label>
			<div class="col-sm-10">
				<select name="providerId" class="form-control">
					<c:forEach items="${plist}" var="p" >
						<option value="${p.proId}"<c:if test="${p.proId eq bill.providerId }">selected</c:if>>${p.proName}</option>
					</c:forEach>
				</select>
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