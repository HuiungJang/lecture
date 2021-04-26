<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/26
  Time: 2:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%--패키지 import하기--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="javax.servlet.RequestDispatcher"
%>
<html>
<head>
    <title>내장객체 사용하기</title>
</head>
<body>
    <h1>내장객체 출력하기</h1>
    <h2><%=request%></h2>
    <h2><%=session%></h2>
    <h2><%=application%></h2>
    <h2><%=response%></h2>
    <h2><%=request%></h2>
    <%
        request.setAttribute("hobby",new String[]{"코딩","정처기","운동","차마시기"});
        session.setAttribute("userId","hh1");
        application.setAttribute("email","jhw11@123.com");
//        response.sendRedirect(request.getContextPath()+"/");
        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request,response);
    %>
</body>
</html>
