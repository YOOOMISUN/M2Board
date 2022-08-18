package Controller;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boardService = new BoardService();
		
		
		
	}



}
