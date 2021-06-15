<%@ page import="com.mybatis.model.vo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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

<c:set var="info" value="${requestScope.info}"/>
<c:if test="${info == null}">
    <script>
      location.replace("${path}/getInfo");
    </script>
</c:if>

<%
    List<Map<String,Student>> tmp = (List<Map<String,Student>>) request.getAttribute("info");
%>

<html>
<head>
    <title>마이바티스 사용하기</title>
</head>
<body>
    <h2>~~~~~~체험~~</h2>
    <a href="${path}/insertStudentTest">학생입력</a>
    <h3>학생이름 등록하기</h3>
    <form action="${path}/paramMybatis" method="post">
        <input type="text" name="name">
        <input type="text" name="email">
        <input type="submit" value="이름 저장">
    </form>

    <h3>여러개의 파라미터 저장하기</h3>
    <form action="${path}/paramAll" method="post">
        이름 <input type="text" name="name">
        이메일 <input type="email" name="email">
        주소 <input type="text" name="addr">
        전화번호 <input type="tel" name="phone">
        <input type="submit" value="등록">
    </form>
    <h3>등록된 회원의 이름, 주소, 전화번호를 받아서 수정해보자</h3>

    <c:if test="${info != null}">
        <form action="${pageContext.request.contextPath}/updateInfo" method="post">
            이름
            <select id ="select" name="replaceName">
                <%for(int i =0; i<tmp.size(); i++){%>
                    <option><%=tmp.get(i).get("STUDENT_NAME")%></option>
                <%}%>
            </select>
            수정할 주소 <input type="text" name="replaceAddr">
            수정할 전화번호 <input type="text" name="replaceTel">
            <input type="submit" value="수정">
        </form>
    </c:if>

    <h3>등록된 회원의 이름을 받아 삭제하기</h3>

    <a href="${path}/selectStudent?no=1">1번학생 호출</a>

    <h3>student 테이블의 전체 학생 가져오기</h3>
    <a href="${path}/selectStudentList">전체 학생 조회</a>

    <h2>vo 객체를 이용하지 않고 Data 가져오기</h2>
    <p>
        vo 객체를 MAP 객체로 대체해서 DB의 데이터를 가져올 수 있음
        Map -> key= 컬럼명, value= 값
    </p>
    <a href="${path}/selectStudentMap?no=1">학생 한명 조회</a>
    <a href="${path}/selectStudentListMap">학생 전체 조회</a>
</body>
</html>
