package controller;

import java.io.IOException;
import java.util.List;

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
        var session = request.getSession();
        var user_id = (String)session.getAttribute("user_id");

        if (request.getParameter("favDelete") != null) {
            deleteFavorite(request, response, user_id);
        } 
        
        displayFavorites(request, response, user_id);
        
        request.getRequestDispatcher("/favList.jsp").forward(request, response);
    }

    private void deleteFavorite(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException {
        try {
            var sys_id = request.getParameter("sys_id");
            FavoritesDao.deleteFavorite(user_id, sys_id);
            
            // ユーザーIDを元にお気に入りのsys_idのリストを取得
    		List<String> favoriteSysIds = FavoritesDao.getSysIdListByUserId(user_id);
    		
    		//セッションスコープに保存
    		var session = request.getSession();
    		session.setAttribute("favoriteSysIds", favoriteSysIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayFavorites(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException {
        try {
            var searchText = request.getParameter("searchText");//nullの場合は全件取得
            var favList = FavoritesDao.getFavListByUserId(user_id, searchText);
            request.setAttribute("favList", favList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
