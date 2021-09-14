package di07;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
	final String publicMethod = "execution(public * di06.*Service.*(..))";
	@Before(publicMethod)
	public void before() {
		System.out.println("[LA]메서드 실행 전 전처리 수행함");
	}
	@AfterReturning(pointcut = publicMethod, returning="ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA]메서드 정상 처리 후 실행 / 리턴값: " + ret);
	}
	@AfterThrowing(pointcut = publicMethod, throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA]메서드 예외 발생 후 수행 / 예외: "+ ex.getMessage());
	}
	@After(publicMethod)
	public void afterFinally() {
		System.out.println("[LA]메서드 실행 후 후처리 수행");
	}
}
