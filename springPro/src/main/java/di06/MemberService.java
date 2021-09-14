package di06;

public interface MemberService {
	public void regist(Member member);
	public boolean update(String memberId, UpdateInfo info);
	public boolean delete(String id, String str);
}
