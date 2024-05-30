<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="jp">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>詳細ページ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<div class="row">
			<h2 class="col justify-content-center text-center">レファレンス事例詳細</h2>
		</div>
		<div class="reference_info">
			<ul>
				<li>
					<p>レファレンス事例詳細</p>
				</li>
				<li>
					<p>事例作成日</p>
				</li>
				<li>
					<p>登録日時</p>
				</li>
				<li>
					<p>更新日時</p>
				</li>
				<li>
					<p>提供館</p>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>