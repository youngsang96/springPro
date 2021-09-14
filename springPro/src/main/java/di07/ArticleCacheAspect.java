package di07;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import di06.Article;

@Component
@Aspect
@Order(2)
public class ArticleCacheAspect {
private Map<Integer,Article> cache = new HashMap<Integer, Article>();
	@Around("execution(public * *..ReadArticleServiceImpl.*(..))")
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[ACA] cache before 실행");
		Integer id = (Integer)joinPoint.getArgs()[0];
		Article article = cache.get(id);
		
		if(article != null) {
			System.out.println("[ACA] cache에서 Article ["+id+"] 가져옴");
			return article;
		}
		Article ret = (Article)joinPoint.proceed();
		System.out.println("[ACA] cache after 실행");
		if(ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] cache에 Article ["+id+"] 객체를 추가함");
		}
		return ret;
	}
}
