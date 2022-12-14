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
			<th>restaurantIdx</th>
			<th>brandName</th>
			<th>address</th>
			<th>brandTel</th>
			<th>introduce</th>
			<th>enrollDate</th>
			<th>ownerIdx</th>
			<th>categoryName</th>
			<th>tableType</th>
		</tr>
		<c:forEach var="restaurant" items="${restaurantList}">		
			<tr>
				<td>
					<a href="myRestaurant?restaurant_idx=${restaurant.restaurantIdx}">${restaurant.restaurantIdx}</a>
				</td>
				<td>${restaurant.brandName}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.brandTel}</td>
				<td>${restaurant.introduce}</td>
				<td>${restaurant.enrollDate}</td>
				<td>${restaurant.ownerIdx}</td>
				<td>${restaurant.categoryName}</td>
				<td>${restaurant.tableType}</td>
				<th>
					<a href="updateRestaurant?restaurant_idx=${restaurant.restaurantIdx}">가게수정하기</a>
				</th>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>