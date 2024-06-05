<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>



<!doctype html>
<html lang="ja">
<head>
	<title>検索結果</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md mt-4">
		<div class="result_num_box d-flex justify-content-center">
			<div>検索結果</div>
			<div>${rsBean.hitNum}件中</div>
			<c:set var="totalPages" value="${sessionScope[stringSearchTextTotalPages]}"></c:set>
			<c:set var="start" value="${(page - 1) * RESULT_NUM + 1 }"></c:set>
			<c:set var="end" value="${start + RESULT_NUM - 1}"></c:set>
			<c:set var="end" value="${Math.min(end.intValue(), totalPages)}"></c:set>
			<div>
				${start}件から${end}件を表示
			</div>
		</div>
		
		<form action="/reference-java-web/search">
			<nav aria-label="Page navigation" class="mt-4">
				<ul class="pagination justify-content-center">
					<c:if test="${page - 1 != 0}">
						<li class="page-item"><button class="page-link" name="page" value="${page - 1}">前</button></li>
						<c:if test="${page -1 != 1}">
							<li class="page-item "><button class="page-link" name="page" value="1">1</button></li>
						</c:if>
						<li class="page-item"><button class="page-link" name="page" value="${page - 1}">${page - 1}</button></li>
					</c:if>
					<li class="page-item active"><button type="button" class="page-link">${page}</button></li>
					<c:if test="${page + 1 <= totalPages}">
						<li class="page-item"><button class="page-link" name="page" value="${page + 1}">${page + 1}</button></li>
						<c:if test="${page + 1 != totalPages}">
							<li class="page-item "><button class="page-link" name="page" value="${totalPages}">${totalPages}</button></li>
						</c:if>
						<li class="page-item"><button class="page-link" name="page" value="${page + 1}">次</button></li>
					</c:if>
					<input type="hidden" name="searchText" value="${searchText}"/>
				</ul>
			</nav>
		</form>


		<c:forEach var="rec" items="${rsBean.result}" varStatus="status">
			<div class="simple_result_list_box mt-4">
				<div class="card text-center">
					<div class="card-body">
						<c:set var="solution" value="${rec.reference.refTypeObject('solution')}"></c:set>
						<h5 class="card-title">
							質問
						</h5>
						<p class="card-text">
							<c:choose>
								<c:when test="${fn:length(rec.reference.refTypeObject('question')) > 40}">
                           			 ${fn:substring(rec.reference.refTypeObject('question'), 0, 40)}...
                       			</c:when>
								<c:otherwise>
		                            ${rec.reference.refTypeObject('question')}
		                        </c:otherwise>
							</c:choose>
							<c:if test="${rec.reference.refTypeObject('ptn-type') != null}">
								by:${rec.reference.refTypeObject('ptn-type')}
							</c:if>
						</p>
						<h5 class="card-title">回答
							<c:if test="${'1'.equals(solution)}"><br />(未解決)</c:if>
						</h5>
						<p class="card-text">
							<c:choose>
								<c:when test="${fn:length(rec.reference.refTypeObject('answer')) > 40}">
                           			 ${fn:substring(rec.reference.refTypeObject('answer'), 0, 40)}...
                       			</c:when>
								<c:otherwise>
		                            ${rec.reference.refTypeObject('answer')}
		                        </c:otherwise>
							</c:choose>
						</p>
						<div class="button_group d-flex justify-content-center gap-3">
							<form action="/reference-java-web/detail">
								<button class="btn btn-primary" type="submit" name="index" value="${status.index}" class="btn">詳細ページ</button>
								<input type="hidden" name="searchText" value="${searchText}">
								<input type="hidden" name="page" value="${page}">
							</form>
							<form action="">
								<button class="btn btn-warning">お気に入り</button>
							</form>
						</div>
					</div>
					<div class="card-footer text-body-secondary">
						<div>提供館:${rec.reference.refTypeObject('system').libName}
						</div>
						<c:if test="${!'00000000'.equals(rec.reference.refTypeObject('crt-date'))}">
							<div>
								事例作成日:
								<fmt:parseDate var="crtDate" 
								value="${rec.reference.refTypeObject('crt-date')}" 
									pattern="yyyyMMdd" />
								<fmt:formatDate var="fCrtDate" value="${crtDate}" pattern="yyyy/MM/dd" />
								${fCrtDate}
							</div>
						</c:if>
						<div>
							更新日:
							<fmt:parseDate var="lstDate" 
							value="${rec.reference.refTypeObject('system').lstDate}"
								pattern="yyyyMMddHHmmss" />
							<fmt:formatDate var="fLstDate" value="${lstDate}" pattern="yyyy/MM/dd" />
							${fLstDate}
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<form action="/reference-java-web/search">
			<nav aria-label="Page navigation" class="mt-4">
				<ul class="pagination justify-content-center">
					<c:if test="${page - 1 != 0}">
						<li class="page-item"><button class="page-link" name="page" value="${page - 1}">前</button></li>
						<c:if test="${page -1 != 1}">
							<li class="page-item "><button class="page-link" name="page" value="1">1</button></li>
						</c:if>
						<li class="page-item"><button class="page-link" name="page" value="${page - 1}">${page - 1}</button></li>
					</c:if>
					<li class="page-item active"><button type="button" class="page-link">${page}</button></li>
					<c:if test="${page + 1 <= totalPages}">
						<li class="page-item"><button class="page-link" name="page" value="${page + 1}">${page + 1}</button></li>
						<c:if test="${page + 1 != totalPages}">
							<li class="page-item "><button class="page-link" name="page" value="${totalPages}">${totalPages}</button></li>
						</c:if>						<li class="page-item"><button class="page-link" name="page" value="${page + 1}">次</button></li>
					</c:if>
					<input type="hidden" name="searchText" value="${searchText}"/>
				</ul>
			</nav>
		</form>
		
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>