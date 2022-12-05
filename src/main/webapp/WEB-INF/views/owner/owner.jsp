<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>userList</h2>
	<c:forEach var="owner" items="${ ownerList }">
		<ul>
	      	<li>${ owner.ownerId}</li>
	      	<li>${ owner.ownerNum}</li>
			<li>${ owner.ownerPw}</li>
			<li>${ owner.ownerName}</li>
			<li>${ owner.ownerTel}</li>
			<li>${ owner.ownerEnable}</li>
			<li>${ owner.joinDate}</li>
			<li>${ owner.userRole}</li>
	    </ul>
    </c:forEach>
</body>
</html>