package com.notice.model.dao;

import com.notice.model.vo.Notice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.common.JDBCTemplate.*;

public class NoticeDao {
    private Properties pp = new Properties();

    public NoticeDao() {
        String path = NoticeDao.class.getResource("/sql/noticeSql.properties").getPath();
        try{
            pp.load(new FileReader(path));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Notice> viewList(Connection conn, int cPage, int numPerPage){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Notice> result = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement(pp.getProperty("viewList"));
            pstmt.setInt(1,(cPage-1)*numPerPage+1);
            pstmt.setInt(2,cPage*numPerPage);

            rs= pstmt.executeQuery();

            while(rs.next()){
                Notice n = new Notice();
                n.setNoticeNo(rs.getInt("notice_no"));
                n.setNoticeTitle(rs.getString("notice_title"));
                n.setNoticeWriter(rs.getString("notice_writer"));
                n.setNoticeContent(rs.getString("notice_content"));
                n.setNoticeDate(rs.getDate("notice_date"));
                n.setFilePath(rs.getString("filepath"));

                result.add(n);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return result;
    }

    public int countList(Connection conn){
        PreparedStatement pstmt= null;
        ResultSet rs = null;
        int result = 0;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("countList"));

            rs= pstmt.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return result;
    }

//    public List<Notice> viewContent(Connection conn,int contentNo){
    public Notice viewContent(Connection conn,int contentNo){

    PreparedStatement pstmt = null;
        ResultSet rs = null;
        Notice n =null;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("viewContent"));
            pstmt.setInt(1,contentNo);

            rs= pstmt.executeQuery();

            if(rs.next()){
                n = new Notice();

                n.setNoticeNo(rs.getInt("notice_no"));
                n.setNoticeTitle(rs.getString("notice_title"));
                n.setNoticeWriter(rs.getString("notice_writer"));
                n.setNoticeContent(rs.getString("notice_content"));
                n.setNoticeDate(rs.getDate("notice_date"));
                n.setFilePath(rs.getString("filepath"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return n;
    }
}
