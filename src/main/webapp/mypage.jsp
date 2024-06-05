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
				<ul class="list-group mt-4">
					<li class="list-group-item d-flex justify-content-center"><button name="button" value="email" class="btn btn-primary">email変更</button></li>
					<li class="list-group-item d-flex justify-content-center"><button name="button" value="password" class="btn btn-primary">password変更</button></li>
					<li class="list-group-item d-flex justify-content-center"><button name="button" value="delete account" class="btn btn-danger">退会</button></li>
				</ul>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>