<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 2:59 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>추가 객체데이터 가져오기</title>
</head>
<body>
    <h3>쿠키값 가져오기</h3>
    <p> cookie 객체를 통해서 데이터를 가져옴</p>
    <h4>${cookie}</h4>
    <h4>${cookie.test.value}</h4>
    <h4>${cookie.test.name}</h4>

    <h3>header 값 가져오기</h3>
    <p> header 객체를 통해서 데이터를 가져옴</p>
    <h4>${header["User-Agent"]}</h4>
    <h4>${header["Referer"]}</h4>
</body>
</html>
