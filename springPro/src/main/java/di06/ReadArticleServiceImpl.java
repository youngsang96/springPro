package di06;

import org.springframework.stereotype.Service;


public class ReadArticleServiceImpl implements ReadArticleService{
	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException{
		System.out.println("getArticleAndeReadCnt(" + id+ ") 호출됨 --> joinPoint ");
		if(id==0) {
			throw new ArticleNotFoundException("id는 0이 안됨");
		}
		return new Article(id);
	}
}
