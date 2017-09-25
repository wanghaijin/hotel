<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">


<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>主界面</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/iframe.css">

</head>
<body>

	<div style="widtu: 100%">

		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<span class="navbar-brand">爱尚宾馆</span>
				</div>
				<div class="collapse navbar-collapse">
					<ul id="mytab" class="nav  navbar-nav">
						<li class="active"><a href="javascript:void(0);"
							onclick="tab(this);" id="room">房间管理</a></li>
						<li><a onclick="tab(this);" id="goods">商品管理</a></li>
					</ul>

				</div>
			</div>
		</nav>
		<div>
			<iframe src="room" id="showTab" frameborder="no" border="0"
				marginwidth="0" marginheight=" 0" scrolling="no"
				allowtransparency="yes"></iframe>
		</div>

	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

	<script>
		$("#mytab  li").click(function(e) {
			e.preventDefault();
			$(this).tab("show");
		});
		function tab(obj) {
			var tab = document.getElementById("showTab");
			tab.src = obj.id;
		};
	</script>


</body>
</html>