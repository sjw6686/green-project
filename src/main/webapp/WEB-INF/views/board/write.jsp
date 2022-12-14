<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 입력화면</title>
<link rel="stylesheet" href="../css/layout.css">
</head>
<script>
	function fn_submit() {
		var f = document.frm;
		if (f.board_title.value == "") {
			alert("제목을 입력해주세요.");
			f.board_title.focus();
			return false;
		}
		if (f.address.value == "") {
			alert("주소를 입력해주세요.");
			f.address.focus();
			return false;
		}
		if (f.board_content.value == "") {
			alert("내용을 입력해주세요.");
			f.board_content.focus();
			return false;
		}
		f.submit();
	}
	function fn_onload() {
		document.frm.board_title.focus();
	}
</script>
<body onload="fn_onload()">
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
				<form name="frm" method="post" action="WriteSave">
					<table>
						<caption>게시판 입력화면</caption>
						<colgroup>
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td><input type="text" name="board_title" class="box_name"
									placeholder="제목을 입력하세요."></td>
							</tr>
							<tr>
								<td><input type="text" id="address_kakao" name="address"
									readonly placeholder="주소를 입력하세요." /></td>
							</tr>
							<tr>
								<td><textarea name="board_content" rows="7" cols="50"
										class="box_name" placeholder="내용을 입력하세요."></textarea></td>
							</tr>
							<tr>
								<td colspan="5"><input type="file" name="fileName"></td>
							</tr>
						</tbody>
					</table>
					<div style="width: 100%; text-align: center; margin-top: 10px;">
						<button type="submit" onclick="fn_submit(); return false;">글쓰기</button>
					</div>
				</form>
			</article>
		</section>
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}
</script>
</html>