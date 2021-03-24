package board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/article")
public class Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		ArticleDao adao = new ArticleDao();
		
		try {
			String action = request.getParameter("action");
			
			if(action !=null) {
				if(action.equals("list")) {
					ArrayList<Article> articles = adao.getAllArticles();
					request.setAttribute("articles", articles);
					RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
					rd.forward(request, response);
					
				}else if(action.equals("insert")) {
					String title = request.getParameter("title");
					String body = request.getParameter("body");
					int mid = Integer.parseInt(request.getParameter("mid"));
					adao.addArticle(title, body, mid);
					//리다이렉팅
					response.sendRedirect("article?action=list");
					
				}else if(action.equals("insertForm")) {
					int mid = Integer.parseInt(request.getParameter("mid"));
					request.setAttribute("mid", mid);
					RequestDispatcher rd = request.getRequestDispatcher("addForm.jsp");
					rd.forward(request, response);
					
				}
				else if(action.equals("updateForm")) {
					int ArticleId = Integer.parseInt(request.getParameter("id"));
					//포워딩
					Article article = adao.getArticleById(ArticleId);
					request.setAttribute("article", article);
					RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
					rd.forward(request, response);
					
				}else if(action.equals("update")) {
					String title = request.getParameter("title");
					String body = request.getParameter("body");
					int aid = Integer.parseInt(request.getParameter("aid"));
					
					adao.updateArticle(title, body, aid);
					
					response.sendRedirect("article?action=detail&id="+aid);
					
				}else if(action.equals("delete")) {
					int aid = Integer.parseInt(request.getParameter("id"));
					adao.deleteArticle(aid);
					adao.deleteArticleReply(aid);
					
					response.sendRedirect("article?action=list");
					
				}else if(action.equals("detail")) {
					int aid = Integer.parseInt(request.getParameter("id"));
					
					Article article = adao.getArticleById(aid);
					ArrayList<Reply> replies = adao.getReplies(aid);
					
					String flag = request.getParameter("flag");
					
					if(flag != null) {
						request.setAttribute("flag", flag);
						int rid = Integer.parseInt(request.getParameter("rid"));
						request.setAttribute("rid", rid );
					}
					
					request.setAttribute("replies", replies);
					request.setAttribute("article", article);
					RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
					rd.forward(request, response);
					
				}else if(action.equals("signup")) {
					String loginId = request.getParameter("loginId");
					String loginPw = request.getParameter("loginPw");
					String nickname = request.getParameter("nickname");
					
					adao.addMember(loginId, loginPw, nickname);
					
					response.sendRedirect("article?action=list");
					
				}else if(action.equals("login")) {
					String loginId = request.getParameter("loginId");
					String loginPw = request.getParameter("loginPw");
					
					Member loginedMember = adao.loginCheck(loginId, loginPw);
					
					if(loginedMember!=null) {
						HttpSession session = request.getSession();
						session.setAttribute("loginedMember", loginedMember);

						response.sendRedirect("article?action=list");
					}else {
						response.sendRedirect("loginError.jsp");
					}
				}else if(action.equals("logout")) {
					HttpSession session = request.getSession();
					session.invalidate();
					response.sendRedirect("article?action=list");
				}else if(action.equals("deleteReply")) {
					int aid = Integer.parseInt(request.getParameter("aid"));
					int id = Integer.parseInt(request.getParameter("rid"));
					adao.deleteReply(id);
					
					response.sendRedirect("article?action=detail&id="+aid);
				}else if(action.equals("addReply")) {
					String body = request.getParameter("body");
					int aid = Integer.parseInt(request.getParameter("aid"));
					int mid = Integer.parseInt(request.getParameter("mid"));
					adao.addReply(body,aid,mid);
					
					response.sendRedirect("article?action=detail&id="+aid);
					
				}else if(action.equals("showReply")) {
					int rid = Integer.parseInt(request.getParameter("rid"));
					int aid = Integer.parseInt(request.getParameter("aid"));
					
					response.sendRedirect("article?action=detail&flag=u&rid="+rid+"&id="+aid);
					
				}else if(action.equals("doUpdateReply")) {
					int rid = Integer.parseInt(request.getParameter("rid"));
					int aid = Integer.parseInt(request.getParameter("aid"));
					
					String body = request.getParameter("body");
					adao.doUpdateReply(body, rid);
					
					response.sendRedirect("article?action=detail&id="+aid);
				}
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
