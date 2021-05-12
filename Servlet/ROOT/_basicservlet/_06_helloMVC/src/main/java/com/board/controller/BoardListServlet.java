package com.board.controller;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardListServlet", value = "/board/boardList")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = -4314115842321248842L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        List<Board> b = new BoardService().viewList(cPage,numPerPage);
        //        // 아직 페이징 처리 안함.


        // 페이징처리
        int cPage;
        int numPerPage = 5;
        try{
            cPage=Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage=1;
        }


//        try{
//            numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
//        }catch (NumberFormatException e){
//            numPerPage=5;
//        }
        List<Board> list = new BoardService().viewList(cPage,numPerPage);

        int totalData= new BoardService().boardCount();
        int totalPage= (int)(Math.ceil((double)(totalData/numPerPage)));
        int pageBarSize= 5;
        int pageNo= ((cPage-1)/pageBarSize)*pageBarSize+1;
        int pageEnd= pageNo+pageBarSize-1;

        String pageBar="";

        if(pageNo==1){
            pageBar+= "<span></span>";
        }else{
            pageBar+="<a href='"+request.getContextPath()+"/board/boardList?cPage="+(cPage-1)+"&numPerPage="+numPerPage
                    +"'>이전</a>";
        }

        while(!(pageNo>pageEnd || pageNo>totalPage)){
            if(cPage==pageNo){
                pageBar+="<span>"+pageNo+"</span>";
            }else{
                pageBar+="<a href='"+request.getContextPath()+"/board/boardList?cPage="+pageNo+
                        "&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
            }
            pageNo++;
        }

        if(pageNo>totalPage){
            pageBar+="<span></span>";
        }else{
            pageBar+="<a href='"+request.getContextPath()+"/board/boardList?cPage"+cPage+"&numPerPage="+numPerPage
                    +"'>다음</a>";
        }
        request.setAttribute("pageBar",pageBar);


        request.setAttribute("boardList",list);
        request.getRequestDispatcher("/views/board/boardList.jsp").forward(request,response);

//        request.getContextPath()+"/views/board/boardList.jsp"
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
