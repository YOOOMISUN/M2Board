package Service;

import java.util.Map;


public interface IBoardService {
	// 반환값 = List<Board>, int lastPage 리턴
	Map<String, Object> getBoardList(int rowPerPage,int currentPage);
	
	int lastaPage(int rowPerPage);
	
	Map<String, Object> getBoardOne(int boardNo);
}
