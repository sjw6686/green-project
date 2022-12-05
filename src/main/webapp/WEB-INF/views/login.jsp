<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login</h2>
	<form action="/restaurant/owner/loginProcess" method="post">
		아이디입력<br>
		<input type="text" name="ownerId" /><br>
		비밀번호입력<br>
		<input type="password" name="ownerPw" />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>