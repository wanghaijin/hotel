<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">

<title>空闲房间管理界面</title>
</head>
<body>

	<div>
		<c:if test="${!rooms.isEmpty()}">

			<c:if test="${!string.equals('')}">
				<h3>
					<span class="label label-success">${string}</span>
				</h3>
			</c:if>
			<form class="form-horizontal col-md-8" action="roomType1">
				<div class="form-group">
					<label for="roomNum"> 房间编号 </label> <select id="roomNum"
						name="roomNum" class="selectpicker form-control"
						data-live-search="true" required="required">
						<c:forEach items="${rooms}" var="list">
							<option value="${list.roomNum}">${list.roomNum}${list.roomSize.sizeName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="user"> 客人信息: </label>
					<table class="table" id="user">
						<thead>
							<tr>
								<th>姓名</th>
								<th>身份证</th>
								<th>电话</th>
								<th>民族</th>
								<th>年龄</th>
								<th>性别</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr id="userAdd">
								<td class="col-xs-2"><input class="form-control" placeholder="输入用户姓名" type="text" name="userName" required="required"></td>
								<td class="col-xs-3"><input class="form-control" type="text" placeholder="输入用户身份证" required="required" name="userId" id="userId" onblur="getAgeAndSex(this)"></td>
								<td class="col-xs-3"><input class="form-control" type="text" placeholder="输入用户电话号码" required="required" name="userTel" id="userTel"></td>
								<td class="col-xs-1"><input class="form-control" type="text" name="userNation" ></td>
								<td class="col-xs-1"><input class="form-control" type="number" name="userAge" id="userIdAge"></td>
								<td class="col-xs-1"><input class="form-control" type="text" name="userSex" id="userIdSex" ></td>
								<td class="col-xs-1"><button class="form-control btn btn-primary" type="button" id="addform">添加客人</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="form-group">
					<label for="roomPrice"> 房间单价 </label> 
					<input type="number" class="form-control" required="required" name="roomPrice">
					<label for="roomOrdersPrice">房间押金</label>
					<input type="number" class="form-control" required="required" name="roomOrdersPrice">
				</div>
				<div class="form-group">
					<label><input class="form-control" type="radio" name="ordersType" id="ordersType" value="02" checked="checked">入住</label>
					<label><input class="form-control" type="radio" name="ordersType" id="ordersType" value="03">预定</label>
				</div>
				<div class="form-group">
					<button type="submit" class="form-control btn btn-primary">提交订单</button>
				</div>

			</form>

		</c:if>
		<c:if test="${rooms.isEmpty()}">
			<h3>
				<span class="label label-danger">暂无空闲房间</span>
			</h3>
		</c:if>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
    var i=0;
    $("#addform").click(function(){
        //添加的内容
        i++;
        var tr='<tr id="userAdd'+i+'"">';
        
		var userName=' <td class="col-xs-2"><input class="form-control" required="required" type="text" name="userName"></td>';
		var userId='<td class="col-xs-3"><input class="form-control" required="required" type="text" name="userId" id="userId'+i+'" onblur="getAgeAndSex(this)"></td>';
		var userTel='<td class="col-xs-3"><input class="form-control" type="text" name="userTel" id="userTel"></td>';
		var userNation='<td class="col-xs-1"><input class="form-control" type="text" name="userNation" ></td>';
		var userAge='<td class="col-xs-1"><input class="form-control" type="number" name="userAge" id="userId'+i+'Age"></td>';
		var userSex='<td class="col-xs-1"><input class="form-control" type="text" name="userSex" id="userId'+i+'Sex" ></td>';

        var button='<td><button type="button" class="btn btn-primary" id="removeform" onclick="deleteRow(userAdd'+i+') ">删除</button></td>';
        var addform = tr+userName+userId+userTel+userNation+userAge+userSex+button+'</tr>'
        $("#userAdd").after($(addform));
    });

    //删除添加的表单
    function deleteRow(userAdd) {
        $(userAdd).remove();
    }

    function getAgeAndSex(obj) {
        var id=document.getElementById(obj.id);
        var iIdNo=id.valueOf().value;
        var tmpStr = "";
        var sex="";
        var myDate = new Date();
        var month = myDate.getMonth() + 1;
        var day = myDate.getDate();
		var isGetTure=false;
        var age = myDate.getFullYear() - iIdNo.substring(6, 10) - 1;
        if (iIdNo.substring(10, 12) < month || iIdNo.substring(10, 12) == month && iIdNo.substring(12, 14) <= day) {
            age++;
        }
        iIdNo = $.trim(iIdNo);
        if(iIdNo.length == 15){
        	isGetTure=true;
            sex = parseInt(iIdNo.substring(14, 1),10) % 2 ? "男" : "女";
        }else if(iIdNo.length == 18){
        	isGetTure=true;
            sex = parseInt(iIdNo.substring(17, 1),10) % 2 ? "男" : "女";
        }else{
        	isGetTure=false;
        }
       
        if(isGetTure){
        	var userAge=obj.id+"Age";
            var userSex=obj.id+"Sex";
            document.getElementById(userAge).value=age;
            document.getElementById(userSex).value=sex;
            $("#"+userAge).attr("disabled","disabled");
            $("#"+userSex).attr("disabled","disabled");
        }
        
    }
	</script>
</body>
</html>