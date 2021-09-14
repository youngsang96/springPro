package di01;

public class ChangePasswordService {
	private MemberDao memberDao;
	public ChangePasswordService() {
		System.out.println("default construct");
	}
	
	public ChangePasswordService(MemberDao memberDao) {
		System.out.println("ChangePasswordService construct test");
		this.memberDao = memberDao;
	}
	
	public MemberDao getDao() {
		return memberDao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPw,newPw);
		memberDao.update(member);
	}
}
