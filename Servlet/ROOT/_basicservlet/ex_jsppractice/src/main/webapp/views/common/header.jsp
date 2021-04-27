<%@ page import="com.test.model.vo.Member" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 11:47 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member loginMember = (Member)session.getAttribute("loginMember");
%>
<html>
<head>
    <title>Title</title>
    <style>
        ul>li{
            display: inline-block;
            margin-left: 30px;
            font-size:30px;
            font-weight: bolder;
        }
        ul>li>a{
            text-decoration: none;
            color: royalblue;
        }
        header{
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <header>
        <div></div>
        <div>
            <ul>
                <li><a href="">메인화면</a></li>
                <li><a href="">게시판</a></li>
                <li><a href="">갤러리</a></li>
                <li><a href="">자료실</a></li>
            </ul>
        </div>
        <div>
            <%if(loginMember ==null){%>
            <form action="${pageContext.request.contextPath}/login.do" method="post">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="userId"> </td>
                    </tr>
                    <tr>
                        <td>패스워드</td>
                        <td><input type="password" name="userPw"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="로그인"></td>
                        <td><input type="reset" value="취소"></td>
                    </tr>
                </table>
            </form>
            <%} else{%>
                <h3><%=loginMember.getMemberId()%>님 환영합니다</h3>
            <%}%>

        </div>
    </header>