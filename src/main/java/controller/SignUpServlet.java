package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UsersDao;
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
		
		if (user_name == null || password == null 
				|| confirm_password == null || email == null
				|| user_name.equals("") || password.equals("") 
				|| confirm_password.equals("") || email.equals("")) {
			//エラー処理
			String msg = "未入力の項目があります";
			request.setAttribute("msg", msg);
			//フォワード
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		if (password.equals(confirm_password) == false) {
			//エラー処理
			String msg = "パスワードが一致しません";
			request.setAttribute("msg", msg);
			//フォワード
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		
		//ユーザーを作成
		var user = UsersService.createUser(user_name, password, email);
		
		//DBに保存
		if (UsersDao.addEntity(user) == false) {
			//エラー処理
			String msg = "登録に失敗しました";
			request.setAttribute("msg", msg);
			//フォワード
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		//メールを送信
		String website = "http://localhost:8080/reference-java-web";
		//TODO
		//String verificationUrl = "website + /verify?token=" + user.getToken();
        //String message = "以下のリンクをクリックして認証を完了してください\n" + verificationUrl;
		//sendEmail(user.getEmail(), verificationUrl);
		//フォワード
		
	}

}
