<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가게 목록</title>
</head>
<body>
	<h2>내가게 목록</h2>
	<a href="/">홈으로</a>
	<table>
		<tr>
			<th>No</th>
			<th>가게이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>소개</th>
			<th>카테고리</th>
			<th>파일이름</th>
		</tr>
		<c:forEach var="restaurant" items="${restaurantList}">		
			<tr>
				<td>
					<a href="myRestaurant?restaurant_idx=${restaurant.restaurant_idx}">${restaurant.restaurant_idx}</a>
				</td>
				<td>${restaurant.brand_name}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.brand_tel}</td>
				<td>${restaurant.introduce}</td>
				<td>${restaurant.category_name}</td>
				<td>${restaurant.sfile_name}</td>
				<th>
					<a href="enrollMenu?restaurant_idx=${restaurant.restaurant_idx}">메뉴등록</a>
				</th>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>