<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>식당목록</h2>
	<table border="1">
		<tr>
			<th>No</th>
			<th>식당이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>소개글</th>
			<th>등록일</th>
			<th>카테고리</th>
			<th>사진</th>
		</tr>
		<c:forEach var="restaurant" items="${restaurantList}">
			<tr>
				<td>
					<a href="/restaurantInfo?restaurant_idx=${restaurant.restaurant_idx}">
						${restaurant.restaurant_idx}
					</a>
				</td>
				<td>${restaurant.brand_name}</td>
				<td>${restaurant.address}</td>
				<td>${restaurant.brand_tel}</td>
				<td>${restaurant.introduce}</td>
				<td>${restaurant.enroll_date}</td>
				<td>${restaurant.category_name}</td>
				<td>${restaurant.sfile_name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>