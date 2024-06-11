
package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 全てのリクエストに対する認証フィルター
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		
		// コンテキストパスとリクエストURIを取得
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI().substring(contextPath.length());
		
		// ログインとサインアップのURIを定義
		String loginURI = "/login";
		String loginJspURI = "/login.jsp";
		String signUpURI = "/signup";
		String signUpJspURI = "/signup.jsp";
		
		// ユーザーがログインしているか、もしくは未ログインでもアクセス可能なリクエスト
		// (ログイン、サインアップ、CSS、JS)の場合は、フィルターを通過させる
		boolean loggedIn = session != null && session.getAttribute("user_id") != null;
		boolean loginRequest = requestURI.equals(loginURI);
		boolean signUpRequest = requestURI.equals(signUpURI);
		boolean cssRequest = requestURI.endsWith(".css");
		boolean jsRequest = requestURI.endsWith(".js");
		
		//条件に合わなければログインページへフォワードする
		if (loggedIn || loginRequest || signUpRequest || cssRequest || jsRequest || requestURI.equals(loginJspURI) || requestURI.equals(signUpJspURI)) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "再度ログインしてください。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	// Add init and destroy methods if needed
}
