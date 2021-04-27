<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 10:18 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="color:red">에러라네~</h1>
    <%=exception.getMessage()%>
    <h3><a href="<%=request.getContextPath()%>">메인페이지로</a> </h3>
</body>
</html>
