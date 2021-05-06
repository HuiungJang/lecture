package com.admin.model.dao;

import com.member.model.vo.Member;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

public class AdminDao {
    private Properties pp = new Properties();

    public AdminDao() {
        String path = AdminDao.class.getResource("/sql/adminSql.properties").getPath();
        try{
            pp.load(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Member> viewMember(Connection conn){
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<Member> m= new ArrayList<>();

        try{
            psmt = conn.prepareStatement(pp.getProperty("viewMember"));
            rs = psmt.executeQuery();

            while(rs.next()){
                Member mem = new Member();

                mem.setUserId(rs.getString("userid"));
                mem.setUserName(rs.getString("username"));
                mem.setGender(rs.getString("gender"));
                mem.setAge(rs.getInt("age"));
                mem.setEmail(rs.getString("email"));
                mem.setPhone(rs.getString("phone"));
                mem.setAddress(rs.getString("address"));
                mem.setHobby(rs.getString("hobby"));
                mem.setEnrollDate(rs.getDate("enrolldate"));

                m.add(mem);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(psmt);
        }

        return m;
    }
}
