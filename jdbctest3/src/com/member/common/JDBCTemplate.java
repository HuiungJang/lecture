package com.member.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){
        Connection conn =null;
        Properties prop = new Properties();
        try{
//            Class.forName("경로");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//                        "student","student");

            // 코드안에 서버의 주소와 아이디, 비밀번호를 적으면 굉장히 위험하다.
            // 노출될경우 해킹의 위험, 자료 유출의 위험이 있다 절대 코드안에 넣지말자
            // -> 따로 파일로 저장해서 관리하자

            String path = JDBCTemplate.class.getResource("").getPath();
            prop.load(new FileReader(path+"driver.properties"));
            // properties 파일을 불러오기

            Class.forName(prop.getProperty("driver"));
            conn=DriverManager.getConnection(prop.getProperty("url"),
                    prop.getProperty("user"), prop.getProperty("pw"));
            // key값을 기준으로 가져오기

            conn.setAutoCommit(false);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn){
        try{
            if(!conn.isClosed() && conn != null) conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt){
        try{
            if(!stmt.isClosed() && stmt != null) stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try{
            if(!rs.isClosed() && rs != null) rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void commit(Connection conn){
        try {
            if(!conn.isClosed() && conn != null) conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn){
        try {
            if(!conn.isClosed() && conn != null) conn.rollback();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
