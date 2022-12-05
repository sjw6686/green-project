<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList</title>
</head>
<body>
	<h2>userList</h2>
	<c:forEach var="user" items="${ userList }">
		<ul>
	      	<li>${ user.userId}</li>
	      	<li>${ user.userPw}</li>
			<li>${ user.userTel}</li>
			<li>${ user.joinDate}</li>
			<li>${ user.userState}</li>
			<li>${ user.likeRestaurant}</li>
			<li>${ user.userRole}</li>
	    </ul>
    </c:forEach>
</body>
</html>