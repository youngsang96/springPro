package di06;

public class Member {
	String memberId;
	String name;
	int age;
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId 
		+ ", name=" + name + ", age=" + age + "]";
	}
}
