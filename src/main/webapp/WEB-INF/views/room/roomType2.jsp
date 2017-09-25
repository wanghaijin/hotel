<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>已入住房间管理界面</title>

</head>
<body>
	<div>
		<c:if test="${!rooms.isEmpty()}">
			<h4>共有${rooms.size()}间房间有人入住</h4>
			<table class="table">
				<thead>
					<tr>
						<td>房间编号</td>
						<td>房间型号</td>
						<td>房间可执行操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rooms}" var="list">
						<tr>
							<td>${list.roomNum}</td>
							<td>${list.roomSize.sizeName}</td>
							<td><a href="roomType2?roomNum=${list.roomNum}&roomType=4"><button
										type="button">退房</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${rooms.isEmpty()}">
			<h4>暂无人入住</h4>
		</c:if>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>