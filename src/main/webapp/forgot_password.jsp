<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
	<title>パスワードリセット要求画面</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<div class="container-md py-4">
	
	<form action="${pageContext.request.contextPath}/forgot_password" method="post" class="mt-5">
		<div class="d-flex flex-column w-75 mx-auto">
		    <label for="email" class="form-label">登録しているメールアドレス</label> 
		    <input id="email" name="email" type="email" class="form-control" required>
		    <div class="mt-3"><input type="submit" value="送信" class="btn btn-primary"></div>
		</div>
	</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>