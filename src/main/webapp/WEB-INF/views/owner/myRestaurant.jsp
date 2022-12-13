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
	<form action="/restaurant/owner/updateRestaurant" method="post" enctype="multipart/form-data">
		<c:set var="role" value="${userRoll}" />
		<c:if test="${role eq 'OWNER' or 'ADMIN'}">
			<input type=submit name="update" value="가게수정" />
		</c:if>
		<input type="hidden" name="restaurant_idx" value="${restaurantJoinMenu[0].restaurant_idx}" />
		<ul>
			<li>restaurant_idx</li>
			<li>${restaurantJoinMenu[0].restaurant_idx}</li>
			<li>brand_name</li>
			<li>${restaurantJoinMenu[0].brand_name}</li>
			<li>address</li>
			<li>${restaurantJoinMenu[0].address}</li>
			<li>brand_tel</li>
			<li>${restaurantJoinMenu[0].brand_tel}</li>
			<li>introduce</li>
			<li>${restaurantJoinMenu[0].introduce}</li>
			<li>enroll_date</li>
			<li>${restaurantJoinMenu[0].enroll_date}</li>
			<li>owner_idx</li>
			<li>${restaurantJoinMenu[0].owner_idx}</li>
		</ul>
		<br>
		<ul>
			<c:forEach var="menu" items="${restaurantJoinMenu}">
				<li>menu_idx</li>
				<li>${menu.menu_idx}</li>
				<li>menu_name</li>
				<li>${menu.menu_name}</li>
				<li>menu_price</li>
				<li>${menu.menu_price}</li>
			</c:forEach>	
		</ul>
	</form>
</body>
</html>