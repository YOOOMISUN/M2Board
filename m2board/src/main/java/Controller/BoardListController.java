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

@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private IBoardService boardService;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨트롤러 역할
		// 1. 요청 받아 분석
		int rowPerPage = 10;
		
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		// 2. 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조)를 구하기 위함
		boardService = new BoardService();
		Map<String,Object> map = boardService.getBoardList(rowPerPage, currentPage);
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("list", map.get("list"));
		request.setAttribute("currentPage", map.get("currentPage"));
		
		
		// 3. 뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
		
		
	}



}
