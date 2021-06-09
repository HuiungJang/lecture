<%@ page import="java.util.List" %>
<%@ page import="com.jspaction.model.vo.Person" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/08
  Time: 12:06 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL표현식 활용하기</title>
</head>
<body>
<%
    String name ="유병승";
    int age = 19;
    request.setAttribute("name",name);
    session.setAttribute("age",age);

    List<Person> persons
            = Arrays.asList(new Person[]{
                    new Person("김상현",29,"서울"),
                    new Person("김예진",26,"서울")
                });
    request.setAttribute("persons",persons);
%>
<h3> EL을 출력해보자</h3>
<p>EL로 작성한 명칭은 기본적으로 내장객체의 키값으로 인식함</p>
<h2>${name}${age}</h2>

<h3>EL을 이용해서 연산처리하기</h3>
<p> EL표현식 내부에는 산술, 논리, 비교, 삼항연산을 처리할 수 있음 </p>
<%
    request.setAttribute("su",20);
    request.setAttribute("su2",30);
    request.setAttribute("userId","admin");
    List<String> list = Arrays.asList(new String[]{"1","2","3"});
    request.setAttribute("list",list);
    Person p = new Person("양호준",27,"서울");
    request.setAttribute("p",p);
%>

<h4> 산술연산처리 </h4>
<p> su+su2 :${su+su2}</p>
<p> su-su2 :${su-su2}</p>

<p> su2%7 :${su2%7} ${su2 mod 7}</p>
<p> su/4 : ${su / 4} ${su div 4}</p>

<h4> 비교연산처리 </h4>
<p>su&lt;su2 : ${su<su2}</p>
<p>su&lt;su2 : ${su lt su2}</p>

<p>su&gt;su2 : ${su>su2}</p>
<p>su&gt;su2 : ${su gt su2}</p>

<p>su&lt;=su2 : ${su le su2}</p>
<p>su&gt;=su2 : ${su ge su2}</p>

<p> "admin" == userId : ${"admin"==userId} ${"admin" eq userId}</p>
<p>"admin" != userId : ${"admin" != userId} ${"admin" ne userId}</p>

<p> list == null : ${list == null}</p>
<p> list != null : ${not empty list}</p>
<p> list != null : ${empty list}</p>

<%list.isEmpty();%>
<p>age>19 && userId =="admin" : ${age>19 && userId =="admin"}</p>
<p>age>19 && userId =="admin" : ${age>19 and userId =="admin"}</p>

<p>age>19 || userId =="admin" : ${age>19 || userId =="admin"}</p>
<p>age>19 || userId =="admin" : ${age>19 or userId =="admin"}</p>

<h4>삼항연산자 사용하기</h4>
<p>${age>19?"성인입니다":"미성년입니다."}</p>

<h4>메소드 호출하기</h4>
<p>${list.size()}</p>

<h4>객체의 내용 출력하기</h4>
<p>Person 정보 출력하기 : ${p.name}</p>
<p>List 정보 출력하기 : ${list.get(0)}</p>

<p>persons 출력 : ${persons.get(0)}</p>
<p>persons 출력 : ${persons.get(0).name}</p>
<p>persons 출력 : ${persons.get(0).getName()}</p>

<h4> 서블릿에서 저장한 객체 EL로 불러오기</h4>
<a href="<%=request.getContextPath()%>/basicEl">서블릿 저장 데이터 출력</a>
<a href="${pageContext.request.contextPath}/basicEl"></a>
<h3> 파라미터로 전송한 값 받아오기</h3>
<form action="${pageContext.request.contextPath}/view/jstl/03_foreach.jsp">
    이름:<input type="text" name="name"><br>
    나이:<input type="text" name="age"><br>
    취미:
    <label>
        <input type="checkbox" name="hobby" value="등산">등산
    </label>
    <label>
        <input type="checkbox" name="hobby" value="게임">게임
    </label>
    <label>
        <input type="checkbox" name="hobby" value="골프">골프
    </label>
    <br>
    <input type="submit" value="전송">
</form>
</body>
</html>
