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

        if (null == session.getAttribute(searchText + page)) {
            handleNewSearch(request, response, session, RESULT_NUM, searchText, page, refApi);
        } else {
            handleExistingSearch(request, response, session, RESULT_NUM, searchText, page);
        }
    }


    private void handleNewSearch(HttpServletRequest request, HttpServletResponse response, HttpSession session, int RESULT_NUM, String searchText, String page, ReferenceApi refApi) throws ServletException, IOException {
        var rsBean = refApi.getResultSetPageBean(searchText, page);
        if (rsBean.getResultsCd().equals("0")) {
            session.setAttribute(searchText + page, rsBean);
            int hit_num = Integer.parseInt(rsBean.getHitNum());
            int totalPages =(hit_num + RESULT_NUM - 1) /RESULT_NUM;
            session.setAttribute(searchText + "TotalPages", totalPages);
            setRequestAttributes(request, RESULT_NUM, searchText, page, rsBean);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }//エラー処理
        if (rsBean.getResultsCd().equals("1")) {
            request.setAttribute("errItem", rsBean.getErrList().getErrItem());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void handleExistingSearch(HttpServletRequest request, HttpServletResponse response, HttpSession session, int RESULT_NUM, String searchText, String page) throws ServletException, IOException {
        var rsBean = (ResultSetType)session.getAttribute(searchText + page);
        setRequestAttributes(request, RESULT_NUM, searchText, page, rsBean);
        String id = request.getAttribute("id") != null ? request.getAttribute("id").toString() : null;
        if (id != null) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void setRequestAttributes(HttpServletRequest request, int RESULT_NUM, String searchText, String page, ResultSetType rsBean) {
        request.setAttribute("stringSearchTextTotalPages", searchText + "TotalPages");
        request.setAttribute("RESULT_NUM", RESULT_NUM);
        request.setAttribute("searchText", searchText);
        request.setAttribute("page", Integer.parseInt(page));
        request.setAttribute("rsBean", rsBean);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
