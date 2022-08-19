package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardService;
import Service.IBoardService;


@WebServlet("/BoardOneController")
public class BoardOneController extends HttpServlet {
	private IBoardService boardService;

	@Override	// 상세페이지 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.boardService = new BoardService();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));   
		Map<String,Object> map = boardService.getBoardOne(boardNo);
		
		if(map != null) {
			System.out.println("성공");
			response.sendRedirect(request.getContextPath() + "/boardOne.jsp");	
		} else {
			System.out.println("실패");
			response.sendRedirect(request.getContextPath() + "/boardList.jsp");	
		}
	}

	@Override	// 조회수 up
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.boardService = new BoardService();

		
	}


}
