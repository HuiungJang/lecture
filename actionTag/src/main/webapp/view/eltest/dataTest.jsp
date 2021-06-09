<%@ page import="com.jspaction.model.vo.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 1:57 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
//    List<Person> list = (List<Person>)request.getAttribute("list");
%>
<head>
    <title>데이터 확인하기</title>
</head>
<body>
    <h2> 서블릿에서 보낸 리스트</h2>
    <h4>${list}</h4>
    <h5>${list.get(0).name}</h5>
<%--    <c:forEach var="p" items="${list}">--%>

<%--    </c:forEach>--%>

    <h5>${p.name}</h5>
    <h2>session 값</h2>
    <h5>${name}</h5>
    <h2>context 값</h2>
    <h5>${email}</h5>
<%--
만약 값이 중복된다면
scope를 지정해서 사용한다.
pageContextScope
requestScope
sessionScope
contextScope
--%>
</body>
</html>
