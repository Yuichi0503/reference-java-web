package model.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class HashService {
	
    private static final SecureRandom random = new SecureRandom();
	/**
	 * 受け取った値にsaltを追加して、
	 * SHA-256でハッシュ化し、hashとsaltをmapで返す
	 * 
	 * @param password hash前のpassword
	 * @return hashとsaltが格納されたmap
	 */
	static public Map<String, String> hashWithSalt(String password) {
		//ハッシュ化
		Map<String, String> hashSaltMap = new HashMap<>();
		try {
			String salt = generateSalt();
			hashSaltMap.put("hash", hash(password + salt) );
			hashSaltMap.put("salt", salt);
			return hashSaltMap;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Stringをsha256でハッシュ化
	 * 
	 * @param s ハッシュ化したいString
	 * @return ハッシュ値
	 */
	public static String hash(String s) {
		byte[] encodedhash = null;
		MessageDigest sha256 = null;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			encodedhash = sha256.digest(s.getBytes("UTF-8"));
			return bytesToHex(encodedhash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String generateSalt() {
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return bytesToHex(salt);
	}
	
	private static String bytesToHex(byte[] inputByte) {
		BigInteger number = new BigInteger(1, inputByte);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		return hexString.toString();
	}
}
