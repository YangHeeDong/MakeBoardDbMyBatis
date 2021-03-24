<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
		번호 : ${article.id }<br>
		제목 : ${article.title }<br>
		내용 : ${article.body }<br>
		작성자 : ${article.nickname }<br>
		작성일 : ${article.regDate }<br>
		<c:if test="${loginedMember.id==article.mid }">
			<a href="article?action=updateForm&id=${article.id}">수정</a>
			<a href="article?action=delete&id=${article.id}">삭제</a><br>
		</c:if>
		<hr>
		댓글<hr>
		<c:forEach items = "${replies }" var="reply">
			${reply.nickname} : ${reply.body }<br>
			<c:choose>	
				<c:when test="${flag=='u' && rid==reply.id}">
					<form action="http://127.0.0.1:8080/article">
						<input type="text" name="body" value="${reply.body}"/>
						<input type="hidden" name="rid" value="${reply.id}"/>
						<input type="hidden" name="aid" value="${article.id}"/>
						<input type="hidden" name="action" value="doUpdateReply" />
						<input type="submit" value="수정" />
					</form>
				</c:when>
				<c:otherwise>
					<c:if test="${loginedMember.id==reply.mid }">
						<a href="article?action=showReply&rid=${reply.id}&aid=${article.id}">수정</a>
						<a href="article?action=deleteReply&rid=${reply.id}&aid=${article.id}">삭제</a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<hr>
		</c:forEach>
		<c:if test="${loginedMember!=null }">
			<form action="http://127.0.0.1:8080/article">
				<input type = "hidden" name="action" value="addReply">
				<input type = "hidden" name="aid" value="${article.id }">
				<input type = "hidden" name="mid" value="${loginedMember.id }">
				<input type = "text" name="body" placeholder="댓글을 등록해 보세요">
				<input type = "submit" value="등록">
			</form>
		</c:if>
</body>
</html>