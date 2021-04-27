<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 2:03 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello MVC</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery.3.6.0.js"></script>
</head>
<body>
    <div id="container">
        <header>
            <h1>Hello MVC</h1>
            <div class ="login-container">
                <form id="loginFrm" action="" method="post" onsubmit="return fn_login_validate();">
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="userId" id="userId" placeholder="아이디">
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="password" name="userPw" id="pw" placeholder="비밀번호">
                            </td>
                            <td>
                                <input type="submit" value="로그인">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="checkbox" name="saveId" id="saveId">
                                <label for="saveId">아이디 저장</label>
                                <input type="button" value="회원가입" onclick="">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <nav>
                <ul class="main-nav">
                    <li class="home"><a href="">Home</a></li>
                    <li id="notice"><a href="">공지사항</a></li>
                    <li id="board"><a href="">게시</a></li>
                </ul>
            </nav>
        </header>
        <script>
            const fn_login_validate= ()=>{
              // userId input 태그에 값이 있고 4글자 이상이면
              const userId = $('#userId').val();
              if(userId.trim().length <4){
                $('#userId').val('').focus();
                alert("아이디는 4글자 이상입니다.");
                return false;
              }

              // 비밀번호가 있어야 전송
              const userPw = $('#pw').val();
              if(userPw.trim().length === 0 ){
                alert("비밀번호를 입력하세요");
                return false;
              }

            }

        </script>