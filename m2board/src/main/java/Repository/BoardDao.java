package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.Board;

public class BoardDao implements IBoardDao {
	
	@Override	// 상세페이지
	public Map<String, Object> selectBoardOne(Connection conn, int boardNo) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		String sql = "SELECT board_no, board_title, board_writer, board_content, create_date, board_read, board_nice FROM board WHERE boardNo=?";
		PreparedStatement stmt= null;
		ResultSet rs = null;
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			map.put("boardNo", rs.getInt("board_no"));
			map.put("boardTitle", rs.getString("board_title"));
			map.put("boardWriter", rs.getString("board_writer"));
			map.put("boardContent", rs.getString("board_content"));
			map.put("createDate", rs.getString("create_date"));
			map.put("boardRead", rs.getString("board_read"));
			map.put("boardNice", rs.getString("board_nice"));
		}
		
		
		return map;
	}

	@Override	// 리스트
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {
		
		List<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no, board_title, board_writer, create_date, board_read, board_nice FROM board ORDER BY board_no LIMIT ?,?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));;
			board.setBoardWriter(rs.getString("board_writer"));
			board.setCreatDate(rs.getString("create_date"));
			board.setBoardRead(rs.getString("board_read"));
			board.setBoardNice(rs.getString("board_nice"));
			
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

	@Override	// 게시판리스트페이징
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

	@Override	// 게시판 추가
	public int insertBoard(Connection conn, Board board) throws Exception {
		
		String sql = "INSERT INTO board (board_title, board_writer, board_content, create_date) VALUES (?,?,?,NOW())";
		PreparedStatement stmt = null;
		int row = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, board.getBoardTitle());
			stmt.setString(2, board.getBoardWriter());
			stmt.setString(3, board.getBoardContent());
		
		// 디버깅
		System.out.println("board.getBoardTitle() : " + board.getBoardTitle());
		System.out.println("board.getBoardWriter() : " + board.getBoardWriter());
		System.out.println("board.getBoardContent() : " + board.getBoardContent());
		
		row = stmt.executeUpdate();
	
		} finally { 
			if(stmt!=null) { 
				stmt.close(); 
			}
		}
		
		
		return row;
	}

	@Override
	public int updateCnt(Connection conn, int boardNo) throws Exception {
		
		String sql="UPDATE board SET board_read=board_read+1 WHERE board_no=?";
		PreparedStatement stmt = null;
		int row = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			
			row = stmt.executeUpdate();
			
			// 디버깅
			System.out.println("row : " + row);
			
		} finally {
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		// 디버깅
		System.out.println("updateCnt >> " + row);
		
		
		return row;
	}
	
}
