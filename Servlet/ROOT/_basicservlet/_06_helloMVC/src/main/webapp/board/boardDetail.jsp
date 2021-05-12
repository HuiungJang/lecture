<%@ page import="com.board.model.vo.Board" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/11
  Time: 10:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/common/header.jsp"%>
<%
    Board b = (Board)request.getAttribute("viewBoard");
    Member m = (Member)session.getAttribute("loginMember");
%>
<section>
    <style>
        section#board-container{width:600px; margin:0 auto; text-align:center;}
        section#board-container h2{margin:10px 0;}
        table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
        table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;}
        table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>

    <div id="board-container">
        <h2>게시판</h2>
        <table id="tbl-board">
            <tr>
                <th>글번호</th>
                <td><%=b.getBoardNo()%></td>
            </tr>
            <tr>
                <th>제 목</th>
                <td><%=b.getBoardTitle()%></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%=b.getBoardWriter()%></td>
            </tr>
            <tr>
                <th>조회수</th>
                <td><%=b.getBoardRecount()%></td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <%if(b.getBoardOriginFileName() != null){%>
                    <td>
                        <a href="javascript:fn_fileDownload('<%=b.getBoardOriginFileName()%>','<%=b.getBoardRenameFileName()%>')">
                            <img src="<%=request.getContextPath()%>/images/file.png" width="16" height="16">
                        </a>
<%--                        <a href="<%=request.getContextPath()%>/board/fileDownload?fname=<%=b.getBoardOriginFileName()%>">--%>
<%--                        </a>--%>
                    </td>
                <%}else{%>
                    <td> </td>
                <%}%>
            </tr>
            <tr>
                <th>내 용</th>
                <td><%=b.getBoardContent()%></td>
            </tr>
            <%--글작성자/관리자인경우 수정삭제 가능 --%>

            <tr>
                <th colspan="2">
                    <button onclick="location.replace('<%=request.getContextPath()%>/board/boardList')">
                        목록
                    </button>
                    <input type="button" value="수정하기" onclick="reviseBoard();">
                    <input type="button" value="삭제하기">
                </th>
            </tr>


        </table>

    </div>
</section>
<script>
  const fn_fileDownload=(oriname,rename)=>{
        url="<%=request.getContextPath()%>/board/filedownload";
        const encOriName= encodeURIComponent(oriname);
        location.assign(url+"?oriname="+encOriName+"&rename="+rename);
  }

  function reviseBoard() {
    if (<%= m.getUserId().equals("admin") || b.getBoardWriter().equals(m.getUserId()) %>) {
      location.replace("<%=request.getContextPath()%>/board/reviseBoard?boardNo=<%=b.getBoardNo()%>");
    } else {
       alert("글 작성자만 수정가능합니다.");
    }
  }
</script>
<%@ include file="/views/common/footer.jsp"%>