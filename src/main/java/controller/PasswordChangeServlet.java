package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UsersDao;
import model.service.HashService;

/**
 * Servlet implementation class PasswordChangeServlet
 */
@WebServlet("/password_change")
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChangeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//password_change.jspからパラメーターを取得
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		
		//セッションからuser_idを取得
		String user_id = (String)request.getSession().getAttribute("user_id");
		
		//パスワードの確認
		if (password == null || !password.equals(confirm_password)) {
			request.setAttribute("msg", "パスワードが一致しません");
			request.getRequestDispatcher("/password_change.jsp").forward(request, response);
			return;
		}
		else {
			//パスワード変更処理
			var map = HashService.hashWithSalt(password);
			UsersDao.updatePasswordAndSalt(user_id, map.get("hash"), map.get("salt"));
			request.setAttribute("msg", "パスワードの変更に成功しました");
			request.getRequestDispatcher("/mypage.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
