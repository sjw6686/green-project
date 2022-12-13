<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>가게수정</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	   var num = 1;
	   $(function() {
		   $('#btnAddFile').on('click', function() {
			   let tag  = '<input type="text" name=\"menu' + num + '\" />';
			   tag += '<input type="text" name=\"price' + num + '\" />';
			   tag += '<input type="file" name=\"upfile' + num + '\ "/><br>';
			   $('#addMenu').append( tag  );
			  // alert(tag);
			   num++;
		   } );
	   });
	</script>
</head>
<body>
	<h2>가게수정</h2>
	<a href="/">홈으로</a>
	<form id="resForm" action="/restaurant/owner/updateProcess" method="post" enctype="multipart/form-data">
			<label>식당이름</label><br>
			<input type="text" name="brandName" id="brandName" value="${restaurantJoinMenu[0].brand_name}" /><br>
			<label>식당주소</label><br>
			<input type="text" name="address" id="address" value="${restaurantJoinMenu[0].address}" /><br>
			<label>식당 전화번호</label><br>
			<input type="text" name="brandTel" id="brandTel" value="${restaurantJoinMenu[0].brand_tel}" /><br>
			<label>카테고리</label><br>
			<select name = "category_name" id = catagory>
				<option value="${restaurantJoinMenu[0].category_name}"></option>
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="일식">일식</option>
			</select>
			<label>간단한 소개글</label><br>
			<textarea name="introduce" id="introduce">
				${restaurantJoinMenu[0].introduce}
			</textarea><br>

			<label>메뉴등록</label><br>
			<div id="addMenu">
				<c:forEach var="menu" items="${restaurantJoinMenu}">
					<input type="text" name="menu" value="${menu.menu_name}" />
					<input type="text" name="price" value="${menu.menu_price}" />
		           	<input type="file" name="upfile" class="upfile" /><br>
	           	</c:forEach>
			</div> 
				<input type="button" id="btnAddFile" value="메뉴추가"/><br>
			
			<br><input type="submit" value="가게 수정" />
		</form>
</body>
</html>