<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Խù� �߰��ϱ�</h1>
		<form action="http://127.0.0.1:8080/article">
			<input type = "hidden" name="action" value="insert">
			<input type = "hidden" name="mid" value="${mid }">
			<input type = "text" name="title" placeholder="������ �Է��ϼ���">
			<input type = "text" name="body" placeholder="������ �Է��ϼ���">
			<input type = "submit" value="���">
		</form>
</body>
</html>