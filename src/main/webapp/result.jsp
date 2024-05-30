<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="jp">
<head>
	<title>検索結果</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md mt-4">
		<div class="result_num_box d-flex justify-content-center">
			<div>検索結果</div>
			<div>hoge件中</div>
			<div>fuga件からpiyo件を表示</div>
		</div>
		<!-- 		<div class="pagination_box"> -->
<!-- 			<ul class="pagination_box_prev"></ul> -->
<!-- 			<ul class="pagination_box_num"></ul> -->
<!-- 			<ul class="pagination_box_next"></ul> -->
<!-- 		</div> -->
		<nav aria-label="Page navigation" class="mt-4">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
		<div class="simple_result_list_box mt-4">
			<div class="card text-center">
				<div class="card-body">
					<h5 class="card-title">質問</h5>
					<p class="card-text">回答</p>
					<a href="#" class="btn btn-primary">詳細ページ</a> <a href="#"
						class="btn btn-warning">お気に入り</a>
				</div>
				<div class="card-footer text-body-secondary">
					<span>lib-name</span> <span>更新日:</span>
				</div>
			</div>
		</div>

		<nav aria-label="Page navigation" class="mt-4">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>