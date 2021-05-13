<%@ page import="com.board.model.vo.Board" %>
<%@ page import="com.board.model.vo.BoardComment" %>
<%@ page import="java.util.List" %><%--
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
    List<BoardComment> comments = (List<BoardComment>)request.getAttribute("comments");
%>
<section>
    <style>
        <%--게시글 css--%>
        section#board-container{width:600px; margin:0 auto; text-align:center;}
        section#board-container h2{margin:10px 0;text-align: center;}
        table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
        table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;}
        table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}

        /*댓글 css*/
        div#comment-container{text-align: center;}
        div#comment-container button#btn-insert{width:60px;height:50px; color:white;
            background-color:#3300FF;position:relative;top:-20px;}
        /*댓글테이블*/
        table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; }
        table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
        table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
        table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
        table#tbl-comment button.btn-reply{display:none;}
        table#tbl-comment button.btn-delete{display:none;}
        table#tbl-comment tr:hover {background:lightgray;}
        table#tbl-comment tr:hover button.btn-reply{display:inline;}
        table#tbl-comment tr:hover button.btn-delete{display:inline;}
        table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
        table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
        table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
        table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
        table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
        table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
        /*답글관련*/
        table#tbl-comment textarea{margin: 4px 0 0 0;}
        table#tbl-comment button.btn-insert2{width:60px; height:23px; color:white; background:#3300ff; position:relative; top:-5px; left:10px;}
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
        <div id="comment-container">
            <div class="comment-editor">
                <form action="<%=request.getContextPath()%>/board/insertBoardComment" method="post">
                    <textarea cols="50" rows="3" name="commentContent"></textarea>
<%--                    게시글 번호를 히든으로 넘겨야 댓글이 원하는 게시글에 달린다.--%>
                    <input type="hidden" name="boardRef" value="<%=b.getBoardNo()%>">
<%--                    댓글 다는 사람 아이디로 필요하니 넘긴다.--%>
                    <input type="hidden" name="commentWriter" value="<%=loginMember.getUserId()%>">
<%--                    댓글인지 답글인지 대댓글인지 확인하는 댓글레벨--%>
                    <input type="hidden" name="boardCommentLevel" value="1">
<%--                    이게 있다면 답글 없으면 댓글 -> 없다는 거는 null --%>
                    <input type="hidden" name="boardCommentRef" value="0">
                    <button type="submit" id="btn-insert">등록</button>
                </form>
            </div>
            <table id="tbl-comment">
                <%if(comments != null){%>
                    <%for(BoardComment bc : comments){
                        if(bc.getBoardCommentLevel()==1){%>
<%--                대댓글 구분하기--%>
                        <tr class="level1">
                            <td>
                               <sub class="comment-writer"><%=bc.getBoardCommentWriter()%></sub>
                               <sub class="comment-date"><%=bc.getBoardCommentDate()%></sub>
                               <br>
                               <%=bc.getBoardCommentContent()%>
                            </td>
                            <td>
                                <%if(loginMember != null ){%>
                                    <button class="btn-reply" value="<%=bc.getBoardCommentNo()%>">답글</button>
                                <%}%>

                                <%if(loginMember != null &&
                                        (loginMember.getUserId().equals("admin") || loginMember.getUserId().equals(bc.getBoardCommentWriter()))){%>
                                    <button class="btn-delete">삭제</button>
                                <%}%>
                            </td>
                        </tr>
                        <%}else{%>
                            <tr class="level2">
                                <td>
                                    <sub class="comment-writer"><%=bc.getBoardCommentWriter()%></sub>
                                    <sub class="comment-date"><%=bc.getBoardCommentDate()%></sub>
                                    <br>
                                    <%=bc.getBoardCommentContent()%>
                                </td>
                                <td>
                                    <%if(loginMember != null ){%>
                                        <button class="btn-reply" value="<%=bc.getBoardCommentNo()%>">답글</button>
                                    <%}%>

                                    <%if(loginMember != null &&
                                            (loginMember.getUserId().equals("admin") || loginMember.getUserId().equals(bc.getBoardCommentWriter()))){%>
                                        <button class="btn-delete">삭제</button>
                                    <%}%>
                                </td>
                            </tr>
                        <%}%>
                    <%}%>
                <%}%>
            </table>
        </div>
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

  $(function(){
    // 로그인 하지 않으면 댓글 못달게하기.
    // 필터로 막아도 되지만 그렇게 하면 서버와 정보를 주고 받아야하기 때문에
    // 효율성이 떨어질 수 있다.

    // 하지만 get방식으로 직접접근 할 수도있기 때문에
    // 필터로 필요한 부분만 막는게 좋다.

    $(".comment-editor textarea").focus((e)=>{
      if(<%=loginMember == null%>){
        alert("로그인 후 이용할 수 있습니다.");
        $("#userId").focus();

      }
    });


    // 답글 클릭하면 대댓 만들기
    $(".btn-reply").click((e)=>{
      const tr= $("<tr>");
      const form=$(".comment-editor>form").clone();

      form.find("textarea").attr("rows","1");
      form.find("[name=boardCommentLevel]").val("2");
      // 누른 버튼의 벨류르 가져옴
      form.find("[name=boardCommentRef]").val($(e.target).val());

      form.find("button").removeAttr("id").addClass("btn-insert2");
      const td=$("<td>").attr("colspan","2");
      tr.append(td.append(form));
      tr.find("td").css("display","none");

      tr.insertAfter($(e.target).parents("tr")).children("td").slideDown(400);
      $(e.target).off("click");
    });

  });
</script>
<%@ include file="/views/common/footer.jsp"%>