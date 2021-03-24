package board.mapper;

import java.util.ArrayList;

import board.Article;
import board.Member;
import board.Reply;

public interface ArticleMapper {

	ArrayList<Article> selectArticles();
	Article getArticleById(int aid);
	public void addArticle(Article param);
	public void updateArticle(Article param);
	public void deleteArticle(int aid);
	public void deleteArticleReply(int aid);
	
	Member loginCheck(Member param);
	public void addMember(Member param);
	
	ArrayList<Reply> getReplies(int aid);
	public void addReply(Reply param);
	public void doUpdateReply(Reply param);
	public void deleteReply(int rid);

}