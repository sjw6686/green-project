<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
 @charset "UTF-8";
.btn {
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 14px;
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
        margin-top: 20px;
        }
      .mp{
      display:block;
      }
    </style>
</head>

<body>
<header><h2>${UserID}님 환영합니다.</h2></header>
<a href="/"><button class="btn btn-primary home" >메인</button></a>
<a href="/"><button class="btn btn-primary home" >로그아웃</button></a>
<div class="mp">
<button class="btn btn-primary home"  type="button" onclick="local.href='/restaurant/mypage/comment'">내가 쓴 댓글</button>
<button class="btn btn-primary home"  type="button" onclick="local.href='restaurant/mypage/board'">내가 쓴 게시글</button>
<button class="btn btn-primary home"  type="button" onclick="local.href='restaurant/mypage/reviewList'">내가 쓴 리뷰</button>

</div>
                                    

</body>
</html>