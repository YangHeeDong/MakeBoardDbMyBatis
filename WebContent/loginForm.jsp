<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="login">
			<input type = "text" name="loginId" placeholder="아이디를 입력하세요">
			<input type = "password" name="loginPw" placeholder="패스워드를 입력하세요">
			<input type = "submit" value="로그인">
		</form>
</body>
</html>