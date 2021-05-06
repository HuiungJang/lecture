<%@ page import="com.common.AESCrypto" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/03
  Time: 10:45 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member m =(Member)request.getAttribute("member");
%>
<%@include file="/views/common/header.jsp"%>
<style>
    section#enroll-container input[readonly]{
        background-color: lightgray;
    }
</style>
<section id=enroll-container>
    <h2>회원 정보 수정</h2>
    <form name="memberReplace" id="memberFrm" method="post" onsubmit="return fn_update_validate();">
        <table>
            <tr>
                <th>아이디</th>
                <td>
<%--                    disabled 사용하면 form으로 서버로 값을 넘기지 못함 readonly 사용하면 서버로 데이터보내기 가능--%>
                    <input type="text" name="userId" id="userId_" value="<%=m.getUserId()%>" readonly>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>패스워드</th>--%>
<%--                <td>--%>
<%--                    <input type="password" name="password" id="password_" value="<%=m.getPassword()%>" required>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>패스워드확인</th>--%>
<%--                <td>--%>
<%--                    <input type="password" id="password_2"><br>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text"  name="userName" id="userName" value="<%=m.getUserName()%>" required><br>
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="number" name="age" id="age" value="<%=m.getAge()%>"><br>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=m.getEmail()%>"><br>
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>
                    <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=m.getPhone()%>"><br>
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" placeholder="" name="address" id="address" value="<%=m.getAddress()%>"><br>
                </td>
            </tr>
            <tr>
                <th>성별 </th>
                <td>
<%--                    DB정보에 따라 분기처리할것--%>
<%--                    <%if(m.getGender().equals("M")){%>--%>
<%--                        <input type="radio" name="gender" id="gender0" value="M" checked>--%>
<%--                        <label for="gender0">남</label>--%>
<%--                        <input type="radio" name="gender" id="gender1" value="F" disabled>--%>
<%--                        <label for="gender1">여</label>--%>
<%--                    <%} else{%>--%>
<%--                        <input type="radio" name="gender" id="gender0" value="M" disabled>--%>
<%--                        <label for="gender0">남</label>--%>
<%--                        <input type="radio" name="gender" id="gender1" value="F" checked>--%>
<%--                        <label for="gender1">여</label>--%>
<%--                    <%}%>--%>

                        <input type="radio" name="gender" id="gender0" value="M" <%=m.getGender().equals("M")?"checked":"disabled"%>>
                        <label for="gender0">남</label>
                        <input type="radio" name="gender" id="gender1" value="F" <%=m.getGender().equals("F")?"checked":"disabled"%>>
                        <label for="gender1">여</label>
                </td>
            </tr>
            <tr>
                <th>취미 </th>
                <td>
                    <input type="checkbox" name="hobby" id="hobby0" value="운동" <%=m.getHobby().contains("운동")?"checked":""%>><label for="hobby0">운동</label>
                    <input type="checkbox" name="hobby" id="hobby1" value="등산" <%=m.getHobby().contains("등산")?"checked":""%>><label for="hobby1">등산</label>
                    <input type="checkbox" name="hobby" id="hobby2" value="독서" <%=m.getHobby().contains("독서")?"checked":""%>><label for="hobby2">독서</label><br />
                    <input type="checkbox" name="hobby" id="hobby3" value="게임" <%=m.getHobby().contains("게임")?"checked":""%>><label for="hobby3">게임</label>
                    <input type="checkbox" name="hobby" id="hobby4" value="여행" <%=m.getHobby().contains("여행")?"checked":""%>><label for="hobby4">여행</label><br />
                </td>
            </tr>
        </table>
        <input type="button" value="정보수정" onclick="fn_update_member();"/>
        <input type="button" value="탈퇴" onclick="fn_delete_member();"/>
        <button type="button" onclick="fn_password_update();">비밀번호변경</button>
    </form>
</section>
<script>
    const fn_password_update=()=>{
        window.open("<%=request.getContextPath()%>/updatepassword?userId=<%=request.getParameter("userId")%>","changePassword","width=400, height=210, left=500,top200");
    }

    const fn_update_validate= ()=>{
    // 정규표현식을 사용해보자
      return true;
    }

    const fn_delete_member=()=>{
      if(confirm("회원탈퇴를 하시겠습니까?")){
        const frm=$("#memberFrm");
        <%--frm.attr("action",'<%=request.getContextPath()%>/memberDelete.do');--%>
        <%--frm.submit();--%>
        location.replace("<%=request.getContextPath()%>/memberDelete?userId="+'<%=loginMember.getUserId()%>');

      }else{
        alert("회원탈퇴가 취소되었습니다.");
      }
    }

    const fn_update_member=()=>{
      const frm = $("#memberFrm");
      frm.attr("action",'<%=request.getContextPath()%>/memberupdate.do');
      frm.submit();
    }

    $('#password_2').blur((e)=>{
      const pw= $('#password_').val();
      const pwCk =$(e.target).val();
      if(pw!=pwCk){
        alert("비밀번호가 일치하지 않습니다.");
        $('#password_').focus();
      }
    });


</script>
<%@include file="/views/common/footer.jsp"%>
