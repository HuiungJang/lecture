<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 10:35 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ifResult</title>
</head>
<body>
    <c:if test="${param.su + param.su2 > 100}">
        <h3>와 100 보다 큽니다</h3>
    </c:if>
<%--    <c:if test="${param.su > param.su2}">--%>
<%--        <h3>${param.su} 가 ${param.su2} 보다 크다</h3>--%>
<%--    </c:if>--%>
<%--    <c:if test="${param.color eq 'red'}">--%>
<%--        <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 빨강</h3>--%>
<%--    </c:if>--%>
<%--    <c:if test="${param.color eq 'blue'}">--%>
<%--        <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 파랑</h3>--%>
<%--    </c:if>--%>
<%--    <c:if test="${param.color eq 'green'}">--%>
<%--        <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 초록</h3>--%>
<%--    </c:if>--%>

    <c:choose>
        <c:when test="${param.color eq 'red'}">
            <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 빨강</h3>
        </c:when>
        <c:when test="${param.color eq 'blue'}">
            <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 파랑</h3>
        </c:when>
        <c:when test="${param.color eq 'green'}">
            <h3 style="color:<c:out value='${param.color}'/>"> 당신이 선택한 컬러는 초록</h3>
        </c:when>
    </c:choose>

</body>
</html>
