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

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                    ,"student","student");
            stmt = conn.createStatement();
            String memInfo = "select * from MEMBER";
            rs = stmt.executeQuery(memInfo);

//            while(rs.next()){
//
//                String memberId = rs.getString("MEMBER_ID");
//                String memberPwd = rs.getString("MEMBER_PWD");
//                String memberName = rs.getString("MEMBER_NAME");
//                String gender = rs.getString("GENDER");
//                int age = rs.getInt("AGE");
//                String email = rs.getString("EMAIL");
//                String phone = rs.getString("PHONE");
//                String address = rs.getString("ADDRESS");
//                String hobby = rs.getString("HOBBY");
//                Date enrollDate =rs.getDate("ENROLL_DATE");
//
//                // 가져온 데이터 result 객체에 넣기
//                // 숙제
//                // 내가한거
//
//                result.add(new Member(memberId,memberPwd,memberName,gender,
//                                    age,email,phone,address,hobby,enrollDate));
//            }

            // row는 하나의 객체
            while(rs.next()){
                // 선생님이 한거.
                Member mb = new Member();

                mb.setMemberId(rs.getString("MEMBER_ID"));
                mb.setMemberPwd(rs.getString("MEMBER_PWD"));
                mb.setMemberName(rs.getString("MEMBER_NAME"));
                mb.setGender(rs.getString("GENDER"));
                mb.setAge(rs.getInt("AGE"));
                mb.setEmail(rs.getString("EMAIL"));
                mb.setPhone(rs.getString("PHONE"));
                mb.setAddress(rs.getString("ADDRESS"));
                mb.setHobby(rs.getString("HOBBY"));
                mb.setEnrollDate(rs.getDate("ENROLL_DATE"));

                result.add(mb);
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

//    public List<Member> searchId(String memberId){
//      내가한거
//        try {
//
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
//                                    ,"student","student");
//            stmt = conn.createStatement();
//            String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID ='"+memberId+"'";
//
//            rs = stmt.executeQuery(sql);
//
//            List<Member> result = new ArrayList<>();
//            while(rs.next()) {
//                Member mb = new Member();
//
//                mb.setMemberId(rs.getString("MEMBER_ID"));
//                mb.setMemberPwd(rs.getString("MEMBER_PWD"));
//                mb.setMemberName(rs.getString("MEMBER_NAME"));
//                mb.setGender(rs.getString("GENDER"));
//                mb.setAge(rs.getInt("AGE"));
//                mb.setEmail(rs.getString("EMAIL"));
//                mb.setPhone(rs.getString("PHONE"));
//                mb.setAddress(rs.getString("ADDRESS"));
//                mb.setHobby(rs.getString("HOBBY"));
//                mb.setEnrollDate(rs.getDate("ENROLL_DATE"));
//
//                result.add(mb);
//                return  result;
//            }
//
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (!rs.isClosed() && rs != null) rs.close();
//                if (!stmt.isClosed() && stmt != null) stmt.close();
//                if (!conn.isClosed() && conn != null) conn.close();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//
//        return null;
//    }


    public Member searchId(String memberId){
        Member m =null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                    ,"student","student");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID ='"+memberId+"'";

            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                m= new Member();
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
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (!rs.isClosed() && rs != null) rs.close();
                if (!stmt.isClosed() && stmt != null) stmt.close();
                if (!conn.isClosed() && conn != null) conn.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return m;
    }


    public List<Member> searchName(String memberName){
       List<Member> l = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                                ,"student","student");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%"+memberName+"%'";

            rs = stmt.executeQuery(sql);


            while(rs.next()){
               Member m = new Member();

//                m.setMemberId(rs.getString("MEMBER_ID"));
//                m.setMemberPwd(rs.getString("MEMBER_PWD"));
//                m.setMemberName(rs.getString("MEMBER_NAME"));
//                m.setGender(rs.getString("GENDER"));
//                m.setAge(rs.getInt("AGE"));
//                m.setEmail(rs.getString("EMAIL"));
//                m.setPhone(rs.getString("PHONE"));
//                m.setAddress(rs.getString("ADDRESS"));
//                m.setHobby(rs.getString("HOBBY"));
//                m.setEnrollDate(rs.getDate("ENROLL_DATE"));

                m.setMemberId(rs.getString(1));
                m.setMemberPwd(rs.getString(2));
                m.setMemberName(rs.getString(3));
                m.setGender(rs.getString(4));
                m.setAge(rs.getInt(5));
                m.setEmail(rs.getString(6));
                m.setPhone(rs.getString(7));
                m.setAddress(rs.getString(8));
                m.setHobby(rs.getString(9));
                m.setEnrollDate(rs.getDate(10));
                // 이렇게 인덱스로 넣을 수도 있다.
                /*

                인덱스로 했을 때

                장점
                1. 입력하기 편하다.

                단점
                1. 컬럼 인덱스가 정확이 어떤 컬럼을 가르키는지 알기 어렵다.
                2. 컬럼의 순서가 바뀌면 원하는 값이 출력되지 않는다.

                => 컬럼명을 쓰는 것이 좋지만 코딩 스타일마다 다르기 때문에
                    잘 알아보고 하자.


                 */



                l.add(m);
            }


        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(!rs.isClosed() && rs != null) rs.close();
                if(!stmt.isClosed() && stmt != null) stmt.close();
                if(!conn.isClosed() && conn != null) conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return l;
    }

    public int insertMember(Member m){
        int result=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                    , "student", "student");
            stmt = conn.createStatement();

            conn.setAutoCommit(false);
            // 트랜젝션 처리(commit, rollback) 개발자가 설정할 수 있게함

            String sql = "INSERT INTO MEMBER VALUES(" +
                    "'"+m.getMemberId()
                    + "','"+m.getMemberPwd()
                    +"','"+m.getMemberName()
                    +"','"+m.getGender()
                    +"',"+m.getAge()
                    +",'"+ m.getEmail()
                    +"','"+m.getPhone()
                    +"','"+m.getAddress()
                    +"','"+m.getHobby()
                    +"','"+m.getEnrollDate()
                    +"'"
                    +")";

            result = stmt.executeUpdate(sql);
            // insert 트랜젝션 처리해야함.
            // Connection 객체에 트랜젝션을 처리해주는 메소드가 있음.
            // commit() / rollback() 메소드
            if(result>0) conn.commit();
            else conn.rollback();


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(!stmt.isClosed() && stmt != null) stmt.close();
                if(!conn.isClosed() && conn != null) conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }

}
