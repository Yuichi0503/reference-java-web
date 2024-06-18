package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.User_requestsDao;
import model.dao.UsersDao;

/**
 * Servlet implementation class VerificationServlet
 */
@WebServlet("/verify")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");

		String operation_type = User_requestsDao.getOperationTypeByToken(token);
		if (User_requestsDao.isValidToken(token) == false) {
			//対象のレコードを削除
			User_requestsDao.deleteByToken(token);
			request.setAttribute("msg", "不正なトークンもしくは<br>トークンの有効期限が切れています。"
					+ "<br>再度登録してください。");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else if (operation_type.equals("signup")) {
			//signup処理
			if (signUp(token) == false) {
				User_requestsDao.deleteByToken(token);
				request.setAttribute("msg", "本登録に失敗しました。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			User_requestsDao.deleteByToken(token);
			request.setAttribute("msg", "認証に成功しました。<br>ログインしてください。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//TODO change_email
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected boolean signUp(String token) throws ServletException, IOException {
		// entityを取得
		var entity = User_requestsDao.getEntityByToken(token);
		//UsersDaoでusersに追加
		return UsersDao.addEntity(entity);

	}

}
