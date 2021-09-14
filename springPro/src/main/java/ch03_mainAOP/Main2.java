package ch03_mainAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di06.Article;
import di06.ArticleNotFoundException;
import di06.Member;
import di06.MemberService;
import di06.MemberServiceImpl;
import di06.ReadArticleService;
import di06.UpdateInfo;

public class Main2 {
	public static void main(String[] args) {
		String[] config= {"ch03_AOPXmlAnno/di.xml","ch03_AOPXmlAnno/aop2.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		ReadArticleService service = ctx.getBean("readArticleService",ReadArticleService.class);
		
		try {
			Article a1 = service.getArticleAndReadCnt(1);
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main] a1 == a2" + (a1==a2));
			service.getArticleAndReadCnt(0);
		}catch(ArticleNotFoundException e) {
			System.out.println("[main] " + e.getMessage());
		}
		System.out.println();
		System.out.println("===== updateMemberInfoTrace Aspect");
		MemberService memberService = ctx.getBean("memberService", MemberService.class);
		memberService.regist(new Member());
		memberService.update("hong", new UpdateInfo());
		memberService.delete("hong2", "test");
	}
}
