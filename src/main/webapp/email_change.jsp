<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
	<title>Email変更</title>
	<jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="container-md py-4">
	
	<form action="/reference-java-web/email_change" method="post" class="mt-5">
		<div class="d-flex flex-column w-75 mx-auto">
		    <label for="new_email" class="form-label">新しいメールアドレス</label> 
		    <input id="new_email" name="new_email" type="email" class="form-control" required="">
		    <label for="confirm_email" class="form-label">新しいメールアドレス再入力</label>
		    <input id="confirm_email" name="confirm_email" type="email" class="form-control" required="">
		    <div class="mt-3"><input type="submit" value="変更" class="btn btn-primary"></div>
		</div>
	</form>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>