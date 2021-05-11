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
    <form action="<%=request.getContextPath()%>/notice/enrollNotice" method="post" enctype="multipart/form-data">
<%--        파일을 업로드하려면 enctype를 꼭 넣어야한다. multipart/form-data --%>
<%--        파일 업로드 할 때는 cos.jar 라이브러리를 사용한다.--%>
        <table id="tbl-notice">
            <tr>
                <th>제 목</th>
                <td>
                    <input type="text" size="48" id="title" name="title" required>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" value="<%=loginMember.getUserId()%>" name="writer" readonly> </td>
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
                    <input type="submit" value="등록하기" onclick="">
                </th>
            </tr>
        </table>
    </form>
</div>

<%--스타일추가--%>

<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;}
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>
<%@include file="/views/common/footer.jsp"%>
