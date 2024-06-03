<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!doctype html>
<html lang="jp">
<head>
	<title>詳細ページ</title>
	<jsp:include page="head.jsp" />
</head>
<body class="bg-body-color">
	<jsp:include page="header.jsp" />
<%-- 	<c:set var="searchTextPage" value="${requestScope.searchTextPage}" /> --%>
<%-- 	<c:set var="index" value="${requestScope.index}" /> --%>
	<c:set var="data" value="${sessionScope[searchTextPage].result[index].reference}"></c:set>
	
	<div class="container-md">
		<div class="">
			<h2 class="col mt-5 text-center">レファレンス事例詳細</h2>
		</div>
		<div class="card mt-5">
			<div class="card-header">提供館:${data.refTypeObject('system').libName}<br />更新日時</div>
			<div class="card-body">
				<h1 class="card-title">質問:</h1>
				<p class="card-text">${data.refTypeObject('question')}</p>
				<h1 class="card-title">回答:</h1>
				<p class="card-text">
				${data.refTypeObject('answer')}
				</p>
			</div>
			<ul class="list-group list-group-flush  justify-content-center">
				<li class="list-group-item">
					<p>回答プロセス<br />
					${data.refTypeObject('ans-proc')}
					</p>
				</li>
				<li class="list-group-item">
					<p>事前調査事項</p><br />
					${data.refTypeObject('pre-res')}
				</li>
				<li class="list-group-item">
					<p>参考資料</p><br />
					${data.refTypeObject('')}
				</li>
				<li class="list-group-item">
					<p>キーワード</p><br />
					${data.refTypeObject('')}
				</li>
				<li class="list-group-item">
					<p>照会先</p><br />
					${data.refTypeObject('')}
				</li>
				<li class="list-group-item">
					<p>寄与者</p><br />
					${data.refTypeObject('')}
				</li>
				<li class="list-group-item">
					<a href="${data.refTypeObject('url')}">URL</a>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>