<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 10:22 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>조건문 활용하기</title>
</head>
<body>
    <h2>c:if문 활용하기</h2>
    <p>자바의 if문과 동일함</p>
    <p>
        &lt;c:if test="비교연산" &gt; 로직 &lt;/c:if&gt;
    </p>

    <ul>
        c:if 속성
        <li>test  : true, false 값이 나오는 연산, 변수 등을 대입</li>
        <li>var   : if문 test 속성의 결과를 저장하는 변수</li>
    </ul>

    <c:set var="su" value="19"/>
    <c:set var="age" value="19"/>

    <c:if test="${su==20}">
        <h3>값은 20!</h3>
    </c:if>

    <form action="ifResult.jsp">
        <input type="text" name="su">
        <input type="text" name="su2">
        <input type="submit" value="계산">
        <select name="color">
            <option value="red">red</option>
            <option value="blue">blue</option>
            <option value="green">green</option>
        </select>
    </form>

    <h3> c:choose 태그 이용하기</h3>
    <p>
        switch 문과 문법 비슷
    </p>
    <p>
        작성법 : &lt;c:choose &gt; &lt;c:when test='' &gt; &lt;/c:when&gt; &lt;/c:choose &gt;
    </p>
    <form action="chooseTest.jsp">
        숫자를 입력하세요 <input type="number" name="su">
        <input type="submit" value="제출">
    </form>
</body>
</html>
