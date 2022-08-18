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


@WebServlet("/AddMember")
public class AddMemberController extends HttpServlet {
	private IMemberService memberService;
	
	// addMemberForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember") != null) {	// 로그인 되어있는 상태
			System.out.println("로그인 되어있는 상태");
			response.sendRedirect(request.getContextPath() + "/LoginController");		// @WebServlet("/LoginController") 인 컨드롤러로..
			return;
		};
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addMember.jsp");		// 회원가입 폼으로
		rd.forward(request, response);
		
		
	}

	// addMemberAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember") != null) {	// 로그인 되어있는 상태
			System.out.println("로그인 되어있는 상태");
			response.sendRedirect(request.getContextPath() + "/LoginController");		// @WebServlet("/LoginController") 인 컨드롤러로..
			return;
		};
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));       
		String gender = request.getParameter("gender");
		String updateDate = request.getParameter("updateDate");
		String createDate = request.getParameter("createDate");
		
		// 디버깅
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("gender : " + gender);
		
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberAge(age);
		member.setMemberGender(gender);
		member.setUpdateDate(updateDate);
		member.setCreateDate(createDate);
		
		// 디버깅
		System.out.println("member : " + member);
		
		this.memberService = new MemberService();
		int row =  memberService.addMemberLogin(member);
		
		if(row == 0) {
			System.out.println("회원가입실패!");
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		} else {
			System.out.println("회원가입성공!");
			response.sendRedirect(request.getContextPath()+"/LoginController");
		}
		
		
		
	}

}
