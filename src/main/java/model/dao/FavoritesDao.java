package model.dao;

import java.util.ResourceBundle;

import model.bean.ResultSetType;

public class FavoritesDao {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("db");
	private static final String URL = bundle.getString("dbURL");
	private static final String USER = bundle.getString("dbUSER");
	private static final String PASS = bundle.getString("dbPASS");
	private static final String FOR_NAME = bundle.getString("FOR_NAME");
	
	public static void addFavorite(String userId, String sys_id, ResultSetType bean) {
		//TODO addFav
	}
}
