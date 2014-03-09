<%@include file="top.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" language="javascript"> 
function iFrameHeight() { 
	var ifm= document.getElementById("iframepage"); 
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument; 
	if(ifm != null && subWeb != null) { 
		ifm.height = subWeb.body.scrollHeight; 
	} 
} 
</script>
<title>死鱼眼，播放 ${movie.title }</title>
</head>
<body>
	<div class="row-fluid">
		<!-- 左部 -->
		<div class="span2">
			<ul class="nav nav-list well">
				<!-- 相关推荐 -->
			</ul>

			<div class="media">
				<a href="#" class="pull-left"><img
					src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
				<div class="media-body">
					<h4 class="media-heading">Nested media heading</h4>
					Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
					scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum
					in vulputate at, tempus viverra turpis.
				</div>
			</div>
		</div>
		<!-- 中部 -->
		<div class="span8">
			<!-- 推荐影片 -->
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="brand">正在为您播放 [${movie.title }]</a>
						<iframe src="${play_url }" id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="100%" height="400px" onLoad="iFrameHeight()" ></iframe> 
					</div>
				</div>
			</div>
			<!-- 播放 || 下载 -->
			


		</div>

		<!-- 右部 -->
		<div class="span2">
			<span class="label label-success">Label</span> <span
				class="badge badge-success">1</span>
			<ul class="breadcrumb">
				<li><a href="#">Home</a> <span class="divider">/</span></li>
				<li><a href="#">Library</a> <span class="divider">/</span></li>
				<li class="active">Data</li>
			</ul>
		</div>
	</div>
	<%@include file="bottom.jsp"%>