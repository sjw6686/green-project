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
  <div class="container-fluid">
    <a class="navbar-brand" href="/">부산 맛집</a>
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
        <h5 class="text-white h4"></h5>${ sessionScope.login.username } 님 환영합니다.<a href="/logout">로그아웃</a>
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
              <li><a class="dropdown-item" href="/User/List">사용자 관리</a></li>
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
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</body>
</html>