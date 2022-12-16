<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메뉴등록</title>
	<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	   var num = 1;
	   $(function() {
		   $('#btnAddFile').on('click', function() {
			   let tag = '<div class="menuForm"><label>메뉴이름' + (num + 1) + '</label>';
			   tag += '<input type="text" name=\"menu[' + num + '\].menu_name" /><br>';
			   tag += '<label>메뉴가격' + (num + 1) + '</label>';
			   tag += '<input type="text" name=\"menu[' + num + '\].menu_price" /><br>';
			   tag += '<label>메뉴사진' + (num + 1) + '</label>';
			   tag += '<input type="file" name=\"upfile' + num + '\ "/></div>';
			   $('#addMenu').append(tag);
			   num++;
		   } );
	   });
	</script> -->
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
			<input type="submit" value="등록" /><br>			<!-- 메뉴를 등록하는 버튼 -->
			<button type="button" onclick="location.href='/'">	<!-- 메뉴를 전부 등록하였으면 홈으로 나간다 -->
				홈으로
			</button>
		</div>
	</form>
	<table border="1">
		<tr>
			<th>메뉴이름</th>
			<th>가격</th>
			<th>메뉴사진</th>
		</tr>
		<c:forEach var="menu" items="${menuList}">				<!-- 메뉴를 등록하고 등록된 목록을 보여준다 -->
			<tr>
				<td>${menu.menu_name}</td>
				<td>${menu.menu_price}</td>
				<td>${menu.sfile_name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>