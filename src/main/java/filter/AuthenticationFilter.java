
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

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		String requestURI = request.getRequestURI().substring(request.getContextPath().length());

		boolean loggedIn = session != null && session.getAttribute("user_id") != null;
		boolean isAllowedRequest = isAllowedRequest(requestURI);

		if (loggedIn || isAllowedRequest) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "再度ログインしてください。");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	private boolean isAllowedRequest(String requestURI) {
		return requestURI.equals("/login") || requestURI.equals("/signup") || requestURI.endsWith(".css")
				|| requestURI.endsWith(".js") || requestURI.equals("/login.jsp") || requestURI.equals("/signup.jsp")
				|| requestURI.equals("/verify") || requestURI.equals("/forgot_password")
				|| requestURI.equals("/forgot_password.jsp");
	}

	// Add init and destroy methods if needed
}
