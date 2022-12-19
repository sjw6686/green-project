<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>관리자 :: 회원관리</title>
    <style>
        table {
            margin-top: 30px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="user.js"></script>
</head>

<body>
    <%@include file="/WEB-INF/views/admin/index.jsp" %>
    <h1 class="title">회원 관리</h1>
    <div>
        <table>
            <thead>
                <tr>
                    <td>아이디</td>
                    <td>비밀번호</td>
                    <td>전화번호</td>
                    <td>이메일</td>
                    <td>가입날짜</td>
                    <td>계정상태</td>
                </tr>
            </thead>
            <tbody id="user_list_body">

            </tbody>
        </table>
    </div>

</body>

</html>