<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/10
  Time: 2:41 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>마이바티스 사용하기</title>
</head>
<body>
    <h2>~~~~~~체험~~</h2>
    <a href="${path}/insertStudentTest">학생입력</a>

</body>
</html>
