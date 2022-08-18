package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.Board;

public class BoardDao implements IBoardDao {
	
	
	
	@Override
	public Map<String, Object> selectBoardOne(Connection conn, int boardNo) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		String sql = "SELECT boardNo, title, writer, content, create_date,read FROM board WHERE boardNo=?";
		PreparedStatement stmt= null;
		ResultSet rs = null;
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			map.put("boardNo", rs.getInt("boardNo"));
			map.put("", rs.getString(""));
			map.put("", rs.getString(""));
			map.put("", rs.getString(""));
			map.put("", rs.getString(""));
			map.put("", rs.getString(""));
			map.put("", rs.getString(""));
		}
		
		
		return map;
	}

	@Override
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {
		
		List<Board> list = new ArrayList<Board>();
		String sql = "SELECT boardNo, title, writer, create_date,read FROM board LIMIT ?,?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("boardNo"));
			board.setTitle(rs.getString("title"));;
			board.setWriter(rs.getString("writer"));
			board.setCreatDate(rs.getString("create_date"));
			board.setRead(rs.getString("read"));
			
			list.add(board);
		}
		
		if(rs!=null) {
			rs.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		
		return list;
		
	}	// end selectBoardListByPage

	@Override
	public int selectBoardCnt(Connection conn, int rowPerPage) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM board";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int lastPage = 0;
		int totalRow = 0;
		
		stmt = conn.prepareStatement(sql);
	    rs = stmt.executeQuery();
		
		 if(rs.next()) {
			 totalRow = rs.getInt("COUNT(*)");
	         }
		
		lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage != 0) {
				lastPage += 1;
			}
		 
		 // 디버깅
		 System.out.println("lastPage : " + lastPage);
		 
		 if(rs!=null)   {
				rs.close();
			}
		 if(stmt!=null)   {
				stmt.close();
			}
		 
		return lastPage;
	}
	
}
