package com.common;

import com.member.model.dao.MemberDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection(){
        Properties pp = new Properties();
        Connection conn = null;

        try {
            String path = JDBCTemplate.class.getResource("/driver/driver.properties").getPath();
            pp.load(new FileReader(path));

            Class.forName(pp.getProperty("driver"));
            conn = DriverManager.getConnection(pp.getProperty("url"),pp.getProperty("id"),pp.getProperty("pw"));

            conn.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn){
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt ){
        try{
            if(stmt!= null && !stmt.isClosed()){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try{
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void commit(Connection conn){
        try{
            if(conn!= null&&!conn.isClosed()){
                conn.commit();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn){
        try{
            if(conn!= null && !conn.isClosed()){
                conn.rollback();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
