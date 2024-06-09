<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="./css/login.css" />
</head>
<body>
	<div class="form-wrapper">
		<h1>Sign In</h1>
		<div class="error_msg">${msg}</div>
		<form action="/reference-java-web/login" method="post">
			<div class="form-item">
				<label for="email"></label> <input type="email" name="email"
					required="required" placeholder="email" value="${email}"></input>
			</div>
			<div class="form-item">
				<label for="password"></label> <input type="password"
					name="password" required="required" placeholder="Password" value="${password}"></input>
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="Sign In" value="Sign In"></input>
			</div>
		</form>
		<div class="form-footer">
			<p>
				<a href="register.jsp">Create an account</a>
			</p>
			<p>
				<a href="#">Forgot password?</a>
			</p>
		</div>
	</div>
</body>
</html>