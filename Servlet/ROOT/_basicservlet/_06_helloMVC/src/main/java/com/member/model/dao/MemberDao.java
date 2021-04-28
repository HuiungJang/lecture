package com.member.model.dao;

import com.member.model.vo.Member;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
