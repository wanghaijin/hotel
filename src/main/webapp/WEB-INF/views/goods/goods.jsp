<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">

<title>房间管理界面</title>

</head>
<body>
<div style="widtu:100%">
	<div id="main-container">
		<div id="sidebar" class="col-md-2 column">
			<ul class="nav nav-pills nav-stacked" id="mytab">
				<li class="active"><a href="javascript:void(0);" onclick="tab(this);" id="goodsOrders">账单添加</a></li>
				<li class=""><a href="javascript:void(0);" onclick="tab(this);" id="goodsOrdersShow">账单显示</a></li>
			</ul>
		</div>
		<div class="col-md-10 column">
			<iframe id="showTab" src="goodsOrders"  frameborder="no" border="0" marginwidth="0"
				marginheight=" 0"  allowtransparency="yes"></iframe>
		</div>
	
	</div>
</div>


<script  src="resources/js/jquery.min.js"></script>
<script  src="resources/js/bootstrap.min.js"></script>

 <script>
$("#mytab  li").click(function(e) {
	e.preventDefault();
	$(this).tab("show");
});
function tab(obj) {
    var tab=document.getElementById("showTab");
    tab.src=obj.id;
};
</script> 

</body>
</html>