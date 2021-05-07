package com.member.controller;

import com.member.model.service.Service;
import com.member.model.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 7101664638528192148L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. client가 보낸 값 가져오기
        String id = request.getParameter("userId");
        String pw = request.getParameter("password");

        // 2. 가져온 값이 DB에 있는지 확인
        Member m = new Service().login(id,pw);
        System.out.println("login 로직 실행");
        System.out.println(m);


        // checkbox 에 있는 값을 가져오자
        String saveId= request.getParameter("saveId");
        System.out.println("췤밗" + saveId);
        // 로그인을 했을 때 아이디 저장을 체크한 경우 전송된 아이디 값을 유지하는 로직
        // 아이디 값을 유지하려면 session, context, cookies 중 하나에 보관해야함
        // 세션은 서버에 쿠키는 클라이언트 컴퓨터에 저장됨
        // 사용자가 조작해도 상관없는 데이터는 쿠키에 저장해서 관리하자
        // 체크했으면 "on" 안했으면 "null" 나옴

        if(saveId != null){
            String userId = request.getParameter("userId");
            Cookie c = new Cookie("saveId",userId);
            c.setPath(request.getContextPath());
            c.setMaxAge(60*60*24*7);
            response.addCookie(c);
        }else{
            Cookie c = new Cookie("saveId","");
            c.setMaxAge(0);
            response.addCookie(c);
        }



        /*
        requset -> 요청이 들어오면 생성되고 다른 요청 들어오면 사라짐
        session -> 생성되면 invalidate 될때 까지 남음
        context -> 서버가 시작하면 생성되고 중단되면 사라짐
         */

        if (m == null) {
            // m 값이 null 이면 실패
            // 로그인 실패에 대한 에러메세지를 띄워주고 메인으로 이동
            // 1. 에러메세지를 출력해주는 별도의 msg 전용 jsp 구성
            // 2. 에러 메세지 출력 후 메인 화면으로 전환
            // 로그인 실패에 대한 에러메세지는 요청에 대한 응답으로 종료됨 -> request 객체
            request.setAttribute("msg","로그인 실패, 아이디/패스워드를 확인하세요");

            // 페이지에 전환할 주소값도 같이 전달 가능하다.
            request.setAttribute("loc","/");

            // 다른 페이지에서 이용한다? 디스패쳐, 필요없다? 리다이렉트
            RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");

            // 한번 요청이 있으면 forward 나 sendRedirect 든 1개만 사용가능하다.
            // 두개를 사용할 수 는 없다.
            rd.forward(request,response);

        }else{
            // m값이 null 아니면 성공
//            request.setAttribute("loginMember",m);
//            이걸로 저장하면 새로운 requset가 들어오면 초기화됨 -> 저장 x

            HttpSession session = request.getSession();
            session.setAttribute("loginMember",m);
            response.sendRedirect(request.getContextPath());


            //session 객체에 대한 설정 및 정보를 가져오는 메소드
            // getCreateTime() -> 세션 생성시간
            // getLastAccessedTime() -> 마지막 요청시간
            // getMaxInactiveInterval() -> 최대 허용시간
            System.out.println("최대 유지시간 : " + session.getMaxInactiveInterval());

            // setMaxInactiveInterval(초);
            // session.setMaxInactiveInterval(10);
            // 최대허용시간을 설청 (초)



        }

        // 로그인 성공, 실패 -> 메인으로
        // 페이지 이동하는 방법 2개, sendRedirect / RequestDispatcher
//        RequestDispatcher rd = request.getRequestDispatcher("");
//        rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
