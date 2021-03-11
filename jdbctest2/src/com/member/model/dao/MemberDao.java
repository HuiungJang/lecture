package com.member.model.dao;


import com.common.JDBCTemplate;
import com.member.model.vo.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    public List<Member> selectAll(Connection conn){
        Statement stmt = null;
        ResultSet rs = null;
        List<Member> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MEMBER";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                Member m = new Member();
                m.setMemberId(rs.getString("MEMBER_ID"));
                m.setMemberPwd(rs.getString("MEMBER_PWD"));
                m.setMemberName(rs.getString("MEMBER_NAME"));
                m.setGender(rs.getString("GENDER"));
                m.setAge(rs.getInt("AGE"));
                m.setEmail(rs.getString("EMAIL"));
                m.setPhone(rs.getString("PHONE"));
                m.setAddress(rs.getString("ADDRESS"));
                m.setHobby(rs.getString("HOBBY"));
                m.setEnrollDate(rs.getDate("ENROLL_DATE"));
                list.add(m);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(stmt);
        }

        return list;
    }

    public int enrollMember(Connection conn,Member m){
//        Statement stmt = null;
        PreparedStatement pstmt =null;
        // 위치홀더 (?) 표시를 이용해서 데이터 자료형 표시 대신해줌
        // 특정 메소드로 (setString,setInt) 해당 위치홀더 값만 대입하면 됨.

        int result =0;
        try{
            //stmt = conn.createStatement();


            // PrepareStatement 를 생성할때는
            // connection의 prepareStatement() 메소드를 이용함
            // 매개변수에 sql구문을 넣는다.
            String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,?)";
            // 실질적으로 값이 들어가는 곳에 ?를 넣는다.
            // 위치 홀더를 지정하는 것은 인덱스 번호다.
            // 단, 1번부터 시작.
            // 중간에 값이 들어있다면 넘기고 인덱스 번호 진행됨
            pstmt = conn.prepareStatement(sql);

            // 위치홀더로 선언된 곳에 값 대입하기
            pstmt.setString(1,m.getMemberId());
            pstmt.setString(2,m.getMemberPwd());
            pstmt.setString(3,m.getMemberName());
            pstmt.setString(4,m.getGender());
            pstmt.setInt(5,m.getAge());
            pstmt.setString(6,m.getEmail());
            pstmt.setString(7,m.getPhone());
            pstmt.setString(8,m.getAddress());
            pstmt.setString(9,m.getHobby());
            pstmt.setDate(10,m.getEnrollDate());
            // 위치 홀더를 누락하면 오류 발생함 IN .... OUT

//            String sql = "INSERT INTO MEMBER VALUES(" +
//                    "'"+m.getMemberId()
//                    + "','"+m.getMemberPwd()
//                    +"','"+m.getMemberName()
//                    +"','"+m.getGender()
//                    +"',"+m.getAge()
//                    +",'"+ m.getEmail()
//                    +"','"+m.getPhone()
//                    +"','"+m.getAddress()
//                    +"','"+m.getHobby()
//                    +"','"+m.getEnrollDate()
//                    +"'"
//                    +")";
//            result = stmt.executeUpdate(sql);


            // PrepareStatement 를 실행하려면 executeQuery() / executeUpdate()
            // 매개변수 없이 실행한다.
            result = pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }

        return result;
    }
}
