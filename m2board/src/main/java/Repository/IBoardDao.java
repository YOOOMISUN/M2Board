package Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import vo.Board;


public interface IBoardDao {
	List<Board> selectBoardListByPage(Connection conn,int rowPerPage, int beginRow) throws Exception;
	int selectBoardCnt(Connection conn, int rowPerPage) throws Exception;
	Map<String,Object> selectBoardOne(Connection conn, int boardNo) throws Exception;
}
