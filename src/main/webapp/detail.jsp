<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!doctype html>
<html lang="ja">
<head>
	<title>詳細ページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<c:set var="data" value="${rsBean.result[index].reference}"></c:set>
	
	<div class="container-md py-4">
		<div class="">
			<h2 class="col mt-5 text-center">レファレンス事例詳細</h2>
		</div>
		<div class="card mt-5">
			<fmt:parseDate var="lstDate" 
							value="${data.refTypeObject('system').lstDate}"
							pattern="yyyyMMddHHmmss" />
			<fmt:formatDate var="fLstDate" value="${lstDate}" pattern="yyyy/MM/dd" />
			<div class="card-header">
			提供館:${data.refTypeObject('system').libName}<br />
			<c:if test="${!'00000000'.equals(data.refTypeObject('crt-date'))}">
				事例作成日:
					<fmt:parseDate var="crtDate" 
					value="${data.refTypeObject('crt-date')}" 
						pattern="yyyyMMdd" />
					<fmt:formatDate var="fCrtDate" value="${crtDate}" pattern="yyyy/MM/dd" />
					${fCrtDate}
					<br />
			</c:if>
			更新日時:${fLstDate}
			</div>
			<div class="card-body">
				<h1 class="card-title">質問:</h1>
				<c:set var="question" value="${fn:replace(data.refTypeObject('question'), '。', '。<br/>')}" />
				<c:set var="question" value="${fn:replace(question, '。<br/>」', '。」')}" />
				<p class="card-text">${question}
				<c:if test="${data.refTypeObject('ptn-type') != null}">
					by:${data.refTypeObject('ptn-type')}
				</c:if>
				</p>
				<h1 class="card-title">回答:</h1>
				<c:set var="answer" value="${fn:replace(data.refTypeObject('answer'), '。', '。<br/>')}" />
				<c:set var="answer" value="${fn:replace(answer, '。<br/>」', '。」')}" />
				<p class="card-text">${answer}</p>
			</div>
			<ul class="list-group list-group-flush  justify-content-center">
				<li class="list-group-item">
					<p>回答プロセス<br />
					<c:set var="ansProc" value="${fn:replace(data.refTypeObject('ans-proc'), '。', '。<br/>')}" />
					<c:set var="ansProc" value="${fn:replace(ansProc, '。<br/>」', '。」')}" />
					${ansProc}
					</p>
				</li>
				<li class="list-group-item">
					<p>事前調査事項</p><br />
					<c:set var="preRes" value="${fn:replace(data.refTypeObject('pre-res'), '。', '。<br/>')}" />
					<c:set var="preRes" value="${fn:replace(preRes, '。<br/>」', '。」')}" />
					${preRes}
				</li>
				<li class="list-group-item">
					<p>参考資料</p>
					<c:forEach var="obj" items="${data.refTypeAllObjects('bibl')}">
						${obj.biblDesc}
						${obj.biblIsbn}
						${obj.biblNote}
						<hr />
						<br />
					</c:forEach>
				</li>
				<li class="list-group-item">
					<p>キーワード</p>
					<c:forEach var="obj" items="${data.refTypeAllObjects('keyword')}">
						${obj}
						<br />
					</c:forEach>
				</li>
				<li class="list-group-item">
					<p>照会先</p>
					<c:forEach var="obj" items="${data.refTypeAllObjects('referral')}">
						${obj}
						<br />
					</c:forEach>
				</li>
				<li class="list-group-item">
					<p>寄与者</p>
					<c:forEach var="obj" items="${data.refTypeAllObjects('contri')}">
						${obj}
						<br />
					</c:forEach>
				</li>
				<li class="list-group-item">
					<p>URL</p>
					<a href="${data.refTypeObject('url')}">${data.refTypeObject('url')}</a>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>