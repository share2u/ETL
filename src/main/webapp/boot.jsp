<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>图表编辑</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="email=no">
<meta name="applicable-device" content="mobile">
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<link rel="stylesheet" href="css/boot.css" type="text/css" />
</head>
<body class="no-skin">
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><span
					class="glyphicon glyphicon-menu-left" aria-hidden="true"></span></a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><p class="navbar-text">编辑图表</p></li>
				</ul>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="row" style="height: 550px;">
			<!--左侧  -->
			<div class="col-md-2" style="height: 100%">
				<div>
					<label for="form-field-select-3">工作表</label> <br /> <select
						class="chosen-select form-control" id="form-field-select-3"
						data-placeholder="选择一张工作表.">
						<option value=""></option>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
					</select>
				</div>
				<hr>
				<div class="dd" id="nestable">
					<label>字段</label> <br />
					<ol class="dd-list">
						<li class="dd-item" data-id="1">
							<div class="dd-handle">
								员工姓名 <i
									class="pull-right bigger-130 ace-icon fa fa-exclamation-triangle orange2"></i>
							</div>
						</li>
						<li class="dd-item" data-id="11">
							<div class="dd-handle">
								工作时长 <span class="sticker"> <span
									class="label label-success arrowed-in"> <i
										class="ace-icon fa fa-check bigger-110"></i>
								</span>
								</span>
							</div>
						</li>
						<li class="dd-item" data-id="12">
							<div class="dd-handle">薪资</div>
						</li>
						<li class="dd-item" data-id="12">
							<div class="dd-handle">薪资</div>
						</li>
						<li class="dd-item" data-id="12">
							<div class="dd-handle">薪资</div>
						</li>
					</ol>
				</div>
			</div>
			<!--中侧  -->
			<div class="col-md-8" style="height: 100%">
				<!--中上维度  -->
				<div class="row">
					<div class="col-md-1">
						<label>维度</label>
					</div>
					<div class="col-md-11" id="weidus">
						<ol class="dd-list">
							<li class="dd-item" data-id="12">
								<div class="dd-handle">薪资</div>
							</li>
							<li class="dd-item" data-id="12">
								<div class="dd-handle">薪资</div>
							</li>
						</ol>
					</div>
				</div>
				<!--中上 数值 -->
				<div class="row">
					<div class="col-md-1">
						<label>度量</label>
					</div>
					<div class="col-md-11 " id="duliangs">
						<ol class="dd-list">
							<li class="dd-item" data-id="12">
								<div class="dd-handle">
									薪资
									<div class="pull-right action-buttons">
										<a class="blue" href="#"> <i
											class="ace-icon fa fa-cog bigger-130"></i>
										</a> <a class="red" href="#"> <i
											class="ace-icon fa fa-trash-o bigger-130"></i>
										</a>
									</div>
								</div>
							</li>
							<li class="dd-item" data-id="12">
								<div class="dd-handle">
									薪资
									<div class="pull-right action-buttons">
										<a class="blue" href="#"> <i
											class="ace-icon fa fa-cog bigger-130"></i>
										</a> <a class="red" href="#"> <i
											class="ace-icon fa fa-trash-o bigger-130"></i>
										</a>
									</div>
								</div>
							</li>
						</ol>
					</div>
				</div>
				<!--中下 -->
				<div class="row" style="height: 100%">
					<!-- <div class="col-md-2" style="height: 100%">
						<h5>筛选器</h5>
						<ul>
							<li>xx</li>
							<li>xx</li>
							<li>xx</li>
							<li>xx</li>
						</ul>
					</div> -->
					<div class="col-md-12" style="background-color: white; height: 90%">
						<div class="widget-box">
							<div class="widget-header widget-header-flat widget-header-small">
								<h5 class="widget-title">
									<i class="ace-icon fa fa-signal"></i> Traffic Sources
								</h5>

								<div class="widget-toolbar no-border">
									<div class="inline dropdown-hover">
										<button class="btn btn-minier btn-primary">
											This Week <i
												class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
										</button>

										<ul
											class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
											<li class="active"><a href="#" class="blue"> <i
													class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i>
													This Week
											</a></li>

											<li><a href="#"> <i
													class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
													Last Week
											</a></li>

											<li><a href="#"> <i
													class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
													This Month
											</a></li>

											<li><a href="#"> <i
													class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
													Last Month
											</a></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div id="piechart-placeholder"></div>

									<div class="hr hr8 hr-double"></div>

									<div class="clearfix">
										<div class="grid3">
											<span class="grey"> <i
												class="ace-icon fa fa-facebook-square fa-2x blue"></i>
												&nbsp; likes
											</span>
											<h4 class="bigger pull-right">1,255</h4>
										</div>

										<div class="grid3">
											<span class="grey"> <i
												class="ace-icon fa fa-twitter-square fa-2x purple"></i>
												&nbsp; tweets
											</span>
											<h4 class="bigger pull-right">941</h4>
										</div>

										<div class="grid3">
											<span class="grey"> <i
												class="ace-icon fa fa-pinterest-square fa-2x red"></i>
												&nbsp; pins
											</span>
											<h4 class="bigger pull-right">1,050</h4>
										</div>
									</div>
								</div>
								<!-- /.widget-main -->
							</div>
							<!-- /.widget-body -->
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧  -->
			<div class="col-md-2" style="background-color: #e5e5e5; height: 100%">

				<div>
					<div class="widget-body">
						<div class="widget-main">
							<div>
								<label for="form-field-8">图表标题</label> <input type="text"
									id="form-field-8" placeholder="默认的标题"></input>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-12 widget-box">
					<div class="widget-header">
						<h4 class="widget-title">图表类型</h4>

						<div class="widget-toolbar">
							<a href="#" data-action="collapse"> <i
								class="ace-icon fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<tbody>
									<tr>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
										<td class="hidden-sm hidden-xs ">
											<button class="btn btn-xs btn-success">
												<i class="ace-icon fa fa-check bigger-120"></i>
											</button>
										</td>
									</tr>

								</tbody>
							</table>


							<hr />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>
	<script src="assets/js/jquery.sparkline.index.min.js"></script>
	<script src="assets/js/jquery.flot.min.js"></script>
	<script src="assets/js/jquery.flot.pie.min.js"></script>
	<script src="assets/js/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script type="text/javascript">
		$(function() {
			 var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'350px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			
			
			
			
			$("#names > li").draggable({
				helper : "clone"
			});
			$("#weidusinfo").draggable();
			$("#weidus")
					.droppable(
							{
								drop : function(event, ui) {
									$(this).find("#weidusinfo").remove();
									$(
											"<button type=\"button\" class=\"btn btn-primary ui-widget-content\" data-toggle=\"button\"></button>")
											.text(ui.draggable.text())
											.appendTo(this);
								}
							});
			$("#duliangs")
					.droppable(
							{
								drop : function(event, ui) {
									$(this).find("#duliangsinfo").remove();
									$(
											"<button type=\"button\" class=\"btn btn-primary ui-widget-content\" data-toggle=\"button\"></button>")
											.text(ui.draggable.text())
											.appendTo(this);
								}
							});

		});
	</script>
</body>
</html>