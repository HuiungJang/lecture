package com.test.model.dao;

import com.test.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDao {

    public TestDao() {
    }

    public Member login(Connection conn, String id, String pw) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member where member_id=? and member_pw=?";
        Member m = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                m = new Member();
                m.setMemberId(rs.getString("member_id"));
                m.setMemberPw(rs.getString("member_pw"));
                m.setMemberName(rs.getString("member_name"));
                m.setAge(rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return m;
    }
}
