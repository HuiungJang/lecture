package com.member.model.dao;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Member;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberDao {
    private Properties prop = new Properties();

    public MemberDao(){
    File f = new File("");
    String path = f.getAbsolutePath();
        try{
            prop.load(new FileReader(path+File.separator+"jdbctest3"
                    +File.separator+"src"+File.separator+"sql"+
                    File.separator+"member_sql.properties.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public List<Member> selectAll(Connection conn){
        // sql문을 실행하는 객체 -> Statement PreparedStatement
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Member> list = new ArrayList<>();

        // PreparedStatement 사용하기
        // SQL 과 같이 생성해서 쿼리문을 메소드로 완성 후 실행하는 객체

        // 위치홀더가 없어도 사용가능하다. -> 있을 때만 위치홀더 세팅하고 없으면 그냥사용

        try{
            pstmt=conn.prepareStatement(prop.getProperty("selectAll"));
            // ?(위치홀더)가 매개변수로 들어온 쿼리문에 있으면 set000으로 값을 설정
            // 없으면 그냥 실행하면된다.
            rs= pstmt.executeQuery();
            // DB에서 가져오는 row가 1개 이상이면 while
            // 1개 이하면 if
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
                m.setEnrollDate(rs.getString("ENROLL_DATE"));

                list.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public List<Member> searchName(Connection conn,String name) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Member> list = new ArrayList<>();

        // PreparedStatement 사용하기
        // SQL 과 같이 생성해서 쿼리문을 메소드로 완성 후 실행하는 객체

        try {
            pstmt = conn.prepareStatement(prop.getProperty("selectName"));
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

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
                m.setEnrollDate(rs.getString("ENROLL_DATE"));

                list.add(m);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }

        return list;
    }

    public List<Member> choiceSearch(Connection conn, Map<String,String> map){
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        List<Member> list = new ArrayList<>();

        Set<Map.Entry<String,String>> entry = map.entrySet();
        String col ="";
        String val ="";

        for(Map.Entry<String,String> e :entry){
            col = e.getKey();
            val = e.getValue();
        }


        // String sql = "SELECT * FROM MEMBER WHERE ? LIKE ?";
        // 원하는 col을 바꿔가며 sql쿼리를 작석하고 싶을 때는
       // String sql = "SELECT * FROM MEMBER WHERE "+col+" LIKE ?";

        // 쿼리문은 외부에 공개하지말아야한다
        // property 파일등으로 따로 관리한다.

        try{
            String sql = prop.getProperty("choiceSelect").replace("#",col);

            pstmt = conn.prepareStatement(sql);

//            pstmt.setString(1,col);
            pstmt.setString(1,"%"+val+"%");

            rs = pstmt.executeQuery();

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
                m.setEnrollDate(rs.getString("ENROLL_DATE"));

                list.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }

        return list;
    }
}
