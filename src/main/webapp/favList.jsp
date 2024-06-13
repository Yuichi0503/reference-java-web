<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!doctype html>
<html lang="ja">
<head>
	<title>お気に入りページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<c:forEach var="rec" items="${favList}">
			<div class="simple_result_list_box mt-4">
				<ul class="simple_result_ul">
					<div class="card text-center">
						<div class="card-body">
							<h5 class="card-title">質問</h5>
							<p class="card-text">${rec.question}</p>
							<h5 class="card-title">回答</h5>
							<p class="card-text">${rec.answer}</p>
							<a href="#" class="btn btn-primary">詳細ページ</a>
							<a href="#" class="btn btn-warning">お気に入り解除</a>
						</div>
						<div class="card-footer text-body-secondary">
						<span>保存日:
							<fmt:parseDate var="saved_at"
									value="${rec.saved_at}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						    <fmt:formatDate var="f_saved_at" 
						    value="${saved_at}" 
						    pattern="yyyy/MM/dd" />
						    ${f_saved_at}
						</span>
						</div>
					</div>
				</ul>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>