<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="ja">
<head>
	<title>パスワード変更画面</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<div class="container-md py-4">
		<c:if test="${msg != null}">
			<div class="alert alert-info mt-2 text-center" id="msg">${msg}</div>
		</c:if>
	<form action="${pageContext.request.contextPath}/password_change" method="post" class="mt-5">
		<div class="d-flex flex-column w-75 mx-auto">
		    <label for="password" class="form-label">新しいパスワード</label> 
		    <input id="password" name="password" type="password" class="form-control" required>
		    <label for="confirm_password" class="form-label">パスワード再入力</label>
			<input id="confirm_password" name="confirm_password"
				type="password" class="form-control" required>
		    
		    <div class="mt-3"><input type="submit" value="送信" class="btn btn-primary"></div>
		</div>
	</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>