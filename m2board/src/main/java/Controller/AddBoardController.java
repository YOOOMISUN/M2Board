package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardService;
import Service.IBoardService;
import vo.Board;


@WebServlet("/AddBoard")
public class AddBoardController extends HttpServlet {
	private IBoardService boardService;
	
	// addBoardForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시판 글쓰기로
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addBoard.jsp");		
		rd.forward(request, response);
	}

	// addBoardAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		int addboard = 0;
		
		Board board = new Board();
		
		board.setBoardTitle(title);
		board.setBoardWriter(writer);
		board.setBoardContent(content);

		// 디버깅
		System.out.println("board" + board.toString());
		
		this.boardService = new BoardService();
		addboard = boardService.addBoard(board);
		
		if(addboard == 0) {
			System.out.println("게시판 게시 실패!");
			response.sendRedirect(request.getContextPath() + "/addBoard.jsp");
			return;
		} else {
			System.out.println("게시판 게시 성공!");
			response.sendRedirect(request.getContextPath()+"/boardList");
		}
		
		
		
	}

}
