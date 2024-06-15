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
	<div class="container-md py-5">

		<c:if test="${favList.isEmpty()}">
			<div class="alert alert-info mt-5" role="alert">
				お気に入り登録されたデータはありません。</div>
		</c:if>
		<c:if test="${!favList.isEmpty()}">
			<form action="/reference-java-web/favlist" method="post">
				<input type="text" name="searchText" class="form-control" />
			</form>
		</c:if>
		<c:forEach var="rec" items="${favList}">
			<div class="simple_result_list_box mt-5">
				<div class="card text-center">
					<div class="card-header">
						<h5 class="card-title">質問</h5>
						<c:set var="question"
							value="${fn:replace(rec.question, '。', '。<br/>')}" />
						<c:set var="question"
							value="${fn:replace(question, '。<br/>」', '。」')}" />
						<p class="card-text">${question}</p>
					</div>
					<div class="card-body">
						<h5 class="card-title">回答</h5>
						<c:set var="answer"
							value="${fn:replace(rec.answer, '。', '。<br/>')}" />
						<c:set var="answer" value="${fn:replace(answer, '。<br/>」', '。」')}" />
						<p class="card-text">${answer}</p>
						<form action="/reference-java-web/search" method="post">
							<button class="btn btn-primary" type="submit">詳細ページ</button>
							<input type="hidden" name="sys_id" value="${rec.sys_id}" />
						</form>
						<form action="/reference-java-web/favlist" method="post">
							<button class="btn btn-warning" type="submit">お気に入り解除</button>
							<input type="hidden" name="sys_id" value="${rec.sys_id}" /> <input
								type="hidden" name="favDelete" value="1" />
						</form>
					</div>
					<div class="card-footer text-body-secondary">
						<span>保存日: <fmt:parseDate var="saved_at"
								value="${rec.saved_at}" pattern="yyyy-MM-dd'T'HH:mm:ss" /> <fmt:formatDate
								var="f_saved_at" value="${saved_at}" pattern="yyyy/MM/dd" />
							${f_saved_at}
						</span>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>