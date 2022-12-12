<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가게</title>
</head>
<body>
	<h2>내가게</h2>
	<a href="/">홈으로</a>
	<table border="1">
		<tr>
			<th>restaurant_idx</th>
			<th>brand_name</th>
			<th>address</th>
			<th>brand_tel</th>
			<th>introduce</th>
			<th>enroll_date</th>
			<th>owner_idx</th>
		</tr>
		<tr>
			<td>${restaurantJoinMenu[0].restaurant_idx}</td>
			<td>${restaurantJoinMenu[0].brand_name}</td>
			<td>${restaurantJoinMenu[0].address}</td>
			<td>${restaurantJoinMenu[0].brand_tel}</td>
			<td>${restaurantJoinMenu[0].introduce}</td>
			<td>${restaurantJoinMenu[0].enroll_date}</td>
			<td>${restaurantJoinMenu[0].owner_idx}</td>
		</tr>
	</table>
	<br>
	<table border="1">
		<tr>
			<th>menu_idx</th>
			<th>menu_name</th>
			<th>menu_price</th>
		</tr>
		<c:forEach var="menu" items="${restaurantJoinMenu}">
			<tr>
				<td>${menu.menu_idx}</td>
				<td>${menu.menu_name}</td>
				<td>${menu.menu_price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>