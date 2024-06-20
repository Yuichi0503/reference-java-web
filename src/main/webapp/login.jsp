<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="./css/login.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/allFile.css" />
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<div class="container">
		<div class="form-wrapper">
			<h1 style="color:#666666">Login</h1>
			<c:if test="${msg != null}">
				<div class="alert alert-info mt-2 text-center">${msg}</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/login" method="post">
				<div class="form-item">
					<label for="email"></label> <input type="email" name="email"
						required="required" placeholder="email" value="${email}"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="password"
						name="password" required="required" placeholder="Password" value="${password}"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" value="login"></input>
				</div>
			</form>
			<div class="form-footer">
				<p>
					<a href="signup.jsp">Create an account</a>
				</p>
				<p>
					<a href="forgot_password.jsp">Forgot password?</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>