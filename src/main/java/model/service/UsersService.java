
package model.service;

import java.util.UUID;

import model.entity.User_requestsEntity;

public class UsersService {
	/**
	 * Entityを作成
	 * @param username
	 * @param password
	 * @param email
	 * @return User_requestsEntity
	 */
    private static final int EXPIRY_DURATION_IN_MILLISECONDS = 3600000;

	public static User_requestsEntity createUser(String username, String password, String email) {
		//hashWithSaltでソルトとハッシュのmapを取得
		var hsMap = HashService.hashWithSalt(password);
		//受け取った値を元にUser_requestsEntityを作成
		User_requestsEntity user = new User_requestsEntity();
		//Tokenを生成
		user.setToken(UUID.randomUUID().toString());
		
		//operation_typeは"signup"
		user.setOperation_type("signup");
		
		// user_idは36文字のUUID
        user.setUser_id(UUID.randomUUID().toString());
		user.setUser_name(username);
		user.setEmail(email);
		user.setHashed_password(hsMap.get("hash"));
		user.setSalt(hsMap.get("salt"));
		
		//有効期限はEXPIRY_DURATION_IN_MILLISECONDS以内
		user.setExpiry(new java.sql.Timestamp(System.currentTimeMillis() + EXPIRY_DURATION_IN_MILLISECONDS));
		
		return user;
	}
}
