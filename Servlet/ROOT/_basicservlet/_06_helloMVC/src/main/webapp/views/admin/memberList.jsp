<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/06
  Time: 12:49 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/common/header.jsp"%>
<style type="text/css">
    section#memberList-container {text-align:center;}

    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
</style>
<%
    List<Member> members = (List<Member>)request.getAttribute("members");
    int totalPages = (members.size()/10) +1; // 한페이지에 10개 씩 12페이지

    for(int i=0; i<totalPages-1; i++){
      if(i/10 ==0){
          List<Member> numPerPage= members.subList(0,i);
      }
    }

%>
<section id="memberList-container">
    <h2>회원관리</h2>
    <table id="tbl-member">
        <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>성별</th>
            <th>나이</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>취미</th>
            <th>가입날짜</th>

        </tr>
        </thead>
        <tbody>
        <%if(members.isEmpty()){%>
            <tr>
                <td colspan="9" align="center">검색결과가 없습니다.</td>
            </tr>
        <%}else{%>
            <%for(Member m : members){%>
                <tr>
                    <td><%=m.getUserId()%></td>
                    <td><%=m.getUserName()%></td>
                    <td><%=m.getGender()%></td>
                    <td><%=m.getAge()%></td>
                    <td><%=m.getEmail()%></td>
                    <td><%=m.getPhone()%></td>
                    <td><%=m.getAddress()%></td>
                    <td><%=m.getHobby()%></td>
                    <td><%=m.getEnrollDate()%></td>
                </tr>
            <%}%>
        <%}%>
        </tbody>
    </table>
</section>
<%--
페이징 처리는 로직(연산에 의해) 원하는 데이터를 출력 할 수 있게 해야함
totalPage = 전체 자료대비 page의 수 -> 계산식 전체 data/페이지 당 데이터 수
시작데이터 번호 : ( 현재페이지 -1 )* 페이지당 데이터 수+1
끝 데이터 번호 : (현재페이지 * 페이지당 데이터수)
pageBar의 시작 번호 : ((현재페이지 -1) / pageBar당 페이지 숫자의 갯수)*pageBar당 페이지 숫자의 갯수
pageBar의 끝번호 : Page의 시작번호 + 페이지바당 페이지 숫자의 개수 -1

필요변수
cPage : 현재페이지를 저장하는 변수
numPerPage : 페이지당 data 수를 저장하는 변수
totalData : 총 data 수
totlaPage : 총 page 수
pageBarSize :  pageBar당 페이지 숫자의 갯수
pageNo : pageBar의 시작숫자
pageEnd : pageBar의 끝 숫자

--%>
<%@ include file="/views/common/footer.jsp"%>