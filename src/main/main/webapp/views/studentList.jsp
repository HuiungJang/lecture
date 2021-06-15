<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/14
  Time: 9:28 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>전체학생조회</title>
</head>
<body>
    <h2>학생조회</h2>
    <form action="${path}/searchStudent" method="post">
        <input type="text" name="email">
        <input type="submit" value="조회">
    </form>

    <h4>학생조회결과</h4>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>주소</th>
            <th>등록일</th>
        </tr>
        <c:if test="${not empty list}">
            <c:forEach var="s" items="${list}">
                <tr>
                    <td><c:out value="${s.studentNo}"/></td>
                    <td><c:out value="${s.studentName}"/></td>
                    <td><c:out value="${s.studentTel}"/></td>
                    <td><c:out value="${s.studentEmail}"/></td>
                    <td><c:out value="${s.studentAddr}"/></td>
                    <td><c:out value="${s.regDate}"/></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</body>
</html>

