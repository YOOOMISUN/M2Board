package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Commons.DBUtil;
import Repository.IMemberDao;
import Repository.MemberDao;
import vo.Member;

public class MemberService implements IMemberService {
	private IMemberDao memberDao;
		
	@Override	// 로그인
	public Member getMemberLogin(Member paramMember) {
		
		Connection conn = null;
		Member member = new Member();
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			this.memberDao = new MemberDao();
			
			member = memberDao.selectMemberLogin(conn, paramMember);
			
			// 디버깅
			System.out.println("member : " + member);
			
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
		return member;
	}	// end getMemberLogin

	@Override	// 회원가입
	public int addMemberLogin(Member member) {
		
		Connection conn = null;
		int addMember = 0;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			this.memberDao = new MemberDao();
			addMember = memberDao.insertMember(conn, member);
			
			// 디버깅
			System.out.println("addMemberService : " + addMember);
			
			if(addMember == 0) {
				throw new Exception();
			}
			
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
		
		return addMember;
		
	}	// end addMemberLogin

	@Override
	public int removeMember(Member member) {

		Connection conn = null;
		int remove = 0;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			this.memberDao = new MemberDao();
			remove = memberDao.deleteMember(conn, member);
			
			// 디버깅
			System.out.println("removeMemberService : " + remove);
			
			if(remove == 0) {
				throw new Exception();
			}
			
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
		
		return remove;
	}

	@Override
	public int modifyMember(Member member) {
		
		Connection conn = null;
		int modifyMember = 0;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			this.memberDao = new MemberDao();
			modifyMember = memberDao.updateMember(conn, member);
			
			// 디버깅
			System.out.println("modifyMember : " + modifyMember);
			
			if(modifyMember == 0) {		// 값이 없으면 예외처리로
				throw new Exception();
			}
			
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
		
		return modifyMember;
	}
	
	

}
