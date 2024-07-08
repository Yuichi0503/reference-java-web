# サイト概要
レファレンス共同データベースのWebApiを利用した、  
図書館レファレンスデータの取得保存Webアプリケーション  
[スライド](https://www.canva.com/design/DAGJHpZWogY/ipToCdvjvcCGcxFAimMI2A/view?utm_content=DAGJHpZWogY&utm_campaign=designshare&utm_medium=link&utm_source=editor)
# 主な機能
- メール認証によるアカウントの登録・削除
- レファレンスの保存・削除
- レファレンス検索・閲覧
- 詳細ページ表示
- マイページ表示
- ランダム検索/reg-dateでデータ取得(最古のreg-dateは2004/03/06)|
## レファレンス検索部分
### Controller
- 検索時 SessionScopeにデータがなければ、検索文字列と表示pageをModelに投げ、ResultSetTypeのbeanを受け取る
- bean.getResultsCd()で分岐(0:成功、1:失敗)
- 0の場合受け取ったBeanをSessionに検索文字列+page名で保存。その後viewへフォワード
	- 検索結果1~25 `List<ResultType>`  	  
- 1の場合requestScopeにBeanを保存してフォワード
### Model
- 検索文字列とpageを受取りapiへ送信  
  返却されたxmlをbeanに変換後、参照元へ返す
### View
- JSP/JSTLを利用して表示

# 備考
- WEB-INF/classesにpropertiesファイルを追加すること
- WEB-INF直下にGmailAPIのOAuth 2.0クライアントIDのJSONファイルを追加すること
- jspが実行できない場合、プロジェクトファセットの動的webモジュールのバージョンを5.0に変更
- jdbcが読み込めない場合、Class.forName()を追記
- tomcat10の為jakartaでimport
- jaxb2-maven-pluginのxjcを使用して、xsdからbeanを生成
	- pom.xmlの`<configuration>`、`<sources>`、`<source>`に、`${project.basedir}`を使用してxsdのパスを記述
 	- xsdのxmlns:（XML名前空間）の記述に基づいてJavaコードを生成。この名前空間の指定により、生成されるJavaコードのパッケージ構造やimport文が変わる。
- jstlに必要なもの  
	1. jakarta.servlet.jsp.jstl-api
	1. jakarta.servlet.jsp.jstl(jstl-apiの実装)
	1. jakarta.servlet.jsp-api
- jakartaEE10からURIがURNに変更
	- `<%@ taglib prefix="c"uri="jakarta.tags.core" %>`
	- `<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>`
	- `<%@ taglib prefix="fn"uri="jakarta.tags.functions" %>`	
- ResultSetTypeのメソッドgetReference(int index)で、index件目のReferenceTypeが取得できる
- ReferenceTypeの要素にアクセスするには、ReferenceTypeのgetterメソッドを利用
- refTypeNameの一覧
	- “question”, “reg-id”, “answer”, “crt-date”, “solution”, “keyword”, “class”, “res-type”, “bibl”, “ans-proc”, “pre-res”, “ptn-type”, “note”, “system”, “url”, “con-type”, “referral”, “contri”
	

# その他ドキュメント
[URL](https://1drv.ms/x/c/5f191bc732c73af4/EQDSl4KbTWxHsgPtiuarAeUBcdIlaDj7ZotrYrRHMCfXGA?e=yAFASO)

