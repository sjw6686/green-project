<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="../css/layout.css">
</head>
<body>
	<div class="wrap">
		<header>
			<div class="top_header">우리동네 맛집 소개 게시판</div>
		</header>
		<nav>
			<ul>
				<li class="mainLink"><a href="/"> mian </a></li>
			</ul>
		</nav>
		<section>
			<article>
				<table class="mainTable">
					<thead class="thead">
						<tr>
							<th>번호</th>
							<th>작성자</th>
							<th>제목</th>
							<th>내용</th>
							<th>조회수</th>
							<th>좋아요수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${ boardList }">
							<tr>
								<td>${board.board_idx}</td>
								<td>${ board.user_id }</td>
								<td><a href="/Board/View?board_idx=${board.board_idx}">${ board.board_title }</a></td>
								<td>${ board.board_content }</td>
								<td>${ board.view_cnt }</td>
								<td>${ board.cnt_like }</td>
								<td>${ board.reg_date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/Board/Write" class="btn btn-primary pull right">글쓰기</a>
			</article>
		</section>
	</div>
</body>
</html>