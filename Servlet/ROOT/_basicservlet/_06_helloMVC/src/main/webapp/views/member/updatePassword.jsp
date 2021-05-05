<%@ page import="com.member.model.vo.Member" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/04
  Time: 11:35 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<header>
    <style>
        div#updatePassword-container{
            background:red;
        }
        div#updatePassword-container table {
            margin:0 auto;
            border-spacing: 20px;
        }
        div#updatePassword-container table tr:last-of-type td {
            text-align:center;
        }
    </style>
    <script src="lecture/Web/web_lecture/KH_Web/JQurey/library/jquery.3.6.0.js"></script>
</header>
<%  Member m =(Member)request.getAttribute("member");%>
<body>
<div id="updatePassword-container">
    <form name="updatePwdFrm" action="<%=request.getContextPath()%>/updatepasswordend?userId=<%=request.getParameter("userId")%>" method="post" >
        <table>
            <tr>
                <th>현재 비밀번호</th>
                <td><input type="password" name="password" id="password" required></td>
            </tr>
            <tr>
                <th>변경할 비밀번호</th>
                <td>
                    <input type="password" name="password_new" id="password_new" required>
                </td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td>
                    <input type="password" id="password_chk" required><br>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="변경" />
                    <input type="button" value="닫기" onclick="window.close();"/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
    </form>
</div>

<script>
  const pwck = document.getElementById("password_chk");

  pwck.addEventListener((e)=>{
    let pw = document.getElementById("password_new").value;
    let pwckVal = e.target.value;
    if(pw!= pwckVal){
      alert("비밀번호가 일치하지 않습니다.");
      document.getElementById("password_new").focus();
    }
  });

  //
  // $('#password_chk').blur((e)=>{
  //   const pw= $('#password_new').val();
  //   const pwCk =$(e.target).val();
  //
  //   if(pw!=pwCk){
  //     alert("비밀번호가 일치하지 않습니다.");
  //     $('#password_').focus();
  //   }
  //
  // });
</script>
</body>
</html>