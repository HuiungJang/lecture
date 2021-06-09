<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 9:32 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl을 이용하기 위해서는 페이지 상단에 이용 jstl을 선언해야함--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>set/out 태그 활용하기</h3>
    <p>c:set -> 변수를 선언하여 활용하는 태그</p>
    <ul>c:set 속성
        <li>var   : 변수명</li>
        <li>value : 변수에 들어갈 값</li>
        <li>scope : 변수가 선언되는 위치 *생략하면 pageContext에 저장됨</li>
    </ul>
    <p>c:out -> EL 구문, 변수를 출력해주는 태그 *EL 표현식 ,&lt;%=%&gt; 동일함</p>
    <ul>c:out 속성
        <li>value     : 출력할 값(EL 표현식, 리터럴값)</li>
        <li>default   : 변수를 가져왔을 때 그 값이 없는 경우 출력될 기본값 설정</li>
        <li>escapeXml : 태그형식으로 value를 작성했을 때 태그로 해석할지 결정하는 속성(true,false)</li>
    </ul>

    <h2>page에서 사용할 변수 사용하기</h2>
    <c:set var="name" value="유병승"/>
    <h3>c:set으로 선언한 변수는 EL 표현식으로 출력할 수 있음</h3>
    <p>c:set으로 설정한 변수 가져오기 -> ${name}</p>
    <h3>c:set으로 선언한 변수는 c:out으로 출력가능</h3>
    <p>c:out으로 출력하기 -> <c:out value="${name}"/></p>

    <c:set var="addr" value="경기도 시흥시" scope="request"/>
    <p>${pageScope.name} ${pageScope.addr} ${requestScope.addr}</p>
    <a href="${path}/text">페이지 연결</a>

    <h3>c:out</h3>
    리터럴 사용 : <c:out value="안녕하세요 오늘은 수요일"/><br>
    EL 표현식 사용 : <c:out value="${addr}"/>
    <%
        String hobby = "code";
    %>
    출력식 : <c:out value="<%=hobby%>"/><br>
    출력식 : <c:out value='<%=request.getAttribute("addr")%>'/><br>
    <h3>
        <c:out value="이건?"/>
    </h3>
    <c:out value="<h3>이건??</h3>"/>
    <c:out value="<h3>이건???</h3>" escapeXml="false"/>
    <c:out value="<h3>이건???</h3>" escapeXml="true"/>

    <%
        String test = "<script>alert('!!!!')</script>";
        request.setAttribute("test",test);
    %>

    <c:set var="script" value="<script>alert('??')</script>"/><br>
    ${script}
    <c:out value="${script}"/><br>
    <input type="text" value="<c:out value='이건 c:out으로 작성'/>">

</body>
</html>
