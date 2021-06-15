<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/11
  Time: 3:02 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학생조회결과</title>
</head>
<body>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>주소</th>
            <th>가입일</th>
        </tr>
        <c:if test="${not empty student}">
            <tr>
                <td>${student.studentNo}</td>
                <td>${student.studentTel}</td>
                <td>${student.studentEamil}</td>
                <td>${student.studentAddr}</td>
                <td>${student.regDate}</td>
            </tr>
        </c:if>
    </table>
<h3>map 1개 출력 </h3>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>주소</th>
            <th>가입일</th>
        </tr>
        <%--            대소문자 구분한다.--%>
        <c:if test="${not empty student}">
        <tr>
            <td>${student.STUDENT_NO}</td>
            <td>${student.STUDENT_NAME}</td>
            <td>${student.STUDENT_TEL}</td>
            <td>${student.STUDENT_EMAIL}</td>
            <td>${student.STUDENT_ADDR}</td>
            <td>${student.REG_DATE}</td>
        </tr>
        </c:if>
    </table>


<h3>map 여러개 출력 </h3>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>주소</th>
            <th>가입일</th>
        </tr>
        <c:forEach var="s" items="${listMap}">
            <tr>
                <td><c:out value="${s.STUDENT_NO}"/></td>
                <td><c:out value="${s.STUDENT_NAME}"/></td>
                <td><c:out value="${s.STUDENT_TEL}"/></td>
                <td><c:out value="${s.STUDENT_EMAIL}"/></td>
                <td><c:out value="${s.STUDENT_ADDR}"/></td>
                <td><c:out value="${s.REG_DATE}"/></td>
<%--                <td><c:out value="${s.['STUDENT_NO']}"/></td>--%>
<%--                <td><c:out value="${s.['STUDENT_NAME']}"/></td>--%>
<%--                <td><c:out value="${s.['STUDENT_TEL']}"/></td>--%>
<%--                <td><c:out value="${s.['STUDENT_EMAIL']}"/></td>--%>
<%--                <td><c:out value="${s.['STUDENT_ADDR']}"/></td>--%>
<%--                <td><c:out value="${s.['REG_DATE']}"/></td>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
