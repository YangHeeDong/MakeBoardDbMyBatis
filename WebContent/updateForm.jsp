<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 수정</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="update">
			<input type = "hidden" name="aid" value="${article.id }">
			<input type = "text" name="title" value="${article.title }">
			<input type = "text" name="body" value="${article.body }">
			<input type = "submit" value="수정">
		</form>
</body>
</html>