package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.User_requestsDao;
import model.dao.UsersDao;
import model.service.EmailService;
import model.service.UsersService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String email = request.getParameter("email");
		
		if (isEmpty(user_name) || isEmpty(password) || isEmpty(confirm_password) || isEmpty(email)) {
	        handleError(request, response, "未入力の項目があります");
	        return;
	    }
	    if (!password.equals(confirm_password)) {
	        handleError(request, response, "パスワードが一致しません");
	        return;
	    }
	    if (UsersDao.getEntityByEmail(email) != null || User_requestsDao.getEntityByEmail(email) != null) {
	        handleError(request, response, "このメールアドレスは既に登録、<br>もしくは仮登録されています");
	        return;
	    }
		
		//ユーザーを作成
		var user = UsersService.createUser(user_name, password, email);
		//user_requestsに保存
		if (User_requestsDao.addEntity(user) == false) {
		    handleError(request, response, "登録に失敗しました");
		    return;
		}
		// エラーがなければ、認証メールを送信
		try {
		    EmailService.sendVerificationEmail(user, this.getServletContext());
		    // フォワード
		    request.setAttribute("msg", "認証メールを送信しました");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
		    e.printStackTrace();
		    handleError(request, response, "認証メールの送信に失敗しました");
		}
		
	}
	
	private boolean isEmpty(String str) {
	    return str == null || str.equals("");
	}

	private void handleError(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
	    request.setAttribute("msg", msg);
	    request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}
	

}
