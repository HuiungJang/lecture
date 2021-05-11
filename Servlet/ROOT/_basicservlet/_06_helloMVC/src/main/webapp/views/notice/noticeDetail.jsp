<%@ page import="com.notice.model.vo.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/10
  Time: 12:41 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/common/header.jsp"%>
<%
    Notice list =(Notice) request.getAttribute("contentView");

    Member m = (Member) session.getAttribute("loginMember");

%>
<div id="notice-container">
    <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=list.getNoticeTitle()%></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=list.getNoticeWriter()%></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <% if(list.getFilePath() != null){%>
                <td>
                    <a href="<%=request.getContextPath()%>/notice/fileDownload?fname=<%=list.getFilePath()%>"><img src="<%=request.getContextPath()%>/images/file.png"></a>
                </td>
            <%}else{%>
                <td></td>
            <%}
                assert m != null;
            %>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=list.getNoticeContent()%></td>
        </tr>
        <tr>
            <th colspan="2">
                <form  class="revise" >
                    <input type="button" value="수정하기" onclick="reviseNotice();">
                    <input type="button" value="삭제하기" onclick="deleteNotice();">
                </form>
            </th>
        </tr>
    </table>
</div>
<script>
  function reviseNotice() {
    if (<%= m!= null && m.getUserId().equals("admin")%>) {
      location.replace("<%=request.getContextPath()%>/notice/moveRevise?noticeNo=<%=list.getNoticeNo()%>");
    } else {
      alert("관리자만 수정가능합니다.");
    }
  }

  function deleteNotice(){
    if (<%= m!= null && m.getUserId().equals("admin")%>) {
      if(confirm("정말 삭제하시겠습니까?")) {
        location.replace("<%=request.getContextPath()%>/notice/deletenotice?noticeNo=<%=list.getNoticeNo()%>");
      }else{
        alert("삭제가 취소되었습니다.");
      }

    } else {
      alert("관리자만 삭제가능합니다.");
    }
  }


  //
  // function submit(){
  //   $(".revise").submit();
  // };
</script>
<%--스타일추가--%>
<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;}
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>
<%@include file="/views/common/footer.jsp"%>
