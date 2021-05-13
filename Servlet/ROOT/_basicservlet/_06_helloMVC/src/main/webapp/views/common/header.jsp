<%@ page import="com.member.model.vo.Member" %>
<%@ page import="com.common.listener.LoginCheckListener" %><%--
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery.3.6.0.js"></script>
</head>
<body>
    <div id="container">
        <header>
            <h1>Hello MVC</h1>
            <div class ="login-container">
            <%
//                Member loginMember =(Member)request.getAttribute("loginMember");
//                session으로 저장했으니까 request 가아니라 session으로 가져오자
                Member loginMember=(Member)session.getAttribute("loginMember");

                // 쿠키값 가져오기
                Cookie[] cookies = request.getCookies();
                String saveId = null;
                if(cookies != null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("saveId")){
                            saveId=c.getValue();
                            break;
                        }
                    }
                }

                if(loginMember==null){%>
                <form id="loginFrm" action="<%=request.getContextPath()%>/login" method="post" onsubmit="return fn_login_validate();">
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="userId" id="userId"  value="<%=saveId !=null? saveId:""%>" placeholder="아이디">
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="password" name="password" id="pw" placeholder="비밀번호">
                            </td>
                            <td>
                                <input type="submit" value="로그인">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="checkbox" name="saveId" id="saveId" <%=saveId!=null ?"checked":""%>>
                                <label for="saveId">아이디 저장</label>
                                <input type="button" value="회원가입" onclick=location.replace('<%=request.getContextPath()%>/views/member/memberenroll.jsp')>
                            </td>
                        </tr>
                    </table>
                </form>
                <%}else {%>
                    <table id="logged-in">
                        <tr>
                            <td colspan="2"><%=loginMember.getUserName()%>님 환영합니다.</td>
                        </tr>
<%--                        <tr>--%>
<%--                            <td colspan="2">현재접속자 수 :<%=LoginCheckListener.getCount()%></td>--%>
<%--                        </tr>--%>
<%--                        <form action="<%=request.getContextPath()%>/logout" method="post">--%>
<%--                            <tr>--%>
<%--                                <td><input type="submit" value="로그아웃"></td>--%>
<%--                                <td><input type="button" value="내정보 보기"></td>--%>
<%--                            </tr>--%>
<%--                        </form>--%>
                        <tr>
                            <td><input type="button" value="로그아웃" onclick="location.replace('<%=request.getContextPath()%>/logout')"></td>
                            <td><input type="button" value="내정보 보기" onclick="location.assign('<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember.getUserId()%>')"></td>
                        </tr>
                    </table>
                <%}%>
            </div>
            <nav>
                <ul class="main-nav">
                    <li class="home"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
                    <li id="notice"><a href="<%=request.getContextPath()%>/notice/noticeList">공지사항</a></li>
                    <li id="board"><a href="<%=request.getContextPath()%>/board/boardList">게시판</a></li>
                    <%if(loginMember != null && loginMember.getUserId().equals("admin")){%>
                        <li id="admin-member"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
                    <%}%>

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