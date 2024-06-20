package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.User_requestsDao;
import model.dao.UsersDao;
import model.service.HashService;


/**
 * Servlet implementation class AccountDelServlet
 */
@WebServlet("/account_del")
public class AccountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDelServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//account_del.jspからパスワードを受け取る
		String password = request.getParameter("password");
		//user_idを取得
		String user_id = (String) request.getSession().getAttribute("user_id");
		
		//user_idをキーにusersのentityを取得
		var entity = UsersDao.getEntityByUserId(user_id);
		
		//受けとったpasswordにsaltを追加してhash化
		var input_hash = HashService.hash(password + entity.getSalt());
		
		var msg = "";
		
		//hashが等しければ削除
		if(input_hash.equals(entity.getHashed_password())) {
            UsersDao.deleteUser(user_id);
            User_requestsDao.deleteUserRequests(user_id);
            request.getSession().invalidate();
            msg = "アカウントを削除しました";
			request.setAttribute("msg", msg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			//等しくなければaccount_del.jspにエラーメッセージを送る
			msg = "<br>パスワードが違います";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("account_del.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
