<%@ page import="com.notice.model.vo.Notice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/10
  Time: 11:22 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/common/header.jsp"%>
<%
    List<Notice> list = (List<Notice>) request.getAttribute("viewList");
%>
<section id="notice-container">
    <h2>공지사항</h2>
    <input type="button" value="글쓰기" id="btn-add" onclick="fn_noticeWrite();">
    <table id="tbl-notice">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
        </thead>
<%--        내용출력할것--%>
<%--        첨부파일 있으면 이미지, 없으면 공란으로 표시--%>
<%--        이미지파일은 web/images/file.png에 저장--%>
        <tbody>
        <%if(list.isEmpty()){%>
            <tr>
                <td colspan="5">"공지사항이 없습니다."</td>
            </tr
        <%} else{%>
            <%for(Notice n : list){%>
                <tr>
                    <td><%=n.getNoticeNo()%></td>
                    <td><a href="<%=request.getContextPath()%>/notice/detailNotice?contentNo=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle()%></a></td>
                    <td><%=n.getNoticeWriter()%></td>
                    <% if(n.getFilePath() != null){%>
                        <td>
                            <img src="<%=request.getContextPath()%>/images/file.png" width="16px" height="16px">
                        </td>
                    <%}else{%>
                        <td>첨부파일없음</td>
                    <%}%>
                    <td><%=n.getNoticeDate()%></td>
                </tr>
            <%}%>
        <%}%>
        </tbody>
    </table>
    <div id ="pageBar">
        <%=request.getAttribute("pageBar")%>
    </div>
</section>
<script>
  const fn_noticeWrite = ()=>{
    location.assign('<%=request.getContextPath()%>/notice/noticeForm');
  }

</script>
<%@include file="/views/common/footer.jsp"%>
<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;}
    #pageBar span{
        margin-left: 20px;
    }
    a{
        text-decoration: none;
    }
    input#btn-add{
        float:right;
        margin: 0 0 15px;
    }
</style>

