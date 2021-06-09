<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 12:34 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>그 외 코어 태그들</title>
</head>
<body>
<h3>c:import 이용하기</h3>
<p>
    페이지에서 다른 페이지를 불러오는 것 -> 페이지를 불러와서 바로 출력 x 변수에 저장
</p>
<ul>
    c:import 속성
    <li>var : 페이지를 저장하는 변수명</li>
    <li>url : 불러올 페이지의 위치</li>
</ul>
<%--<c:import url="http://www.google.com" var="header"/>--%>
<%--<c:out value="${pageScope.header}" escapeXml="false"/>--%>

<c:url var="addr" value="http://search.naver.com/search.naver">
    <c:param name="query" value="양호준"/>
</c:url>
<a href="${addr}">네이버 검색</a>

<h3>c:redirect 태그 이용하기</h3>
<p>페이지 변경해주는 태그</p>
<%--<c:redirect url="${addr}">--%>
<%--    <c:param name="query" value="코로나"/>--%>
<%--</c:redirect>--%>
<h3>c:catch 태그이용 예외처리하기</h3>
<%
    String test = null;
    request.setAttribute("test",test);
%>
<c:catch var="e">
    <%=test.charAt(0)%>
</c:catch>
<c:out value="${e}"/>
<%--${test.charAt(0)}--%>
</body>
</html>
