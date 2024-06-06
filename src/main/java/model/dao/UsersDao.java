package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import model.bean.UsersEntity;

public class UsersDao {
	
	ResourceBundle bundle = ResourceBundle.getBundle("db");
	private final String URL = bundle.getString("dbURL");
	private final String USER = bundle.getString("dbUSER");
	private final String PASS = bundle.getString("dbPASS");
	
	
	/**
	 * emailをキーにentityを返す
	 * @param email
	 * @return entity or null
	 */
	public UsersEntity getEntity(String email) {
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
				//この中にcloseすべきものを書ける(pstmtがcloseされる時、rsもcloseされます)
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
	
}
