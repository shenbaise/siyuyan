<%@include file="top.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row-fluid">
	<!-- 左部 -->
	<div class="span2">
		<ul class="nav nav-list well">
			<li class="nav-header">${catgoryName }</li>
			<c:forEach var="item" items="${facet}">
				<c:forEach var="item2" items="${item}">
					<li><a href="category/${item2.key }">${item2.key }(${item2.value })</a>
					</li>
				</c:forEach>
			</c:forEach>
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
					<a href="#" class="brand">热门电影</a>
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav pull-right">
							<li class="divider-vertical" />
							<li><a href="#">更多</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<ul class="thumbnails">
			<c:forEach var="item" items="${film}">
				<li class="span4">
					<div class="thumbnail">
						<a href="${ctx }/play/${item.id }"><img class="img-responsive" alt="Responsive image"  src="${item.thumbnail }" class="img-rounded" 
						onerror="javascript:this.src='${ctx }/static/simple.jpg'"></a>
						<div class="caption">
							<a href="${ctx }/play/${item.id }">${item.title }</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<div class="navbar">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="#" class="brand">热门电视剧</a>
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav pull-right">
							<li class="divider-vertical" />
							<li><a href="#">更多</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<ul class="thumbnails">
			<c:forEach var="item" items="${tv}">
				<li class="span4">
					<div class="thumbnail">
						<a href="${ctx }/play/${item.id }"><img alt="200x200" src="${item.thumbnail }" 
						onerror="javascript:this.src='${ctx }/static/simple.jpg'"></a>
						<div class="caption">
							<a href="${ctx }/play/${item.id }">${item.title }</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<div class="navbar">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="#" class="brand">热门综艺节目</a>
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav pull-right">
							<li class="divider-vertical" />
							<li><a href="#">更多</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<ul class="thumbnails">
			<c:forEach var="item" items="${zy}">
				<li class="span4">
					<div class="thumbnail">
						<a href="${ctx }/play/${item.id }"><img alt="200x200" src="${item.thumbnail }" onerror="javascript:this.src='${ctx }/static/simple.jpg'"></a>
						<div class="caption">
							<a href="${ctx }/play/${item.id }">${item.title }</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
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
		<!-- 10个最新电影 -->
		<ol>
			<c:forEach var="item" items="${newFilm}">
				<li><a href="#">${item.title}</a></li>
			</c:forEach>
		</ol>
	</div>
</div>
<!-- BEGIN CORE PLUGINS -->
<script src="${ctx}/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ctx}/js/jquery-ui-1.10.1.custom.min.js"
	type="text/javascript"></script>
<script src="${ctx}/js/bootstrap.min.js" type="text/javascript"></script>
<!--[if lt IE 9]>
	<script src="${ctx}/js/excanvas.min.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>  
	<![endif]-->
<script src="${ctx}/js/jquery.blockui.min.js" type="text/javascript"></script>
<%@include file="bottom.jsp"%>