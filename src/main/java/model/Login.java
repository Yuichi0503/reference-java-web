package model;

import model.dao.UsersDao;
import model.service.HashService;

public class Login {
	
	public static boolean loginCheck(String email, String input_password) {
		//daoを利用してemailを元にレコードを取得
		UsersDao dao = new UsersDao();
		//entityがなければfalse
		if (dao.getEntity(email) == null) {
			return false;
		}
		//emailをkeyにentity取得
		var entity = dao.getEntity(email);
		
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
