<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
   h2 { margin : 20px;  }
</style>
</head>
<body>
 <div id="main">
    <h2>메뉴 수정</h2>
    <form action="/admin/UpdateRestaurant" method="POST">
    <div>
    가게 이름:
    <input type="text"   name="brand_name"    value="${ restaurant.brand_name }" />
    </div>
    <div>
    가게 주소:
    <input type="text"   name="address"  value="${ restaurant.address }" />
    </div>
    <div>
    가게 번호:
    <input type="text" name="brand_tel"   value="${ restaurant.brand_tel }" />
    </div>
    <div>
    가게 설명:
    <input type="text" name="introduce"   value="${ restaurant.introduce }" />
    </div>
    <div>
      <input type="submit" value="추가" />
    </div>
    </form> 
</body>
</html>