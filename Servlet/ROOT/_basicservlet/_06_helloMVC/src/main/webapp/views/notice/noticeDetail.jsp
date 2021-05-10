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
                <td><img src="<%=request.getContextPath()%>/images/file.png"></td>
            <%}else{%>
                <td></td>
            <%}%>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=list.getNoticeContent()%></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" onclick="">
                <input type="button" value="삭제하기" onclick="">
            </th>
        </tr>
    </table>
</div>
<script>

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
