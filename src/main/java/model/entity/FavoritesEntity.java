package model.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.ReferenceApi;
import model.bean.ResultSetType;

public class FavoritesEntity {
	
	//メインメソッド
	public static void main(String[] args) {
		new FavoritesEntity().test();
	}
	
	//TODO FavEntity beanをシリアライズ
	public void test() {
		
		var bean = new ReferenceApi().getBeanBySys_id("1000205483 1000113444");
	    String json = serializeWithJackson(bean);
	    System.out.println(json);
//	    ResultSetType bean2 = deserializeWithJackson(json);
//	    System.out.println(bean2);
	}
	
	public void serializeBean(Object bean, String filePath) {
	    try (FileOutputStream fileOut = new FileOutputStream(filePath);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	        out.writeObject(bean);
	        System.out.println("Serialized data is saved in " + filePath);
	    } catch (IOException i) {
	        i.printStackTrace();
	    }
	}
	public ResultSetType deserializeBean(String filePath) {
	    Object bean = null;
	    try (FileInputStream fileIn = new FileInputStream(filePath);
	         ObjectInputStream in = new ObjectInputStream(fileIn)) {
	        bean = in.readObject();
	        System.out.println("Deserialized data is read from " + filePath);
	    } catch (IOException i) {
	        i.printStackTrace();
	    } catch (ClassNotFoundException c) {
	        System.out.println("Class not found");
	        c.printStackTrace();
	    }
	    return (ResultSetType) bean ;
	}
	public String serializeWithGson(Object object) {
	    Gson gson = new Gson();
	    String json = gson.toJson(object);
	    return json;
	}
	public String serializeWithJackson(Object object) {
	    ObjectMapper mapper = new ObjectMapper();
	    String json = "";
	    try {
	        json = mapper.writeValueAsString(object);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return json;
	}
	
	public ResultSetType deserializeWithJackson(String json) {
	    ObjectMapper mapper = new ObjectMapper();
	    ResultSetType bean = null;
	    try {
	        bean = mapper.readValue(json, ResultSetType.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bean;
	}
}
