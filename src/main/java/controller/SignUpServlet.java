package controller;

import java.io.IOException;
import java.util.ResourceBundle;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UsersDao;
import model.entity.UsersEntity;
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
		
		if (isEmpty(user_name) || isEmpty(password) || isEmpty(confirm_password) || isEmpty(email)) {
	        handleError(request, response, "未入力の項目があります");
	        return;
	    }
	    if (!password.equals(confirm_password)) {
	        handleError(request, response, "パスワードが一致しません");
	        return;
	    }
	    if (UsersDao.getEntity(email) != null) {
	        handleError(request, response, "このメールアドレスは既に登録されています");
	        return;
	    }
		
		//ユーザーを作成
		var user = UsersService.createUser(user_name, password, email);
		//DBに保存
		if (UsersDao.addEntity(user) == false) {
		    handleError(request, response, "登録に失敗しました");
		    return;
		}
		// エラーがなければ、認証メールを送信
		try {
		    sendVerificationEmail(user, this.getServletContext());
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
	
	private Message sendVerificationEmail(UsersEntity user, ServletContext servletContext) throws Exception {
	    String verificationUrl = website + "/verify?token=" + user.getToken();
	    String message = "以下のアドレスにアクセスして認証を完了してください\n" + verificationUrl;

	    Gmail gmail = EmailService.getGmail(servletContext);
	    Gmail.Users gmailUsers = gmail.users();
	    Gmail.Users.Messages gmailMessages = gmailUsers.messages();

	    var mimeM = EmailService.createMimeMessage(user.getEmail(), "認証メール", message);
	    var content = EmailService.createMessage(mimeM);
	    var send = gmailMessages.send("me", content);
	    var mRes = send.execute();
	    return mRes;
	}

}
