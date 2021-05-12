<%@ page import="com.board.model.vo.Board" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/11
  Time: 10:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/common/header.jsp"%>
<%
    List<Board> boardList = (List<Board>) request.getAttribute("boardList");
%>
<section>
    <style>
        section#board-container{width:600px; margin:0 auto; text-align:center;}
        section#board-container h2{margin:10px 0;}
        table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
        table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;}
        /*글쓰기버튼*/
        input#btn-add{float:right; margin: 0 0 15px;}
        /*페이지바*/
        div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
        div#pageBar span.cPage{color: #0066ff;}
        div#pageBar a{padding-left: 10px;}
        div#pageBar span{padding-left: 10px;}
    </style>
    <section id="board-container">
        <h2>게시판 </h2>
        <table id="tbl-board">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
            <%if(!boardList.isEmpty()){%>
                <%for(Board b : boardList){%>
                    <tr>
                        <td><a href="<%=request.getContextPath()%>/board/view?boardNo=<%=b.getBoardNo()%>"><%=b.getBoardNo()%></a></td>
                        <td><a href="<%=request.getContextPath()%>/board/view?boardNo=<%=b.getBoardNo()%>"><%=b.getBoardTitle()%></a></td>
                        <td><%=b.getBoardWriter()%></td>
                        <td><%=b.getBoardDate()%></td>

                        <%if(b.getBoardOriginFileName() != null){%>
                        <%--
                            오리지널 파일이름이 있으면 RefileName이 있어야한다.
                            둘중에 하나만 있는 경우는 없다.
                        --%>
                            <td><img src="<%=request.getContextPath()%>/images/file.png" width="16" height="16">  </td>
                        <%}else{%>
                            <td> </td>
                        <%}%>

                        <td><%=b.getBoardRecount()%></td>
                    </tr>
                <%}%>
            <%}%>
        </table>
        <div>
            <input type="button" onclick="fn_moveBoardForm();" value="글작성하기">
        </div>
<%--        페이징처리--%>
        <div id="pageBar">
            <%=request.getAttribute("pageBar")%>
        </div>
    </section>
    <script>
        const fn_moveBoardForm=()=>{
          location.assign('<%=request.getContextPath()%>/board/boardForm');
        }
    </script>
</section>
<%@ include file="/views/common/footer.jsp"%>