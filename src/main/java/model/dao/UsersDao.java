package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import model.bean.UsersEntity;

public class UsersDao {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	
	
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
			Class.forName("org.postgresql.Driver");
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
	            entity.setEmail(rs.getString("email")); 
	            entity.setHashed_password(rs.getString("hashed_password")); 
	            entity.setSalt(rs.getString("salt"));
	            entity.setReg_date(rs.getDate("reg_date").toLocalDate());
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
	
}
