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
|||ランダム検索語句生成|

# 画面一覧
## ログイン

## 登録画面

## メインページ
- 検索 (searchText)
  - radioボタン(type:all/or)
- ランダム検索
- 新着 rss

### サーブレット
- 検索時 Sessionになければ、検索文字列と表示pageをModelに投げbeanを受け取る
  bean.getResultsCd()で分岐(0:成功、1:失敗)
- 0の場合List<ResultType>を受け取る。Sessionに、検索文字列+page番号名で保存後フォワード
	- 検索結果1~25 `List<ResultType>`  	  
- 1の場合err_list>err_item のerr_code/err_fid/err_msgを受取り、requestScopeにエラーデータを保存してフォワード

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
# テーブル一覧
[URL](https://onedrive.live.com/personal/5f191bc732c73af4/_layouts/15/doc2.aspx?resid=8297d200-4d9b-476c-b203-ed8ae6ab01e5&cid=5f191bc732c73af4&ct=1716525039995&wdOrigin=OFFICECOM-WEB.START.UPLOAD&wdPreviousSessionSrc=HarmonyWeb&wdPreviousSession=1202191a-e18f-4d9a-9386-35394108ce06)

