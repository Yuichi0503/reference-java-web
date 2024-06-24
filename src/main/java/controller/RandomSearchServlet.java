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
 * Servlet implementation class RandomSearchServlet
 */
@WebServlet("/random_search")
public class RandomSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var session = request.getSession();
		
		//セッションからsys_idのリストを取得
        @SuppressWarnings("unchecked")
		List<String> favoriteSysIds = (List<String>) session.getAttribute("favoritesSysIds");
		if (favoriteSysIds == null) {
			// ユーザーIDを元にお気に入りのsys_idのリストを取得
			String user_id = (String) session.getAttribute("user_id");
			favoriteSysIds = FavoritesDao.getSysIdListByUserId(user_id);
		}
		// セッションスコープに保存
		session.setAttribute("favoriteSysIds", favoriteSysIds);
		
		//apiを使ってランダムなBeanを取得
		ReferenceApi api = new ReferenceApi();
		try {
			request.setAttribute("rsBean", api.getRandomBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
