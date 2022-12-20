<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${restaurantInfo[0].brand_name}</title>
</head>
<body>
	<h2>${restaurantInfo[0].brand_name}</h2>
	<a href="/">홈으로</a>
	<form action="/restaurant/owner/updateRestaurant" method="post" enctype="multipart/form-data">
		<input type="hidden" name="restaurant_idx" value="${restaurantInfo[0].restaurant_idx}" />
	</form>
	<h3>식당정보</h3>
	<ul>
		<li>번호</li>
		<li>${restaurantInfo[0].restaurant_idx}</li>
		<li>가게 이름</li>
		<li>${restaurantInfo[0].brand_name}</li>
		<li>주소</li>
		<li>${restaurantInfo[0].address}</li>
		<li>전화번호</li>
		<li>${restaurantInfo[0].brand_tel}</li>
		<li>소개</li>
		<li>${restaurantInfo[0].introduce}</li>
		<li>등록 날짜</li>
		<li>${restaurantInfo[0].enroll_date}</li>
		<li>일련번호</li>
		<li>${restaurantInfo[0].owner_idx}</li>
	</ul>
	<br>
	<h3>메뉴정보</h3>
	<table>
		<tr>
			<th>메뉴 번호</th>
			<th>메뉴 이름</th>
			<th>가격</th>
			<th>사진</th>
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
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>평점</th>
			<th>작성날짜</th>
			<th>restaurant_idx</th>
			<th>조회수</th>
			<th>작성자</th>
			<th>좋아요</th>
			<th>싫어요</th>
			<th>주소</th>
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
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c7e8b5181a619680766ee94de5ed015&libraries=services"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script>
		    var inputData = ['${restaurantInfo[0].brand_name}']
		    
		    var mapContainer = document.getElementById('map'),
		        mapOption = {
		            center: new kakao.maps.LatLng(37.54699, 127.09598),
		            level: 3
		        };
		    var map = new kakao.maps.Map(mapContainer, mapOption);
		    var count = 0;
		    var ps = new kakao.maps.services.Places();
		    var bounds = new kakao.maps.LatLngBounds();
		 
		    if (inputData != null) {
		        kewwordSearch(inputData[count]);
		    }
		 
		    function kewwordSearch(keword) {
		        ps.keywordSearch(keword, placesSearchCB);
		        count = count + 1;
		    }
		 
		    function placesSearchCB(data, status, pagination) {
		        if (status === kakao.maps.services.Status.OK) {
		            displayMarker(data[0]);
		            bounds.extend(new kakao.maps.LatLng(data[0].y, data[0].x));
		            if (count < inputData.length) {
		                kewwordSearch(inputData[count]);
		            } else if (count == inputData.length) {
		                setBounds();
		            }
		        }
		    }
		 
		    function displayMarker(place) {
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: new kakao.maps.LatLng(place.y, place.x),
		        });
		        var infowindow = new kakao.maps.InfoWindow({
	                content: '<div style="width:150px;text-align:center;padding:6px 0;">${restaurantInfo[0].brand_name}, 마커 클릭시 길찾기 이동</div>'
	            });
	            infowindow.open(map, marker);
		        kakao.maps.event.addListener(marker, 'click', function () {
		            var position = this.getPosition();
		            var url = 'https://map.kakao.com/link/to/' + place.id;
		            window.open(url, '_blank');
		        });
		    }
		 
		    function setBounds() {
		        map.setBounds(bounds, 90, 30, 10, 30);
		    }
		    </script>    
</body>
</html>