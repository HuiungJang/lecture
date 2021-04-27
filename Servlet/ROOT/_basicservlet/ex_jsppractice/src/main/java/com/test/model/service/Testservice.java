package com.test.model.service;

import com.test.model.dao.TestDao;
import com.test.model.vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testservice {
    private TestDao dao = new TestDao();

    public Member login(String id, String pw){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","kh","kh");

        }catch (Exception e){
            e.printStackTrace();
        }

        Member m = dao.login(conn,id,pw);
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }
}
