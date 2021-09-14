package di01;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;
	public MemberRegisterService() {
		System.out.println("default construct");
	}
	public MemberRegisterService(MemberDao memberDao) {
		System.out.println("MemberRegisterService construct test");
		this.memberDao=memberDao;
	}
	public void regist() {
		System.out.println(memberDao.selectAll());
	}
	
	public void regist(RegisterRequest req) throws AlreadyMemberException {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyMemberException("email 중복" + req.getEmail());
		}
		Member newMember = new Member(null, req.getName(), req.getEmail(), req.getPassword(), new Date());
		memberDao.insert(newMember);
		System.out.println(newMember);
	}
}
