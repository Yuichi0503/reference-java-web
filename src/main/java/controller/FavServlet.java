package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ReferenceApi;

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
		//result.jspからsys_idを受け取る
		String sys_id = request.getParameter("sys_id");
		//TODO sys_idを元にBeanを取得
		var bean =new ReferenceApi().getBeanBySys_id(sys_id);
		//sessionのuser_idとsys_idおよびbeanをDBに登録
		//登録成功したらresult.jspに戻る
		//登録失敗したらエラーページに飛ばす
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
