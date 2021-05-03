<%@ page import="com.member.model.vo.Member" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/03
  Time: 9:43 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member m = (Member)request.getAttribute("result");
%>
<html>
<head>
    <title>아이디 중복확인</title>
    <style>
        div#checkId-container{text-align: center;padding-top:50px }
        span#duplicated{color: red; font-weight: bolder;}
    </style>
</head>
<body>
<div id="checkId-container">
    <%if(m==null){%>
        [<span><%=request.getParameter("userId")%></span>]는 사용가능합니다.<br>
        <button type="button" onclick="fn_close();">닫기</button>
    <%}else{%>
        [<span id="duplicated"><%=request.getParameter("userId")%> </span>]는 사용중입니다.<br>
        <form action='<%=request.getContextPath()%>/checkDuplicateId'  method='post' onsubmit="return id_length();">
            <input type="text" name="userId" id="userId">
            <input type="submit" value="중복검사" >
        </form>
    <%}%>
</div>
<%--닫기 버튼을 누르면 현재 가져온 아이디를 부모창 userId_에 대입하고 창을 닫기--%>
<%--중복됐을 때는 다시 확인 --%>
<script>
    const fn_close=()=>{
        const id ='<%=request.getParameter("userId")%>';
        // 자식객체에서 부모객체로 이름값을 기준으로 직접접근이 가능하다.
        opener.memberEnrollForm.userId.value=id;

        // 다음 창으로 포커스 주기
        opener.memberEnrollForm.password.focus();
        window.close();
    }
    const id_length=()=>{
        let id = document.getElementById("userId").innerText.length;
        if(id<3){
          alert("아이디는 4글자 이상이어야합니다.");
          return false;
        }
    }
</script>
</body>
</html>
