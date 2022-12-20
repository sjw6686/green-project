<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
</head>
<body>
	<nav>
		<ul>
			<li class="mainLink"><a href="/"> mian </a></li>
		</ul>
	</nav>
	<div id="main">
		<h2>게시판 제목</h2>
		<a href="/Board/UpdateForm?board_idx=${boardVo.board_idx}">글 수정</a>
		<a href="/Board/Delete?board_idx=${boardVo.board_idx}">글 삭제</a>
		<!--  내용보기 -->
		<table id="board" border="1">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
				<th>작성일</th>
			</tr>
			<tr>
				<th>${ boardVo.board_idx }</th>
				<!-- 번호 -->
				<td>${ boardVo.user_id }</td>
				<!-- 작성자 -->
				<td>${ boardVo.board_title }</td>
				<!-- 제목 -->
				<td>${ boardVo.board_content }</td>
				<!-- 내용 -->
				<td>${ boardVo.view_cnt }</td>
				<!-- 조회수 -->
				<td>${ boardVo.cnt_like }</td>
				<!-- 좋아요 -->
				<td>${ boardVo.cnt_hate }</td>
				<!-- 싫어요 -->
				<td>${ boardVo.reg_date }</td>
				<!-- 작성일 -->
			</tr>
				
		</table>
		<table>
			<tr>
				<th>작성자</th>
				<th>댓글 내용</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="commentList" items="${commentList}">
				<tr>
					<td>${commentList.user_id}</td>
					<td>${commentList.comment_content}</td>
					<td>${commentList.reg_date}</td>
				</tr>
				<tr>
					<td>
					<a href="/restaurant/BoardComment/CommentUpdateForm?comment_idx=
								${ commentList.comment_idx}">글 수정</a>
					<a href="#">글 삭제</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		 <form method="post" action="/restaurant/BoardComment/Write">
			<input type="hidden" name="board_idx" value="${boardVo.board_idx}" />
			<input type="hidden" name="lvl" value="0" /> 
			<input type="hidden"name="step" value="0" /> 
			<input type="hidden" name="cnum" value="0" />
			<input type="hidden" name="nref" value="0" />
			<textarea name="comment_content" id="content" rows="4"></textarea>
			<input type="submit" value="댓글달기">
		</form> 
	</div>
</body>
</html>

