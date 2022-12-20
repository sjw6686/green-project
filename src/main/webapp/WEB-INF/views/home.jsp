<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loader.css">
<link rel="stylesheet" href="/css/home.css">
<!-- bootstrap css-->
<link rel="stylesheet" href="/css/bootstrap.css">
<!--slick -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/typing.js"></script>
<!-- <script src="<c:url value="/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="/js/jquery.autocomplete.min.js" />"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<style>
.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
.autocomplete-suggestion { padding: 5px 5px; white-space: nowrap; overflow: hidden; font-size:22px}
.autocomplete-selected { background: #F0F0F0; }
.autocomplete-suggestions strong { font-weight: bold; color: #3399FF; }
</style>

    <style>
        #autoMaker{
            position: absolute; width: 200px;
            height: auto; background: white;
            margin-top: 3px; cursor:pointer;
            top: 51px;
   			left: 16px;
   			font-family: -apple-system,BlinkMacSystemFont,"Malgun Gothic","맑은 고딕",helvetica,"Apple SD Gothic Neo",'나눔바른고딕 옛한글','NanumBarunGothic YetHangul',sans-serif;
		    border: 1px solid #e4e7e8;
		    border-top: 0;
		    border-radius: 0 0 6px 6px;
		    -webkit-box-shadow: 0 2px 3px 0 rgb(0 1 3 / 7%);
		    box-shadow: 0 2px 3px 0 rgb(0 1 3 / 7%);
		    letter-spacing: -.25px;
		    line-height: 1.8rem;
		    background-color: #fff;
		        }
        #autoMaker > div{
            border : 1px solid #ffffff;
            margin-top : 3px;
        }
        #autoMaker > div:hover{
            background : #e6d1ff;
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
	    <input type="hidden" id='insert_target' readonly style='background: #cacaca'>
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
	    	<a href="/logOut">로그아웃</a>
	    </c:otherwise>
    	</c:choose>
            <a class="nav-link active" aria-current="page" href="/">홈으로 돌아가기</a>
          </li>
          <li class="nav-item dropdown">
          <c:if test="${sessionScope.login.userRole eq 'USER' }">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             사용자 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/Board/List">게시판</a></li>
              <li><a class="dropdown-item" href="/restaurant/owner/requestUserUpgrade">등업신청</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">닫기</a></li>
            </ul>
            </c:if>
            <c:if test="${sessionScope.login.userRole eq 'OWNER' }">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             사장 메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/restaurant/owner/myRestaurantList">내가게 보기</a></li>
               <li><a class="dropdown-item" href="/restaurant/owner/enrollRestaurant">가게등록</a></li>
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
              <li><a class="dropdown-item" href=/admin/usersearch>유저조회</a><br></li>
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
	  <div>
	<input type="text"  id="w-input-search" value="">
	<span>
	  <button id="button-id" type="button">Search</button>
	</span>
  </div>
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
                    <a class="tag-filter_tag" href="categorySearch?category_name=${category.category_name}"><h6>${category.category_name}</h6></a>
                    </c:forEach>
                </div>
            </div>
            
            <div class="allyc">
			  <div class="your-class" style="background-color: #EFF5F5;">음식점 목록
			  <c:forEach var="restaurant" items="${restaurantList}">
			    <div>
			      <figure>
			       <img src="/img2/${restaurant.sfile_name}" alt="식당이미지">
			       <figcaption>
			       <em><a href="/restaurantInfo?restaurant_idx=${restaurant.restaurant_idx}">${restaurant.brand_name}</a></em>
			       <span>${restaurant.introduce}</span>
			       <span>${restaurant.address}</span>
			       </figcaption>
			       </figure>
			   </div>
			   </c:forEach>
			  </div>
			 <div class="your-class" style="background-color: #EEEEEE;">음식점 랭킹
			   <c:forEach var="restaurant" items="${restaurantList}">
			    <div>
			      <figure>
			       <img src="/img2/${restaurant.sfile_name}" alt="식당이미지" />
			       <figcaption>
			       <em><a href="/restaurantInfo?restaurant_idx=${restaurant.restaurant_idx}">${restaurant.brand_name}</a></em>
			       <span>${restaurant.introduce}</span>
			       <span>${restaurant.address}</span>
			       </figcaption>
			       </figure>
			   	</div>
			   </c:forEach>
			  </div>
  			</div>
		</div>
	</div>
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

  <script>

var ref = [
    {key:1, name:'공담'},
    {key:2, name:'해목'},
    {key:3, name:'국제통닭'},
    {key:4, name:'깐풍집'},
    {key:5, name:'한국정'},
    {key:6, name:'호로롯쿠'},
    {key:7, name:'라라코스트 서면'},
    {key:8, name:'한식당'},
    {key:9, name:'짬뽕관 서면점'},
    {key:10, name:'한국정정정'},
    {key:11, name:'한국정정'},
];

var isComplete = false;  //autoMaker 자식이 선택 되었는지 여부
$('#search_area').keyup(function(){
    var txt = $(this).val();
    if(txt != ''){  //빈줄이 들어오면
        $('#autoMaker').children().remove();

        ref.forEach(function(arg){
            if(arg.name.indexOf(txt) > -1 ){
                $('#autoMaker').append(
                    $('<div>').text(arg.name).attr({'key':arg.key})
                );		
            }
        });
        $('#autoMaker').children().each(function(){
            $(this).click(function(){
                $('#search_area').val($(this).text());
                $('#insert_target').val("key : "+$(this).attr('key')+ ", data : " + $(this).text());
                $('#autoMaker').children().remove();	
                isComplete = true;
            });
        });			
    } else {
        $('#autoMaker').children().remove();
    }  
});
$('#search_area').keydown(function(event){
    if(isComplete) {  //autoMaker 자식이 선택 되었으면 초기화
        $('#insert_target').val('')	
    }
})

</script>

  <script>
  $(document).ready(function() {

	$('#w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/getTags',
		paramName: "tagName",
		delimiter: ",",
	   transformResult: function(response) {
		    	
		return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
		            	
		      return { value: item.tagName, data: item.id };
		   })
		            
		 };
		        
            }
		    
	 });
				
  });
  </script>
 
</body>
</html>