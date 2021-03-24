<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="signup">
			<input type = "text" name="loginId" placeholder="아이디를 입력하세요">
			<input type = "text" name="loginPw" placeholder="패스워드를 입력하세요">
			<input type = "text" name="nickname" placeholder="닉네임를 입력하세요">
			<input type = "submit" value="회원가입">
		</form>
</body>
</html>