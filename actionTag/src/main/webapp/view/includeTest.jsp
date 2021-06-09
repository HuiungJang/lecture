<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 10:29 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="메인화면"/>
</jsp:include>
<%-- header에서 선언된 변수 사용불가능하다. --%>
<%-- 다른 불러왔을 때 불러온 페이지에 원하는 값을 전송(parameter)할 수 있다.--%>
<%-- jsp:param 태그를 이용한다.--%>



<%--<%@ include file="header.jsp"%>--%>
<%-- header에 선언된 변수 사용가능하다.--%>

<%-- jsp:include 는 각 jsp 파일을 각각 컴파일해서 사용한다.--%>


<section>
    <h1>여기가 본문부분</h1>
    <p> 당신의 아이디는 : 입니다.</p>
</section>