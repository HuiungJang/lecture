<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 11:26 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = "유병승";
    String email ="1223@naver.com";
%>
<style>
        ul>li{
            display: inline-block;
            margin-right: 30px;
            font-size: 30px;
            font-weight: bolder;
        }
        li>a{
            text-decoration: none;
            color:magenta;
        }
        table{
            width:300px;
            height: 400px;
            border: 1px solid lime;
        }
        table td{
            border: 1px solid lime;
        }
</style>

<header>
    <ul>
        <li><a href="content.jsp">메인화면</a> </li>
        <li><a href="board.jsp">게시판</a> </li>
        <li><a href="">갤러리</a> </li>
        <li><a href="">자료실</a> </li>
    </ul>
</header>
