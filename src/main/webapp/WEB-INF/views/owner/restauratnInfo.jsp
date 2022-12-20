<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <meta name="theme-color" content="#712cf9">
<title>${restaurantInfo[0].brand_name}</title>
<style>
@charset "UTF-8";
/* stylelint-disable selector-list-comma-newline-after */
.container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
    --bs-gutter-x: 4.5rem; transform : translateX(225px);}
a{text-decoration:none;}
.blog-header {
  border-bottom: 1px solid #e5e5e5;
}

.blog-header-logo {
  font-family: "Playfair Display", Georgia, "Times New Roman", serif/*rtl:Amiri, Georgia, "Times New Roman", serif*/;
  font-size: 4.25rem;
}

.blog-header-logo:hover {
  text-decoration: none;
}


.display-4 {
  font-size: 2.5rem;
}
@media (min-width: 768px) {
  .display-4 {
    font-size: 3rem;
  }
}

.flex-auto {
  flex: 0 0 auto;
}

.btn {
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 24px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        /* vertical-align: middle; */
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 4px;
    }
     .btn-primary {
        color: #fff;
        background-color: #337ab7;  
        border-color: #2e6da4;
        margin-top: 20px;
        }
*{text-align:center;}
table{
 margin-left: auto;
    margin-right: auto;}
  th,td{
  text-align:center;
  padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 30px;
    padding-right: 40ox;
  }
  .map{
  padding-top:10px;}
  li{
  font-weight: bold;
  padding-top:30px;
  padding-bottom:10px;}
button{
float:left;}
uu{position:absolute;}
.info{
float : left;
display:inline-block;
width:49%;
position: relative;
height :auto;
}
ul{
   list-style:none;
   }
.menu{
   margin-top : 10px;}
.review{
   margine-top:50px;}
   img{
  width:50px;
  height:50px;
   object-fit: scale-down;
   cursor:pointer;}
   .contain{
   position : relative;
   left:200px;
   }
</style>
</head>
<body>

<nav class="navbar bg-light">
  <form class="container-fluid justify-content-start">
    <button class="btn btn-sm btn-outline-secondary"  onclick="location.href='/'" type="button" >메인페이지</button>
    <div class="col-4 text-center">
        <a class="blog-header-logo text-dark">${restaurantInfo[0].brand_name}</a>
      </div>
  </form>
</nav>
<div class="contain">
	<div class="info">
	<div id="uu">
	<ul>
		 <%-- <li>식당번호</li>
		<li>${restaurantInfo[0].restaurant_idx}</li>  
		<li>식당 이름</li>
		<li>${restaurantInfo[0].brand_name}</li>--%>
		
		<h3><br>가게 정보</h3>
		<li>주소 : ${restaurantInfo[0].address}</li>
		<li>전화번호 : ${restaurantInfo[0].brand_tel}</li>
		<li>소개 : ${restaurantInfo[0].introduce}</li>
		<li>갱신 날짜 : ${restaurantInfo[0].enroll_date}<br></li>
		
		 <%-- <li>일련번호</li>
		<li>${restaurantInfo[0].owner_idx}</li>--%>
	</ul></div>
	<div class="menu">
	<h3>메뉴정보</h3>
	<table style="text-align : center;">
		<tr>
			<%--<th>메뉴 번호</th>--%>
			<th>메뉴명</th>
			<th>가격</th>
			<th>대표 사진</th>
		</tr>
		<c:forEach var="menu" items="${restaurantInfo}">
			<tr>
				<%--<th>${menu.menu_idx}</th>--%>
				<th>${menu.menu_name}</th>
				<th>${menu.menu_price}</th>
				<th><img src="/img2/${menu.sfile_name}"onclick="window.open(this.src)"/></th>
			</tr>
		</c:forEach>	
	</table>
	</div>
     </div>
     <div class="map">
            <div id="map" style="width:500px;height:500px; margin-top:100px; margin-bottom: 200px;"></div>
    </div>
     </div>
	<br>
	<div class=review>
	<h2>리뷰목록</h2> <!-- 리뷰에있는 링크누르면 리뷰에 대한 자세한 정보를 확인할수있음 -->
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>평점</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>작성자</th>
			<th>작성 날짜</th>
		</tr>
		<c:forEach var="review" items="${reviewList}">
		<c:set var="i" value="${i+1}"/>
			<tr>
				<th>
					<a href="reviewComment?board_idx=${review.board_idx}">${i }</a>
				</th>
				<th>${review.board_title}</th>
				<th>${review.board_content}</th>
				<th>${review.review_avg}</th>
				<th>${review.view_cnt}</th>
				<th>${review.cnt_like}</th>
				<th>${review.boardWriter}</th>
				<th>${review.boardRegDate}</th>
				
			</tr>
		</c:forEach>
	</table>
	<button type="button" onclick="location.href='restaurant/owner/writeReview?restaurant_idx=${restaurantInfo[0].restaurant_idx}'">리뷰쓰기</button>
</div>
</body>
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
	                content: '<div style="width:150px;text-align:center;padding: 5px 0;"><strong>${restaurantInfo[0].brand_name}</strong><br><u>${restaurantInfo[0].introduce}</u></div>'
	            });
	            infowindow.open(map, marker);
		        kakao.maps.event.addListener(marker, 'click', function a() {
		            var position = this.getPosition();
		            var url = 'https://map.kakao.com/link/to/' + place.id;
		            window.open(url, '_blank');
		        });
		        
		    }
		 
		    function setBounds() {
		        map.setBounds(bounds, 90, 30, 10, 30);
		    }
    </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
