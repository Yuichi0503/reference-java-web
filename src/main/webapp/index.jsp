<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
	<title>メインページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="container-md py-4">
	
	<form action="/reference-java-web/search" class="mt-5">
		<div class="d-flex justify-content-center flex-wrap gap-3">
			<input type="search" class="w-50 form-control" name="searchText" placeholder="キーワード検索" required="required"/>
			<button type="submit" class="btn btn-secondary">検索</button>
			<input type="hidden" name="page" value="1"/>
		</div>		
	</form>
	<form action="" class="mt-5 d-flex justify-content-center">
		<button type="submit" class="btn btn-secondary">ランダム検索</button>
	</form>
	
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>