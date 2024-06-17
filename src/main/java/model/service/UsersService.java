
package model.service;

import java.util.UUID;

import model.entity.UsersEntity;

public class UsersService {
	/**
	 * ユーザーを作成
	 * @param username
	 * @param password
	 * @param email
	 * @return 作成したユーザー
	 */
	public static UsersEntity createUser(String username, String password, String email) {
		//hashWithSaltでソルトとハッシュのmapを取得
		var hsMap = HashService.hashWithSalt(password);
		//受け取った値を元にUserEntityを作成
		UsersEntity user = new UsersEntity();
		// user_idは36文字のUUID
        user.setUser_id(UUID.randomUUID().toString());
		user.setUser_name(username);
		user.setEmail(email);
		user.setSalt(hsMap.get("salt"));
		user.setHashed_password(hsMap.get("hash"));
		//Tokenを生成
		user.setToken(UUID.randomUUID().toString());
		//認証を無効
		user.setVerified(false);

		return user;
	}
}
