<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/home.css">
<!-- bootstrap css-->
<link rel="stylesheet" href="/css/bootstrap.css">
<!--slick -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/typing.js"></script>
<style>
</style>
</head>
<body>
<nav class="navbar bg-light fixed-top">
  <div class="container-fluid" style="background-color: #439A97;">
    <a class="navbar-brand" href="/">부산 맛집</a>
    <ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Active</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/Board/List">게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled">Disabled</a>
  </li>
</ul>
    <nav class="navbar bg-light">
	  <div class="container-fluid">
	    <form class="d-flex mt-2" role="search">
	      <input class="form-control me-2 me-width1" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">안녕하세요!</h5>
        <h5 class="text-white h4"></h5>${ sessionScope.login.userId } 님 환영합니다.<a href="/logout">로그아웃</a>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/">홈으로 돌아가기</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             관리자 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/User/List">유저 관리</a></li>
               <li><a class="dropdown-item" href="/admin/search">사용자 활동 조회</a></li>
              <li><a class="dropdown-item" href="/admin/ReviewList">리뷰 관리</a></li>
              <li><a class="dropdown-item" href="/admin/RestaurantList">가게 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index/category/list">카테고리 관리</a></li>
              <li><a class="dropdown-item" href="/User/List">코딩중...</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">닫기</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex mt-3" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </div>
  </div>
</nav>
  <div id="main">
	<div class="wrapper">

        <div class="main-box">
            <div class="intro">
                <h1 class="intro-title"></h1>
                  <div class="typing-txt"> 
				    <ul>
				      <li>부산 맛집을 찾아보세요!</li>
				  </ul>
				  </div> 
				  <div class="typing">
				     <ul>
				       <li></li>
				    </ul>
				  </div>
                <h2 class="intro-sub"></h2>
            </div>
            <div class="tag-filters">
                <div class="tag-filter">
                    <h4 class="tag-filter_title">카테고리</h4>
                    <a class="tag-filter_tag" href="/"><h6>전체</h6></a>
                    <c:forEach var="category" items="${categoryList}">
                    <a class="tag-filter_tag" href="categorySearch?category_name=${category.category_name }"><h6>${category.category_name }</h6></a>
                    </c:forEach>
                </div>
            </div>
   		</div>
   </div>
 </div>
<div class="your-class" style="background-color: #EFF5F5;">음식점 목록
 <c:forEach var="category" items="${ categoryVo }">
    <div>
      <figure>
       <img src="/img/해목.png" alt="이미지1">
       <figcaption>
       <em><a href="#">${ category.brand_name }</a></em>
       <span>${ category.introduce }</span>
       <span>${ category.address }</span>
       </figcaption>
       </figure>
	</div>
  </c:forEach>
</div>
<div class="your-class" style="background-color: #EEEEEE;">음식점 랭킹
 <c:forEach var="category" items="${ categoryVo }">
    <div>
      <figure>
       <img src="/img/해목.png" alt="이미지1">
       <figcaption>
       <em><a href="#">${ category.brand_name }</a></em>
       <span>${ category.introduce }</span>
       <span>${ category.address }</span>
       </figcaption>
       </figure>
	</div>
  </c:forEach>
</div>
     
   <!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/bootstrap.bundle.min.js"></script>
<!-- slick -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
      $('.your-class').slick({
    	  slidesToShow: 4,
    	  slidesToScroll: 1,
    	  autoplay: true,
    	  autoplaySpeed: 2000,
    	  dots: true
      });
    });
  </script>
</body>
</html>