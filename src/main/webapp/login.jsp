<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="./css/login.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/allFile.css" />
</head>
<body>
	<div class="container">
		<div class="form-wrapper">
			<h1>Sign In</h1>
			<div class="alert alert-info mt-5 text-center">${msg}</div>
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
					<a href="signup.jsp">Create an account</a>
				</p>
				<p>
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>