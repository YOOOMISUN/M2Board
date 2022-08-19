package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.IMemberService;
import Service.MemberService;
import vo.Member;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private IMemberService memberService;

	
	// login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 디버깅
		System.out.println("session : " + session.getAttribute("loginMemberId"));
		
		if(session.getAttribute("loginMember") != null) {	// 로그인 되어있는 상태
			System.out.println("로그인 되어있는 상태");
			response.sendRedirect(request.getContextPath() + "/index");		// @WebServlet("/index") 인 컨드롤러로..
			return;
		};
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		rd.forward(request, response);
		
	}

	
	
	// login Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember") != null) {	// 로그인 되어있는 상태	
			System.out.println("로그인 되어있는 상태");
			response.sendRedirect(request.getContextPath() + "/index");		// @WebServlet("/index") 인 컨드롤러로..
			return;
		};
		
		request.setCharacterEncoding("utf-8");
		String id  = request.getParameter("id");
		String pw =  request.getParameter("pw");
		Member paramMember = new Member();
		
		memberService = new MemberService();
	
		paramMember.setMemberId(id);
		paramMember.setMemberPw(pw);
		
		Member member = memberService.getMemberLogin(paramMember);
		
		System.out.println("member : " + member);
		
		
		if(member == null) {
			System.out.println("로그인 실패!");
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		} 
		

		session.setAttribute("loginMember", member);
		
		// 디버깅
		System.out.println("member >> " + member.toString());
		
		System.out.println("로그인 성공");
		 response.sendRedirect(request.getContextPath()+"/index");
		
		}
		
		
}
