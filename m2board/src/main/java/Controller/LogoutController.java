package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/after/Logout")
public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃 : 기존의 세션을 지우고 새로운 세션을 줌 
		request.getSession().invalidate();			// 기존 세셩영역을 지우고 새로운 세션을 부여
		response.sendRedirect(request.getContextPath() + "/LoginController");

	}




}
