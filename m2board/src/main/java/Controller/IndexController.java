package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class IndexController extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {		// 로그인 안되어있는 상태
			System.out.println("로그인 안되어있는상태");
			response.sendRedirect(request.getContextPath() + "/LoginController");		// @WebServlet("/LoginController") 인 컨드롤러로..
			return;
		};
		
		request.setCharacterEncoding("utf-8");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}


}
