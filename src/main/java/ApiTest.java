import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.bean.ResultSetType;
import model.bean.SystemType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiTest {

	final static OkHttpClient client = new OkHttpClient();
	public static void main(String[] args) throws Exception {
		ApiTest api = new ApiTest();
		//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20any%20 + searchText + page
		//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20all%20 + searchText + page
		//		検索結果取得位置	任意	results_get_position	int デフォルト1
		//		検索結果返却件数	任意	results_num	int デフォルト200
		String apiString = "https://crd.ndl.go.jp/api/refsearch?type=reference";
		String results_num = "&results_num=" + "5";
		String searchText = "&query=question%20any%20" + "Test";
		String page = "&results_get_position=" + "1";
		
		String response = api.run(apiString + searchText + page + results_num);
		
		try {
		    // JAXBContextインスタンスを作成
		    JAXBContext context = JAXBContext.newInstance(ResultSetType.class);

		    // Unmarshallerオブジェクトを作成
		    Unmarshaller unmarshaller = context.createUnmarshaller();

		    // String型のXMLデータ
		    String xmlString = response;

		    // StringReaderを使用してString型のXMLデータからJavaオブジェクトを生成
		    @SuppressWarnings("unchecked")
			JAXBElement<ResultSetType> jaxbElement = (JAXBElement<ResultSetType>) unmarshaller.unmarshal(new StringReader(xmlString));
		    ResultSetType bean = jaxbElement.getValue();

		    // ここでbeanを使用して何かを行う
		    // 例：bean.getResult()  List<ResultType>を返す
		    //     bean.getResult().get(i).getReference() i件目のreferenceを返す
//		    System.out.println(bean.getResultsCd());
//		    for (int i = 0; i < 11; i++) {
//				System.out.println(i + "番目" +
//						bean.getResult().get(0).getReference().getQuestionOrRegIdOrAnswer().get(i).getValue());
//			}
		    
		    var elements = bean.getResult().get(0).getReference();
//		    for (JAXBElement<?> element : elements) {
//		        // "?"という名前の要素を探す
//		        if ("question".equals(element.getName().getLocalPart())) {
//		            // answerの値を取得
//		            String answer = (String) element.getValue();
//		            // ここでanswerを使用
//		            System.out.println(answer);
//		        }
//		    }
		    
		    System.out.println(elements.refTypeObject("question"));
		    System.out.println(((SystemType)elements.refTypeObject("system")).getLibName());
		    System.out.println(elements.refTypeAllObjects("keyword"));
		    
//		    for (JAXBElement<?> element : elements) {
//		        // "system"という名前の要素を探す
//		        if ("system".equals(element.getName().getLocalPart())) {
////		        	Object value = element.getValue();
////		        	System.out.println(element.getName().getLocalPart());
//		            System.out.println(((SystemType)((Object)element.getValue())).getLibName());
//		        }
//		    }


		} catch (JAXBException e) {
		    e.printStackTrace();
		}
		
		
		
		
		
		
		
//		
//        Document doc = api.convertStringToXMLDocument(response);
//        Element result_set = doc.getDocumentElement();
////        
////      resultタグ指定でNodelist取得
//        NodeList results = result_set.getElementsByTagName("result");
        
//        for (int i = 0; i < results.getLength(); i++) {
			//.item()でi件目のresultを取得
//			Element result = (Element) results.item(0);
//			//referenceタグ指定でElement取得
//			Element reference = (Element) result.getElementsByTagName("reference").item(0);
//			String question =  reference.getElementsByTagName("question").item(0).getTextContent();
//			String answer = reference.getElementsByTagName("answer").item(0).getTextContent();
//			String libName = reference.getElementsByTagName("lib-name").item(0).getTextContent();
//			System.out.println("質問：" + question);
//			System.out.println("回答：" + answer);
//			System.out.println("提供館：" + libName);
//			System.out.println("------------------------------");
//		}
        
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
