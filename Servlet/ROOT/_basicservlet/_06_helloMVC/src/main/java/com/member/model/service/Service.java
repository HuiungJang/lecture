package com.member.model.service;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

public class Service {
    private MemberDao dao = new MemberDao();

    public Member login(String id, String pw){
        Connection conn = getConnection();
        Member m = dao.login(conn,id,pw);
        close(conn);
        return m;
    }

}
