package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao implements IMemberDao{

	@Override	// 로그인
	public Member selectMemberLogin(Connection conn, Member paramMember) throws Exception {
		String sql = "SELECT member_id,member_pw,member_name,member_age,member_gender,update_date, create_date FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member memberLogin = null;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramMember.getMemberId());
		stmt.setString(2, paramMember.getMemberPw());
		 
		rs = stmt.executeQuery();
		
		try {
			if(rs.next()) {
				memberLogin = new Member();
				memberLogin.setMemberId(rs.getString("member_id"));
				memberLogin.setMemberPw(rs.getString("member_pw"));
				memberLogin.setMemberName(rs.getString("member_name"));
				memberLogin.setMemberAge(rs.getInt("member_age"));
				memberLogin.setMemberGender(rs.getString("member_gender"));
				memberLogin.setUpdateDate(rs.getString("update_date"));
				memberLogin.setCreateDate(rs.getString("create_date"));
			}
		
		// 디버깅
		System.out.println("memberLogin : " + memberLogin);
			
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		// 디버깅
		System.out.println("memberLogin : " + memberLogin);
			
		
		return memberLogin;
	}

	@Override	// 회원추가
	public int insertMember(Connection conn, Member member) throws Exception {
		
		String sql = "INSERT INTO member (member_id,member_pw,member_name,member_age,member_gender,update_date, create_date ) VALUES (?,PASSWORD(?),?,?,?,NOW(),NOW())";
		PreparedStatement stmt = null;
		int row = 0;
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		stmt.setInt(4, member.getMemberAge());
		stmt.setString(5, member.getMemberGender());
		
		row = stmt.executeUpdate();
		
		// 디버깅
		System.out.println("row : " + row);
		
		if(stmt!=null) {
			stmt.close();
		}
		
		
		return row;
	}

	@Override	// 회원 탈퇴
	public int deleteMember(Connection conn, Member member) throws Exception {
		
		String sql = "DELETE FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		int row = 0;
		
		row = stmt.executeUpdate();
		
		// 디버깅
		System.out.println("row : " + row);
		
		if(stmt!=null) {
			stmt.close();
		}
		
		return row;
	}

	@Override	// 회원 정보 수정
	public int updateMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "UPDATE member SET member_name=?, member_age=?, member_gender=?, update_date=NOW() WHERE member_id=? AND member_pw=PASSWORD(?)";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberName());
			stmt.setInt(2, member.getMemberAge());
			stmt.setString(3, member.getMemberGender());
			stmt.setString(4, member.getMemberId());
			stmt.setString(5, member.getMemberPw());
			
			
			row = stmt.executeUpdate();
		} finally {
			if(stmt!=null) {
				stmt.close();
			}
		}

		System.out.println("row >> " + row);		
		return row;
	}


	
}
