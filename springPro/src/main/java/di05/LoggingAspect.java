package di05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	//joinpoint : 호출되는 메서드의 실행 순서를 저장하는 객체
	public Object logging(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("[LA]로그 시작");
		StopWatch sw = new StopWatch();
		sw.start();
		Object ret = joinpoint.proceed(); //다음 메서드 호출
		sw.stop();
		System.out.println("[LA]메서드 실행시간: " + sw.getTotalTimeMillis() + "밀리초");
		return ret;
	}
}
