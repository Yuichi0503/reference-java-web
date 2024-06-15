<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
	<meta charset="UTF-8">
	<title>登録画面</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/signup.css" />
	<link rel="stylesheet" href="./css/allFile.css" />
</head>
<body>


	<form action="/reference-java-web/signup" method="post">
		<h2>Sign Up</h2>
		<c:if test="${msg != null}">
			<div class="alert alert-info mt-2 text-center">${msg}</div>
		</c:if>
		<p>
			<label for="user_name" class="floatLabel">ユーザー名</label> <input id="user_name"
				name="user_name" type="text" required>
		</p>
		<p>
			<label for="email" class="floatLabel">メールアドレス</label> <input id="email"
				name="email" type="email" required>
		</p>
		<p>
			<label for="password" class="floatLabel">パスワード</label> <input
				id="password" name="password" type="password" required> <span>Enter
				a password longer than 8 characters</span>
		</p>
		<p>
			<label for="confirm_password" class="floatLabel">パスワード再入力</label> <input id="confirm_password" name="confirm_password"
				type="password" required> <span>Your passwords do not match</span>
		</p>
		<p>
			<input type="submit" value="Create My Account" id="submit">
		</p>
	</form>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="./js/register.js"></script>
</body>
</html>