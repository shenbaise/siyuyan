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
					<li><a href="${ctx }/category/${category}/${item2.key }">${item2.key }(${item2.value })</a>
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
				<a class="brand" href="${ctx }/category/${category}">${category}</a> <span class="brand">&gt;</span> <a class="brand" href="${ctx }/category/${category}/${type}">${type}</a>
			</div>
		</div>
		<c:forEach var="item" items="${film}" varStatus="i">
			<c:if test="${i.index % 4 == 0 }">
				<ul class="thumbnails">
			</c:if>
			<li class="span3">
				<div class="thumbnail hover_img">
					<a href="${ctx }/play/${item.id }"><img alt="300x200" src="${ctx}/${item.thumbnail}"
						class="img-rounded"></a>
					<div class="caption">
						<p>
							<a href="${ctx }/play/${item.id }">${item.title }</a>
						</p>
					</div>
				</div>
			</li>
			<c:if test="${(i.index+1) % 4 == 0 }">
				</ul>
			</c:if>
		</c:forEach>
		<div class="span10">
		${pager }
		</div>
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
				<li><a href="#">${item.name}</a></li>
			</c:forEach>
		</ol>
	</div>
</div>
<%@include file="bottom.jsp"%>