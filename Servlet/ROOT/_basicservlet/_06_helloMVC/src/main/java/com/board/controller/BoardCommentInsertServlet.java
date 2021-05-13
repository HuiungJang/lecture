package com.board.controller;

import com.board.model.service.BoardService;
import com.board.model.vo.BoardComment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BoardCommentInsertServlet", value = "/board/insertBoardComment")
public class BoardCommentInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 74526715192403743L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int boardRef = Integer.parseInt(request.getParameter("boardRef"));
        int boardCommentRef = Integer.parseInt(request.getParameter("boardCommentRef"));
        int boardLevel = Integer.parseInt(request.getParameter("boardCommentLevel"));
        String boardComment = request.getParameter("commentContent");
        String commentWriter = request.getParameter("commentWriter");

        BoardComment bc = new BoardComment();
        bc.setBoardCommentRef(boardCommentRef);
        bc.setBoardCommentLevel(boardLevel);
        bc.setBoardRef(boardRef);
        bc.setBoardCommentWriter(commentWriter);
        bc.setBoardCommentContent(boardComment);

        int result = new BoardService().insertBoardComment(bc);

        String msg="";
        String loc="/board/view?boardNo="+boardRef;

        if(result>0){
            // success
            msg="댓글등록 성공";
        }else{
            // fail
            msg="댓글등록 실패";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);

        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
