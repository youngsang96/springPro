package di06;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArticleCacheAdvice {
	private Map<Integer,Article> cache = new HashMap<Integer, Article>();
	
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
