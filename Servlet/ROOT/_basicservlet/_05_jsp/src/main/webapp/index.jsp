<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/26
  Time: 12:31 오후
  To change this template use File | Settings | File Templates.
--%>
<%--파일에 대한 설정 선언이 있다. 무조건 있어야한다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 첫 JSP페이지</title>
</head>
<body>
    <h1>Hello World!</h1>
    <h2>JSP 태그에 대해 알아보자</h2>
    <p>
        jsp 태그는 html 문서에서 자바 코드를 사용할 수 있게 하는 태그로
        &lt;%&gt; ->태그에 %가 있으면 자바코드로 인식<br>

        기본적인 자바코드를 작성 할 때는 스크립트 태그를 이용해서 작성 -> &lt;%&gt; <br>
        예) 지역변수, 조건문, 반복문, 메소드 호출(get/set)을 사용할 사용.<br>

        jsp로 생성되는 클래스의 멤버변수, 메소드를 선언 할 때는 지시자 태그를 이용 ->  &lt;%!&gt;<br>

        자바코드로 작성된 변수를 html  화면에 출력하려면 표현식 태그-> &lt;%=&gt;<br>
    </p>
    <h3>지시자 태그 이용하기</h3>
<%!
    // 클래스 선언부에 작성되는 코드를 작성할 수 있다.
//    지시자 태그
    String name = "유병승"; // default 접근 제한자를 갖는 멤버변수
    private int age = 19;

//    if(name.equals("유병승")){
//        System.out.println("안뇽");
//    }
//    클래스 선언부에는 조건문 반복문 등을 사용할 수 없다.
    public String test(){
        return "점심은 맛있어";
    }
%>
<h3>선언된 자바코드 화면에 출력하기</h3>
<h4>당신의 나이는 <%=age%></h4>
<h4>당신의 이름은 <%=name%></h4>
<h4>메소드 실행 <%=test()%></h4>

<h3> 스크립트립을 이용하기</h3>
<p>지역변수 조건문 반복문 등을 사용하기 위해</p>
<%
    String addr = "경기도 시흥시";
    double height = 194.1;
    String[] names= {"유병승","김상현","김예진","김두호","김지한"};
%>
<ul>
    <%for(int i=0; i<names.length; i++){
        if(names[i].equals("유병승")){
    %>
    <li><%=names[i]%></li>
    <%}
    }
    %>
</ul>
<%if(age>18){%>
    <h1>당신은 18세 이상이네요</h1>
    <%}else{%>
    <h1>당신은 18세 이상이 아니네요</h1>
<%} %>
<a href="views/innerObjjsp.jsp">innerObj.jsp</a>
<h2> 내장 객체의 값 출력하기</h2>
<%
    String[] hobby = (String[])request.getAttribute("hobby");
    String userId = (String)session.getAttribute("userId");
    String adminEmail = (String)application.getAttribute("email");
%>
<% if(hobby!=null){%>
<h2>당신의 취미는</h2>
<ul>
    <%for(String h :hobby){%>
        <li><%=h%></li>
    <%} %>
</ul>
<%} %>
<h2>session 저장 값은 ?<%=userId%></h2>
<h2>application 저장 값은 ?<%=adminEmail%></h2>

</body>
</html>
