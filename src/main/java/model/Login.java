package model;

import model.dao.UsersDao;
import model.service.HashService;

public class Login {
	
	public static boolean loginCheck(String email, String input_password) {
		//daoを利用してemailを元にレコードを取得
		var entity = UsersDao.getEntity(email);
		//entityがなければfalse
		if (entity == null) {
			return false;
		}
		//emailをkeyにentity取得
		
		//レコードのhashed_passwardの値と引数+saltのhashを比較
		var salt = entity.getSalt();
		var input_hash = HashService.hash(input_password + salt);
		//等しければtrue
		if (input_hash.equals(entity.getHashed_password())) {
			return true;
		}
		
		return false;
	}
	
}
