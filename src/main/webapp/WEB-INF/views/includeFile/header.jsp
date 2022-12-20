<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<style>
   		h2 { margin : 20px;  }
  		 .wrapper {
            position: relative;
            width: 100%;
            top: 43px;
        }

        .top-bars {
            position: fixed;
            width: 100%;
            background-color: var(--body-color);
            border-bottom: 1px solid rgba(0, 0, 0, 0.2);
            display: flex;
            padding: 20px var(--body-padding) 10px;
            align-items: center;
            z-index: 5;
            left: 0;
        }

        .title-logo {
            color: var(--body-color);
            text-decoration: none;
            font-size: 30px;
        }

        .intro-title {
            position: relative;
		    font-size: 36px;
		    text-align: center;
		    margin-top: 50px;
		    font-weight: 800;
		    top: 45px;
		    width: 100%;
		    margin: 0px auto;
		    padding: 10px 0;
        }

        .intro {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
        }


        .tag-filters {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
        }

        .tag-filter_title {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
        }

        .tag-filter_tag {
            margin: 0 auto;
            width: 100px;
            height: 100px;
            padding: 7px 18px;
            background-color: #ecedf0;
            border-radius: 50%;
        }

        .store1 {
            position: relative;
        }

        .restaurant-list_textBox_name {
            display: block;
            line-height: 19px;
            font-size: 1.167em;
            padding-top: 0;
            padding-bottom: 2px;
            font-weight: 700;
        }

        .restaurant-list_textBox_sub {
            display: block;
        }

        .restaurant-list_textBox {
            margin-left: 0;
            padding-right: 10px;
            padding-top: 6px;
            font-size: 15px;
            position: absolute;
            top: 190px;
        }

        .restaurantInfo {
            position: relative;
            width: 100%;
            display: flex;
            align-items: center;
            gap: 10px;
            opacity: 1;
            margin-top: 20px;
            justify-content: space-around;
        }

        .Info {
            position: relative;
        }

        .tag-filter_title2 {
            position: relative;
            margin-left: 5%;
        }

        .restaurantrank-lists {
            position: relative;
            top: 110px;
        }

        .restaurant-list_textBox_ {
            font-size: 13px;
        }

        .top-bars__menu {
            position: relative;
            left: 1770px;
        }
        
        .me-width1{
        	width: 550px;
        }
        
       em{
       		display: block;
            line-height: 19px;
            font-size: 1.167em;
            padding-top: 0;
            padding-bottom: 2px;
            font-weight: 700;
            text-align: center;
            }
            
       span{
      		display: block;
      		text-align: center;
       		}
       		
       img{
       		margin : 0 auto;
       		}
       		
       .your-class{
       		top: 30px;
       		}
       		
.slick-arrow {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    border: none;
    font-size: 0;
    width: 0px;
    height: 100px;
    background: #ffffff;
}

.slick-prev {
    z-index: 20;
    left: 0;
}

.slick-prev::before {
    position: absolute;
    left: 0;
    top: 0;
    content: "\f104";
    width: 30px;
    height: 30px;
    font-family: "Font Awesome 5 Free";
    font-weight: 900;
    font-size: 50px;
}

.slick-next {
    z-index: 20;
    right: 0;
}

.slick-next::before {
    position: absolute;
    right: 0;
    top: 0;
    content: "\f105";
    width: 30px;
    height: 30px;
    font-family: "Font Awesome 5 Free";
    font-weight: 900;
    font-size: 50px;
}
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
	    <input type="text" id='insert_target' readonly style='background: #cacaca'>
	      <input class="form-control me-2 me-width1 form-control" type="text" placeholder="Search" aria-label="Search" id="search_area" name="recv_id" >
		    <div id='autoMaker'></div>
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
        <h5 class="text-white h4"></h5><c:if test = "${sessionScope.login != null}">${ sessionScope.login.userId } 님 환영합니다.</c:if>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>

      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
          <c:choose>
	    <c:when test = "${sessionScope.login == null}">	<!-- interceptor에 로그인 정보가 세션에 담기는데, 이때 저장되는 세션의 이름이 "login"이라는 이름으로 저장됨. sessionScope.login은 "login"이라는 이름의 세션정보를 가져오는것. 로그인을 하지않았다면 세션정보가 null임.  -->
	    	<a href="/login">로그인</a><br>				<!-- 따라서 when태그 안의 것은 로그인 하지 않은 유저에게 보여주는 정보 -->
	    	<a href="/signUp">회원가입</a><br>
	    </c:when>
	    <c:otherwise>
	    	<c:if test="${sessionScope.login.userRole eq 'OWNER' }">
	    		<a href="/restaurant/owner/myRestaurantList">내가게 보기</a><br>	  
   	 			<a href="/restaurant/owner/enrollRestaurant">가게등록</a><br>
	    	</c:if>
	    	<c:if test="${sessionScope.login.userRole eq 'USER' }">
	    		<a href="/restaurant/owner/requestUserUpgrade">등업신청</a><br>
	    	</c:if>
	    	<a href="/logOut">로그아웃</a><br>	  
	    </c:otherwise>
    	</c:choose>
            <a class="nav-link active" aria-current="page" href="/">홈으로 돌아가기</a>
          </li>
          <li class="nav-item dropdown">
          <c:if test="${sessionScope.login.userRole eq 'USER' }">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             관리자 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/User/List">유저 관리</a></li>
               <li><a class="dropdown-item" href="/admin/search">사용자 활동 조회</a></li>
              <li><a class="dropdown-item" href="/admin/ReviewList">리뷰 관리</a></li>
               <li><a class="dropdown-item" href="/admin/reviewsearch">리뷰 조회</a></li>
              <li><a class="dropdown-item" href="/admin/RestaurantList">가게 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index/category/list">카테고리 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index2">관리자 메뉴2로 가기</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">닫기</a></li>
            </ul>
            </c:if>
            <c:if test="${sessionScope.login.userRole eq 'OWNER' }">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             관리자 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/User/List">유저 관리</a></li>
               <li><a class="dropdown-item" href="/admin/search">사용자 활동 조회</a></li>
              <li><a class="dropdown-item" href="/admin/ReviewList">리뷰 관리</a></li>
               <li><a class="dropdown-item" href="/admin/reviewsearch">리뷰 조회</a></li>
              <li><a class="dropdown-item" href="/admin/RestaurantList">가게 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index/category/list">카테고리 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index2">관리자 메뉴2로 가기</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">닫기</a></li>
            </ul>
            </c:if>
          <c:if test="${sessionScope.login.userRole eq 'ADMIN' }">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             관리자 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/User/List">유저 관리</a></li>
               <li><a class="dropdown-item" href="/admin/search">사용자 활동 조회</a></li>
              <li><a class="dropdown-item" href="/admin/ReviewList">리뷰 관리</a></li>
               <li><a class="dropdown-item" href="/admin/reviewsearch">리뷰 조회</a></li>
              <li><a class="dropdown-item" href="/admin/RestaurantList">가게 관리</a></li>
              <li><a class="dropdown-item" href="/admin/index/category/list">카테고리 관리</a></li>
              <li><a class="dropdown-item" href=/restaurant/owner/requestUserUpgradeList>등업신청목록보기</a><br></li>
              <li><a class="dropdown-item" href="/admin/index2">관리자 메뉴2로 가기</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">닫기</a></li>
            </ul>
            </c:if>
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
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</body>
</html>