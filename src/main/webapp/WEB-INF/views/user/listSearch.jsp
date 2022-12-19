<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</script>
</head>
<body>
<div id="main">
   <h2>사용자 조회</h2>
      <!-- 이름 & 아이디로 서치 -->
	<div>
		<select name="searchType">
			<option value="userid">아이디</option>
			<option value="username">닉네임</option>
		</select>	
		
		<input type="text" name="keyword"/>
		<form type="submit" name="keyword"></form>
		
		<button type="button" id="searchBtn">검색</button>
		
	</div>

 </div>
 <script>

 document.getElementById("searchBtn").onclick = function () {
    
  let searchType = document.getElementsByName("searchType")[0].value;
  let keyword =  document.getElementsByName("keyword")[0].value;
  
  location.href = "/User/ListSearch" + "searchType=" + searchType + "keyword=" + keyword;
 };
</script>	
</body>
</html>