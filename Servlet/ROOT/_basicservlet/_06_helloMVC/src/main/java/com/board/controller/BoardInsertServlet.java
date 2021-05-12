package com.board.controller;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;
import com.common.MyReName;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "BoardInsertServlet", value = "/board/boardInsert")
public class BoardInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 8423711401177136890L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        if(!ServletFileUpload.isMultipartContent(request)){
            request.setAttribute("msg","실패");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/views/commcon.jsp");
        }

        String path = "/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/board";
        int maxSize = 1024*1024*10;
        String encode = "utf-8";

        // DefaultFileRenamePolicy -> 파일 이름 재정의하자
        // 새로운 클래스를 만들고 implements FileRenamePolicy 받고 rename 오버라이딩하고
        // 거기서 파일이 들어오면 어떤것을 할 것인지 만든다.
        MultipartRequest mr = new MultipartRequest(request,path,maxSize,encode,new MyReName());

        Board b = new Board();
//        b.setBoardNo(Integer.parseInt(mr.getParameter("boardNo")));
        b.setBoardTitle(mr.getParameter("boardTitle"));
        b.setBoardWriter(mr.getParameter("boardWriter"));
        b.setBoardContent(mr.getParameter("boardContent"));
        b.setBoardOriginFileName(mr.getOriginalFileName("upFile"));
        // getOriginalFileName을 사용하면 rename하기 전의 파일 이름을 가지고 온다.
        // 사용자한테 원본파일이름을 보여줘야한다면 사용하자.

        b.setBoardRenameFileName(mr.getFilesystemName("upFile"));
        // rename 한 후의 파일 이름 -> 서버에 저장될 파일이름(중복되면 안됨)

        int result = new BoardService().boardInsert(b);

        String msg="";
        if(result>0){
            msg="게시물이 등록되었습니다.";

        }else{
            msg="게시물이 정상적으로 등록되지않았습니다.";
        }

        request.setAttribute("msg",msg);
        request.setAttribute("loc","/board/boardList");
        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
