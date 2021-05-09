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
    section#memberList-container>div#pageBar>*{margin-right: 20px;}

    /* 검색창에 대한 스타일 */
    div#search-container {margin:0 0 10px 0; padding:3px;
        background-color: rgba(0, 188, 212, 0.3);}
    div#search-userId{display:inline-block;}
    div#search-userName{display:none;}
    div#search-gender{display:none;}
    div#numPerpage-container{float:right;}
    form#numperPageFrm{display:inline;}
</style>
<%--<script><%=request.getAttribute("formPath")%></script>--%>

<%
    List<Member> members = (List<Member>)request.getAttribute("members");
    request.getAttribute("numPerPageVal");
    // 내가한 상세 조회 로직
//    List<Member> searchMember = (List<Member>)request.getAttribute("searchMember");
//
//    if(searchMember !=null){
//        members=(List<Member>)request.getAttribute("searchMember");
//    }

%>
<script>

// 내가한거
  // function changeVal() {
  //   let select = $('#search-type option:selected').val()
  //
  //   if (select === 'userName') {
  //     $('#search-userId').css("display", "none");
  //     $('#search-gender').css("display", "none");
  //     $('#search-userName').css("display", "inline-block");
  //
  //   } else if (select === 'gender') {
  //     $('#search-userId').css("display", "none");
  //     $('#search-gender').css("display", "inline-block");
  //     $('#search-userName').css("display", "none");
  //
  //   } else {
  //     $('#search-userId').css("display", "inline-block");
  //     $('#search-gender').css("display", "none");
  //     $('#search-userName').css("display", "none");
  //   }
  // }

  // 샘이 한거
  $(function(){

    $("#search-type").change((e)=>{
      const userId=$("#search-userId");
      const userName=$("#search-userName");
      const gender = $("#search-gender");
      const value = $(e.target).val();

      // 전부 display none 로 바꾼다.
      userId.css("display","none");
      userName.css("display","none");
      gender.css("display","none");

      // 여기서 선택된거는 무조건 inline-block로 바뀌니까.
      $("#search-"+value).css("display","inline-block");
    });

    // 숙제2
    // 페이지 당 회원수 선택하면 제출
    $("#numPerPage").change(()=>{
      const path ='<%=request.getContextPath()%>/admin/searchMember?searchType='
        +'<%=request.getParameter("searchType")%>'
        +'&searchKeyword='+'<%=request.getParameter("searchKeyword")%>'+
      '&numPerPage='+$('#numPerPage').val();
      // console.log(path);
      location.assign(path)
    });


  });

  // 숙제2
  // 페이지 당 회원수 선택하면 제
  <%=request.getAttribute("numPerPageVal")%>

  //숙제3
  //회원이름 검색하면 input창에 유지하게 하기
  <%=request.getAttribute("stayInputKeyword")%>

</script>
<section id="memberList-container">
    <h2>회원관리</h2>
    <div id="search-container">
        검색타입:
<%--        숙제 3--%>
<%--        회원이름 검색하면 input창에 유지하게 하기--%>

<%--        <select id="search-type" onchange="changeVal();">--%>
        <select id="search-type">
            <option value="userId">아이디</option>
            <option value="userName">이름</option>
            <option value="gender">성별</option>
        </select>
        <div id="search-userId">
            <form action="<%=request.getContextPath()%>/admin/searchMember">
                <input type="hidden" name="searchType" value="userId">
                <input class="keyword" type="text" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력해주세요">
                <button type="submit">검색</button>
            </form>
        </div>
        <div id="search-userName">
            <form action="<%=request.getContextPath()%>/admin/searchMember">
                <input type="hidden" name="searchType" value="userName">
                <input class="keyword" type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력해주세요">
                <button type="submit">검색</button>
            </form>
        </div>
        <div id="search-gender">
            <form action="<%=request.getContextPath()%>/admin/searchMember">
                <input type="hidden" name="searchType" value="gender">
                <label><input type="radio" name="searchKeyword" value="M">남</label>
                <label><input type="radio" name="searchKeyword" value="F">여</label>
                <button type="submit">검색</button>
            </form>
        </div>

<%--        숙제 2--%>
<%--        회원수 고르면 그에 맞춰서 조회--%>
        <div id="numPerpage-container">
            페이지당 회원수 :
            <form id="perPageSubmit" action='<%=request.getContextPath()%>/admin/memberList'>
                <%--            아이디나 이름 값은 자유--%>
                <select name="numPerPage" id="numPerPage">
                    <option value="10">10</option>
                    <option value="5">5</option>
                    <option value="3">3</option>
                </select>
            </form>
        </div>
    </div>
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
    <div id ="pageBar">
        <%=request.getAttribute("pageBar")%>
    </div>
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

<%--
숙제 4.
새로운 프로젝트 만들어서
kh 계정의 employee 사원 전체 조회하고
페이징 처리하기 , 1페이지에 3개씩 나오게하기
--%>
<%@ include file="/views/common/footer.jsp"%>