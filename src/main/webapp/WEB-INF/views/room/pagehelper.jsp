<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <div class="message">
        共<i class="blue">${pagehelper.total}</i>条记录,
        当前显示第&nbsp;<i class="blue">${pagehelper.pageNum}/${pagehelper.pages}</i>&nbsp;页
    </div>
    <div style="text-align: center">
        <ul class="pagination">
            <c:if test="${!pagehelper.isFirstPage}">
                <li><a id="${pagehelper.firstPage}" href="javascript:void(0);" onclick="pageShow(this)">首页</a></li>
                <li><a id="${pagehelper.prePage}" href="javascript:void(0);" onclick="pageShow(this)">上一页</a></li>
            </c:if>
            <c:forEach items="${pagehelper.navigatepageNums}" var="navigatepageNum">

                <c:if test="${navigatepageNum==pagehelper.pageNum}">
                    <li class="active"><a id="${navigatepageNum}" href="javascript:void(0);" onclick="pageShow(this)">${navigatepageNum}</a></li>
                </c:if>
                <c:if test="${navigatepageNum!=pagehelper.pageNum}">
                    <li><a id="${navigatepageNum}" href="javascript:void(0);" onclick="pageShow(this)">${navigatepageNum}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${!pagehelper.isLastPage}">
                <li><a id="${pagehelper.nextPage}" href="javascript:void(0);" onclick="pageShow(this)">下一页</a></li>
                <li><a id="${pagehelper.lastPage}" href="javascript:void(0);" onclick="pageShow(this)">最后一页</a></li>
            </c:if>
        </ul>
    </div>
    
    <script type="text/javascript">
    	function pageShow(obj) {
    		var preUrl='roomType5?pageNum=';
			var sufUrl='&pageSize=${param.pageSize}&roomNum=${param.roomNum}&userId=${param.userId}&startTime=${param.startTime}&endTime=${param.endTime}';
			var trueUrl=preUrl+obj.id+sufUrl;
			
			window.location.href=trueUrl;
		}
    </script>
</body>
</html>
