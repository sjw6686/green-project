<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>리뷰쓰기</h2>
	<form action="/restaurant/owner/writeReviewProcess" method="post">
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="restaurant_idx" value="${restaurant_idx}" />
		<label>제목</label><br>
		<input type="text" name="title" /><br>
		<label>평점</label><br>
		<input type="text" name="review_avg" /><br>
		<label>내용</label><br>
		<textarea name="content"></textarea><br>
		<input type="submit" value="작성">
	</form>
</body>
</html>