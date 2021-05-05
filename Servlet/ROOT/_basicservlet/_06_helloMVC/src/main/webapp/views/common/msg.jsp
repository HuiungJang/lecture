<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/30
  Time: 9:23 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String msg = (String)request.getAttribute("msg");
    String script=(String)request.getAttribute("close");
%>
<html>
<head>
    <title>시스템 메세지</title>
</head>
<body>
    <script>
        alert('<%=msg%>');
        <%=script!=null?script:""%>
        location.replace('<%=request.getContextPath()%><%=request.getAttribute("loc")%>');
    </script>
</body>
</html>
