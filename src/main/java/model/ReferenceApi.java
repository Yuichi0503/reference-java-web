package model;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.net.URLCodec;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.bean.ResultSetType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReferenceApi {
	final static OkHttpClient client = new OkHttpClient();
	final static URLCodec codec = new URLCodec("UTF-8");
	
	public ResultSetType getResultSetPageBean(String searchText, String page) throws UnsupportedEncodingException, IOException{
		String apiString = "https://crd.ndl.go.jp/api/refsearch?type=reference";
		String results_num = "&results_num=" + "25";
		
		searchText = codec.encode(searchText, "UTF-8");
		
		searchText = "&query=question%20any%20" + searchText;
		page = "&results_get_position=" + page;
		
		String xmlString = getUrlResponse(apiString + searchText + page + results_num);
		
		try {
		    // JAXBContextインスタンスを作成
		    JAXBContext context = JAXBContext.newInstance(ResultSetType.class);

		    // Unmarshallerオブジェクトを作成
		    Unmarshaller unmarshaller = context.createUnmarshaller();

		    // StringReaderを使用してString型のXMLデータからJavaオブジェクトを生成
		    @SuppressWarnings("unchecked")
			JAXBElement<ResultSetType> jaxbElement = (JAXBElement<ResultSetType>) unmarshaller.unmarshal(new StringReader(xmlString));
		    ResultSetType bean = jaxbElement.getValue();

		    // ここでbeanを使用して何かを行う
		    // 例：bean.getResult()  List<ResultType>を返す
		    //     bean.getResult().get(i).getReference() i件目のreferenceを返す
//		    System.out.println(bean.getResultsCd());
//		    System.out.println(bean.getResult().get(1).getReference().getQuestionOrRegIdOrAnswer().get(0).getValue());
//		    System.out.println(bean.getResult().get(0).getReference().getQuestionOrRegIdOrAnswer().get(0).getValue());
		    return bean;

		} catch (JAXBException e) {
		    e.printStackTrace();
		}
		return null;
	}
	
	
	
	String getUrlResponse(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}


}
