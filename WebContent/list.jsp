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
	<h1>게시물 리스트</h1>
		<c:choose>
			<c:when test="${loginedMember==null }">
				<a href="loginForm.jsp">로그인</a>
				<a href="signupForm.jsp">회원가입</a><br>
			</c:when>
			<c:otherwise>
				${loginedMember.nickname}님 반갑습니다!
				<a href="article?action=logout">로그아웃</a><br>
			</c:otherwise>
		</c:choose>
		<br>
		<c:forEach items="${articles }" var ="article">
			<div>
				번호 : ${ article.id }<br>
				제목 : <a href="article?action=detail&id=${article.id}">${ article.title }</a><br>
				<hr>
			</div>
		</c:forEach>
		<c:if test="${loginedMember!=null }">
			<a href="article?action=insertForm&mid=${loginedMember.id }">글쓰기</a>
		</c:if>
</body>
</html>