package com.member.model.dao;

import com.member.model.vo.Member;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.common.JDBCTemplate.close;

public class MemberDao {
    private Properties pp = new Properties();

    public MemberDao() {
        try {
            String path = MemberDao.class.getResource("/driver/sql.properties").getPath();
            pp.load(new FileReader(path));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Member login(Connection conn, String id, String pw){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member m = null;

        try{
            pstmt=conn.prepareStatement(pp.getProperty("search"));
            pstmt.setString(1,id);
            pstmt.setString(2,pw);
            rs= pstmt.executeQuery();

            if(rs.next()){
                m=new Member();
                m.setUserId(rs.getString("userid"));
                m.setPassword(rs.getString("password"));
                m.setUserName(rs.getString("username"));
                m.setGender(rs.getString("gender"));
                m.setAge(rs.getInt("age"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                m.setAddress(rs.getString("address"));
                m.setHobby(rs.getString("hobby"));
                m.getEnrollDate(rs.getDate("enrolldate"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return m;
    }
    public int memberEnroll(Connection conn,Member m){
        PreparedStatement pstmt = null;
        int result = 0;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("insertmember"));

            pstmt.setString(1,m.getUserId());
            pstmt.setString(2,m.getPassword());
            pstmt.setString(3,m.getUserName());
            pstmt.setString(4,m.getGender());
            pstmt.setInt(5,m.getAge());
            pstmt.setString(6,m.getEmail());
            pstmt.setString(7,m.getPhone());
            pstmt.setString(8,m.getAddress());
            pstmt.setString(9,m.getHobby());

            result= pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(conn);
        }

        return  result;
    }

    public Member checkDuplicateId(Connection conn, String id){
        PreparedStatement pstmt= null;
        ResultSet rs = null;
        Member m =null;

        try{
            pstmt=conn.prepareStatement(pp.getProperty("checkDuplicateId"));
            pstmt.setString(1,id);
            rs= pstmt.executeQuery();

            if(rs.next()){
                m = new Member();
                m.setUserId(rs.getString("userid"));
                m.setPassword(rs.getString("password"));
                m.setUserName(rs.getString("username"));
                m.setGender(rs.getString("gender"));
                m.setAge(rs.getInt("age"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                m.setAddress(rs.getString("address"));
                m.setHobby(rs.getString("hobby"));
                m.getEnrollDate(rs.getDate("enrolldate"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return m;
    }

    public int updateMember(Connection conn, Member m){
        PreparedStatement pstmt = null;
        int result =0;
        try{
            pstmt = conn.prepareStatement(pp.getProperty("updateMember"));
//            pstmt.setString(1,m.getPassword());
            pstmt.setString(1,m.getUserName());
            pstmt.setString(2,m.getEmail());
            pstmt.setString(3,m.getPhone());
            pstmt.setString(4,m.getAddress());
            pstmt.setString(5,m.getHobby());
            pstmt.setString(6,m.getUserId());

            result = pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(conn);
        }
        return result;
    }

    public int deleteMember(Connection conn,String id){
        PreparedStatement pstmt= null;
        int result = 0;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("deleteMember"));
            pstmt.setString(1,id);

            result = pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            // 에러나면 로그만 찍히도록 하는 것이 아니라
            // 다른 페이지로 연결하거나 다른 로직을 실행 할 수 있음.
        }finally {
            close(pstmt);
            close(conn);
        }

        return result;
    }

    public int changePw(Connection conn, String id, String pw){
        PreparedStatement pstmt = null;
        int result=0;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("changePw"));
            pstmt.setString(1,pw);
            pstmt.setString(2,id);

            result = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(conn);
        }

        return result;
    }
}
