<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 11:04 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:choose>
        <c:when test="${param.su % 5 == 0}">
            <h4>케이스</h4>
        </c:when>
        <c:when test="${param.su % 5 == 3}">
            <h4>맥</h4>
        </c:when>
        <c:when test="${param.su % 5 == 2}">
            <h4>패드</h4>
        </c:when>
        <c:otherwise>
            <h4> 다음 기회에</h4>
        </c:otherwise>
    </c:choose>
</body>
</html>
