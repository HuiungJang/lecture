<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 11:22 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<%@include file="common/header.jsp"%>
<h2><%=name%>님의 이메일은 <%=email%></h2>
<section>
    <table>
        <tr>
            <td>이름</td>
            <td>나이</td>
            <td>성별</td>
            <td>키</td>
        </tr>
        <tr>
            <td>유병승</td>
            <td>12</td>
            <td>남</td>
            <td>123</td>
        </tr>
        <tr>
            <td>김상현</td>
            <td>13</td>
            <td>남</td>
            <td>123</td>
        </tr>
    </table>
</section>
<%@include file="common/footer.jsp"%>
</body>
</html>
