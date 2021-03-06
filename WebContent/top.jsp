<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="not-ie" lang="en">
<!--<![endif]-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<meta charset="utf-8">
<title>死鱼眼，最优雅的电影休闲站!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="死鱼眼是一个以各类视频为主的休闲娱乐网站，这里有最新的电影资源，最好的观影体验。最新最热的电影、电视剧尽在死鱼眼电影网！">
<meta name="author" content="死鱼眼电影网站由深白色制作">

<!--link rel="stylesheet/less" href="${ctx }/less/bootstrap.less" type="text/css" /-->
<!--link rel="stylesheet/less" href="${ctx }/less/responsive.less" type="text/css" /-->
<!--script src="${ctx }/js/less-1.3.3.min.js"></script-->
<!--append ‘#!watch’ to the browser URL, then refresh the page. -->

<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${ctx }/css/style.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${ctx }/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${ctx }/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${ctx }/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${ctx }/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="${ctx }/img/favicon.png">

<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx }/js/scripts.js"></script>
<link
	href="//cdnjs.bootcss.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<script type="text/javascript">
	function onLiClick(item){
		item = $(item);
		item.attr("class", "active");
	}
</script>
</head>

<body>
	<div class="container">

		<!-- top bar -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<div class="container">
					<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
						class="btn btn-navbar"><span class="icon-bar"></span><span
						class="icon-bar"></span><span class="icon-bar"></span></a> <a
						href="www.siyuyan.com" class="brand">死鱼眼</a>
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav">
							<li><a class="bootstro" href="${ctx }/">主页</a></li>
							<li><a class="bootstro" href="${ctx }/category/电影">电影</a></li>
							<li><a href="${ctx }/category/电视剧">电视剧</a></li>
							<li><a href="${ctx }/category/综艺">综艺</a></li>
							<li><a href="${ctx }/category/音乐">音乐</a></li>
							<li><a href="${ctx }/category/动漫">动漫</a></li>
							<li><a href="${ctx }/new">最新</a></li>
							<li><a href="${ctx }/hot">热门</a></li>
							<li class="divider-vertical">
								<div class="pull-left">
									<div class="input-append">
										<form class="navbar-search form-inline" action="${ctx }/s">
											<input class="span2" name="wd" type="text" value="${wd }" />
											<button type="submit" class="btn btn-primary">
												<i class="icon-search">搜</i>
											</button>
										</form>
									</div>
								</div>
						</ul>

						<c:if test="${sessionScope.userSession==null }">
							<ul class="nav pull-right">
								<li><a href="${ctx }/login">登录</a></li>
								<li class="divider">
								<li><a href="${ctx }/register">注册</a></li>
							</ul>
						</c:if>

						<c:if test="${sessionScope.userSession!=null }">
							<ul class="nav pull-right">
								<div class="btn-group navbar-inverse">
									<button class='btn' type='submit'>${sessionScope.userSession.username }</button>
									<button class="btn dropdown-toggle" type='submit'
										data-toggle="dropdown">
										<span class='caret'></span>
									</button>
									<ul class='dropdown-menu'>
										<li><a href="#">个人资料</a></li>
										<li><a href="#">个人收藏</a></li>
										<li><a href="#">观看记录</a></li>
										<li class="divider"></li>
										<li><a href="logout">注销</a></li>
									</ul>
								</div>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<!-- end of top bar -->