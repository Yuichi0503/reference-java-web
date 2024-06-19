package model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User_requestsEntity {
	private String token;
    private String operation_type;
    private String user_id;
    private String user_name;
    private String email;
    private String hashed_password;
    private String salt;
    private Date reg_date;
    private String new_email;
    private String new_hashed_password;
    private String new_salt;
    private Timestamp expiry;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getNew_email() {
		return new_email;
	}
	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}
	public String getNew_hashed_password() {
		return new_hashed_password;
	}
	public void setNew_hashed_password(String new_hashed_password) {
		this.new_hashed_password = new_hashed_password;
	}
	public String getNew_salt() {
		return new_salt;
	}
	public void setNew_salt(String new_salt) {
		this.new_salt = new_salt;
	}
	public Timestamp getExpiry() {
		return expiry;
	}
	public void setExpiry(Timestamp expiry) {
		this.expiry = expiry;
	}
    
    
}
