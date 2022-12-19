<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   table { margin-top: 30px; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
</script>
</head>
<body>
<div id="main">

 </div>
   <h2>사용자 목록</h2>
   <c:forEach var="user" items="${ userList }">
   <ul>
      <li>${ user.userid   }</li>
      <li>${ user.username }</li>
      <li>${ user.indate   }</li>
   </ul>
   </c:forEach>
</body>
</html>