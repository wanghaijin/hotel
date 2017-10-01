<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="resources/css/jquery-ui.min.css" rel="stylesheet">
<link href="resources/css/jquery-ui.theme.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/iframe.css" rel="stylesheet">
<link href="resources/css/jquery-ui-timepicker-addon.min.css"
	rel="stylesheet">
<title>账单页面</title>

</head>
<body>
	<div>
		<form class="form-horizontal col-md-8" action="goodsOrdersShow">

			<table class="table" id="user">
				<thead>
					<tr>
						<th>商品名称</th>
						<th>每页显示数据条数</th>
						<th>出售时间段</th>
					</tr>
				</thead>
				<tbody>
					<tr id="userAdd">
						<td class="col-xs-3">
							
							<select id="goodsName"
						name="goodsId" class="selectpicker form-control"
						data-live-search="true">
						<option value="">全部</option>
						<c:forEach items="${goods}" var="list">
						<c:if test="${list.goodsId == param.goodsId}">
							<option value="${list.goodsId}"  selected = "selected">${list.goodsName}</option>
						</c:if>
						<c:if test="${list.goodsId != param.goodsId}">
						<option value="${list.goodsId}">${list.goodsName}</option>
						</c:if>
						</c:forEach>
					</select>
							
							</td>
						<td class="col-xs-1"><input type="text"
							value="${param.pageSize}" class="form-control" name="pageSize"></td>
						<td class="col-xs-3"><input name="dateStart"
							value="${param.dateStart}" class="form-control" id="dateStart" />~
							<input name="dateEnd" value="${param.dateEnd}"
							class="form-control" id="dateEnd" /></td>
						<td class="col-xs-1"><label><button type="submit"
									class="form-control btn btn-primary">搜索</button></label></td>
					</tr>
				</tbody>
			</table>

		</form>
		<div>
			<div class="col-md-10 column">
				<c:if test="${!pagehelper.list.isEmpty() }">
					<!-- <button type="button" onclick="toExcel('table')">导出数据</button> -->
					<h4>
						共有<span class="label label-danger">${pagehelper.list.size() }</span>条数据
					</h4>
					<div id="table">
						<table class="table" id="goodsOrdersTable">
							<thead>
								<tr>
									<th>商品名字</th>
									<th>商品出售数量</th>
									<th>商品出售时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pagehelper.list}" var="list" varStatus="i">
									<tr>
										<td>${list.goods.goodsName}</td>
										<td>${list.goodsOrdersAmount}</td>
										<td>${list.goodsOrdersTime}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div>
							<%@include file="pagehelper.jsp"%>
						</div>
					</div>
				</c:if>
				<c:if test="${pagehelper.list.isEmpty() }">
					<h3>
						<span class="label label-danger">暂无商品订单数据</span>
					</h3>
				</c:if>
			</div>

		</div>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-ui.min.js"></script>
	<script src="resources/js/jquery-ui-timepicker-addon.min.js"></script>
	<script>
		$(document)
				.ready(
						function($) {

							$(function() {
								$.datepicker.regional['zh-CN'] = {
									changeMonth : true,
									changeYear : true,
									clearText : '清除',
									clearStatus : '清除已选日期',
									closeText : '关闭',
									closeStatus : '不改变当前选择',
									prevText : '<上月',
									prevStatus : '显示上月',
									prevBigText : '<<',
	            prevBigStatus: '显示上一年',
	            nextText: '下月>',
									nextStatus : '显示下月',
									nextBigText : '>>',
									nextBigStatus : '显示下一年',
									currentText : '今天',
									currentStatus : '显示本月',
									monthNames : [ '一月', '二月', '三月', '四月',
											'五月', '六月', '七月', '八月', '九月', '十月',
											'十一月', '十二月' ],
									monthNamesShort : [ '1', '2', '3', '4',
											'5', '6', '7', '8', '9', '10',
											'11', '12' ],
									monthStatus : '选择月份',
									yearStatus : '选择年份',
									weekHeader : '周',
									weekStatus : '年内周次',
									dayNames : [ '星期日', '星期一', '星期二', '星期三',
											'星期四', '星期五', '星期六' ],
									dayNamesShort : [ '周日', '周一', '周二', '周三',
											'周四', '周五', '周六' ],
									dayNamesMin : [ '日', '一', '二', '三', '四',
											'五', '六' ],
									dayStatus : '设置 DD 为一周起始',
									dateStatus : '选择 m月 d日, DD',
									dateFormat : 'yy-mm-dd',
									firstDay : 1,
									initStatus : '请选择日期',
									isRTL : false
								};

							});

							$(function() {
								$.datepicker
										.setDefaults($.datepicker.regional['zh-CN']);
								$("#dateStart")
										.prop("readonly", true)
										.datepicker(
												{
													changeMonth : true,
													dateFormat : "yy-mm-dd",
													onClose : function(
															selectedDate) {
														$("#dateEnd")
																.datepicker(
																		"option",
																		"minDate",
																		selectedDate);
													}
												});

								$("#dateEnd")
										.prop("readonly", true)
										.datepicker(
												{
													changeMonth : true,
													dateFormat : "yy-mm-dd",
													onClose : function(
															selectedDate) {
														$("#dateStart")
																.datepicker(
																		"option",
																		"maxDate",
																		selectedDate);
														$("#dateEnd").val(
																$(this).val());
													}
												});

							});
						}(jQuery));
		/* 导出Excel文件 */
		function toExcel(tableid) {

			var curTbl = document.getElementById(tableid);
			var oXL;
			try {
				oXL = new ActiveXObject("Excel.Application"); //创建AX对象excel  
			} catch (e) {
				alert("无法启动Excel!\n\n如果您确信您的电脑中已经安装了Excel并且您使用的是IE浏览器，"
						+ "那么请调整IE的安全级别。\n\n具体操作：\n\n"
						+ "工具 → Internet选项 → 安全 → 自定义级别 → 对没有标记为安全的ActiveX进行初始化和脚本运行 → 启用");
				return false;
			}
			var oWB = oXL.Workbooks.Add(); //获取workbook对象  
			var oSheet = oWB.ActiveSheet;//激活当前sheet  
			var sel = document.body.createTextRange();
			sel.collapse(true);
			sel.moveToElementText(curTbl); //把表格中的内容移到TextRange中  
			/*  sel.collapse(true); */
			sel.select(); //全选TextRange中内容  
			sel.execCommand("Copy");//复制TextRange中内容  
			oSheet.Paste();//粘贴到活动的EXCEL中  
			oXL.Visible = false; //设置excel可见属性  
			var fname = oXL.Application.GetSaveAsFilename("商品账单.xlsx",
					"Excel工作簿(*.xlsx), *.xlsx");
			oWB.SaveAs(fname);
			oWB.Close();
			oXL.Quit();
		}
	</script>
</body>
</html>