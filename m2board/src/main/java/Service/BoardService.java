package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Commons.DBUtil;
import Repository.BoardDao;
import Repository.IBoardDao;
import vo.Board;

public class BoardService implements IBoardService {
	private IBoardDao boardDao;

	
	
	@Override	// 상세페이지
	public Map<String, Object> getBoardOne(int boardNo) {
		
		Map<String,Object> map = new HashMap<>();
		
		 Connection conn = null;
		 this.boardDao = new BoardDao();
		 
		 try {
			 conn = new DBUtil().getConnection();
			 conn.setAutoCommit(false);
			 
			 map = boardDao.selectBoardOne(conn, boardNo);
			 
			 
		 } catch (Exception e) {
			 e.printStackTrace();
			 try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		 }finally {
			 try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		 }
		 
		 
		return map;
	}
	
	@Override	// 조회수
	public int BoardOneCnt(Board board) {
		
		Connection conn = null;
		this.boardDao = new BoardDao();
		int updateCnt = 0;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			updateCnt = boardDao.updateCnt(conn, updateCnt);
			
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateCnt;
	}
	
	

	@Override	// 리스트
	public Map<String,Object> getBoardList(int rowPerPage, int currentPage) {
		
		Map<String,Object> map = new HashMap<>();
		
		 Connection conn = null;
		 this.boardDao = new BoardDao();
		 
		 int beginRow = (currentPage-1)*rowPerPage;
		
		 try {
			 conn = new DBUtil().getConnection();
			 conn.setAutoCommit(false);
			 
			 map.put("list", boardDao.selectBoardListByPage(conn, rowPerPage, beginRow));
			 map.put("lastPage", boardDao.selectBoardCnt(conn, rowPerPage));

			
			 // 디버깅
			 System.out.println("map : " + map);
			
		 } catch (Exception e) {
			 e.printStackTrace();
			 try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		 }finally {
			 try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		 }
		 
		 
		return map;
	}	// end getBoardList
	
	@Override	// 페이징
	public int lastaPage(int rowPerPage) {
		Connection conn = null;
		this.boardDao = new BoardDao();
		
		try {
			conn=new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			rowPerPage = boardDao.selectBoardCnt(conn, rowPerPage);
			
			if(rowPerPage == 0) {			// 실패시 예외처리로..
				throw new Exception();
			}
			
		} catch(Exception e){
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowPerPage;
	}	// end lastaPage	

	@Override
	public int addBoard(Board board) {
		
		Connection conn = null;
		this.boardDao = new BoardDao();
		int addBoard = 0;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			addBoard = boardDao.insertBoard(conn, board);
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return addBoard;
	} 	// end addBoard


	
	
	
	
	
}
