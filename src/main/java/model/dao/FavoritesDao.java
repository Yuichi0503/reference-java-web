package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import model.bean.ResultSetType;
import model.entity.FavoritesEntity;

public class FavoritesDao {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	private static final String FOR_NAME = bundle.getString("FOR_NAME");

	//TODO  デフォルトで全件表示/検索も可能
	//データベースからお気に入りentityのリストを取得
	//servletはリストをjspに渡す
	//jspはリストをforeachで回して表示する

	//servletはsys_idをwebAPIに渡し、beanを取得する
	//favdetail.jspに遷移するリンクを表示

	//	public List<Favorite> getFavoritesByUserId(String userId) {
	//	    // SQLを実行してお気に入りを取得
	//	-- ユーザーのお気に入りを取得
	//	SELECT * FROM favorites WHERE user_id = ? ORDER BY saved_at DESC;
	//	}

	/**
	 * favoritesテーブルにuserIdとbeanの情報と日時を追加する
	 * @param userId ユーザーID
	 * @param bean ResultSetTypeのbean
	 * @param index Referenceのインデックス
	 */
	public static void addFavorite(String userId, ResultSetType bean, int index) {
		String sql = "INSERT INTO favorites (user_id, sys_id, question, answer, keyword, saved_at) "
				   + "VALUES (?, ?, ?, ?, ?, NOW())";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement pstmt = con.prepareStatement(sql);
				
				) {
			pstmt.setString(1, userId);
			pstmt.setString(2, bean.getReference(index).getSysId());
			pstmt.setString(3, bean.getReference(index).getQuestion());
			pstmt.setString(4, bean.getReference(index).getAnswer());
			pstmt.setString(5, bean.getReference(index).getKeyword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ユーザーIDと検索ワードを元に、favoritesテーブルからお気に入りを取得する
	 * @param userId ユーザーID
	 * @param searchText 検索ワード
	 * @return FavoritesEntityのリスト
	 */
	public static List<FavoritesEntity> getFavoritesByUserId(String userId, String searchText) {
		 //TODO check
	        List<FavoritesEntity> favorites = new ArrayList<>();
	        
	        searchText = "%" + searchText + "%";
	        
	        String sql = "SELECT * FROM favorites "
	                   + "WHERE user_id = ? "
	                   + "AND (question LIKE ? OR answer LIKE ? OR keyword LIKE ?) "
	                   + "ORDER BY saved_at DESC";
	        try (
	        		Connection con = DriverManager.getConnection(URL, USER, PASS);
	        		PreparedStatement pstmt = con.prepareStatement(sql);
	        		) {
	            pstmt.setString(1, userId);
	            pstmt.setString(2, searchText);
	            pstmt.setString(3, searchText);
	            pstmt.setString(4, searchText);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
					favorites.add(new FavoritesEntity(
							rs.getString("user_id"),
							rs.getString("sys_id"),
							rs.getString("question"),
							rs.getString("answer"),
							rs.getString("keyword"),
							rs.getTimestamp("saved_at").toLocalDateTime() ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return favorites;
	    }
	 
}
