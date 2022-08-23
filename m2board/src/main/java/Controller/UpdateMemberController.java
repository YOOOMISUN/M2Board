package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IMemberService;
import Service.MemberService;
import vo.Member;


@WebServlet("/after/UpdateMember")
public class UpdateMemberController extends HttpServlet {
	private IMemberService memberService;


	// updateForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateMember.jsp");
		rd.forward(request, response);
		
	}

	// updateAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));       
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String detailAddr = request.getParameter("detailAddr");
		
		// 디버깅
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("gender : " + gender);
		System.out.println("address : " + addr);
		System.out.println("detailAddr : " + detailAddr);
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberAge(age);
		member.setMemberGender(gender);
		member.setMemberAddress(addr);
		member.setMemberDetailAddr(detailAddr);
		
		// 디버깅
		System.out.println("member : " + member.toString());
		
		int row = 0;
		
		this.memberService = new MemberService();
		row =  memberService.modifyMember(member);
		
		if(row == 0) {
			System.out.println("수정 실패!");
			response.sendRedirect(request.getContextPath() + "/after/UpdateMember");
			return;
		} else {
			System.out.println("수정 성공!");
			request.getSession().removeAttribute("loginMember");			// 세션삭제
			request.getSession().setAttribute("loginMember", member);	// 세션 다시 넣기
			
			response.sendRedirect(request.getContextPath()+"/after/index");
		}
	}

}
