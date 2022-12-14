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
	<div>
		<h2>Enroll Restaurant</h2>
		<a href="/">홈으로</a>
	</div>
	<div>
		<form id="resForm" action="/restaurant/owner/enrollProcess" method="post" encType="multipart/form-data">
			<label>식당이름</label><br>
			<input type="text" name="brandName" id="brandName" /><br>
			<label>식당사진등록</label><br>
			<input type="file" name="upfile" /><br>
			<label>식당주소</label><br>
			<input type="text" name="address" id="address" /><br>
			<label>식당 전화번호</label><br>
			<input type="text" name="brandTel" id="brandTel" /><br>
			<label>카테고리</label><br>
			<select name = "categoryName" id = catagory>
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="일식">일식</option>
			</select>
			<label>간단한 소개글</label><br>
			<textarea name="introduce" id="introduce"></textarea><br>
			<input type="submit" value="등록하기" />
		</form>
	</div>
</body>
</html>