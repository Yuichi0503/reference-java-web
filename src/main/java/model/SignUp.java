package model;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequestWrapper;
import model.bean.UsersEntity;
import model.service.HashService;

public class SignUp {
	
	/**
	 * formから送られたrequestを受け取り、
	 * 登録用のentityを返す
	 * 
	 * @param request 
	 * @return 登録用entity
	 */
	public UsersEntity regUsersEntity(HttpServletRequestWrapper request){
		if (request.getParameter("email") == null || request.getParameter("email").isEmpty() ) {
	        throw new IllegalArgumentException("Email is required.");
		}
		if (request.getParameter("password") == null || request.getParameter("password").isEmpty() ) {
	        throw new IllegalArgumentException("Password is required.");
		}
		var entity = new UsersEntity();
		String hash_email = HashService.hash(request.getParameter("email"));
		entity.setUser_id(hash_email);
		entity.setEmail(request.getParameter("email"));
		var hashSaltMap = HashService.hashWithSalt(request.getParameter("password"));
		entity.setHashed_password(hashSaltMap.get("hash"));
		entity.setSalt(hashSaltMap.get("salt"));
		entity.setReg_date(LocalDate.now());
		return entity;
	}

}
