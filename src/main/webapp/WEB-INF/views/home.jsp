<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
    	<h2>hello</h2>
    	<a href="/restaurant/user/userList">유저리스트</a><br>
    	<a href="/restaurant/owner/ownerList">사장리스트</a><br>
    	<c:choose>
	    	<c:when test = "${sessionScope.login != null}">
	    		<a href="/logOut">로그아웃</a><br>	  
	    	</c:when>
	    	<c:otherwise>
	    		<a href="/signUp">사장 회원가입</a><br>
	    	</c:otherwise>
    	</c:choose>
</body>
</html>