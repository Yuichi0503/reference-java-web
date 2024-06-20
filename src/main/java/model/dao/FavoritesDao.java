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
	
	static {
        try {
            Class.forName(FOR_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	/**
	 * お気に入りのトグル処理を行う
	 * @param user_id
	 * @param bean
	 * @param index
	 */
	public static void toggleFavorite(String user_id, ResultSetType bean, int index) {
        String sys_id = bean.getReference(index).getSysId();
        if (isFavorite(user_id, sys_id)) {
            deleteFavorite(user_id, sys_id);
        } else {
            addFavorite(user_id, bean, index);
        }
    }
	
	/**
	 * user_idとsys_idを元にfavoritesテーブルに登録されているか確認する
	 * @param user_id
	 * @param sys_id
	 * @return 登録されている場合true、されていない場合false
	 */
	public static boolean isFavorite(String user_id, String sys_id) {
		String sql = "SELECT * FROM favorites WHERE user_id = ? AND sys_id = ?";
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, sys_id);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * favoritesテーブルにuserIdとbeanの情報と日時を追加する
	 * @param userId ユーザーID
	 * @param bean ResultSetTypeのbean
	 * @param index Referenceのインデックス
	 */
	public static void addFavorite(String userId, ResultSetType bean, int index) {
		String sql = "INSERT INTO favorites (user_id, sys_id, question, answer, keyword, saved_at) "
				   + "VALUES (?, ?, ?, ?, ?, NOW())";
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
	 * user_idとsys_idを元にfavoritesテーブルからお気に入りを削除する
	 * @param user_id
	 * @param sys_id
	 */
	public static void deleteFavorite(String user_id, String sys_id) {
		String sql = "DELETE FROM favorites WHERE user_id = ? AND sys_id = ?";
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, sys_id);
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
	public static List<FavoritesEntity> getFavListByUserId(String userId, String searchText) {
	        List<FavoritesEntity> favorites = new ArrayList<>();
			if (searchText == null) {
				searchText = "";
			}
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
	 
	//user_idを元にsys_idのリストを取得する
	public static List<String> getSysIdListByUserId(String userId) {
		List<String> sysIdList = new ArrayList<>();
		String sql = "SELECT sys_id FROM favorites WHERE user_id = ?";
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				sysIdList.add(rs.getString("sys_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sysIdList;
	}
}
