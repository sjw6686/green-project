<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/restaurant/owner/signUpProcess" method="post">
		아이디입력<br>
		<input type="text" name="ownerId" /><br>
		비밀번호입력<br>
		<input type="password" name="ownerPw" /><br>
		비밀번호확인<br>
		<input type="password" name="passwordConfirm" /><br>
		사업자번호입력<br>
		<input type="text" name="ownerNum" /><br>
		대표이름<br>
		<input type="text" name="ownerName" /><br>
		사업자 전화번호<br>
		<input type="text" name="ownerTel" /><br>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>