<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="jp">
<head>
	<title>メインページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="container-md">
	<form action="/reference-java-web/search">
		<div>
			<input type="search" class="form-control" name="searchText" placeholder="キーワード検索" required="required"/>
			<button type="submit">検索</button>
		</div>		
	</form>
	<button type="submit">ランダム検索</button>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>