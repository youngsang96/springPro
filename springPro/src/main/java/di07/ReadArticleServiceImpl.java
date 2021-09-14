package di07;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import di06.Article;
import di06.ArticleNotFoundException;
import di06.ReadArticleService;

@Component("readArticleService")
public class ReadArticleServiceImpl implements ReadArticleService{
	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException{
		System.out.println("getArticleAndeReadCnt(" + id+ ") 호출됨 --> joinPoint ");
		if(id==0) {
			throw new ArticleNotFoundException("id는 0이 안됨");
		}
		return new Article(id);
	}
}
