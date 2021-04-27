<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.member.vo.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/27
  Time: 9:25 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Member> members = new ArrayList<>();
    members.add(new Member("admin","admin","관리자",12));
    members.add(new Member("user1","user1","유저1",11));
    members.add(new Member("user2","user2","유저2",10));
    members.add(new Member("user3","user3","유저3",9));

    request.setAttribute("members",members);

    RequestDispatcher rd = request.getRequestDispatcher("viewmember.jsp");
    rd.forward(request,response);

%>
