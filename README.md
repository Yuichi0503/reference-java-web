# 機能一覧
|機能id|画面名|機能概要|
|----|----|----|
|||ユーザー登録|
|||ログイン|
|||ログアウト|
|||マイページにリファレンスを保存|
|||保存したリファレンスの削除|
|||リファレンス検索・取得|
|||検索結果の一覧表示|
|||詳細ページ表示|
|||マイページ表示|
|||ランダム検索/reg-dateでデータ取得(最古のreg-dateは2004/03/06)|

# 画面一覧
## ログイン

## 登録画面

## メインページ
- 検索 (searchText)
- ランダム検索
- 新着 rss

### サーブレット
- 検索時 Sessionになければ、検索文字列と表示pageをModelに投げResultSetTypeクラスbeanを受け取る
  bean.getResultsCd()で分岐(0:成功、1:失敗)
- 0の場合受け取ったBeanをSessionに検索文字列+page名で保存。その後フォワード
	- 検索結果1~25 `List<ResultType>`  	  
- 1の場合requestScopeにBeanを保存してフォワード

### Model
- 検索文字列とpageを受取りapiへ送信  
  返却されたxmlをbeanに変換後、参照元へ返す

## 検索結果(記事一覧)(記事保存)
### 成功時
- ヒット数
- 検索開始位置
- 現在のページ
- レファレンス情報
    - lib-name
    - 作成日
    - 更新日
    - 質問
    - 回答
    
### 失敗時
- エラーコード(api画像表示)
- エラーメッセージ

## マイページ（保存したレファレンス一覧）

## 記事詳細ページ(記事保存)
レファレンス事例詳細  
事例作成日  
更新日時  
提供館  

解決or未解決  
質問内容    
回答内容  

回答プロセス  
事前調査事項  
参考資料  
キーワード  
照会先  
寄与者  
備考  
調査種別  
内容種別  
質問者区分  

転記用URL  

# 備考
- WEB-INF/classesにpropertiesファイルを追加すること
- WEB-INF直下にGmailAPIのOAuth 2.0クライアントIDのJSONファイルを追加すること
- jspが実行できない場合、プロジェクトファセットの動的webモジュールのバージョンを5.0に変更
- jdbcが読み込めない場合、Class.forName()を追記
- tomcat10の為jakartaでimport
- jaxb2-maven-pluginのxjcを使用して、xsdからbeanを生成します。
	- pom.xmlの`<configuration>`、`<sources>`、`<source>`に、`${project.basedir}`を使用してxsdのパスを記述します。
 	- xsdのxmlns:（XML名前空間）の記述に基づいてJavaコードを生成します。この名前空間の指定により、生成されるJavaコードのパッケージ構造やimport文が変わります。
- jstlに必要なもの  
	1. jakarta.servlet.jsp.jstl-api
	1. jakarta.servlet.jsp.jstl(jstl-apiの実装)
	1. jakarta.servlet.jsp-api
- jakartaEE10からURIがURNに変更
	- `<%@ taglib prefix="c"uri="jakarta.tags.core" %>`
	- `<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>`
	- `<%@ taglib prefix="fn"uri="jakarta.tags.functions" %>`	
- ReferenceTypeへのアクセスにはReferenceTypeメソッドの  
  refTypeObject("refTypeName")を使う
	- “question”, “reg-id”, “answer”, “crt-date”, “solution”, “keyword”, “class”, “res-type”, “bibl”, “ans-proc”, “pre-res”, “ptn-type”, “note”, “system”, “url”, “con-type”, “referral”, “contri”
- ReferenceTypeの要素にアクセスするには、ReferenceTypeに対してgetterを利用(XMLではハイフン区切りケバブケースだが,キャメルケースに変更)
	

# テーブル一覧
[URL](https://onedrive.live.com/personal/5f191bc732c73af4/_layouts/15/doc2.aspx?resid=8297d200-4d9b-476c-b203-ed8ae6ab01e5&cid=5f191bc732c73af4&ct=1716525039995&wdOrigin=OFFICECOM-WEB.START.UPLOAD&wdPreviousSessionSrc=HarmonyWeb&wdPreviousSession=1202191a-e18f-4d9a-9386-35394108ce06)

