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
	<form name="form1" method="post" action="${path}/admin/usersearch">
		<select name="searchOption">
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >전체</option>
			<option value="user_id" <c:out value="${map.searchOption == 'user_id'?'selected':''}"/> >아이디</option>
			<option value="user_tel" <c:out value="${map.searchOption == 'user_tel'?'selected':''}"/> >전화번호</option>
			<option value="user_role" <c:out value="${map.searchOption == 'user_role'?'selected':''}"/> >전화번호</option>
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="조회">
	</form>
	<table border="1" width="600px">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th>권한</th>
		</tr>
		<c:forEach var="list" items="${map.list}">
			<tr>
				<td>${list.user_id}</td>
				<td>${list.user_pw}</td>
				<td>${list.user_tel}</td>
				<td>
					${list.join_date}
				</td>
				<td>${list.user_role}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>등업신청 목록</h2>
	<form action="/restaurant/owner/userUpgradeProcess" method="post">
		<table border="1">
			<tr>
				<th>선택</th>
				<th>유저 아이디</th>
				<th>사업자번호</th>
			</tr>
			<c:forEach var="requestList" items="${requestList}">
				<tr>
					<td>
						<input type="checkbox" name="owner_idx" value="${requestList.ownerIdx}" />
						<input type="hidden" name="user_id" value="${requestList.userId}" />
					</td>
					<td>${requestList.userId}</td>
					<td>${requestList.ownerNum}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="submit" value="등업하기" />
		</div>
	</form>
</div>
</body>
</html>