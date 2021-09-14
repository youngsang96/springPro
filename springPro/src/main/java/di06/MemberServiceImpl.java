package di06;

public class MemberServiceImpl implements MemberService {
	public void regist(Member member) {
		System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}
	
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update() 메서드 실행");
		return false;
	}
	
	public boolean delete(String id, String str) {
		System.out.println("MemberServiceImpl.delete() 메서드 실행");
		return false;
	}
}
