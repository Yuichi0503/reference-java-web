package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.ResultSetType;
import model.dao.FavoritesDao;

/**
 * Servlet implementation class FavServlet
 */
@WebServlet("/fav")
public class FavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//呼び出し元からuser_idとbeanとsearchTextとpageおよびindexを受け取る
		var session = request.getSession();
		var user_id = (String)session.getAttribute("user_id");
		var searchText = request.getParameter("searchText");
		var page = request.getParameter("page");
		var index = Integer.parseInt(request.getParameter("index") );
		var bean = (ResultSetType)session.getAttribute(searchText + page);
		//daoを呼び出しDBに登録/削除
		FavoritesDao.toggleFavorite(user_id, bean, index);
		//登録/削除が成功したらresult.jspに戻る
		
		// ユーザーIDを元にお気に入りのsys_idのリストを取得
		List<String> favoriteSysIds = FavoritesDao.getSysIdListByUserId(user_id);
		
		//セッションスコープに保存
		session.setAttribute("favoriteSysIds", favoriteSysIds);
		
		request.setAttribute("id", index);
		request.getRequestDispatcher("/search").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
