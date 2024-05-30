<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>登録画面</title>
	<link rel="stylesheet" href="./css/register.css" />
</head>
<body>


	<form action="#" method="post">
		<h2>Sign Up</h2>
		<p>
			<label for="userid" class="floatLabel">UserID</label> <input id="userid"
				name="userid" type="text" required>
		</p>
		<p>
			<label for="email" class="floatLabel">email</label> <input id="email"
				name="email" type="email" required>
		</p>
		<p>
			<label for="password" class="floatLabel">Password</label> <input
				id="password" name="password" type="password" required> <span>Enter
				a password longer than 8 characters</span>
		</p>
		<p>
			<label for="confirm_password" class="floatLabel">Confirm
				Password</label> <input id="confirm_password" name="confirm_password"
				type="password" required> <span>Your passwords do not match</span>
		</p>
		<p>
			<input type="submit" value="Create My Account" id="submit">
		</p>
	</form>
	
	<script src="./js/register.js"></script>
</body>
</html>