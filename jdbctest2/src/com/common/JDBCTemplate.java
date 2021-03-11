package com.common;

import java.sql.*;

public class JDBCTemplate {
    // DAO에서 공통적으로 사용하는
    // Connection 생성,Statement 반환, ResultSet 반환, connection 반환, transaction 처리 메소드
    // 공통으로 관리하는 클래스

    // 각 메소드는 모두 어플리케이션 안에서 공통으로 사용하기 때문에
    // static 으로 관리한다. -> 메소드는 모두 static 으로 선언

    //Connection 생성
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                                    ,"student","student");

            conn.setAutoCommit(false);
            // 자동 커밋 방지.
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    // 객체 반환 메소드
    public static void close(Connection conn){
        try {
            if(conn!=null&& !conn.isClosed()) conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt){
        try{
            if(stmt!=null && !stmt.isClosed()) stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs){
        try{
            if(rs!=null && !rs.isClosed()) rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // 트렌젝션 처리하기
    public static void commit(Connection conn){
        try{
            if(conn!= null&& !conn.isClosed()) conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void rollback(Connection conn){
        try{
            if(conn!= null&& !conn.isClosed()) conn.rollback();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
