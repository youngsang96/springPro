package di03;

public class AuthFailLogger {
	private int threshold;
	private int failCounts;
	
	public void setThreshold(int threshold) {
		this.threshold=threshold;
	}
	
	public void insertBadPw(String userId, String inputPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s\n", userId, inputPw);
		failCounts++;
		if(threshold > 0 && failCounts > threshold) {
			System.out.println("너무 많은 로그인 시도 실패");
			failCounts = 0;
		}
	}
}
