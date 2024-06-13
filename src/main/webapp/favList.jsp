<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="ja">
<head>
	<title>お気に入りページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<c:forEach var="rec" items="">
			<div class="simple_result_list_box">
				<ul class="simple_result_ul">
					<div class="card text-center">
						<div class="card-body">
							<h5 class="card-title">質問</h5>
							<p class="card-text">回答</p>
							<a href="#" class="btn btn-primary">詳細ページ</a>
							<a href="#" class="btn btn-warning">お気に入り解除</a>
						</div>
						<div class="card-footer text-body-secondary">
						<span>lib-name</span>
						<span>作成日:</span>
						<span>更新日:</span>
						</div>
					</div>
				</ul>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>