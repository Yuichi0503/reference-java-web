package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//index,検索文字列,ページをリクエストパラメーターから受け取り、リクエストスコープへ設定
		int index = Integer.parseInt(request.getParameter("index"));
		String searchText = request.getParameter("searchText");
		String page = request.getParameter("page");
		request.setAttribute("index", index);
		request.setAttribute("searchText", searchText);
		request.setAttribute("page", page );
		
		//検索文字列+pageでセッションからBeanを取得
		var rsBean = session.getAttribute(searchText + page);
		request.setAttribute("rsBean", rsBean);
		
		//detail.jspへフォワード
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
