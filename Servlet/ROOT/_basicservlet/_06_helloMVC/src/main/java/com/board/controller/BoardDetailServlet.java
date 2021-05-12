package com.board.controller;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BoardDetailServlet", value = "/board/view")
public class BoardDetailServlet extends HttpServlet {
    private static final long serialVersionUID = -8420254773055361282L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int boardNo= Integer.parseInt(request.getParameter("boardNo"));

        // Cookie에 저장하는 값.
        // boardRead 키로 읽은 게시글의 번호를 저장함

        Cookie[] cookies = request.getCookies();
        String boardRead = "";
        boolean readFlag= false; // 안읽은 상태

        if(cookies!=null){
            for(Cookie c : cookies){
                String name = c.getName(); // 키값을 가져옴
                String value = c.getValue(); // 벨류값을 가져옴

                if(name.equals("boardRead")){
                    boardRead=value;
                    if(value.contains("|"+boardNo+"|")){
                        // 스트링 값으로 벨류가 들어가기 때문에 구분가능한 문자 넣음
                        readFlag =true;
                        break;
                    }
                }
            }
        }

        if(!readFlag){
            // 안읽었다면 기존 boardread 값에 추가한
            Cookie c = new Cookie("boardRead",boardRead+"|"+boardNo+"|");
            c.setMaxAge(60*60*24); // 24시간
            response.addCookie(c);
        }

        Board result = new BoardService().viewBoard(boardNo,readFlag);

        request.setAttribute("viewBoard",result);
        request.getRequestDispatcher("/views/board/boardDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
