<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
  .td1 { width:150px; text-align: center; }
  .td2 { width:400px; text-align: left; }
  .td3 { width:150px; text-align: center; }
  .td4 { width:400px; text-align: left; }
  
  [type=text]  { width:100%;  }
  textarea     { width:100%; height: 300px;  }
</style> -->
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $( function() {
	  $('form').on('submit', function(e) {
		  if( $('[name=title]').val().trim() == ''   ) {
			  alert('제목을 입력하세요');
		  	  return false;
		  }
		  // jqeury 에서는 return false는 아래 두 문장과 동일
		  //e.preventDefault();
		  //e.stopPropagation();
	  });
	  
	  $('#btnList').on('click', function() {
		  alert('목록으로 돌아갑니다.');		  
		  let    url     =  '/Board/View?board_idx=${boardCommentVo.comment_idx}';
		  location.href  =  url;
	  } )
	 
	 	 	  
  })
</script>
</head>
<body>
  <div id="main">
    <!-- 게시물 수정 -->
    <form action="/BoardComment/CommentUpdate" method="POST">
    <input type="hidden" name="comment_idx"     value="${boardCommentVo.comment_idx}" /> 
    <%-- <input type="hidden" name="menu_id" value="${ menu_id } " /> --%> 
    <table  id="boardCommentUpdate">
     <caption><h2>게시물 수정</h2></caption>
     <tr>
       <td class="td1">글쓴이</td>
       <td class="td2">${ boardCommentVo.user_id  }</td> <%--  <%=boardVo.getidx() %> --%>
       <td class="td3">날짜</td>
       <td class="td4">${ boardCommentVo.reg_date }</td>
     </tr>
     <tr>
       <td class="td1">내용</td>
       <td class="td2"  colspan="3">
       	 <textarea name="comment_content">${ boardCommentVo.comment_content }</textarea>
       </td>
     </tr>
     <tr>
       <td class="td1" colspan="4">
         <input type="submit"  value="수정" />
         <input type="button"  value="글 목록" id="btnList" />
        </td>      
     </tr>
    </table>
    </form>
   
  </div>
</body>
</html>














