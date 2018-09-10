<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<% String path = request.getContextPath();%>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
	<title>注册</title>
	<link rel="icon" href="<%=path %>/images/logo.jpg" type="image/x-icon">
	<link rel="stylesheet" href="<%=path %>/css/login.css">
	<link rel="stylesheet" href="<%=path %>/css/index.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-3.2.0.min.js"></script>
	<script src="<%=path %>/js/particles.js"></script>
	<script src="<%=path %>/js/app.js"></script>
	<script>
		var path = "<%=path %>";
	</script>
</head>

<body>
	<div id="particles"></div>
	<div class="form">
		<form name="loginForm" validate="validate" action="<%=path %>/RegisterServlet" method="post">		
			<table class="main-container">
				<tr>
					<td colspan="2">
						<h1 class="logo-big">知乎</h1>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<h2 class="subtitle">与世界分享你的知识、经验和见解</h2>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<div class="group-inputs">
							<input type="text" class="input-wrapper" id="username" name="username" placeholder="手机号或邮箱" required="required">
							<input type="password" class="input-wrapper border" id="password" name="password" placeholder="密码" required="required">
							<input type="password" class="input-wrapper border" id="confirmpassword" name="confirmpassword" placeholder="确认密码" required="required">
							<input type="text" class="input-wrapper border no-border-b" id="name" name="name" placeholder="姓名" required="required">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="sign" type="submit" value="注册知乎"/>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=path %>/page/login.jsp" class="nav-slider right-side">登录</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="nav-slider left-side" onclick="updatePassword()">修改密码</a>
					</td>
				</tr>
			</table>
		</form>
		<footer>
			<span>© 2017 知乎</span>
		</footer>
	</div>
	<div class="cover" id="cover"  onclick="hide()"></div>
	<div class="model-container">
		<div class="model">
			<div class="model-header">
				<h3>修改密码</h3>
			</div>
			<div class="model-body">
					<div class="group-inputs">
						<div class="form-group">
							<div class="col-3 text-r">
								<label for="account" class="mr-10">账号：</label>
							</div>
							<div class="col-6">
								<input type="text" class="form-console" id="account" placeholder="账号" required="required">
							</div>	
						</div>
						<div class="form-group">
							<div class="col-3 text-r">
								<label for="oldPassword" class="mr-10">原密码：</label>
							</div>
							<div class="col-6">
								<input type="password" class="form-console border" id="oldPassword" placeholder="原密码" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-3 text-r">
								<label for="newPassword" class="mr-10">新密码：</label>
							</div>
							<div class="col-6">
								<input type="password" class="form-console border" id="newPassword" placeholder="新密码" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-3 text-r">
								<label for="confirmPassword" class="mr-10">确认新密码：</label>
							</div>
							<div class="col-6">
								<input type="password" class="form-console border" id="confirmPassword" placeholder="确认新密码" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-6 col-offset-2">
								<button class="btn-confirm" onclick="doUpdatePassword()">确认修改</button>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>
			