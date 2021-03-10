package com.member.model.dao;

import com.member.model.vo.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DB 접속정보를 가지고 DB에 접속해서 SQL 구문을 실행하는 클래스
// SQL 실행 결과를 호출한 쪽으로 반환해줌
public class MemberDao {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    // select문 실행 안할꺼면 ResultSet은 필요없다.
    public List<Member> selectAll(){
        // DB연결해서 ResultSet으로 데이터 받아오기

        // 반환형에 대한 선언
        List<Member> result = new ArrayList<>();
        Member mb = new Member();


        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                    ,"student","student");
            stmt = conn.createStatement();
            String memInfo = "select * from MEMBER";
            rs = stmt.executeQuery(memInfo);

            while(rs.next()){

                String memberId = rs.getString("MEMBER_ID");
                String memberPwd = rs.getString("MEMBER_PWD");
                String memberName = rs.getString("MEMBER_NAME");
                String gender = rs.getString("GENDER");
                int age = rs.getInt("AGE");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                String address = rs.getString("ADDRESS");
                String hobby = rs.getString("HOBBY");
                Date enrollDate =rs.getDate("ENROLL_DATE");
//                System.out.println(memberId+" "+memberPwd+" "+memberName+" "+gender+" "+age+" "+
//                                    email+" "+phone+" "+address+" "+hobby+" "+enrollDate);




                // 가져온 데이터 result 객체에 넣기
                // 숙제
                mb.setMemberId(memberId);
                mb.setMemberPwd(memberPwd);
                mb.setMemberName(memberName);
                mb.setGender(gender);
                mb.setAge(age);
                mb.setEmail(email);
                mb.setPhone(phone);
                mb.setAddress(address);
                mb.setHobby(hobby);
                mb.setEnrollDate(enrollDate);

                result.add(new Member(memberId,memberPwd,memberName,gender,age,email,phone,address,hobby,enrollDate));
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(rs != null&& !rs.isClosed()) rs.close();
                if(stmt != null&& !stmt.isClosed()) stmt.close();
                if(conn != null&& !conn.isClosed()) conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }
}
