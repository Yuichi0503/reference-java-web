package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ReferenceApi;
import model.dao.FavoritesDao;

/**
 * Servlet implementation class FavDetailServlet
 */
@WebServlet("/fav_detail")
public class FavDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//呼び出し元からuser_id,sys_idを受け取る
		var session = request.getSession();
		var user_id = (String)session.getAttribute("user_id");
		var sys_id = request.getParameter("sys_id");
		
		//sys_idを元にbeanを取得
		var api = new ReferenceApi();
		var bean = api.getBeanBySys_id(sys_id);
		
		//daoを呼び出しDBに登録/削除
		FavoritesDao.toggleFavorite(user_id, bean, 0);

		// お気に入りのsys_idリストを取得
		List<String> favoriteSysIds = FavoritesDao.getSysIdListByUserId(user_id);
		//セッションスコープに保存
		session.setAttribute("favoriteSysIds", favoriteSysIds);

		//登録/削除が成功したらdetail.jspに戻る
		request.setAttribute("rsBean", bean);
		request.setAttribute("index", 0);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
