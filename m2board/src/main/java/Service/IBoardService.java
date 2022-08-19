package Service;

import java.util.Map;

import vo.Board;


public interface IBoardService {
	// 반환값 = List<Board>, int lastPage 리턴
	Map<String, Object> getBoardList(int rowPerPage,int currentPage);
	
	int lastaPage(int rowPerPage);
	
	Map<String, Object> getBoardOne(int boardNo);
	
	int addBoard(Board board);
	
	int BoardOneCnt(Board board);
}
