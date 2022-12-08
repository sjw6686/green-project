<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script>
		window.onload = function() {
		const form = document.querySelector('form')
			form.addEventListener('submit', function(e) {
				const p1 = document.getElementById('password1').value;
				const p2 = document.getElementById('password2').value;
				if(p1 != p2){
					alert("비밀번호가 일치하지 않습니다.");
					e.preventDefault()
					e.stopPropagation()
				}
				else{
					alert("회원가입이 완료되었습니다.");					
				}
		  	})
	  	}
	</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/restaurant/user/signUpProcess" method="post">
		아이디입력<br>
		<input type="text" name="userId" id="userid" /><br>
		비밀번호입력<br>
		<input type="password" name="userPw" id="password1" /><br>
		비밀번호확인<br>
		<input type="password" id="password2" /><br>
		전화번호<br>
		<input type="text" name="userTel" /><br>
		<input type="submit"  value="회원가입" />
	</form>
</body>
</html>