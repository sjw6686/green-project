<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
  input[type=button] {
      display : inline-block;
      height: 100px; width:100px;
  }
  h2 { margin:20px;  }
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/includeFile/header.jsp" %>
<div id="main">
<h2>리뷰 목록</h2>
	<table>
 
   <c:forEach var="review" items="${ reviewList }">
   <tr>
      <td>${ review.review_comment }</td>
      <td><a href="/admin/DeleteReview/${review.review_comment}">삭제</a></td>
   </tr>
   </c:forEach>
   </table>
 </div>
</body>
</html>