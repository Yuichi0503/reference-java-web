package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import model.entity.UsersEntity;

public class UsersDao {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	private static final String FOR_NAME = bundle.getString("FOR_NAME");
	
	
	/**
	 * emailをキーにentityを返す
	 * @param email
	 * @return entity or null
	 */
	public static UsersEntity getEntity(String email) {
		var entity = new UsersEntity();
		String sql =  "SELECT *\n"
					+ "FROM users\n"
					+ "WHERE email = ?\n";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entity.setUser_id(rs.getString("user_id"));
				entity.setUser_name(rs.getString("user_name"));
	            entity.setEmail(rs.getString("email")); 
	            entity.setHashed_password(rs.getString("hashed_password")); 
	            entity.setSalt(rs.getString("salt"));
	            entity.setReg_date(rs.getDate("reg_date").toLocalDate());
	            entity.setToken(rs.getString("token"));
	            entity.setVerified(rs.getBoolean("is_verified"));
	            return entity;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * entityをDBに追加
	 * @param entity
	 * @return 成功したか
	 */
	public static boolean addEntity(UsersEntity entity) {
		String sql =  "INSERT INTO users (user_id, user_name, email, hashed_password, salt, token, is_verified)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ? )\n";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, entity.getUser_id());
			pstmt.setString(2, entity.getUser_name());
			pstmt.setString(3, entity.getEmail());
			pstmt.setString(4, entity.getHashed_password());
			pstmt.setString(5, entity.getSalt());
			pstmt.setString(6, entity.getToken());
			pstmt.setBoolean(7, entity.isVerified());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//usersテーブルからtokenをkeyにentityを返す
	/**
	 * tokenをキーにuser_idを返す
	 * @param token
	 * @return String user_id or null
	 */
	public static String getUserIdByToken(String token) {
		String sql =  "SELECT user_id\n"
                    + "FROM users\n"
                    + "WHERE token = ?\n";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setString(1, token);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * user_id該当レコードのuser_nameを変更
	 * @param userId
	 * @param newUserName
	 * @return true or false
	 */
	public static boolean updateUserName(String userId, String newUserName) {
		String sql = "UPDATE users SET user_name = ? WHERE user_id = ?";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, newUserName);
			pstmt.setString(2, userId);
			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * user_id該当レコードのhashed_passwordとsaltを変更
	 * @param userId
	 * @param newHashedPassword
	 * @param newSalt
	 * @return true or false
	 */
	public static boolean updatePasswordAndSalt(String userId, String newHashedPassword, String newSalt) {
		String sql = "UPDATE users SET hashed_password = ?, salt = ? WHERE user_id = ?";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, newHashedPassword);
			pstmt.setString(2, newSalt);
			pstmt.setString(3, userId);
			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * user_id該当レコードのis_verifiedを変更
	 * @param userId
	 * @param isVerified
	 * @return true or false
	 */
	public static boolean updateIsVerified(String userId, boolean isVerified) {
		String sql = "UPDATE users SET is_verified = ? WHERE user_id = ?";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setBoolean(1, isVerified);
			pstmt.setString(2, userId);
			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
