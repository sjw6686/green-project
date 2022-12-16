<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>등업신청 목록</title>
</head>
<body>
	<h2>등업신청 목록</h2>
	<form action="userUpgradeProcess" method="post">
		<table border="1">
			<tr>
				<th>선택</th>
				<th>유저 아이디</th>
				<th>사업자번호</th>
			</tr>
			<c:forEach var="requestList" items="${requestList}">
				<tr>
					<td>
						<input type="checkbox" name="owner_idx" value="${requestList.ownerIdx}" />
						<input type="hidden" name="user_id" value="${requestList.userId}" />
					</td>
					<td>${requestList.userId}</td>
					<td>${requestList.ownerNum}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="submit" value="등업하기" />
		</div>
	</form>
</body>
</html>