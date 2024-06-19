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

		} 
		else if (operation_type.equals("signup")) {
			//signup処理
			if (signUp(token) == false) {
				User_requestsDao.deleteByToken(token);
				request.setAttribute("msg", "本登録に失敗しました。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			else {
				User_requestsDao.deleteByToken(token);
				request.setAttribute("msg", "認証に成功しました。<br>ログインしてください。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}
		else if (operation_type.equals("email_change")) {
			//change_email処理
			if (changeEmail(token) == false) {
				User_requestsDao.deleteByToken(token);
				request.setAttribute("msg", "メールアドレスの変更に失敗しました。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			else {
				User_requestsDao.deleteByToken(token);
				request.setAttribute("msg", "メールアドレスの変更に成功しました。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}
		else if (operation_type.equals("password_reset") ) {
			//password_reset処理
			var entity = User_requestsDao.getEntityByToken(token);
			UsersDao.updatePasswordAndSalt(entity.getUser_id(), entity.getNew_hashed_password(), entity.getNew_salt());
			
			//同じuser_idのoperatin_typeが"password_reset"のレコードを削除
			deletePasswordResetToken(token);
			
			//ログイン画面に遷移
			request.setAttribute("msg", "パスワードの変更に成功しました。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * usersDBに本登録
	 * @param token
	 * @return true or false
	 * @throws ServletException
	 * @throws IOException
	 */
	protected boolean signUp(String token) throws ServletException, IOException {
		// entityを取得
		var entity = User_requestsDao.getEntityByToken(token);
		//UsersDaoでusersに追加
		return UsersDao.addEntity(entity);

	}
	
	/**
	 * usersDBのemailを変更
	 * @param token
	 * @return true or false
	 */
	protected boolean changeEmail(String token) {
		// entityを取得
		var entity = User_requestsDao.getEntityByToken(token);
		//UsersDaoでemailを変更
		return UsersDao.updateEmail(entity.getUser_id(), entity.getNew_email());
	}
	
	//tokenを元に,同じuser_idのoperatin_typeが"password_reset"のレコードを削除
	protected void deletePasswordResetToken(String token) {
		var entity = User_requestsDao.getEntityByToken(token);
		User_requestsDao.deleteByUserIdAndOperationType(entity.getUser_id(), "password_reset");
	}

}
