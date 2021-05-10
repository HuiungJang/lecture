<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/10
  Time: 12:41 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/common/header.jsp"%>

<div id="notice-container">
    <form action="" method="post">
        <table id="tbl-notice">
            <form action="<%=request.getContextPath()%>/enrollNotice" method="post">
                <tr>
                    <th>제 목</th>
                    <td>
                        <input type="text" size="48" id="title" name="title" required>
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=((Member) session.getAttribute("loginMember")).getUserId()%></td>
                <tr>
                    <th>첨부파일</th>
                    <td>
                        <input type="file" id="uploadFile" name="filePath">
                    </td>
                </tr>
                <tr>
                    <th>내 용</th>
                    <td>
                        <textarea id="content" cols="41" rows="15" name="content"></textarea>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="등록하기" onclick="enrollNotice();">
                    </th>
                </tr>
            </form>
        </table>
    </form>
</div>
<script>
    const enrollNotice = ()=>{
      const title = $("#title").val();
      const file = $("#uploadFile").val();
      const content =$("#content").val();

      <%--location.href('<%=request.getContextPath()%>/a');--%>
      <%--console.log('title :'+ title   + 'file :'+file+    'content :'+content);--%>
    }
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
