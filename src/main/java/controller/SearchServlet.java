package controller;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ReferenceApi;

/**
 * Servlet implementation class SearchServlet
 */

@WebServlet("/search")
public class SearchServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String searchText = (String) request.getParameter("searchText");
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		 
		String searchTextPage = searchText + page;
		
		var refApi = new ReferenceApi();
		
		if (null == request.getAttribute(searchTextPage)) {
			//searchTextとpageを投げて、データを受け取る
			var rsBean = refApi.getResultSetPageBean(searchText, page);
			//bean.getResultsCd()で分岐(0:成功、1:失敗)
			if (rsBean.getResultsCd().equals("0")) {
				//データをセッションに保存
				session.setAttribute(searchTextPage, rsBean);
				//検索結果へフォワード
				request.setAttribute("searchTextPage", searchTextPage);
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
			
			if (rsBean.getResultsCd().equals("1")) {
//				1の場合requestScopeにエラーデータを保存してフォワード
				request.setAttribute("errItem", rsBean.getErrList().getErrItem());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}else {
			//検索結果へフォワード
			request.setAttribute("searchTextPage", searchTextPage);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
//		検索結果1~25
//		HashMap<sys-id, bean>

		
		//リクエストの中身 検索内容、and/orラジオボタン
		if (true) {
			//and検索をして検索結果をHashMap< sys-id ,HashMap<String,String>  >    >      sessionに保存してfoward
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
