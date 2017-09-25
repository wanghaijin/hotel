<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>空闲房间管理界面</title>
</head>
<body>

	<div>
		<c:if test="${!rooms.isEmpty()}">
		<h4>共有${rooms.size()}间空闲房间</h4>
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
							<td><a href="roomType1?roomNum=${list.roomNum}&roomType=2"><button
										type="button">入住</button></a> <a
								href="roomType1?roomNum=${list.roomNum}&roomType=3"><button
										type="button">预定</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${rooms.isEmpty()}">
			<h4>暂无空闲房间</h4>
		</c:if>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>