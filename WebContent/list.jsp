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
	<h1>�Խù� ����Ʈ</h1>
		<c:choose>
			<c:when test="${loginedMember==null }">
				<a href="loginForm.jsp">�α���</a>
				<a href="signupForm.jsp">ȸ������</a><br>
			</c:when>
			<c:otherwise>
				${loginedMember.nickname}�� �ݰ����ϴ�!
				<a href="article?action=logout">�α׾ƿ�</a><br>
			</c:otherwise>
		</c:choose>
		<br>
		<c:forEach items="${articles }" var ="article">
			<div>
				��ȣ : ${ article.id }<br>
				���� : <a href="article?action=detail&id=${article.id}">${ article.title }</a><br>
				<hr>
			</div>
		</c:forEach>
		<c:if test="${loginedMember!=null }">
			<a href="article?action=insertForm&mid=${loginedMember.id }">�۾���</a>
		</c:if>
</body>
</html>