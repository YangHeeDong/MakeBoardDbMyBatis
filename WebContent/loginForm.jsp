<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α���</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="login">
			<input type = "text" name="loginId" placeholder="���̵� �Է��ϼ���">
			<input type = "password" name="loginPw" placeholder="�н����带 �Է��ϼ���">
			<input type = "submit" value="�α���">
		</form>
</body>
</html>