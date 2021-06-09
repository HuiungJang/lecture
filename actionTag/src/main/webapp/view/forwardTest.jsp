<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 11:37 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("지나갑니다~~");
    request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="useBeanTest.jsp">
    <jsp:param name="name" value="김지한"/>
    <jsp:param name="age" value="26"/>
    <jsp:param name="addr" value="서울"/>
</jsp:forward>