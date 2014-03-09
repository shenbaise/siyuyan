<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tag.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<title>死鱼眼电影网 |用户登录</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="死鱼眼电影网，小清新的电影网站，为您推荐最新，最热的电影资源。" />
<meta content="" name="深白色" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/default.css" rel="stylesheet" type="text/css"
	id="style_color" />
<link href="${ctx}/css/uniform.default.css" rel="stylesheet"
	type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${ctx}/css/login-soft.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<link rel="icon" href="${ctx}/image/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${ctx}/image/favicon.ico"
	type="image/x-icon" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="${ctx}/image/fish.png" alt="" />
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="dologin" method="post">
			<h3 class="form-title">登录</h3>
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
				<span>输入用户名和密码.</span>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户账号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i> <input class="m-wrap placeholder-no-fix"
							type="text" placeholder="输入注册的email地址" name="email" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">账号密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix"
							type="password" placeholder="输入用户密码" name="password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox"> <input type="checkbox"
					name="rememberMe" value="1" />以后自动登录
				</label>
				<button type="submit" class="btn blue pull-right">
					登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>
				<c:if test="${msg!=null }">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert"></button>
						<span>${msg }.</span>
					</div>
				</c:if>
			</div>
			<div class="forget-password">
				<h4>忘记密码了 ?</h4>
				<p>
					别担心,点击 <a href="javascript:;" class="" id="forget-password">这里</a>
					找回你的密码.
				</p>
			</div>
			<div class="create-account">
				<p>还没有死鱼眼的账号吗？&nbsp;
				<h3>
					<a href="javascript:;" id="register-btn" class="">快速创建账号</a>
				</h3>
				</p>
			</div>
		</form>
		<!-- END LOGIN FORM -->
		<!-- BEGIN FORGOT PASSWORD FORM -->
		<form class="form-vertical forget-form" action="doresetpasswd"
			method="post">
			<h3 class="">忘记密码了 ?</h3>
			<p>输入您注册是留下的email地址重置您的密码.</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i> <input
							class="m-wrap placeholder-no-fix" type="text" placeholder="电子邮箱"
							name="email" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
					<i class="m-icon-swapleft"></i> 返回
				</button>
				<button type="submit" class="btn blue pull-right">
					提交 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END FORGOT PASSWORD FORM -->
		<!-- BEGIN REGISTRATION FORM -->
		<form class="form-vertical register-form" action="doregister"
			method="post">
			<h3 class="">创建账户</h3>
			<p>请您填写以下信息:</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i> <input class="m-wrap placeholder-no-fix"
							type="text" placeholder="用户名" name="username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix"
							type="password" id="register_password" placeholder="密码"
							name="password" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">电子邮箱</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i> <input
							class="m-wrap placeholder-no-fix" type="text" placeholder="电子邮箱"
							name="email" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox" name="tnc" />
						我同意 <a href="#">服务与免责条款</a>
					</label>
					<div id="register_tnc_error"></div>
				</div>
			</div>
			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
					<i class="m-icon-swapleft"></i> 退后
				</button>
				<button type="submit" id="register-submit-btn"
					class="btn blue pull-right">
					注册 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END REGISTRATION FORM -->
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2013 &copy; 死鱼眼</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="${ctx}/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${ctx}/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="${ctx}/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="${ctx}/js/excanvas.min.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>  
	<![endif]-->
	<script src="${ctx}/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.blockui.min.js" type="text/javascript"></script>

	<script src="${ctx}/js/jquery.uniform.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${ctx}/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery.backstretch.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctx}/js/app.js" type="text/javascript"></script>
	<script src="${ctx}/js/login-soft.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
	<!-- END BODY -->
</html>