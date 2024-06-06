package model.bean;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequestWrapper;
import model.service.HashService;

public class UsersEntity {
	private String user_id;
	private String email;
	private String hashed_password;
	private String salt;
	private LocalDate reg_date;
	
	public UsersEntity() {
	}
	
	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashed_password() {
		return hashed_password;
	}

	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}
	
	/**
	 * formから送られたrequestを受け取り、
	 * entityで返す
	 * 
	 * @param request 
	 * @return 登録用entity
	 */
	public UsersEntity regUsersEntity(HttpServletRequestWrapper request){
		if (request.getParameter("email") == null || request.getParameter("email").isEmpty() ) {
			return null;
		}
		if (request.getParameter("password") == null || request.getParameter("password").isEmpty() ) {
			return null;
		}
		var entity = new UsersEntity();
		entity.setEmail(request.getParameter("email"));
		var hashSaltMap = HashService.hashWithSalt(request.getParameter("password"));
		entity.setHashed_password(hashSaltMap.get("hash"));
		entity.setSalt(hashSaltMap.get("salt"));
		entity.setReg_date(LocalDate.now());
		return entity;
	}
	
}
