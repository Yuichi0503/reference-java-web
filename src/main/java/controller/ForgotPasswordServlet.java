package controller;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.User_requestsDao;
import model.dao.UsersDao;
import model.entity.User_requestsEntity;
import model.service.EmailService;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgot_password")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//3600000ミリ秒 = 1時間
    private static final int EXPIRY_DURATION_IN_MILLISECONDS = 3600000;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forgot_password.jspからメールアドレスを受け取り認証メールを送信
		String email = request.getParameter("email");
		
		var entity = UsersDao.getEntityByEmail(email);
		
		//メールアドレスが登録されているか確認
		//登録されていない場合、エラーメッセージを送信
		if (entity == null) {
			request.setAttribute("msg", "このメールアドレスは登録されていません");
			request.getRequestDispatcher("/forgot_password.jsp").forward(request, response);
			return;
		}
		//登録されている場合、user_requestsに登録後、認証メールを送信
		else {
			
			var requestsEntity = createPassResetEntity(email);
			//user_requestsに保存
			User_requestsDao.addEntity(requestsEntity);
			
			//メール送信処理
			try {
				EmailService.sendVerificationEmail(email, requestsEntity.getToken()
						, getServletContext());
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", "登録されたメールアドレス宛に<br>"
					+ "パスワード再設定のためのリンクを送信しました");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//emailを引数にuser_requestsEntityを生成
	//token,operation_type,expiry,user_idを設定
	private User_requestsEntity createPassResetEntity(String email) {
		//user_idを取得
		var entity = UsersDao.getEntityByEmail(email);
		String user_id = entity.getUser_id();

		//entityに設定
		var user_requestsEntity = new User_requestsEntity();
		user_requestsEntity.setToken(UUID.randomUUID().toString());
		user_requestsEntity.setOperation_type("password_reset");
		user_requestsEntity.setExpiry(new java.sql.Timestamp(
				System.currentTimeMillis() + EXPIRY_DURATION_IN_MILLISECONDS));
		user_requestsEntity.setUser_id(user_id);
		return user_requestsEntity;
	}

}
