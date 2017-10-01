<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>商品订单生成与显示页面</title>

</head>
<body>
<h4>
	<c:if test="${info != null || info != '' }">
		<h3><span class="label label-success">${info}</span></h3></c:if>
</h4>
	<form class="form-horizontal col-md-4" action="goodsOrders">
		<div class="form-group">
			<label for="goodsName">
				商品名称
			</label>
			<input class="form-control" placeholder="请输入商品名字" type="text" required="required" name="goodsName" id="goodsName">
		</div>
		<div class="form-group">
			<label for="goodsOrdersAmount">
				商品数量
			</label>
			<input class="form-control" placeholder="请输入销售数量" type="number" required="required" name="goodsOrdersAmount" id="goodsOrdersAmount">
		</div>
		<div class="form-group">
			<button type="submit" class="form-control btn btn-primary">提交订单</button>
		</div>
		
		</form>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>