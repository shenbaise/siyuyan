<%@include file="top.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row-fluid">
	<!-- 左部 -->
	<div class="span2">
		<!-- ad -->
	</div>
	<!-- 中部 -->
	<div class="span8">
		<!-- 推荐影片 -->
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand">搜索结果</a>
			</div>
		</div>
		<c:forEach var="item" items="${film}" varStatus="i">
			<c:if test="${i.index % 4 == 0 }">
				<ul class="thumbnails">
			</c:if>
			<li class="span3">
				<div class="thumbnail hover_img">
					<img alt="300x200" src="${ctx}/static/simple.jpg"
						class="img-rounded">
					<div class="caption">
						${item.title }
						<p>
							<a class="btn btn-primary" href="${ctx }/play/${item.id }">播放</a>
						</p>
					</div>
				</div>
			</li>
			<c:if test="${(i.index+1) % 4 == 0 }">
				</ul>
			</c:if>
		</c:forEach>
		${pager }
	</div>

	<div class="span2">
		<!-- ad -->
	</div>
</div>
<%@include file="bottom.jsp"%>