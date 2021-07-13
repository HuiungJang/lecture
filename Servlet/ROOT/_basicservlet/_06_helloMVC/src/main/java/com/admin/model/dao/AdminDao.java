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
import java.util.regex.Pattern;

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

    public List<Member> viewMember(Connection conn,int cPage,int numPerPage){
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<Member> m= new ArrayList<>();

        try{
            psmt = conn.prepareStatement(pp.getProperty("viewMember"));

            psmt.setInt(1, (cPage-1)*numPerPage+1);
            psmt.setInt(2, cPage*numPerPage);

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
//
//    public List<Member> listSize(Connection conn){
//        PreparedStatement psmt = null;
//        ResultSet rs = null;
//        List<Member> m= new ArrayList<>();
//
//        try{
//            psmt = conn.prepareStatement(pp.getProperty("listSize"));
//            rs = psmt.executeQuery();
//
//            while(rs.next()){
//                Member mem = new Member();
//
//                mem.setUserId(rs.getString("userid"));
//                mem.setUserName(rs.getString("username"));
//                mem.setGender(rs.getString("gender"));
//                mem.setAge(rs.getInt("age"));
//                mem.setEmail(rs.getString("email"));
//                mem.setPhone(rs.getString("phone"));
//                mem.setAddress(rs.getString("address"));
//                mem.setHobby(rs.getString("hobby"));
//                mem.setEnrollDate(rs.getDate("enrolldate"));
//
//                m.add(mem);
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            close(rs);
//            close(psmt);
//        }
//
//        return m;
//    }

    public int listCount(Connection conn){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result =0;

        try{
            pstmt=conn.prepareStatement(pp.getProperty("selectMemberCount"));

            rs= pstmt.executeQuery();

            if(rs.next()){
                result=rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
        }

        return result;
    }

    public List<Member> searchKeyword(Connection conn, String searchKeyword){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member m = null;
        List<Member> searchMem = new ArrayList<>();

        try{
            if(searchKeyword.equals("M") || searchKeyword.equals("F")) {
                pstmt = conn.prepareStatement(pp.getProperty("searchKeywordGender"));

            }else if(Pattern.matches("^[가-힣]*$",searchKeyword)){
                pstmt = conn.prepareStatement(pp.getProperty("searchKeywordName"));

            }else{
                pstmt = conn.prepareStatement(pp.getProperty("searchKeywordId"));

            }

            pstmt.setString(1,searchKeyword);

            rs=pstmt.executeQuery();

            while(rs.next()){
                m = new Member();
                m.setUserId(rs.getString("userid"));
                m.setUserName(rs.getString("username"));
                m.setGender(rs.getString("gender"));
                m.setAge(rs.getInt("age"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                m.setAddress(rs.getString("address"));
                m.setHobby(rs.getString("hobby"));
                m.setEnrollDate(rs.getDate("enrolldate"));

                searchMem.add(m);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return searchMem;
    }
}
