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
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	height: 100%;
}

body {
	overflow: auto;
}

.title {
	width: 100%;
	height: 15%;
	background: aqua;
}

.content {
	width: 100%;
	height: 85%;
	background: salmon;
}

.left {
	float: left;
	width: 15%;
	height: 100%;
	background: darkcyan;
}

.left-top {
	width: 100%;
	height: 20%;
	background: fuchsia;
}
.left-middle {
	width: 100%;
	height: 80%;
	background: chartreuse;
}

.middle {
	float: left;
	width: 60%;
	height: 100%;
	background: firebrick;
}

.middle-top {
	width: 100%;
	height: 20%;
	background: ghostwhite;
}

.middle-content {
	width: 100%;
	height: 80%;
	background: hotpink;
}

.middle-content-left {
	float: left;
	width: 20%;
	height: 100%;
	background: bisque;
}

.middle-content-right {
	float: left;
	width: 80%;
	height: 100%;
	background: chartreuse;
}

.right {
	float: left;
	width: 25%;
	height: 100%;
	background: darkgreen;
}

.right-top {
	width: 100%;
	height: 20%;
	background: navajowhite;
}

.right-middle {
	width: 100%;
	height: 60%;
	background: tomato;
}

.right-bottom {
	width: 100%;
	height: 20%;
	background: lavender;
}
</style>

</head>

<body>
	<!--顶部导航-->
	<div class="title">
		<div style="float:left;width: 10%;height: 100%;position: relative;"><img  style="width: 30%;height: 40%;position: absolute;left: 50%;top:50%;transform:translate(-50%,-50%);"src="/images/fanhui.png"></div>
		<div style="float:left; width: 90%;height: 100%;position: relative;">
				<h3>编辑图表</h3>
		</div>
	</div>
	<!--内容编辑-->
	<div class="content">
		<!--左边区域-->
		<div class="left">
			<div class="left-top"></div>
			<div class="left-middle"></div>
		</div>
		<!--中间区域-->
		<div class="middle">
			<div class="middle-top"></div>
			<div class="middle-content">
				<div class="middle-content-left"></div>
				<div class="middle-content-right"></div>
			</div>
		</div>
		<!--右边区域-->
		<div class="right">
			<div class="right-top"></div>
			<div class="right-middle"></div>
			<div class="right-bottom"></div>
		</div>
	</div>
</body>
</html>