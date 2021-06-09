<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 2:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>parameter 받기</title>
</head>
<body>
    <h1>파라미터로 전송된 데이터 받기</h1>
    <p> 파라미터로 전송된 데이터는 param 객체를 통해서 받아옴</p>
    <h4>${param.name} ${param.age} ${param.hobby}</h4>

    <h4>${paramValues.hobby[0]} ${paramValues.hobby[1]} ${paramValues.hobby[2]}</h4>

</body>
</html>
