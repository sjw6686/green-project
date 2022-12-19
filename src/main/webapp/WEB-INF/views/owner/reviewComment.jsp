<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
</head>
<body>
	<h2>리뷰</h2>
	<a href="/"></a>
	<table>
		<tr>
			<th>board_idx</th>
			<th>board_title</th>
			<th>board_content</th>
			<th>review_avg</th>
			<th>boardRegDate</th>
			<th>restaurant_idx</th>
			<th>view_cnt</th>
			<th>boardWriter</th>
			<th>cnt_like</th>
			<th>cnt_hate</th>
		</tr>
		<tr>
			<td>${ownerBoardVo.board_idx}</td>
			<td>${ownerBoardVo.board_title}</td>
			<td>${ownerBoardVo.board_content}</td>
			<td>${ownerBoardVo.review_avg}</td>
			<td>${ownerBoardVo.boardRegDate}</td>
			<td>${ownerBoardVo.restaurant_idx}</td>
			<td>${ownerBoardVo.view_cnt}</td>
			<td>${ownerBoardVo.boardWriter}</td>
			<td>${ownerBoardVo.cnt_like}</td>
			<td>${ownerBoardVo.cnt_hate}</td>
		</tr>
	</table>
	<c:if test="${reviewCommentList[0].comment_idx != 0}">
		<table>
			<tr>
				<th>comment_idx</th>
				<th>commentWriter</th>
				<th>comment_content</th>
				<th>commentBoardIdx</th>
				<th>commentRegDate</th>
				<th>lvl</th>
				<th>step</th>
				<th>cnum</th>
				<th>nref</th>
			</tr>
			<c:forEach var="comment" items="${reviewCommentList}">
				<tr>
					<td>${comment.comment_idx}</td>
					<td>${comment.commentWriter}</td>
					<td>${comment.comment_content}</td>
					<td>${comment.commentBoardIdx}</td>
					<td>${comment.commentRegDate}</td>
					<td>${comment.lvl}</td>
					<td>${comment.step}</td>
					<td>${comment.cnum}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>