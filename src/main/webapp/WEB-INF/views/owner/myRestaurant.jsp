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
		<input type="hidden" name="restaurant_idx" value="${restaurantInfo[0].restaurant_idx}" />
	</form>
	<h3>식당정보</h3>
	<ul>
		<li>restaurant_idx</li>
		<li>${restaurantInfo[0].restaurant_idx}</li>
		<li>brand_name</li>
		<li>${restaurantInfo[0].brand_name}</li>
		<li>address</li>
		<li>${restaurantInfo[0].address}</li>
		<li>brand_tel</li>
		<li>${restaurantInfo[0].brand_tel}</li>
		<li>introduce</li>
		<li>${restaurantInfo[0].introduce}</li>
		<li>enroll_date</li>
		<li>${restaurantInfo[0].enroll_date}</li>
		<li>owner_idx</li>
		<li>${restaurantInfo[0].owner_idx}</li>
	</ul>
	<br>
	<h3>메뉴정보</h3>
	<table>
		<tr>
			<th>menu_idx</th>
			<th>menu_name</th>
			<th>menu_price</th>
			<th>sfile_name</th>
		</tr>
		<c:forEach var="menu" items="${restaurantInfo}">
			<tr>
				<th>${menu.menu_idx}</th>
				<th>${menu.menu_name}</th>
				<th>${menu.menu_price}</th>
				<th>${menu.sfile_name}</th>
			</tr>
		</c:forEach>	
	</table>
	<br>
	<h2>리뷰목록</h2> <!-- 리뷰에있는 링크누르면 리뷰에 대한 자세한 정보를 확인할수있음 -->
	<table>
		<tr>
			<th>board_idx</th>
			<th>board_title</th>
			<th>board_content</th>
			<th>review_avg</th>
			<th>boardRegDate</th>
			<th>restaurant_idx</th>
			<th>view_cnt</th>
			<th>boardWriter</th>
			<th>cnt_like</th>
			<th>cnt_hate</th>
			<th>address</th>
		</tr>
		<c:forEach var="review" items="${reviewList}">
			<tr>
				<th>
					<a href="reviewComment?board_idx=${review.board_idx}">${review.board_idx}</a>
				</th>
				<th>${review.board_title}</th>
				<th>${review.board_content}</th>
				<th>${review.review_avg}</th>
				<th>${review.boardRegDate}</th>
				<th>${review.restaurant_idx}</th>
				<th>${review.view_cnt}</th>
				<th>${review.boardWriter}</th>
				<th>${review.cnt_like}</th>
				<th>${review.cnt_hate}</th>				
				<th>${review.address}</th>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>