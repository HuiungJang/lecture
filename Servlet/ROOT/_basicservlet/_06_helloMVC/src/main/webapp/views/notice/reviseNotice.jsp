<%@ page import="com.notice.model.vo.Notice" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/10
  Time: 11:52 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/common/header.jsp"%>
<%
    Notice list =(Notice) request.getAttribute("revise");

    System.out.println(list);
%>


<div id="notice-container">
    <form action="<%=request.getContextPath()%>/notice/reviseNotice" method="post" enctype="multipart/form-data">
        <input type="hidden" name="noticeNo" value="<%=list.getNoticeNo()%>">
        <table id="tbl-notice">
                <tr>
                    <th>제 목</th>
                    <td>
                        <input type="text" size="48" id="title" name="title" value="<%=list.getNoticeTitle()%>" required>
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>
                        <input type="text" name="writer" value="<%=list.getNoticeWriter()%>" readonly>
                    </td>
                <tr>
                    <th>첨부파일</th>
                    <% if(list.getFilePath() != null){%>
                        <td style="position: relative">
                            <input type="file" name="filePath">
                            <input type="hidden" name="oldFile" value="<%=list.getFilePath()%>">
                            <span id="fname"><%=list.getFilePath()%></span>
                        </td>
                    <%--
                        value="<%=list.getFilePath()%>"
                        value는 보안때문에 수정이 불가능하다.
                    --%>
                    <%--
                        파일을 선택했을 때 이전 파일을 지우는 경우, 새로운파일을 추가하면 이전파일 지우고
                        새로운 파일을 등록하는 경우 등 경우의 수가 있다.
                        아무 것도 하지 않으면 원본파일이 유지 되어야한다.

                    --%>
                    <%}else{%>
                        <td><input type="file" name="filePath"></td>
                    <%}%>
                </tr>
                <tr>
                    <th>내 용</th>
                    <td>
                        <textarea id="content" cols="41" rows="15" name="content"><%=list.getNoticeContent()%></textarea>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="수정하기">
                    </th>
                </tr>
        </table>
    </form>
</div>
<script>
    $(function(){
      $("input[name=filePath]").change((e)=>{
        if($(e.target).val ===""){
          $("#fname").show();
        }else{
          $("#fname").hide();
        }
      });
    });
</script>
<%--스타일추가--%>
<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;}
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    span#fname{position: absolute; left: 80px; top:9px; width: 285px; background-color: #F5F5F5;}
</style>
<%@include file="/views/common/footer.jsp"%>

