package model.dao;

import java.util.ResourceBundle;

import model.bean.ResultSetType;

public class FavoritesDao {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	private static final String FOR_NAME = bundle.getString("FOR_NAME");
	
	public static void addFavorite(String userId, String sys_id, ResultSetType bean) {
		//TODO addFav
	}
	
	//TODO データベースからお気に入りを取得
	//呼び出し元へsys_id文字列の配列を返す
	//servletはsys_idをwebAPIに渡し、beanを取得する
	//servletはbeanをjspに渡す
	//jspはbeanを表示する
	//resultをforeachで回して表示
	//favdetail.jspに遷移するリンクを表示
	
	
//	public List<Favorite> getFavoritesByUserId(String userId) {
//	    // SQLを実行してお気に入りを取得
//	-- ユーザーのお気に入りを取得
//	SELECT * FROM favorites WHERE user_id = ? ORDER BY saved_at DESC;
//	}
}
