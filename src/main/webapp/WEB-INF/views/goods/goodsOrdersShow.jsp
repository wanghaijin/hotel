<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>账单页面</title>

</head>
<body>
	<div class="container">
    <div class="row clearfix">
            <div id="edit_area_div">
                <table class="table" id="personList_table">
                    <thead>
                        <tr>
                            <td>商品名字</td>
                            <td>商品出售数量</td>
                            <td>商品出售时间</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageInfo.list}" var="goodsorder" varStatus="i">
                            <tr>
                                <td>${goodsorder.goods.goodsName}</td>
                                <td>${goodsorder.goodsOrdersAmount}</td>
                                <td>${goodsorder.goodsOrdersTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="page_div">
                    <%@include file="pagehelper.jsp"%>
                </div>
                
            </div>
    </div>
</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>