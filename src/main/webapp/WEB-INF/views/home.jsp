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
    <a href="/Board/List">게시물 목록</a><br>
  	<a href="/showJsp">메뉴등록화면보기</a><br>
    <c:choose>
	    <c:when test = "${sessionScope.login == null}">	<!-- interceptor에 로그인 정보가 세션에 담기는데, 이때 "login"이라는 이름으로 저장됨. sessionScope.login은 "login"이라는 이름의 세션정보를 가져오는것. 로그인을 하지않았다면 세션정보가 null임.  -->
	    	<a href="/login">로그인</a><br>				<!-- 따라서 when태그 안의 것은 로그인 하지 않은 유저에게 보여주는 정보 -->
	    	<a href="/signUp">회원가입</a><br>
	    </c:when>
	    <c:otherwise>
	    	<a href="/restaurant/owner/myRestaurantList">내가게 보기</a><br>	  
   	 		<a href="/restaurant/owner/enrollRestaurant">가게등록</a><br>
	    	<a href="/logOut">로그아웃</a><br>	  
	    </c:otherwise>
    </c:choose>
</body>
</html>