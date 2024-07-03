package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ReferenceApi;
import model.bean.ResultSetType;
import model.dao.FavoritesDao;

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


		try {
			//detailがあれば詳細ページに遷移
			String detail = request.getParameter("detail");
			if(detail != null && detail.equals("true")) {
				goDetailPageBySysId(request, response);
			}
			//detailがなければ検索結果を表示
			else if (null == session.getAttribute(searchText + page)) {
				handleNewSearch(request, response, RESULT_NUM);
			} else {
				handleExistingSearch(request, response, RESULT_NUM);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


    /**
     * レファ協APIから検索結果を取得し、セッションスコープに保存後、フォワード
     * @param request
     * @param response
     * @param RESULT_NUM
     * @throws ServletException
     * @throws IOException
     */
    private void handleNewSearch(HttpServletRequest request, HttpServletResponse response
    		, int RESULT_NUM) throws ServletException, IOException {
    	var session = request.getSession();
        var refApi = new ReferenceApi();
        String searchText = request.getParameter("searchText");
        String page = request.getParameter("page");
        var rsBean = refApi.getResultSetPageBean(searchText, page);
        
        //成功時
        if (rsBean.getResultsCd().equals("0")) {
            session.setAttribute(searchText + page, rsBean);
            int hit_num = Integer.parseInt(rsBean.getHitNum());
            int totalPages =(hit_num + RESULT_NUM - 1) /RESULT_NUM;
            
            session.setAttribute(searchText + "TotalPages", totalPages);
            request.setAttribute("stringSearchTextTotalPages", searchText + "TotalPages");
            request.setAttribute("RESULT_NUM", RESULT_NUM);
            request.setAttribute("searchText", searchText);
            request.setAttribute("page", Integer.parseInt(page));
            request.setAttribute("rsBean", rsBean);            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
        //エラー時
        else if (rsBean.getResultsCd().equals("1")) {
            request.setAttribute("msg", rsBean.getErrList().getErrItem());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    /**
     * セッションスコープに保存された検索結果を取得し、フォワード
     * @param request
     * @param response
     * @param RESULT_NUM
     * @throws ServletException
     * @throws IOException
     */
    private void handleExistingSearch(HttpServletRequest request, HttpServletResponse response, int RESULT_NUM) throws ServletException, IOException {
    	var session = request.getSession();
    	String searchText = request.getParameter("searchText");
        String page = request.getParameter("page");
        
        var rsBean = (ResultSetType)session.getAttribute(searchText + page);
        request.setAttribute("stringSearchTextTotalPages", searchText + "TotalPages");
        request.setAttribute("RESULT_NUM", RESULT_NUM);
        request.setAttribute("searchText", searchText);
        request.setAttribute("page", Integer.parseInt(page));
        request.setAttribute("rsBean", rsBean);
        
        //お気に入り保存した後、元のページ位置に戻るための処理
        String id = request.getAttribute("id") != null ? request.getAttribute("id").toString() : null;
        if (id != null) {
            request.setAttribute("id", id);
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

	/**
	 * sys_idを元にbeanを取得し、リクエストスコープにセット後、detail.jspに遷移
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goDetailPageBySysId(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		var refApi = new ReferenceApi();
		var sys_id = request.getParameter("sys_id");
		var bean = refApi.getBeanBySys_id(sys_id);
		
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
