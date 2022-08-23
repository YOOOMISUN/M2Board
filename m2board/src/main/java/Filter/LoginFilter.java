package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/after/*")
public class LoginFilter extends HttpFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(request instanceof HttpServletRequest == true) {
			HttpSession session = ((HttpServletRequest)request).getSession();
			if(session.getAttribute("loginMember") == null) {	// 세션값이 null이면 /begin/login 로 보냄
				if(response instanceof HttpServletResponse == true) {
					System.out.println("잘못된 접근");
					((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/LoginController");
				}
				return;
			}
		} else {
			System.out.println("잘못된 요청");
		}
		
		chain.doFilter(request, response);
	}


}
