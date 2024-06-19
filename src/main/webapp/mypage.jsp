<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="ja">
<head>
	<title>マイページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md py-4">
		<c:if test="${msg != null}">
			<div class="alert alert-info mt-2 text-center w-75 mx-auto">${msg}</div>
		</c:if>
		<div>
			<ul class="list-group mt-4">
				<li class="list-group-item d-flex justify-content-center"><a
					class="btn btn-primary" href="email_change.jsp" role="button">Email変更</a></li>

				<li class="list-group-item d-flex justify-content-center"><a
					class="btn btn-primary" href="password_change.jsp" role="button">Password変更</a></li>

				<li class="list-group-item d-flex justify-content-center">
					<button name="button" value="delete account" class="btn btn-danger">退会</button>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>