package di06;

public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(boolean result, String memberId, UpdateInfo info) {
		System.out.println("[TA] 정보 수정: 결과 = "+ result + ", 대상회원= " + memberId + ", 수정정보= " + info );
	}
}
