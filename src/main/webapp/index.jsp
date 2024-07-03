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
	
	<c:if test="${msg != null}">
		<div class="alert alert-info mt-2 text-center">${msg}</div>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/search" class="mt-5">
		<div class="d-flex justify-content-center flex-wrap gap-3">
			<input type="search" class="w-50 form-control" name="searchText" placeholder="キーワード検索" required="required"/>
			<button type="submit" class="btn btn-success">検索</button>
			<input type="hidden" name="page" value="1"/>
		</div>		
	</form>
	
	<form action="${pageContext.request.contextPath}/random_search" class="my-5 d-flex justify-content-center">
		<button type="submit" class="btn btn-secondary" style="background-color:#265f92">ランダム検索</button>
	</form>
	
		<script
			src="https://embeds.rss2html.net/embed.js?url=https%3A%2F%2Fcrd.ndl.go.jp
			%2Fjp%2Fpublic%2Frss2%2Frss.xml&amp;embed_render_title=0&amp;feed_render_image=0&amp;
			feed_render_description=0&amp;item_render_body=0"></script>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>