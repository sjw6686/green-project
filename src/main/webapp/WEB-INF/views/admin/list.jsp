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
  
  #main{
 	position: relative;
  	top: 85px;
  }
  
  .tanone{
 	text-align: inherit;
  }
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/includeFile/header.jsp" %>
<div id="main">
<h2>카테고리 목록</h2>
	<table>
   <c:forEach var="category" items="${ categoryList }">
   <tr>
      <td>${ category.category_name }</td>
      <td><a href="/admin/DeleteCategory/${category.category_name}">삭제</a></td>
   </tr>
   </c:forEach>
   </table>
   <div>
   <h1 class="title">카테고리 추가</h1>
	<div class="cate_wrap">
		<span class="tanone">추가할 카테고리를 입력하세요!</span>
		<form action="/admin/index/category/write" method="POST">
		<div>
		<input type="text" name="category_name"/>
		</div>
		<div>
		<input type="submit" value="추가"/>
		</div>
		</form>
	</div>
   </div>
 </div>
</body>
</html>