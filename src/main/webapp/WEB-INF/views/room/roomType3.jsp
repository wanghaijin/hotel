<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">
<title>已预定房间管理界面</title>

</head>
<body  onload="showLeftTime()">
	<h3>当前时间<label id="show">显示时间的位置</label></h3>
	<c:if test="${!roomOrders.isEmpty()}">
		<h3>共有<span class="label label-danger">${roomOrders.size()}</span>间房间有人预定</h3>
		<div class="col-md-10 column">
			<table class="table">
				<thead>
					<tr>
						<th>房间</th>
						<th>价格</th>
						<th>房间开始使用时间</th>
						<th>入住人姓名</th>
						<th>入住人身份证号</th>
						<th>入住人电话</th>
						<th>押金</th>
						<th>房间可执行操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roomOrders}" var="list" varStatus="i">
					<tr>
							<td>${list.roomNum}${list.room.roomSize.sizeName}</td>
							<td>${list.roomPrice}</td>
							<td>${list.roomOrdersStartTime.toString().substring(0,(list.roomOrdersStartTime.toString().length()-2))}</td>
							<td>
								<table>
									<c:forEach items="${list.users }" var="user">
										<tr><td>${user.userName }</td></tr>
									</c:forEach>
								</table>
							</td>
							<td>
								<table>
									<c:forEach items="${list.users }" var="user">
										<tr><td>${user.userId }</td></tr>
									</c:forEach>
								</table>
							</td>
							<td>
								<table>
									<c:forEach items="${list.users }" var="user">
										<tr><td>${user.userTel }</td></tr>
									</c:forEach>
								</table>
							</td>
							<td>${list.roomOrdersPrice}</td>
							
							<td><a
								href="roomType3?roomNum=${list.roomNum}&roomType=2&roomOrdersId=${list.roomOrdersId}"><button
										type="button">入住</button></a> <a
								href="roomType3?roomNum=${list.roomNum}&roomType=1&roomOrdersId=${list.roomOrdersId}"><button
										type="button">退订</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${roomOrders.isEmpty()}">
		<h3><span class="label label-danger">暂无被预定的房间</span></h3>
	</c:if>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function showLeftTime()
	{
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth()+1;//0-11月
	var day=now.getDate();
	var hours=now.getHours();
	if (hours<10) {
		hours="0"+hours;
	}
	var minutes=now.getMinutes();
	if (minutes<10) {
		minutes="0"+minutes;
	}
	var seconds=now.getSeconds();
	if (seconds<10) {
		seconds="0"+seconds;
	}
	document.all.show.innerHTML=""+year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds+"";
	//一秒刷新一次显示时间
	var timeID=setTimeout(showLeftTime,1000);
	}
	//-->
	</script>
</body>
</html>