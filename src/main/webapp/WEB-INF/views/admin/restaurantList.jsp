<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
  h2 { margin:20px;  }
</style>
</head>
<body>

 <div id="main">
   <h2>가게 관리</h2>
   
   <table>
   <c:forEach  var="restaurant"  items="${ restaurantList }">
      <tr>
        <td>${ restaurant.brand_name }</td>
        <td>${ restaurant.address }</td>
        <td>${ restaurant.brand_tel }</td>
        <td>${ restaurant.introduce }</td>
        <td><a href="/admin/DeleteRestaurant/${ restaurant.brand_name }">삭제</a></td>  
        <td><a href="/admin/UpdateRestaurant/${ restaurant.restaurant_idx }">수정</a></td>z  
      </tr>

   <h2>가게 리뷰</h2>
  	 <tr>
      <td>${ review.review_comment }</td>
  	 </tr>
   </c:forEach>
      <h2>가게 리뷰</h2>
  	 <tr>
      <td>${ allVo.review_comment }</td>
  	 </tr>
   </table>
   
   <div>
   </div>
   
 </div>  
</body>
</html>