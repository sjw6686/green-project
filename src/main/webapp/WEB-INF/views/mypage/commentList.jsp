<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>내 댓글</title>
<style>
.btn {
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 24px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        /* vertical-align: middle; */
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 4px;
    }
     .btn-primary {
        color: #fff;
        background-color: #337ab7;  
        border-color: #2e6da4;
        }
     th, td{
  
      margin-top:50px;}
      .table {
    margin-left:auto; 
    margin-right:auto;
}

*{margin:0; padding:0;
	text-align : center;}
	
</style>
</head>
<body>
<header><h2>내가 쓴 댓글</h2></header>
	<table class="table">
		<tr>	
			<th scope="col">번호</th>
			<th scope="col">댓글 내용</th>		
			<th scope="col">댓글 쓴 시간</th>
			<th scope="col">관리</th>			
		</tr>
		<c:forEach var="comlist" items="${commentList}" >
		<c:set var="i" value="${i+1}"/>
			<tr>
				<th scope="row">${i }</th>
				<td>${comlist.comment_content}</td>
				<td>${comlist.reg_date}</td>
				<td><a href="/BoardComment/CommentUpdateForm?comment_idx=${ comlist.comment_idx}"><button class="btn btn-sm btn-outline-secondary" >수정</button></a>
				<a href="/"></a><button class="btn btn-sm btn-outline-secondary" >삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>