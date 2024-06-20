package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import model.entity.User_requestsEntity;
import model.entity.UsersEntity;

public class UsersDao {
	
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
	 * emailをキーにentityを返す
	 * @param email
	 * @return entity or null
	 */
	public static UsersEntity getEntityByEmail(String email) {
		var entity = new UsersEntity();
		String sql =  "SELECT *\n"
					+ "FROM users\n"
					+ "WHERE email = ?\n";
	
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
	            return entity;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * user_idをキーにentityを返す
	 * @param user_id
	 * @return entity or null
	 */
	public static UsersEntity getEntityByUserId(String user_id) {
		var entity = new UsersEntity();
		String sql = "SELECT *\n"
				+ "FROM users\n"
				+ "WHERE user_id = ?\n";
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entity.setUser_id(rs.getString("user_id"));
				entity.setUser_name(rs.getString("user_name"));
				entity.setEmail(rs.getString("email"));
				entity.setHashed_password(rs.getString("hashed_password"));
				entity.setSalt(rs.getString("salt"));
				entity.setReg_date(rs.getDate("reg_date").toLocalDate());
				entity.setToken(rs.getString("token"));
				return entity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * User_requestsEntityをusersDBに追加
	 * @param User_requestsEntity
	 * @return true or false
	 */
	public static boolean addEntity(User_requestsEntity entity) {
		String sql =  "INSERT INTO users (user_id, user_name, email, hashed_password, salt)\n"
                    + "VALUES (?, ?, ?, ?, ?)\n";
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
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * user_id該当レコードのuser_nameを変更
	 * @param userId
	 * @param newUserName
	 * @return true or false
	 */
	public static boolean updateUserName(String userId, String newUserName) {
		String sql = "UPDATE users SET user_name = ? WHERE user_id = ?";
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
	 * user_id該当レコードのemailを変更
	 * @param userId
	 * @param newEmail
	 * @return true or false
	 */
	public static boolean updateEmail(String userId, String newEmail) {
		String sql = "UPDATE users SET email = ? WHERE user_id = ?";
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, newEmail);
			pstmt.setString(2, userId);
			int result = pstmt.executeUpdate();
			return result == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * user_id該当レコードを削除
	 * @param user_id
	 * @return　 true or false
	 */
	public static boolean deleteUser(String user_id) {
		String sql = "DELETE FROM users WHERE user_id = ?";
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
		    System.err.println("Error occurred while deleting user: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

}
