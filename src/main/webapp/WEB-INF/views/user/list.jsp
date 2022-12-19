<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<style>
  input[type=button] {
      display : inline-block;
      height: 100px; width:100px;
  }
    h2 { margin:20px;  }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
</script>
</head>
<body>
<div id="main">
<%@ include file="/WEB-INF/views/includeFile/header.jsp" %>
      <!-- 이름 & 아이디로 서치 -->
   <h2>전체 사용자 목록</h2>
   <table>
   <tr>
   		<td>ID</td>
  		<td>닉네임</td>
   		<td>가입일자</td>
   		<td>상태</td>	
   </tr>
   </table>
   <table>
   <c:forEach var="user" items="${ userList }">
   <tr>
      <td>${ user.userid   }</td>
      <td>${ user.username }</td>	
      <td>${ user.indate   }</td>
      <!-- 
      <option value="${user.userid }"
      <c:if test="${user.userid eq user.userid}"></c:if>>${user.userid }</option>
       -->
      <td><a href="/DeleteUser/${user.userid}">삭제</a></td>
   </tr>
   </c:forEach>
   </table>
 </div>
</body>
</html>