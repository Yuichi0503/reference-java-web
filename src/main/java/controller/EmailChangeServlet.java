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
 * Servlet implementation class EmailChangeServlet
 */
@WebServlet("/email_change")
public class EmailChangeServlet extends HttpServlet {
	
	//3600000ミリ秒 = 1時間
    private static final int EXPIRY_DURATION_IN_MILLISECONDS = 3600000;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailChangeServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var session = request.getSession();
		//新しいEmailを取得
		String new_email = request.getParameter("new_email");
		String confirm_email = request.getParameter("confirm_email");
		
		//新しいEmailと確認用Emailが一致しているか確認
		if (new_email == null || new_email.equals(confirm_email) == false) {
			request.setAttribute("msg", "メールアドレスが一致しません");
			request.getRequestDispatcher("/mypage.jsp").forward(request, response);
			return;
		}
		
		//新規emailが、登録or仮登録されているemailと同じではないか確認
		if(UsersDao.getEntityByEmail(new_email) != null
				|| User_requestsDao.getEntityByEmail(new_email) != null) {
			request.setAttribute("msg", "このメールアドレスは<br>既に登録されています");
			request.getRequestDispatcher("/mypage.jsp").forward(request, response);
			return;
		}
		
		//entityに変換して、user_requestsに保存
		String user_id = (String)session.getAttribute("user_id");
		var entity = createEmailChangeEntity(user_id, new_email);
		User_requestsDao.addEntity(entity);
		
		//メール送信
		try {
			EmailService.sendVerificationEmail
			(new_email, entity.getToken(), getServletContext());
			// フォワード
		    request.setAttribute("msg", "認証メールを送信しました");
		    request.getRequestDispatcher("/mypage.jsp")
		    .forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// user_idとnew_emailを引数にして、entityを生成するメソッド
	private User_requestsEntity createEmailChangeEntity(String user_id, String new_email) {
		User_requestsEntity entity = new User_requestsEntity();
		entity.setOperation_type("email_change");
		entity.setToken(UUID.randomUUID().toString());
		entity.setUser_id(user_id);
		entity.setNew_email(new_email);
		//有効期限はEXPIRY_DURATION_IN_MILLISECONDS以内
		entity.setExpiry(new java.sql.Timestamp(
				System.currentTimeMillis() + EXPIRY_DURATION_IN_MILLISECONDS));

		return entity;
	}

}
