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

    public List<Member> searchMember(String searchKeyword){
        Connection conn = getConnection();
        List<Member> mem = dao.searchKeyword(conn,searchKeyword);
        close(conn);

        return mem;
    }

}
