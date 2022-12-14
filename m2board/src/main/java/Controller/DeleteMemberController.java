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

@WebServlet("/after/DeleteMember")
public class DeleteMemberController extends HttpServlet {
	private IMemberService memberService;
	
	// delete Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deleteMember.jsp");
		rd.forward(request, response);

	}

	// delete Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id  = request.getParameter("id");
		String pw =  request.getParameter("pw");
		Member member = new Member();
		int row = 0;
		
		memberService = new MemberService();
	
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		row = memberService.removeMember(member);
		
		if(row == 0) {
			System.out.println("탈퇴 실패!");
			response.sendRedirect(request.getContextPath() + "/after/index");
			return;
		} 
	

		System.out.println("탈퇴 성공!");
		 response.sendRedirect(request.getContextPath()+"/LoginController");
		

	}

}
