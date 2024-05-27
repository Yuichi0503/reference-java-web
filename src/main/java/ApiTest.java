import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
        Document doc = api.convertStringToXMLDocument(response);
        
        org.w3c.dom.Element root = doc.getDocumentElement();
        System.out.println("Root element :" + root.getNodeName());

	}
	
	String run(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}
	
	// Method to convert String to XML Document
	private org.w3c.dom.Document convertStringToXMLDocument(String xmlString)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xmlString));
		return builder.parse(is);
	}

}
