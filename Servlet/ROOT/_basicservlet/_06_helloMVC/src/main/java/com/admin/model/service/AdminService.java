package com.admin.model.service;

import com.admin.model.dao.AdminDao;
import com.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;
import static com.common.JDBCTemplate.*;

public class AdminService {
    private AdminDao dao = new AdminDao();

    public List<Member> viewMember(int cPage,int numPerPage){
        Connection conn = getConnection();
        List<Member> list = dao.viewMember(conn,cPage,numPerPage);

        close(conn);

        return list;
    }
//
//    public List<Member> listSize(){
//        Connection conn = getConnection();
//        List<Member> list = dao.listSize(conn);
//
//        close(conn);
//
//        return list;
//    }

    public int listCount(){
        Connection conn = getConnection();
        int result = dao.listCount(conn);
        close(conn);
        return result;
    }

    // 내가한 상세조회 Service logic
//    public List<Member> searchMember(String searchKeyword){
//        Connection conn = getConnection();
//        List<Member> mem = dao.searchKeyword(conn,searchKeyword);
//        close(conn);
//
//        return mem;
//    }

    // 샘이 한거
    public List<Member> searchMember(String searchType, String keyword,int cPage, int numPerPage){
        Connection conn = getConnection();
        List<Member> list =dao.searchMember(conn,searchType,keyword,cPage,numPerPage);
        close(conn);

        return list;
    }

    public int detailListCount(String searchType,String keyword){
        Connection conn = getConnection();
        int result = dao.detailListCount(conn,searchType,keyword);
        close(conn);

        return result;
    }

}
