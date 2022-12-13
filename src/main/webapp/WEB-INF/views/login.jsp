<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/restaurant/user/loginProcess" method="post">
		아이디입력<br>
		<input type="text" name="userId" value="owner1234" /><br>
		비밀번호입력<br>
		<input type="password" name="userPw" value="qwer1234" />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>