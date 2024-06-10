package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        // Find the user with this token in the database
       String userId = UsersDao.getUserIdByToken(token);
        if (userId != null) {
            // Verify the user
        	UsersDao.updateIsVerified(userId, true);
        	request.setAttribute("msg", "認証に成功しました。<br>ログインしてください。");
        	request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "認証に失敗しました。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
