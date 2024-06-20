package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import model.entity.User_requestsEntity;

public class User_requestsDao {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	private static final String FOR_NAME = bundle.getString("FOR_NAME");
	
	/**
	 * entityをDBに追加
	 * @param entity
	 * @return true or false
	 */
	public static boolean addEntity(User_requestsEntity entity) {
		String sql =  "INSERT INTO user_requests (user_id, user_name, email"
				+ ", hashed_password, salt, token, expiry, operation_type"
				+ ", new_email, new_hashed_password, new_salt, reg_date)\n"
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";
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
			pstmt.setString(1, entity.getUser_id());
			pstmt.setString(2, entity.getUser_name());
			pstmt.setString(3, entity.getEmail());
			pstmt.setString(4, entity.getHashed_password());
			pstmt.setString(5, entity.getSalt());
			pstmt.setString(6, entity.getToken());
			pstmt.setTimestamp(7, entity.getExpiry());
			pstmt.setString(8, entity.getOperation_type());
			pstmt.setString(9, entity.getNew_email());
			pstmt.setString(10, entity.getNew_hashed_password());
			pstmt.setString(11, entity.getNew_salt());
			pstmt.setDate(12, new java.sql.Date(System.currentTimeMillis()));
			
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
	 * tokenをキーにentityを返す
	 * @param token
	 * @return entity or null
	 */
	public static User_requestsEntity getEntityByToken(String token) {
		User_requestsEntity entity = new User_requestsEntity();
		String sql =  "SELECT *\n"
					+ "FROM user_requests\n"
					+ "WHERE token = ?\n";
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
			pstmt.setString(1, token);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
			    entity.setUser_id(rs.getString("user_id"));
			    entity.setUser_name(rs.getString("user_name"));
			    entity.setEmail(rs.getString("email"));
			    entity.setHashed_password(rs.getString("hashed_password"));
			    entity.setSalt(rs.getString("salt"));
			    entity.setReg_date(rs.getDate("reg_date"));
			    entity.setToken(rs.getString("token"));
			    entity.setOperation_type(rs.getString("operation_type"));
			    entity.setNew_email(rs.getString("new_email"));
			    entity.setNew_hashed_password(rs.getString("new_hashed_password"));
			    entity.setNew_salt(rs.getString("new_salt"));
			    entity.setExpiry(rs.getTimestamp("expiry"));
			    entity.setToken(token);
			    return entity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * emailをキーにentityを返す
	 * @param email
	 * @return entity or null
	 */
	public static User_requestsEntity getEntityByEmail(String email) {
		User_requestsEntity entity = new User_requestsEntity();
		String sql =  "SELECT *\n"
					+ "FROM user_requests\n"
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
			    entity.setReg_date(rs.getDate("reg_date"));
			    entity.setToken(rs.getString("token"));
			    entity.setOperation_type(rs.getString("operation_type"));
			    entity.setNew_email(rs.getString("new_email"));
			    entity.setNew_hashed_password(rs.getString("new_hashed_password"));
			    entity.setNew_salt(rs.getString("new_salt"));
			    entity.setExpiry(rs.getTimestamp("expiry"));
			    return entity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * user_requestsテーブルから
	 * tokenをキーにuser_idを返す
	 * @param token
	 * @return String user_id or null
	 */
	public static String getUserIdByToken(String token) {
		String sql = "SELECT user_id\n"
				+ "FROM user_requests\n"
				+ "WHERE token = ?\n";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
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
	 * トークンをキーにoperation_typeを返す
	 * @param token
	 * @return String operation_type or null
	 */
	public static String getOperationTypeByToken(String token) {
		String sql = "SELECT operation_type\n"
				+ "FROM user_requests\n"
				+ "WHERE token = ?\n";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, token);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("operation_type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * トークンが有効期限内であればtrueを返す
	 * トークンが存在しない、もしくは有効期限切れであればfalseを返す
	 * @param token
	 * @return true or false
	 */
	public static boolean isValidToken(String token) {
		String sql = "SELECT expiry\n"
				+ "FROM user_requests\n"
				+ "WHERE token = ?\n";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				//この中にcloseすべきものを書く(pstmtがcloseされる時、rsもcloseされます)
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, token);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getTimestamp("expiry").getTime() > System.currentTimeMillis();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * トークンをキーに対象レコードを削除
	 * @param token
	 */
	public static void deleteByToken(String token) {
		String sql = "DELETE FROM user_requests WHERE token = ?";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, token);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteByUserIdAndOperationType(String user_id, String operation_type) {
		String sql = "DELETE FROM user_requests WHERE user_id = ? AND operation_type = ?";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, operation_type);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * user_requestsテーブルから
	 * user_idをキーにレコードを削除
	 * @param user_id
	 * @return 削除されたレコード数
	 */
	public static int deleteUserRequests(String user_id) {
		String sql = "DELETE FROM user_requests WHERE user_id = ?";
		try {
			Class.forName(FOR_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error occurred while deleting user_requests: " 
								+ e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}
}
