<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>分页脚标</title>
</head>
<body>
<div class="message">
        共<i class="blue">${pageInfo.total}</i>条记录,
        当前显示第&nbsp;<i class="blue">${pageInfo.pageNum}/${pageInfo.pages}</i>&nbsp;页
    </div>
    <div style="text-align: center">
        <ul class="pagination">
            <c:if test="${!pageInfo.isFirstPage}">
                <li><a href="goodsOrdersShow?pageNum=${pageInfo.firstPage}">首页</a></li>
                <li><a href="goodsOrdersShow?pageNum=${pageInfo.prePage}">上一页</a></li>
            </c:if>
            <c:forEach items="${pageInfo.navigatepageNums}" var="navigatepageNum">

                <c:if test="${navigatepageNum==pageInfo.pageNum}">
                    <li class="active"><a href="goodsOrdersShow?pageNum=${navigatepageNum}">${navigatepageNum}</a></li>
                </c:if>
                <c:if test="${navigatepageNum!=pageInfo.pageNum}">
                    <li><a href="goodsOrdersShow?pageNum=${navigatepageNum}">${navigatepageNum}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${!pageInfo.isLastPage}">
                <li><a href="goodsOrdersShow?pageNum=${pageInfo.nextPage}">下一页</a></li>
                <li><a href="goodsOrdersShow?pageNum=${pageInfo.lastPage}">最后一页</a></li>
            </c:if>
        </ul>
    </div>
</body>
</html>