package com.admin.controller;

import com.admin.model.service.AdminService;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMemberServlet", value = "/admin/searchMember")
public class SearchMemberServlet extends HttpServlet {
    private static final long serialVersionUID = -881912918370927433L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Member loginMember = (Member)session.getAttribute("loginMember");

        if(session == null || loginMember == null || !loginMember.getUserId().equals("admin")){
            // 잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.
            request.setAttribute("msg","잘못된 경로로 접근하셨습니다.  이 페이지 사용권한이 없습니다.");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
        }else {

            String searchType = request.getParameter("searchType");
            String keyword = request.getParameter("searchKeyword");


            // 숙제
            // 1. 조회된거 페이징 처리하기
            int cPage;
            int numPerPage;

            try {
                System.out.println(request.getParameter("cPage") + ": cPage");
                cPage = Integer.parseInt(request.getParameter("cPage"));

            } catch (NumberFormatException e) {
                cPage = 1;
            }

            try {
                System.out.println(request.getParameter("numPerPage") + ": numPerPage");
                numPerPage = Integer.parseInt(request.getParameter("numPerPage"));

            } catch (NumberFormatException e) {
                numPerPage = 5;
            }

            List<Member> result = new AdminService().searchMember(searchType, keyword, cPage, numPerPage);

            // 페이지 설정하기 위한 변수
//        int totalData= result.size();
            // 이렇게 하면 페이지에 numPerPage에 설정한 수 만큼만 결과가 나옴 -> numPerPage 개수 초과하는 결과는 안나옴
            int totalData = new AdminService().detailListCount(searchType, keyword);

            System.out.println(totalData + "토탈데이터");
            System.out.println(result.size() + "리스트");

            int totalPage = (int) (Math.ceil((double) (totalData / numPerPage)));
            int pageBarSize = 4;
            int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
            int pageEnd = pageNo + pageBarSize - 1;

            String pageBar = "";
            if (pageNo == 1) {
                // 첫번째 페이지 일때
                pageBar += "<span>이전</span>";
            } else {
                // 첫번째 페이지 아니면 이전 버튼 활성화
                pageBar += "<a href='" + request.getContextPath() + "/admin/searchMember?searchType=" + searchType +
                        "&searchType=" + searchType + "&cPage=" + (pageNo - 1) + "&numPerPage=" + numPerPage + "'>[이전]</a>";
            }

            while (!(pageNo > pageEnd || pageNo > totalPage)) {
                if (cPage == pageNo) {
                    pageBar += "<span>" + pageNo + "</span>";
                } else {
                    pageBar += "<a href='" + request.getContextPath() + "/admin/searchMember?searchType=" + searchType +
                            "&searchKeyword=" + keyword + "&cPage=" + pageNo + "&numPerPage=" + numPerPage + "'>" + pageNo + "</a>";
                }
                pageNo++;
            }

            if (pageNo > totalPage) {
                // 마지막 페이지 일때
                pageBar += "<span>다음</span>";
            } else {
                pageBar += "<a href='" + request.getContextPath() + "/admin/searchMember?searchType=" + searchType +
                        "&searchType=" + searchType + "&cPage=" + pageNo + "&numPerPage=" + numPerPage + "'>[다음]</a>";
            }

            System.out.println(pageBar);

            request.setAttribute("pageBar", pageBar);
            request.setAttribute("members", result);
            request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
