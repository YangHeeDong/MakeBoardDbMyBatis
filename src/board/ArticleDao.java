package board;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.mapper.ArticleMapper;

public class ArticleDao {
	
	SqlSessionFactory sqlSessionFactory =null;
	
	//세션빌드
	public ArticleDao() throws IOException{
		String resource = "board/MyBatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	//리스트 얻기
	public ArrayList<Article> getAllArticles(){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		ArrayList<Article> articles = mapper.selectArticles();
		
		if(session!=null) {
			session.close();
		}
		
		return articles;
	}
	//게시물 추가
	public void addArticle(String title, String body, int mid) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Article param = new Article();
		param.setTitle(title);
		param.setBody(body);
		param.setMid(mid);
		
		mapper.addArticle(param);
		session.commit();
		
		if(session!=null) {
			session.close();
		}
	}
	//댓글 추가
	public void addReply(String body,int aid, int mid){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Reply param = new Reply();
		param.setBody(body);
		param.setAid(aid);
		param.setMid(mid);
		
		mapper.addReply(param);
		session.commit();
		
		if(session!=null) {
			session.close();
		}
	}
	// 댓글 수정
	public void doUpdateReply(String body, int rid){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Reply param = new Reply();
		param.setBody(body);
		param.setId(rid);
		
		mapper.doUpdateReply(param);
		session.commit();
		
		if(session!=null) {
			session.close();
		}

	}
	//게시물 수정
	public void updateArticle(String title, String body, int aid){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Article param = new Article();
		param.setTitle(title);
		param.setBody(body);
		param.setId(aid);
		
		mapper.updateArticle(param);
		session.commit();
		
		if(session!=null) {
			session.close();
		}
	}
	//게시물 삭제 메서드
	public void deleteArticle(int aid){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.deleteArticle(aid);
		session.commit();
		
		if(session!=null) {
			session.close();
		}
	}
	// 회원가입
	public void addMember(String id, String pw, String nick){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Member param = new Member();
		param.setLoginId(id);
		param.setLoginPw(pw);
		param.setNickname(nick);
		
		mapper.addMember(param);
		session.commit();
		
		if(session!=null) {
			session.close();
		}
	}
	//댓글삭제
	public void deleteReply(int rid){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.deleteReply(rid);
		
		session.commit();
		if(session!=null) {
			session.close();
		}
	}
	//게시물 삭제 될 때 게시물 속 댓글도 삭제
	public void deleteArticleReply(int aid) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.deleteArticleReply(aid);
		
		session.commit();
		if(session!=null) {
			session.close();
		}
	}
	//로그인
	public Member loginCheck(String id, String pw){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Member param = new Member();
		param.setLoginId(id);
		param.setLoginPw(pw);
		
		Member loginedMember = mapper.loginCheck(param);
		
		return loginedMember;
	}
	// 특정 게시물 가져오기
	public Article getArticleById(int aid){
		
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		Article articles = mapper.getArticleById(aid);
		
		return articles;
	}
	// 댓글 목록 가져오기
	public ArrayList<Reply> getReplies(int aid) throws ClassNotFoundException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		ArrayList<Reply> replies = mapper.getReplies(aid);
		
		return replies;
	}
}