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
    <c:choose>
	    <c:when test = "${sessionScope.login == null}">
	    	<a href="/login">로그인</a><br>
	    	<a href="/signUp">회원가입</a><br>
	    </c:when>
	    <c:otherwise>
	    	<a href="/restaurant/owner/myRestaurantList">내가게 보기</a><br>	  
	    	<a href="/logOut">로그아웃</a><br>	  
	    </c:otherwise>
    </c:choose>
    <a href="/restaurant/owner/enrollRestaurant">가게등록</a><br>
</body>
</html>