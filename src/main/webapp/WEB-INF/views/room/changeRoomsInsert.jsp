<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>房间增加与删除</title>
</head>
<body>
<div>
<!--显示插入反馈信息  -->
	<h3>
		<c:if test="${string != null}">
			${string }
		</c:if>
	</h3>
	<!--数据表格  -->
	<form class="form-horizontal col-md-4" action="changeRoomsInsert">
		<div class="form-group">
			<label for="name">房间编号</label> <input type="text"
				class="form-control" id="roomNum" name="roomNum" maxlength="3"
				placeholder="请输入房间编号,如101"  required="required">
		</div>
		<div>
			<div class="form-group">
				<label for="name">房间类型</label>
					<div class="radio">
					<c:forEach items="${roomSizes}" var="list">
						<label> <input type="radio" id="roomSize" name="roomSize"
							value="${list.sizeId}"  required="required">${list.sizeName}</label>
					</c:forEach>
					</div>
			</div>
		</div>
		<div class="form-group">
			<button type="submit">添加房间</button>
		</div>
	</form>
</div>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$('input#roomNum').keyup(function() {
			var c = $(this);
			if (/[^\d]/.test(c.val())) {//替换非数字字符  
				var temp_amount = c.val().replace(/[^\d]/g, '');
				$(this).val(temp_amount);
			}
		});
		
	</script>
</body>
</html>