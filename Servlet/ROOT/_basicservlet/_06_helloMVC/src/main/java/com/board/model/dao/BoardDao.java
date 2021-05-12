package com.board.model.dao;

import com.board.model.vo.Board;
import oracle.jdbc.proxy.annotation.Pre;

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

import static com.common.JDBCTemplate.close;

public class BoardDao {
    private Properties pp =new Properties();

    public BoardDao() {
        String path = BoardDao.class.getResource("/sql/boardSql.properties").getPath();
        try {
            pp.load(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Board> viewList(Connection conn,int cPage, int numPerPage){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Board> result = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement(pp.getProperty("viewList"));
            pstmt.setInt(1,(cPage-1)*numPerPage+1);
            pstmt.setInt(2,cPage*numPerPage);

            rs= pstmt.executeQuery();

            while (rs.next()){
                Board b = new Board();
                b.setBoardNo(rs.getInt("board_no"));
                b.setBoardTitle(rs.getString("board_title"));
                b.setBoardWriter(rs.getString("board_writer"));
                b.setBoardContent(rs.getString("board_content"));
                b.setBoardOriginFileName(rs.getString("board_original_filename"));
                b.setBoardRenameFileName(rs.getString("board_renamed_filename"));
                b.setBoardDate(rs.getDate("board_date"));
                b.setBoardRecount(rs.getInt("board_readcount"));

                result.add(b);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return  result;
    }

    public int boardCount(Connection conn){
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        int result = 0;

        try{
            pstmt=conn.prepareStatement(pp.getProperty("boardCount"));

            rs=pstmt.executeQuery();

            if(rs.next()){
                result= rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return  result;
    }

    public Board viewBoard(Connection conn,int boardNo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Board b = null;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("viewBoard"));
            pstmt.setInt(1,boardNo);

            rs= pstmt.executeQuery();

            if(rs.next()){
                b = new Board();

                b.setBoardNo(rs.getInt("board_no"));
                b.setBoardTitle(rs.getString("board_title"));
                b.setBoardWriter(rs.getString("board_writer"));
                b.setBoardContent(rs.getString("board_content"));
                b.setBoardOriginFileName(rs.getString("board_original_filename"));
                b.setBoardRenameFileName(rs.getString("board_renamed_filename"));
                b.setBoardDate(rs.getDate("board_date"));
                b.setBoardRecount(rs.getInt("board_readcount"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return b;
    }

    public int updateBoardReadCount(Connection conn, int boardNo){
        PreparedStatement psmt =null;
        int result = 0;
        try{
            psmt = conn.prepareStatement(pp.getProperty("updateBoardReadCount"));

            psmt.setInt(1,boardNo);
            result = psmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(psmt);
        }
        return result;
    }

    public int boardInsert(Connection conn, Board b){
        PreparedStatement pstmt = null;
        int result = 0;

        try{
            pstmt = conn.prepareStatement(pp.getProperty("boardInsert"));
//            pstmt.setInt(1,b.getBoardNo());
            pstmt.setString(1,b.getBoardTitle());
            pstmt.setString(2,b.getBoardWriter());
            pstmt.setString(3,b.getBoardContent());
            pstmt.setString(4,b.getBoardOriginFileName());
            pstmt.setString(5,b.getBoardRenameFileName());
//            pstmt.setInt(6,b.getBoardRecount());

            result=pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(pstmt);
        }

        return result;
    }
}
