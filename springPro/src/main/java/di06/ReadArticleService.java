package di06;

public interface ReadArticleService {
	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException;
}
