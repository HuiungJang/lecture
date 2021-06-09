<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 10:30 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String memberId = "admin";
    // 호출한 곳에서 jsp:param 으로
    // 보낸 데이터는 request.getParameter()로 받을 수 있음
    request.setCharacterEncoding("utf-8");
    String title = request.getParameter("title");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <ul>
        <h1><%=title%></h1>
        <li>메인</li>
        <li>공지사항</li>
        <li>게시판</li>
        <li>갤러리</li>
    </ul>
</header>