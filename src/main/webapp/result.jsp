<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="jp">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>検索結果</title>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<div class="result_num_box"><span>検索結果</span><span>hoge件中</span><span>fuga件からpiyo件を表示</span></div>
		<div class="pagination_box">
			<ul class="pagination_box_prev"></ul>
			<ul class="pagination_box_num"></ul>
			<ul class="pagination_box_next"></ul>
		</div>
		<div class="simple_result_list_box">
			<ul class="simple_result_ul">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title">質問</h5>
						<p class="card-text">回答</p>
						<a href="#" class="btn btn-primary">詳細ページ</a>
						<a href="#" class="btn btn-warning">お気に入り</a>
					</div>
					<div class="card-footer text-body-secondary">
					<span>lib-name</span>
					<span>作成日:</span>
					<span>更新日:</span>
					</div>
				</div>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>