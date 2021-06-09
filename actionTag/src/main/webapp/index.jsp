<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>표준 액션태그</title>
</head>
<body>
<h1>표준 액션태그-> jsp:태그명</h1>

<h2>jsp:include</h2>
<p>
    외부의 페이지를 불러와 사용하는 태그
</p>
<a href="<%=request.getContextPath()%>/view/includeTest.jsp"> 이동 </a> <br>
<a href="<%=request.getContextPath()%>/view/notice.jsp"> notice 이동 </a>

<h2>jps:usebean 이용하기</h2>
<p>
    vo 객체를 jsp 태그로 이용하는 것
    parma 값, request  저장된 vo 자동 매핑
</p>
<a href="<%=request.getContextPath()%>/useBeanTest">useBean 활용하기</a>
<form action="<%=request.getContextPath()%>/view/useBeanTest.jsp">
    이름<input type="text" name="name"><br>
    나이<input type="text" name="age"><br>
    주소<input type="text" name="addr"><br>
    <input type="submit" value="전송">
</form>

<h3>jsp:forward 활용하기</h3>
<p>
    jsp 페이지를 다른 페이지로 이동시키는 태그
    이동시킬 때 parameter 값을 전송할 수 있음
</p>
<a href="view/forwardTest.jsp"> 페이지 이동설정</a>

<h3> 내장객체 (cookies, header)에 있는 데이터 가져오기</h3>
<a href="${pageContext.request.contextPath}/extraData">데이터 가져오기</a>
</body>
</html>