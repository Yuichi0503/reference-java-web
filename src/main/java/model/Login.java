package model;

import model.dao.UsersDao;
import model.service.HashService;

public class Login {
	
	public static boolean loginCheck(String email, String input_password) {
		//emailを元にentityを取得
		var entity = UsersDao.getEntityByEmail(email);
		
		//entityがなければfalse
		if (entity == null) {
			return false;
		}
		
		//レコードのhashed_passwardの値と引数+saltのhashを比較
		var input_hash = HashService.hash(input_password + entity.getSalt() );
		//等しければtrue
		if (input_hash.equals(entity.getHashed_password())) {
			return true;
		}
		
		return false;
	}
	
}
