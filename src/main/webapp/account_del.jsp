<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="ja">
<head>
	<title>アカウント削除画面</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<div class="container-md py-4">
	
		<div class="alert alert-danger mt-2 text-center w-75 mx-auto" id="msg">
		この処理は取り消しできません。<br>
		確認のために現在のパスワードを入力してください。
		${msg}
		</div>
		
	<form action="${pageContext.request.contextPath}/account_del" method="post" class="mt-5">
		<div class="d-flex flex-column w-75 mx-auto">
		    <label for="password" class="form-label">パスワード</label> 
		    <input id="password" name="password" type="password" class="form-control" required>
		    
		    <div class="mt-3"><input type="submit" value="退会" class="btn btn-danger"></div>
		</div>
	</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>