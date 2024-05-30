<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="jp">
<head>
	<title>詳細ページ</title>
	<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-md">
		<div class="">
			<h2 class="col mt-5 text-center">レファレンス事例詳細</h2>
		</div>
		<div class="card mt-5">
			<div class="card-body">
				<h1 class="card-title">質問:</h1>
				<p class="card-text">平安～鎌倉時代の「読書」について書かれた本や論文はあるか。
					仏教の経典などは、寺院に行って読むことができ、経典を書写すること自体が修行なので、経典が数多く存在し目にする機会も多かったと思う。
					また、「平家物語」は琵琶法師が節をつけ、語り、普及したと思うが、「源氏物語」や「徒然草」など紫式部や兼好法師が個人で書いたものを当時の人たちはどうやって読んだのか。本がたくさんつくられたのか、それとも一冊をまわし読みしたのか。
					中世以前の読書について、書かれた本や研究論文があれば知りたい。</p>
				<h1 class="card-title">回答:</h1>
				<p class="card-text">中世期日本においては、貴族・武家階級が写本により読書しており、民衆が読書に接し始めたのは近世（江戸時代）以降と推測される。
					本の歴史に関する資料を調査し、次の資料に関係する記載があった。

					『書物の文化史』第2章「日本の書物史」のp45には「印刷が普及する江戸時代初頭以前は、書物は多く写本でつくられた」と記載されている。
					『日本の書物』4「平安時代の本」のp29には「平安時代の文化は、いわゆる貴族文化で、一般民衆にはかかわりなく、必要な書物はすべて書写でこと足りていた」と記載されている。
					『読書と読者』冒頭のp1には「日本列島上の人類史において、武家上層だけでなく民衆までの広範な人々が書籍（書物、本とも）に関心をもち蔵書を形成しはじめたのは、近世である」と記載されている。

					雑誌論文については、当館蔵書の他CiNii Articlesを検索したが見つからず。
					参考として、『図説本の歴史』には日本の文庫、図書館について(p78～79）、江戸の貸本屋について（p80～81）等、日本の読書における歴史に関する記載があった。</p>
			</div>
			<ul class="list-group list-group-flush  justify-content-center">
				<li class="list-group-item">
					<p>回答プロセス<br />テスト</p>
				</li>
				<li class="list-group-item">
					<p>更新日時</p>
				</li>
				<li class="list-group-item">
					<p>提供館</p>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>