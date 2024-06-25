package model;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	final String RESULTS_NUM = "25";
	
	
	/**
     * レファ協APIからResultSetTypeオブジェクトを取得するメソッドです。
     * @param searchText レファ協APIで検索するテキスト。
     * @param page レファ協APIから取得するページ。
     * @return レファ協APIからの結果を含むResultSetTypeオブジェクト。
     * @throws UnsupportedEncodingException searchTextがエンコードできない場合にスローされます。
     * @throws IOException HTTPリクエストのエラーが発生した場合にスローされます。
     */
	public ResultSetType getResultSetPageBean(String searchText, String page) throws UnsupportedEncodingException, IOException{
		int pageInt = Integer.parseInt(page);
		searchText = codec.encode(searchText, "UTF-8");
		
		String position ;
		
		position = Integer.toString((pageInt - 1) * Integer.parseInt(RESULTS_NUM) + 1);
		
		String xmlString = getUrlResponse(
						  "https://crd.ndl.go.jp/api/refsearch?type=reference" 
						+ "&query=question%20any%20" + searchText 
						+ "&results_get_position=" + position
						+ "&results_num=" + RESULTS_NUM);
		
		try {
		    // JAXBContextインスタンスを作成
		    JAXBContext context = JAXBContext.newInstance(ResultSetType.class);

		    // Unmarshallerオブジェクトを作成
		    Unmarshaller unmarshaller = context.createUnmarshaller();

		    // StringReaderを使用してString型のXMLデータからJavaオブジェクトを生成
		    @SuppressWarnings("unchecked")
			JAXBElement<ResultSetType> jaxbElement = (JAXBElement<ResultSetType>) unmarshaller.unmarshal(new StringReader(xmlString));
		    ResultSetType bean = jaxbElement.getValue();
		    return bean;

		} catch (JAXBException e) {
		    e.printStackTrace();
		}
		return null;
	}
	public ResultSetType getRandomBean() throws UnsupportedEncodingException, IOException{
		String apiString = "https://crd.ndl.go.jp/api/refsearch?type=reference&sort=reg-date&sort_order=desc&results_num=1";
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		getRandomDate().format(formatter);
		
		String regDate = "&reg-date_to=" + getRandomDate().format(formatter);
		
		String xmlString = getUrlResponse(apiString + regDate);
		
		try {
			// JAXBContextインスタンスを作成
			JAXBContext context = JAXBContext.newInstance(ResultSetType.class);
			
			// Unmarshallerオブジェクトを作成
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// StringReaderを使用してString型のXMLデータからJavaオブジェクトを生成
			@SuppressWarnings("unchecked")
			JAXBElement<ResultSetType> jaxbElement = (JAXBElement<ResultSetType>) unmarshaller.unmarshal(new StringReader(xmlString));
			ResultSetType bean = jaxbElement.getValue();
			return bean;
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//2004年3月6日から今日までのランダムな日付を取得(XXXX-XX-XX)形式
	public LocalDate getRandomDate() {
		LocalDate start = LocalDate.of(2004, 3, 6);
		LocalDate end = LocalDate.now();
		long randomEpochDay = start.toEpochDay() + (long) (Math.random() * (end.toEpochDay() - start.toEpochDay()));
		return LocalDate.ofEpochDay(randomEpochDay);
	}
	
	
	/**
     * URLにGETリクエストを行い、レスポンスボディを文字列として返すメソッドです。
     * @param url GETリクエストを行うURL。
     * @return レスポンスボディを文字列として返します。
     * @throws IOException HTTPリクエストのエラーが発生した場合にスローされます。
     */
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


	/**
	 * 指定されたsys_idに基づいてBeanを取得します。
	 * 
	 * <p>このメソッドは、指定されたsys_idをクエリパラメータとしてAPIエンドポイントにGETリクエストを送信します。
	 * レスポンスとして返されたXMLデータをJavaオブジェクト（この場合はResultSetTypeオブジェクト）に変換し、
	 * そのオブジェクトを返します。</p>
	 *
	 * <p>このメソッドはJAXBExceptionとIOExceptionをキャッチします。これらの例外は、XMLのアンマーシャル（Javaオブジェクトへの変換）や
	 * HTTPリクエストの送信中に問題が発生した場合にスローされます。例外がキャッチされた場合、スタックトレースが出力され、メソッドはnullを返します。</p>
	 *
	 * @param sys_id Beanを取得するためのsys_id
	 * @return 指定されたsys_idに基づいて取得されたBean。問題が発生した場合はnull
	 */
	public ResultSetType getBeanBySys_id(String sys_id) {
		String apiString = "https://crd.ndl.go.jp/api/refsearch?type=reference";
		
		try {
			sys_id = codec.encode(sys_id, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String query = "&query=sys-id%20any%20" + sys_id;		
		
		try {
			String xmlString = getUrlResponse(apiString + query);
		    // JAXBContextインスタンスを作成
		    JAXBContext context = JAXBContext.newInstance(ResultSetType.class);

		    // Unmarshallerオブジェクトを作成
		    Unmarshaller unmarshaller = context.createUnmarshaller();

		    // StringReaderを使用してString型のXMLデータからJavaオブジェクトを生成
		    @SuppressWarnings("unchecked")
			JAXBElement<ResultSetType> jaxbElement = (JAXBElement<ResultSetType>) unmarshaller.unmarshal(new StringReader(xmlString));
		    ResultSetType bean = jaxbElement.getValue();
		    return bean;

		} catch (JAXBException | IOException e) {
		    e.printStackTrace();
		}
		
		return null;
	}


}
