package com.admin.controller;

import com.admin.model.service.AdminService;
import com.common.AESCrypto;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MemberListServlet", value = "/admin/memberList")
public class MemberListServlet extends HttpServlet {
    private static final long serialVersionUID = 28397928389643109L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        // 관리자가 아닌 사용자가 접근했을 때 예외 처리하기
        HttpSession session = request.getSession(false);
        Member loginMember = (Member)session.getAttribute("loginMember");

        // 필터로 빼서 처리해보자
        // 숙제 (관리자 페이지는 항상 /admin 붙음)
        if(session == null || loginMember == null || !loginMember.getUserId().equals("admin")){
            // 잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.
            request.setAttribute("msg","잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
        }else{
            // 데이터 가져올 때 원하는 구역(page) 가져오기
            // 사용자가 원하는 page -> 현재 페이지(0페이지는 없기 때문에 1페이지부터 시작한다.)
            int cPage;
            try {
                cPage = Integer.parseInt(request.getParameter("cPage"));
            }catch (NumberFormatException e){
                cPage=1;
            }

            // 페이지당 나오는 데이터 수 (사용자가 설정함)
            int numPerPage;
            try {
                numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
            }catch (NumberFormatException e){
                numPerPage=10;
            }

            // 클릭시 전체 회원에 대한 정보를 조회해서 가져옴
            List<Member> list = new AdminService().viewMember(cPage,numPerPage);

            for(Member m : list) {
                try {
                    m.setPhone(AESCrypto.decrypt(m.getPhone()));
                    m.setEmail(AESCrypto.decrypt(m.getEmail()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 사용자가 원하는 페이지를 호출 할 수 있도록 pageBar를 만들어보자
            // 전체 페이지에 대한 수 -> 무조건 올림 처리함
            int totalData = new AdminService().listCount();
            int totalPage = (int)(Math.ceil((double)(totalData/numPerPage)));

            // pageBar 구성하기 -> html
            int pageBarSize =4; // pageBar에 출력된 페이지숫자 개수

            // pageNo 는 pageBar에 출력되는 페이지 숫자의 시작값
            // cPage 2 -> pageNo 1
            // cPage 4 -> pageNo 1
            // cPage 5 -> pageNo 5
            // cPage 6 -> pageNo 5
            // cPage 9 -> pageNo 9
            int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;

            // pageNo 1 -> pageEnd 4
            // pageNo 5 -> pageEnd 8
            // pageNo 9 -> pageEnd 12
            int pageEnd = pageNo+pageBarSize-1;

            // 사용자가 클릭할 수 있는 페이지 바를 구성해보자
            String pageBar="";
            if(pageNo==1){
                pageBar+="<span>[이전]</span>";
            }else{
                pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="
                        +(pageNo-1)+"&numPerPage="
                        +numPerPage+"'>[이전]</a>";
            }

            while(!(pageNo>pageEnd || pageNo>totalPage)){
                if(cPage == pageNo){
                    pageBar+="<span>"+pageNo+"</span>";
                }else{
                    pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+
                            "&numPerPage=" +numPerPage+"'>"+pageNo+"</a>";
                }
                pageNo++;
            }

            if(pageNo>totalPage){
                pageBar+="<span>다음</span>";
            }else {
                pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="
                        +pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
            }

//            내가한 부분조회 샘이한거는 새롭게 서블릿을 만들었음 -> SearchMemberServlet
//            String searchKeyword = request.getParameter("searchKeyword");
//            if(searchKeyword != null) {
//                List<Member> searchMember = new AdminService().searchMember(searchKeyword);
//                request.setAttribute("searchMember",searchMember);
//            }

            // 숙제2
            // 페이지 당 회원수 선택하면 제출
            // numPerPage 받아와서 스크립트에 넣고 다시 전송
            String numPerPageVal = "$(function(){$(\"#numPerPage\").val("+numPerPage+")});";
            request.setAttribute("numPerPageVal",numPerPageVal);

            request.setAttribute("pageBar",pageBar);
            // 가져온 값을 jsp 페이지에 전달
            request.setAttribute("members",list);
            request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
