<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="sticky-top">
		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">RefPockets</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="mypage.jsp">マイページ</a></li>
					<li class="nav-item">
						<form action="${pageContext.request.contextPath}/favlist" method="post">
							<button type="submit" class="nav-link btn-link">お気に入り</button>
						</form>
					</li>
					<li class="nav-item">
						<form action="${pageContext.request.contextPath}/logout" method="post">
							<button type="submit" class="nav-link btn-link">ログアウト</button>
						</form>
					</li>
				</ul>
				<form action="${pageContext.request.contextPath}/random_search" class="me-2">
					<button type="submit" class="btn btn-secondary" style="background-color:#265f92">ランダム検索</button>
				</form>
				<form class="d-flex" role="search"
					action="${pageContext.request.contextPath}/search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search" name="searchText">
					<button class="btn btn-success" type="submit">Search</button>
					<input type="hidden" name="page" value="1" />
				</form>
			</div>
		</div>
		</nav>
	</header>