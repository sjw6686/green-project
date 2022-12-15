<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>식당등록</title>
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
				<c:forEach var="categoryList" items="${categoryList}">
					<option value="${categoryList.category_name}">${categoryList.category_name}</option>
				</c:forEach>
			</select>
			<label>간단한 소개글</label><br>
			<textarea name="introduce" id="introduce"></textarea><br>
			<input type="submit" value="등록하기" />
		</form>
	</div>
</body>
</html>