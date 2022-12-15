<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메뉴등록</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	   var num = 1;
	   $(function() {
		   $('#btnAddFile').on('click', function() {
			   let tag = '<div class="menuForm"><label>메뉴이름' + (num + 1) + '</label>';
			   tag += '<input type="text" name=\"menu_name' + num + ' \" /><br>';
			   tag += '<label>메뉴가격' + (num + 1) + '</label>';
			   tag += '<input type="text" name=\"menu_price' + num + '\" /><br>';
			   tag += '<label>메뉴사진' + (num + 1) + '</label>';
			   tag += '<input type="file" name=\"upfile' + num + '\ "/></div>';
			   $('#addMenu').append(tag);
			   num++;
		   } );
	   });
	</script>
</head>
<body>
	<h2>메뉴등록</h2>
	<form id="addMenu" action="/restaurant/owner/enrollMenuProcess" method="post" encType="multipart/form-data">
		<div class="menuForm">
			<input type="hidden" name="restaurant_idx" value="${restaurant_idx}" />
			<label>메뉴이름</label>
			<input type="text" name="menu_name" /><br>
			<label>메뉴가격</label>
			<input type="text" name="menu_price" /><br>
			<label>메뉴사진</label>
			<input type="file" name="upfile" />
			<input type="button" id="btnAddFile" value="메뉴 추가" />
			<input type="submit" value="등록" />
		</div>
	</form>
</body>
</html>