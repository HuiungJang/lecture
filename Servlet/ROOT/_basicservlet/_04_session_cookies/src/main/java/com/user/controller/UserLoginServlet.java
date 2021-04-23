package com.user.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "UserLoginServlet", value = "/login.do")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 7487776849468514488L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 클라이언트가 보낸 데이터 받아오기
        String userId = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        // 서비스 로직을 구성
        // 클라이언트가 보낸 userId, userPw가 DB에 저장되어있는 데이터 인지 확인하고
        // 저장되어있으면 로그인 성공 없으면 실패
        // Servlet -> Service -> Dao

        // 1. 드라이버 올리기
        // 2. connection 정보설정 Connection 객체 생성
        // 3. Connection 객체에서 PreparedStatement 객체 생성 쿼리문 설정
        // 4. ResultSet에 결과 저장 -> executeQuery()
        // 5. 그 결과를 가지고 처리
        Connection conn =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean result = false;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","student","student");
            pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PWD=?");

            pstmt.setString(1,userId);
            pstmt.setString(2,pw);

            rs = pstmt.executeQuery();

            if(rs.next()){
                result = true;
            }

//
//            if(rs!=null&&!rs.isClosed()){ rs.close(); }
//            if(pstmt!=null && pstmt.isClosed()){pstmt.close();}
//            if(conn!=null && conn.isClosed()){conn.close();}

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }catch (SQLException e){
            e.printStackTrace();
        }

        String path = "";
        if(result){
            // 로그인 성공
            // 로그인 성공하면 그 값을 유지하기 위해 session 객체에 데이터를 대입
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId); // vo 객체도 가능함.
            path="/mainpage.do";
        }else{
            // 로그인 실패
            request.setAttribute("msg","로그인 실패 다시시도하세요");
            path="/msg.do";
        }
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
