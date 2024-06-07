package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.dao.UsersDao;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//オブジェクト生成
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//ログインチェック
		if (Login.loginCheck(email, password)) {
			var entity = UsersDao.getEntity(email);
			if (entity.isVerified() == true) {
				//ユーザ情報をセッションに保存
				session.setAttribute("user_id", entity.getUser_id());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				//認証が完了していない場合、認証を促す
				request.setAttribute("msg", "認証が完了していません。メールを確認してください。");
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			//失敗時、再入力を促す
			request.setAttribute("msg", "ログインに失敗しました。");
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
