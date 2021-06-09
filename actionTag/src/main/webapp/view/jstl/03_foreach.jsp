<%@ page import="com.jspaction.model.vo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 11:16 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>반복문 활용하기</title>
</head>
<body>
    <h3>반복문 -> c:forEach 태그를 이용</h3>
    <p>두가지 방법으로 사용가능</p>
    <p> 1. 기본 for</p>
    <p> 2.forEach (배열, collection)</p>
    <ul>c:forEach 속성
        <li> begin : 초기값 (시작값) *기본 for문</li>
        <li> end   : 마지막 값( 끝내는 값 ) *기본 for문</li>
        <li> step  : 증감식 (초기값에서 step 값만큼 증가/ 감소 *기본 for문</li>
        <li> var   : 배열, 컬렉션의 값을 순차적으로 보관하는 변수명</li>
        <li> items : 배열, 컬렉션을 선언 *EL 표현식으로 가져옴</li>
        <li> varStatus : index, 반복수, 시작값, 마지막값을 저장한 객체</li>
    </ul>
    <h3> 기본 반복문 활용하기</h3>
    <h4>1~10 출력하기</h4>
    <c:forEach var="i" begin="1" end="10" step="1">
    <%--    for(int i =1; i<=10; i++){}--%>
        <c:out value="${i}"/>
    </c:forEach>
    <%--    step default -> 1 --%>
    <c:forEach var="i" begin="1" end="6">
        <h${i}>이거는 어케 출력될까요??</h${i}>
    </c:forEach>

    <h4>배열, List를 c:forEach 태그로 이용하기</h4>
<%
    request.setAttribute("names",new String[]{"유병승","양호준","곽승혁","김두호","김상현","김태희"});
    List<Person> list = Arrays.asList(new Person[]{
            new Person("유병승",19,"경기도"),
            new Person("김예진",26,"서울"),
            new Person("김지한",26,"서울"),
            new Person("권설영",20,"서울시")
    });
    request.setAttribute("list",list);
%>
    <ul>
    <c:forEach var="n" items="${names}">
        <li><c:out value="${n}"/></li>
    </c:forEach>
    </ul>
    <c:if test="${not empty list}">
        <ul>
            <c:forEach var="p" items="${list}">
                <li><c:out value="${p}"/></li>
            </c:forEach>
        </ul>
    </c:if>

    list에 있는 객체를 테이블 형식으로 출력하기
    <table>
        <c:if test="${not empty list}">
            <c:forEach var="j" items="${list}" varStatus="vs">
                <c:if test="${vs.count<3}">
                <tr>
<%--                    <td>${j.name}</td>--%>
<%--                    <td>${j.age}</td>--%>
<%--                    <td>${j.addr}</td>--%>
                    <td><c:out value="${j.name}"/></td>
                    <td><c:out value="${j.age}"/></td>
                    <td><c:out value="${j.addr}"/></td>
                </tr>
                </c:if>
            </c:forEach>
        </c:if>
    </table>

    <c:forEach var="p" items="${list}" varStatus="vs">
        인덱스 : ${vs.index}
        반복수 : ${vs.count}
        첫번째 값 : ${vs.first}
        마지막 값 : ${vs.last}
        <br>
    </c:forEach>
<table>
    <c:forEach var="p" items="${list}" varStatus="vs">
        <c:if test="${vs.first}">
            <tr>
                <th>이름</th>
                <th>나이</th>
                <th>주소</th>
            </tr>
        </c:if>
        <tr>
            <td><c:out value="${p.name}"/></td>
            <td><c:out value="${p.age}"/></td>
            <td><c:out value="${p.addr}"/></td>
        </tr>
        <c:if test="${vs.last}">
            <tr>
                <td>총인원수 : </td>
                <td colspan="2"><c:out value="${vs.count}"/></td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<h3> 파라미터로 받은 값 c:forEach로 출력하기</h3>
<c:forEach var="h" items="${paramValues.hobby}">
    <c:out  value="${h}"/>
</c:forEach>

<h3>c:forTokens 활용하기</h3>
<p>
    StringTokenizer 객체와 비슷한 기능함
    문자열을 특정 구분자로 분리해 반복문으로 출력
</p>
<ul>
    c:forTokens 속성
    <li>var : 값을 받는 변수</li>
    <li>delims : 분리기준이 되는 문자</li>
    <li>items : 분리할 문자열</li>
</ul>
<c:set var="hobby" value="코딩,등산,쿵푸,독서,낮잠"/>
<h4><c:out value="${hobby}"/></h4>

<c:forTokens var="h" items="${hobby}" delims=",">
    <c:if test="${h.contains('코딩') or h.contains('낮잠')}">
        <li><c:out value="${h}"/></li>
    </c:if>
</c:forTokens>
</body>
</html>
