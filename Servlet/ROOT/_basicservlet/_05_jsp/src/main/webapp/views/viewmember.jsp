<%@ page import="com.model.member.vo.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 9:33 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>저장된 회원정보 출력</h2>
    <%
        List<Member> members =(List<Member>)request.getAttribute("members");
    %>

    <table>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>나이</th>
        </tr>
    <%for(Member m : members){%>
        <tr>
            <td><%=m.getMemberId()%></td>
            <td><%=m.getMemberPw()%></td>
            <td><%=m.getMemberName()%></td>
            <td><%=m.getAge()%></td>
        </tr>
    <%}%>
    </table>

</body>
</html>
