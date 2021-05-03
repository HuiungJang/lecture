<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/04/30
  Time: 12:12 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<style>
    section#enroll-container {text-align:center;}
    section#enroll-container input{margin:3px;}
    section#enroll-container table{margin:0 auto;}
    section#enroll-container table th {padding:0 10px; text-align:right;}
    section#enroll-container table td {padding:0 10px; text-align:left;}
</style>
<section id=enroll-container>
    <script>
      // 내가한거
      // const idCheck =()=>{
      //     if( $("#userId_").val().length<4 ){
      //       alert("아이디는 4글자 이상이어야합니다.");
      //       return false;
      //     }
      // }
      // const passwordCheck=()=>{
      //   if($("#password_").val() !== $("#password_2").val()){
      //     alert("비밀번호가 일치하지 않습니다.")
      //     return false;
      //   }
      // }
      $(function (){
        $('#password_2').blur((e)=>{
          const pwck = $(e.target).val();
          const pw =$('#password_').val();
          if(pwck!==pw){
            alert("비밀번호가 일치하지 않습니다.");
            $('#password_').focus();
          }
        });
      });

      const idCheck=()=>{
        const userId = $('userId_');
        if(userId.val().length<4){
            alert("아이디는 4글자 이상이어야합니다.");
            userId.focus();
            return false;
        }
      }

    </script>
    <h2>회원 가입 정보 입력</h2>
    <form name="memberEnrollForm" action="<%=request.getContextPath()%>/memberenroll.do" method="post" onsubmit="return idCheck()">
        <table>
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" placeholder="4글자이상" name="userId" id="userId_" required>
<%--                    form 태그안에 button 태그가 있으면 제출이 됨--%>
                    <input type="button" value="중복검사" onclick="popUp();">
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td>
                    <input type="password" name="password" id="password_" required><br>
                </td>
            </tr>
            <tr>
                <th>패스워드확인</th>
                <td>
                    <input type="password" id="password_2" ><br>
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text"  name="userName" id="userName" required><br>
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="number" name="age" id="age"><br>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="email" placeholder="abc@xyz.com" name="email" id="email" required><br>
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>
                    <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" placeholder="" name="address" id="address"><br>
                </td>
            </tr>
            <tr>
                <th>성별 </th>
                <td>
                    <input type="radio" name="gender" id="gender0" value="M" >
                    <label for="gender0">남</label>
                    <input type="radio" name="gender" id="gender1" value="F">
                    <label for="gender1">여</label>
                </td>
            </tr>
            <tr>
                <th>취미 </th>
                <td>
                    <input type="checkbox" name="hobby" id="hobby0" value="운동"><label for="hobby0">운동</label>
                    <input type="checkbox" name="hobby" id="hobby1" value="등산"><label for="hobby1">등산</label>
                    <input type="checkbox" name="hobby" id="hobby2" value="독서"><label for="hobby2">독서</label><br />
                    <input type="checkbox" name="hobby" id="hobby3" value="게임"><label for="hobby3">게임</label>
                    <input type="checkbox" name="hobby" id="hobby4" value="여행"><label for="hobby4">여행</label><br />
                </td>
            </tr>
        </table>
        <input type="submit" value="가입">
        <input type="reset" value="취소">
    </form>
</section>
<form action="" name="checkDuplicateId">
    <input type="hidden" name="userId">
</form>
<script>

  const popUp = ()=>{

    const url= '<%=request.getContextPath()%>/checkDuplicateId';
    const title = 'duplicateId';
    const status = 'width=300,height=200,left=500,top=100'
    window.open('',title,status);

    // form에 있는 input의 값을 채우고 윈도우(새창)에서 그 결과를 받는 로직으로 설정
    // form 태그는 name 속성을 설정한면 그 name 속성으로 직접접근이 가능함
    // form의 name 속성으로 필요한 데이터 세팅하기
    checkDuplicateId.userId.value=$('#userId_').val();
    checkDuplicateId.method="post";
    checkDuplicateId.action=url;
    // 이 form 태그가 제출(submit) 되는 윈도우를 지정
    checkDuplicateId.target=title;

    checkDuplicateId.submit();
  }
</script>
<%@ include file="../common/footer.jsp"%>