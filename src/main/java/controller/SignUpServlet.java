package controller;

import java.io.IOException;
import java.util.ResourceBundle;

import com.google.api.services.gmail.Gmail;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UsersDao;
import model.service.EmailService;
import model.service.UsersService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final ResourceBundle bundle = ResourceBundle.getBundle("appConfig");
	private static final String website = bundle.getString("website");
	
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
		//エラーがなければ、認証メールを送信
		ServletContext servletContext = this.getServletContext();
		String verificationUrl = website + "/verify?token=" + user.getToken();
		String message = "以下のアドレスにアクセスして認証を完了してください\n" + verificationUrl;
		try {
			Gmail gmail = EmailService.getGmail(servletContext);
			Gmail.Users gmailUsers = gmail.users();
			Gmail.Users.Messages gmailMessages = gmailUsers.messages();

			var mimeM = EmailService.createMimeMessage(user.getEmail(), "認証メール", message);
			var content = EmailService.createMessage(mimeM);
			var send = gmailMessages.send("me", content);
			var mRes = send.execute();
			System.out.println(mRes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//フォワード
		request.setAttribute("msg", "認証メールを送信しました");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
