<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 추가하기</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="insert">
			<input type = "hidden" name="mid" value="${mid }">
			<input type = "text" name="title" placeholder="제목을 입력하세요">
			<input type = "text" name="body" placeholder="내용을 입력하세요">
			<input type = "submit" value="등록">
		</form>
</body>
</html>