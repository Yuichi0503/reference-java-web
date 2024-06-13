package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.FavoritesDao;

/**
 * Servlet implementation class FavListServlet
 */
@WebServlet("/favlist")
public class FavListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavListServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザーIDと検索ワードを元に、favoritesテーブルからお気に入りを取得する
		var session = request.getSession();
		var user_id = (String)session.getAttribute("user_id");
		var searchText = request.getParameter("searchText");
		var favList = FavoritesDao.getFavListByUserId(user_id, searchText);
		
		//お気に入り一覧をリクエストにセット
		request.setAttribute("favList", favList);
		//お気に入り一覧ページにフォワード
		request.getRequestDispatcher("/favList.jsp").forward(request, response);
	}

}
