<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>식당등록</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	   var num = 1;
	   $(function() {
		   $('#btnAddFile').on('click', function() {
			   let tag  = '<input type="text" name=\"menu' + num + '\"/>';
			   tag += '<input type="file" name=\"upfile' + num + '\"/><br>';
			   $('#addMenu').append( tag  );
			  // alert(tag);
			   num++;
		   } );
	   });
	</script>
</head>
<body>
	<div>
		<h2>Enroll Restaurant</h2>
		<a href="/">홈으로</a>
	</div>
	<div>
		<form id="resForm" action="/restaurant/owner/enrollProcess" method="post" enctype="multipart/form-data">
			<label>식당이름</label><br>
			<input type="text" name="brandName" id="brandName" /><br>
			<label>식당주소</label><br>
			<input type="text" name="address" id="address" /><br>
			<label>식당 전화번호</label><br>
			<input type="text" name="brandTel" id="brandTel" /><br>
			<label>카테고리</label><br>
			<select name = "category" id = catagory>
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="일식">일식</option>
			</select>
			<label>간단한 소개글</label><br>
			<textarea name="introduce" id="introduce"></textarea><br>
			<!-- 
			<label>메뉴등록</label><br>
			<div id="addMenu">
				<input type="text" name="menu_name" value="메뉴이름" /><br>
				<input type="text" name="menu_price" value="메뉴이름" /><br>
	           	<input type="file" name="upfile" class="upfile" /><br>
				<input type="button" id="btnAddFile" value="메뉴추가"/><br>
			</div>
			-->
			<br><input type="submit" value="가게등록" />
		</form>
	</div>
</body>
</html>