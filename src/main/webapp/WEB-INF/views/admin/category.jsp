<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <script src="/js/category.js"></script> -->
</head>
<body>
<%@ include file="/WEB-INF/views/includeFile/header.jsp" %>
	<h1 class="title">카테고리 관리</h1>
	<div class="cate_wrap">
		<span>카테고리 명</span>
		<form action="/admin/index/category/write" method="POST">
		<div>
		<input type="text" name="category_name"/>
		</div>
		<div>
		<input type="submit" value="add"/>
		</div>
		</form>
	</div>
	
	<div class="list">
		<table id="cate_table">
			<thead>
		 <h2>카테고리 목록으로 가기</h2>
		 <a href="/admin/index/category/list">카테고리 목록으로 가기</a>
			</tbody>
		</table>
	</div>
</body>
</html>