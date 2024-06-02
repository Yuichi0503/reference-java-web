import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiTest2 {
	final static OkHttpClient client = new OkHttpClient();

	public static void main(String[] args) throws Exception {
		ApiTest2 api = new ApiTest2();
		
		//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20any%20 + searchText + page
		//		https://crd.ndl.go.jp/api/refsearch?type=reference&query=question%20all%20 + searchText + page
		//		検索結果取得位置	任意	results_get_position	int デフォルト1
		//		検索結果返却件数	任意	results_num	int デフォルト200
		String apiString = "https://crd.ndl.go.jp/api/refsearch?type=reference&results_num=5";
		String searchText = "&query=question%20any%20" + "Test";
		String page = "&results_get_position=" + "1";
		
//		String rootXml = api.run(apiString + searchText + page);
//		JSONObject json = XML.toJSONObject(rootXml); 
//		
//		Gson gson = new Gson();
//		ReferenceBean rfBean = gson.fromJson(json.toString(), ReferenceBean.class);
//		
//		System.out.println(rfBean.getResultSet().getResultsNum());
		
//		JSONObject result_set = (JSONObject) json.get("result_set");
//		JSONArray resultList = (JSONArray) result_set.get("result");
//		JSONObject result = (JSONObject)resultList.get(0);//0件目のresult
//		JSONObject reference = (JSONObject)result.get("reference");
//		JSONObject system = (JSONObject)reference.get("system");
//		System.out.println(result_set.get("hit_num"));
//		System.out.println(reference.get("reg-id"));
//		System.out.println(system.get("sys-id"));
		
		
//		System.out.println(json.toString(4));

	}

	String run(String url) {
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		    return "エラーが発生しました: " + e.getMessage();
		}
	}

}
