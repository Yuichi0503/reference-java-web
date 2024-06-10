<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
	<meta charset="UTF-8">
	<title>登録画面</title>
	<link rel="stylesheet" href="./css/signup.css" />
</head>
<body>


	<form action="/reference-java-web/signup" method="post">
		<h2>Sign Up</h2>
		<div class="error_msg">${msg}</div>
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

	<script src="./js/register.js"></script>
</body>
</html>