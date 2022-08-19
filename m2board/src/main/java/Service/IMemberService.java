package Service;

import vo.Member;

public interface IMemberService {
	
	Member getMemberLogin(Member paramMember);
	
	int addMemberLogin(Member member);
	
	int removeMember(Member member);
	
	int modifyMember(Member member);
	
}
