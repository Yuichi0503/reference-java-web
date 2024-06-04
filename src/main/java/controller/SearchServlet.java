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
import model.bean.ResultSetType;

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
		final int RESULT_NUM = 25;
		String searchText = request.getParameter("searchText");
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		 
		var refApi = new ReferenceApi();
		
		//検索文字列+ページ番号の名前のBeanがセッションにない場合
		if (null == session.getAttribute(searchText + page)) {
			//searchTextとpageを投げて、データを受け取る
			var rsBean = refApi.getResultSetPageBean(searchText, page);
			//bean.getResultsCd()で分岐(0:成功、1:失敗)
			if (rsBean.getResultsCd().equals("0")) {
				//検索文字列+pageでBeanをセッションに保存
				session.setAttribute(searchText + page, rsBean);
				
				int hit_num = Integer.parseInt(rsBean.getHitNum());
				int totalPages =(hit_num + RESULT_NUM - 1) /RESULT_NUM;
				//検索文字列+TotalPagesの名前で総ページ数をセッションに保存
				session.setAttribute(searchText + "TotalPages", totalPages);
				
				//検索結果へフォワード
				request.setAttribute("stringTotalPages", searchText + "TotalPages");
				request.setAttribute("RESULT_NUM", RESULT_NUM);
				request.setAttribute("searchText", searchText);
				request.setAttribute("page", Integer.parseInt(page));
				request.setAttribute("rsBean", rsBean);
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
			
			if (rsBean.getResultsCd().equals("1")) {
//				1の場合requestScopeにエラーデータを保存してフォワード
				request.setAttribute("errItem", rsBean.getErrList().getErrItem());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}else {
			//検索文字列+ページ番号の名前のBeanがセッションにある場合
			var rsBean = (ResultSetType)session.getAttribute(searchText + page);
			
			//検索結果へフォワード
			request.setAttribute("stringTotalPages", searchText + "TotalPages");
			request.setAttribute("RESULT_NUM", RESULT_NUM);
			request.setAttribute("searchText", searchText);
			request.setAttribute("page", Integer.parseInt(page));
			request.setAttribute("rsBean", rsBean);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
