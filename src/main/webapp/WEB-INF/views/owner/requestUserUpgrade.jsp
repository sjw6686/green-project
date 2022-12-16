<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>등업신청</h2>
	<table border="1">
		<tr>
			<th>USER_ID</th>
			<th>USER_TEL</th>
			<th>JOIN_DATE</th>
			<th>USER_ROLE</th>
		</tr>
		<tr>
			<td>${userVo.userId}</td>
			<td>${userVo.userTel}</td>
			<td>${userVo.joinDate}</td>
			<td>${userVo.userRole}</td>
		</tr>
	</table>
	<form action="/restaurant/owner/requestUserUpgradeProcess" method="post">
		<label>사업자 번호입력</label>
		<input type="text" name="owner_num" placeholder = "사업자번호 입력" />
		<input type="hidden" name="user_id" value="${userVo.userId}" />
		<input type="submit" value="신청" />
	</form>
</body>
</html>