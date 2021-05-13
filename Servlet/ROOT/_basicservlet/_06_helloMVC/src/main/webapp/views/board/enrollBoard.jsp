<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/11
  Time: 10:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/common/header.jsp"%>
<section>
    <style>
        div#board-container
        {
            width:600px;
            margin:0 auto;
            text-align:center;
        }
        div#board-container h2
        {
            margin:10px 0;
        }
        table#tbl-board
        {
            width:500px;
            margin:0 auto;
            border:1px solid black;
            border-collapse:collapse;
        }
        table#tbl-board th
        {
            width:125px;
            border:1px solid;
            padding:5px 0;
            text-align:center;
        }
        table#tbl-board td
        {
            border:1px solid;
            padding:5px 0 5px 10px;
            text-align:left;
        }

    </style>
    <script>
      // 내용입력여부 확인 후 전송
    </script>

    <div id='board-container'>
        <h2>게시판 작성</h2>
        <form action='<%=request.getContextPath()%>/board/boardInsert' method="post" enctype="multipart/form-data">
            <table id='tbl-board'>
                <tr>
                    <th>제목</th>
                    <td>
                        <input type="text" name="boardTitle" id="boardTitle" placeholder="제목을 입력하세요" required>
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>
                        <input type="text" value="<%=loginMember.getUserId()%>" name="boardWriter" id="boardWriter" readonly>
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                        <input type="file" name="upFile" id="upFile">
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea rows="5" cols="50" name="boardContent" id="boardContent"></textarea>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="등록하기">
                    </th>
                </tr>
            </table>
        </form>
    </div>
</section>
<%@ include file="/views/common/footer.jsp"%>