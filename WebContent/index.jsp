<!DOCTYPE html>
<html lang="zh">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
  <meta charset="utf-8">
  <title>死鱼眼，最优雅的电影休闲站!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="死鱼眼是一个以各类视频为主的休闲娱乐网站，这里有最新的电影资源，最好的观影体验。最新最热的电影、电视剧尽在死鱼眼电影网！">
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
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx }/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx }/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx }/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="${ctx }/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="${ctx }/img/favicon.png">
  
	<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/scripts.js"></script>
</head>

<body>
<div class="container-fluid">
	<!-- top bar -->
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="container-fluid">
				 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="www.siyuyan.com" class="brand">死鱼眼</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">
					<ul class="nav">
						<li class="active">
							<a href="#">主页</a>
						</li>
						<li>
							<a href="#">电影</a>
						</li>
						<li>
							<a href="#">电视剧</a>
						</li>
						<li>
							<a href="#">综艺</a>
						</li>
						<li>
							<a href="#">音乐</a>
						</li>
						<li>
							<a href="#">动漫</a>
						</li>
						<li>
							<a href="#">最新</a>
						</li>
						<li class="divider-vertical">
						<li>
							<div class="input-append">
							<form class="navbar-search form-inline">
								<input class="span3" type="text" /> <button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i></button>
							</form>
							</div>
						</li>
						
						<li>
							<a href="#"><span class="badge badge-info">接上次播放</span></a>
						</li>
					</ul>
					
					<ul class="nav pull-right">
						<li>
							<a href="#">右边链接</a>
						</li>
						<li class="divider-vertical">
						</li>
						<li class="dropdown">
							 <a data-toggle="dropdown" class="dropdown-toggle" href="#">shenbaise<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">个人资料</a>
								</li>
								<li>
									<a href="#">个人收藏</a>
								</li>
								<li>
									<a href="#">观看记录</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#logout">注销</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
	<!-- end of top bar -->
			
	<div class="row-fluid">
		<div class="span3">
			<ul class="nav nav-list well">
				<li class="nav-header">
					${catgoryName }
				</li>
				<c:forEach var="item" items="${facet}"> 
					<li>
						<a href="#">${item.key }(${item.value })</a>
					</li>
				</c:forEach>
				<li class="active">
					<a href="#">Home</a>
				</li>
				<li>
					<a href="#">Library</a>
				</li>
				<li>
					<a href="#">Applications</a>
				</li>
				<li class="nav-header">
					Another list header
				</li>
				<li>
					<a href="#">Profile</a>
				</li>
				<li>
					<a href="#">Settings</a>
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="#">Help</a>
				</li>
			</ul>
			<div class="media">
				 <a href="#" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
				<div class="media-body">
					<h4 class="media-heading">
						Nested media heading
					</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
				</div>
			</div>
		</div>
		<div class="span7">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">Title</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active">
									<a href="#">Home</a>
								</li>
								<li>
									<a href="#">Link</a>
								</li>
								<li>
									<a href="#">Link</a>
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">Action</a>
										</li>
										<li>
											<a href="#">Another action</a>
										</li>
										<li>
											<a href="#">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li class="nav-header">
											Nav header
										</li>
										<li>
											<a href="#">Separated link</a>
										</li>
										<li>
											<a href="#">One more separated link</a>
										</li>
									</ul>
								</li>
							</ul>
							<ul class="nav pull-right">
								<li>
									<a href="#">Link</a>
								</li>
								<li class="divider-vertical">
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">Action</a>
										</li>
										<li>
											<a href="#">Another action</a>
										</li>
										<li>
											<a href="#">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">Separated link</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
			<form class="form-search form-inline">
				<input type="text" class="input-medium search-query"> <button type="submit" class="btn">Search</button>
			</form>
			<div class="carousel slide" id="carousel-293745">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-293745">
					</li>
					<li data-slide-to="1" data-target="#carousel-293745">
					</li>
					<li data-slide-to="2" data-target="#carousel-293745" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="http://lorempixel.com/1600/500/sports/1">
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="http://lorempixel.com/1600/500/sports/2">
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="http://lorempixel.com/1600/500/sports/3">
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-293745" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-293745" class="right carousel-control">›</a>
			</div>
			<ul class="thumbnails">
				<li class="span4">
					<div class="thumbnail">
						<img alt="300x200" src="http://lorempixel.com/600/200/people">
						<div class="caption">
							<h3>
								Thumbnail label
							</h3>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								<a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div class="thumbnail">
						<img alt="300x200" src="http://lorempixel.com/600/200/city">
						<div class="caption">
							<h3>
								Thumbnail label
							</h3>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								<a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div class="thumbnail">
						<img alt="300x200" src="http://lorempixel.com/600/200/sports">
						<div class="caption">
							<h3>
								Thumbnail label
							</h3>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
							<p>
								<a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Product
						</th>
						<th>
							Payment Taken
						</th>
						<th>
							Status
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination pagination-centered pagination-large">
				<ul>
					<li>
						<a href="#">Prev</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">Next</a>
					</li>
				</ul>
			</div>
			<div class="media">
				 <a href="#" class="pull-left"><img src="http://lorempixel.com/64/64/" class="media-object" alt=""></a>
				<div class="media-body">
					<h4 class="media-heading">
						Nested media heading
					</h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
				</div>
			</div>
		</div>
		<div class="span2">
			 <span class="label label-success">Label</span> <span class="badge badge-success">1</span>
			<ul class="breadcrumb">
				<li>
					<a href="#">Home</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="#">Library</a> <span class="divider">/</span>
				</li>
				<li class="active">
					Data
				</li>
			</ul>
			<div class="accordion" id="accordion-702944">
				<div class="accordion-group">
					<div class="accordion-heading">
						 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-702944" href="#accordion-element-423475">Collapsible Group Item #1</a>
					</div>
					<div id="accordion-element-423475" class="accordion-body in collapse">
						<div class="accordion-inner">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-702944" href="#accordion-element-726162">Collapsible Group Item #2</a>
					</div>
					<div id="accordion-element-726162" class="accordion-body collapse">
						<div class="accordion-inner">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
			</div>
			<div class="accordion" id="accordion-132568">
				<div class="accordion-group">
					<div class="accordion-heading">
						 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-132568" href="#accordion-element-436578">Collapsible Group Item #1</a>
					</div>
					<div id="accordion-element-436578" class="accordion-body collapse in">
						<div class="accordion-inner">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-132568" href="#accordion-element-7129">Collapsible Group Item #2</a>
					</div>
					<div id="accordion-element-7129" class="accordion-body collapse">
						<div class="accordion-inner">
							Anim pariatur cliche...
						</div>
					</div>
				</div>
			</div>
			<ol>
				<li>
					Lorem ipsum dolor sit amet
				</li>
				<li>
					Consectetur adipiscing elit
				</li>
				<li>
					Integer molestie lorem at massa
				</li>
				<li>
					Facilisis in pretium nisl aliquet
				</li>
				<li>
					Nulla volutpat aliquam velit
				</li>
				<li>
					Faucibus porta lacus fringilla vel
				</li>
				<li>
					Aenean sit amet erat nunc
				</li>
				<li>
					Eget porttitor lorem
				</li>
			</ol>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			 <address> <strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br> San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123) 456-7890</address>
		</div>
	</div>
</div>
</body>
</html>
