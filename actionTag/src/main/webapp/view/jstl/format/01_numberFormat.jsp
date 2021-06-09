<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/09
  Time: 1:53 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>숫자 표현하기</title>
</head>
<body>
    <h1>기본 숫자 표현하기</h1>
    <c:set var="numtest" value="123456789"/>
    <c:set var="numtest1" value="2134213000"/>
    <c:set var="numtest2" value="1"/>
    <c:set var="numtest3" value="1234.123"/>
    <h3> 기본 출력 : ${numtest}</h3>
    <h3> 기본 숫자 출력 : <c:out value="${numtest}"/> </h3>

<h2> fmt : numberFormat 태그 이용해서 숫자출력하기</h2>
<h3><fmt:formatNumber value="${numtest}" /></h3>
<h3> groupingUsed 속성을 설정해서 , 구분한다.</h3>
<h3><fmt:formatNumber value="${numtest}" groupingUsed="true"/> </h3>
<h3><fmt:formatNumber value="${numtest}" groupingUsed="false"/> </h3>

<h2> 화폐단위를 출력할때</h2>
<p>type 속성을 이용하여 설정 - > type="currency"</p>
<fmt:setLocale value="ko_KR"/>
<h3><fmt:formatNumber value="${numtest}"/> </h3>
<h3><fmt:formatNumber value="${numtest}" type="currency"/> </h3>
<h3><fmt:formatNumber value="${numtest}" type="currency" currencySymbol="$"/></h3>
<h3>현재 로케일 : ${pageContext.request.locale}</h3>

<h2>퍼센트 표시하기</h2>
<p>
    type 속성에 percent 값을 대입함.
    value= 0~1 까지 가능
</p>
<h3><fmt:formatNumber type="percent" value="${numtest2}"/> </h3>
<h3><fmt:formatNumber type="percent" value="0.35"/> </h3>

<h2>패턴으로 숫자표현하기</h2>
<p>
    pattern 속성을 이용함
    0 : pattern 으로 지정한 자리에 수가 없으면 0
    # : pattern 으로 지정한 자리에 수가 없으면 출력안함(공백)
</p>
<h3><fmt:formatNumber value="1234.1235" pattern="####,###.00000000"/> </h3>
<h3>0 : ${numtest3} => <fmt:formatNumber value="${numtest3}" pattern="0,00.0000"/> </h3>
<h3># : ${numtest3} => <fmt:formatNumber value="${numtest3}" pattern="###,###.####"/> </h3>

<h2> 소수점 처리하기 </h2>
<p>
    minFractionDigits : 최소 소수점자리
    maxFractionDigits : 최대 소수점자리
</p>

<h3><fmt:formatNumber value="123.14" minFractionDigits="5" pattern="#,###.##"/> </h3>

<%--    넘어가면 반올림--%>
<h3><fmt:formatNumber value="123.16" maxFractionDigits="1" pattern="#,###.##"/> </h3>

<h2> 정수 자리 수 처리하기</h2>
<p>
    minIntegerDigits : 최소 정수 자리수
    maxIntegerDigits : 최대 정수 자리수
</p>
    <h3><fmt:formatNumber value="12.14" minIntegerDigits="3" pattern="#,###.##"/> </h3>
    <h3><fmt:formatNumber value="1230.14" minIntegerDigits="3" pattern="#,###.##"/> </h3>
    <h3><fmt:formatNumber value="1230.16" maxIntegerDigits="3" pattern="#,###.##"/> </h3>
</body>
</html>
