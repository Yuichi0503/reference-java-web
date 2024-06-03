<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>



<!doctype html>
<html lang="jp">
<head>
	<title>検索結果</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md mt-4">
		<div class="result_num_box d-flex justify-content-center">
			<div>検索結果</div>
			<div>hoge件中</div>
			<div>fuga件からpiyo件を表示</div>
		</div>
		<nav aria-label="Page navigation" class="mt-4">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">前</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">次</a></li>
			</ul>
		</nav>


		<c:forEach var="rec" items="${sessionScope[searchTextPage].result}" varStatus="status">
			<div class="simple_result_list_box mt-4">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title">
							質問
						</h5>
						<p class="card-text">${rec.reference.refTypeObject('question')}</p>
						<h5 class="card-title">回答</h5>
						<p class="card-text">
							<c:choose>
								<c:when
									test="${fn:length(rec.reference.refTypeObject('answer')) > 40}">
                            ${fn:substring(rec.reference.refTypeObject('answer'), 0, 40)}...
                       			 </c:when>
								<c:otherwise>
                            ${rec.reference.refTypeObject('answer')}
                        </c:otherwise>
							</c:choose>
						</p>
						<form action="/reference-java-web/detail">
							<button class="btn btn-primary" type="submit" name="index" value="${status.index}" class="btn">詳細ページ</button>
							<input type="hidden" name="searchTextPage" value="${searchTextPage}">
						</form>
						<form action="">
							<button class="btn btn-warning">お気に入り</button>
						</form>
					</div>
					<div class="card-footer text-body-secondary">
						<div>提供館:${rec.reference.refTypeObject('system').libName}
						</div>
						<div>
							更新日:
							<fmt:parseDate var="date" 
							value="${rec.reference.refTypeObject('system').lstDate}"
								pattern="yyyyMMddHHmmss" />
							<fmt:formatDate var="fDate" value="${date}" pattern="yyyy/MM/dd" />
							${fDate}
						</div>
					</div>
				</div>
			</div>
		</c:forEach>




		<nav aria-label="Page navigation" class="mt-4">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">前</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">次</a></li>
			</ul>
		</nav>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>