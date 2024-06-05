package model.bean;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequestWrapper;
import model.service.HashService;

public class UsersEntity {
	private String email;
	private String hashed_password;
	private String salt;
	private LocalDate reg_date;
	
	public UsersEntity() {
	}
	//TODO 別クラスに分ける
	public UsersEntity(HttpServletRequestWrapper request){
		this.email = request.getParameter("email");
		var hashSaltMap = HashService.hashWithSalt(request.getParameter("password"));
		this.hashed_password = hashSaltMap.get("hash");
		this.salt = hashSaltMap.get("salt");
		this.reg_date = LocalDate.now();
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
	
	
	
}
