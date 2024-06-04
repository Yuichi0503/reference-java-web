<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
	<title>マイページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<form action="">
			<div>
				<ul>
					<li><button name="button" value="email">email変更</button></li>
					<li><button name="button" value="password">password変更</button></li>
					<li><button name="button" value="delete account">退会</button></li>
				</ul>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>