import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiTest {

	final static OkHttpClient client = new OkHttpClient();
	public static void main(String[] args) throws Exception {
		ApiTest api = new ApiTest();
		String response = api.run("https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20any%20%E8%AA%AD%E6%9B%B8");
//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20any%20 + searchText
//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20all%20 + searchText
//		検索結果取得位置	任意	results_get_position	int デフォルト1
//		検索結果返却件数	任意	results_num	int デフォルト200
        Document doc = api.convertStringToXMLDocument(response);
        Element result_set = doc.getDocumentElement();
        
        //resultタグ指定でNodelist取得
        NodeList results = result_set.getElementsByTagName("result");
        
        for (int i = 0; i < results.getLength(); i++) {
			//.item()でi件目のresultを取得
			Element result = (Element) results.item(i);
			//referenceタグ指定でElement取得
			Element reference = (Element) result.getElementsByTagName("reference").item(0);
			Element questioneElement = (Element) reference.getElementsByTagName("question").item(0);
			Element answereElement = (Element) reference.getElementsByTagName("answer").item(0);
			Element libNameeElement = (Element) reference.getElementsByTagName("lib-name").item(0);
			String question = questioneElement.getTextContent();
			String answer = answereElement.getTextContent();
			String libName = libNameeElement.getTextContent();
			System.out.println("質問：" + question);
			System.out.println("回答：" + answer);
			System.out.println("提供館：" + libName);
			System.out.println("------------------------------");
		}
        
	}
	
	String run(String url) {
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	// Method to convert String to XML Document
	private Document convertStringToXMLDocument(String xmlString)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xmlString));
		return builder.parse(is);
	}

}
