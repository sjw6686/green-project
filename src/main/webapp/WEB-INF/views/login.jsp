<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	h2{
		text-align: center;
	}
	.login{
		margin: 0 auto;
	    width: 250px;
	    height: 300px;
	    display: flex;
	    border: 1px solid #a9a9a9;
	    border-radius: 5px;
	    align-items: center;
	    justify-content: center;
	}
	form{
		text-align: center;
	}
	input{
		margin: 15px;
	}
</style>
</head>
<body>
	<h2>로그인</h2>
	<div class="login">
		<form action="/restaurant/user/loginProcess" method="post">
			<label>아이디입력</label><br>
			<input type="text" name="userId" value="admin1234" /><br>
			<label>비밀번호입력</label><br>
			<input type="password" name="userPw" value="qwer1234" /><br>
			<input type="submit" value="로그인" />
		</form>
	</div>
</body>
</html>