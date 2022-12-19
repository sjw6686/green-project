<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here11</title>
<link rel="stylesheet" href="/css/common.css" />
<style>
  input[type=button] {
      display : inline-block;
      height: 100px; width:100px;
  }
    h2 { margin:20px;  }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			location.href = "${path}/board/WriteForm";
		});
	});
</script>
</head>
<body>
<div id="main">
	<%@ include file="/WEB-INF/views/includeFile/header.jsp" %>
	<h2>사용자 조회</h2>
	<form name="form1" method="post" action="${path}/admin/search">
		<select name="searchOption">
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >전체</option>
			<option value="board_title" <c:out value="${map.searchOption == 'board_title'?'selected':''}"/> >제목</option>
			<option value="user_id" <c:out value="${map.searchOption == 'user_id'?'selected':''}"/> >이름</option>
			<option value="board_content" <c:out value="${map.searchOption == 'board_content'?'selected':''}"/> >내용</option>
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="조회">
	</form>
	${map.count}개가 조회되었습니다.
	<table border="1" width="600px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${map.list}">
			<tr>
				<td><a href="${path}/board">${list.board_title}</a></td>
				<td>${list.user_id}</td>
				<td>
					<fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-DD HH:mm:ss" />
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>