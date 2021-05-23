package com.member.model.service;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

import java.sql.Connection;

import static com.common.JDBCTemplate.*;

public class Service {
    private MemberDao dao = new MemberDao();

    public Member login(String id, String pw){
        Connection conn = getConnection();
        Member m = dao.login(conn,id,pw);
        close(conn);
        return m;
    }

    public int enrollMember(Member m){
        Connection conn = getConnection();
        int mem = dao.memberEnroll(conn,m);

        if(mem>0) commit(conn);
        else rollback(conn);

        close(conn);

        return mem;
    }

    public Member checkDuplicateId(String id){
        Connection conn = getConnection();
        Member m = dao.checkDuplicateId(conn,id);
        close(conn);

        return m;
    }

    public int updateMember(Member m){
        Connection conn =getConnection();
        int result = dao.updateMember(conn,m);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);
        return result;
    }
    public int deleteMember(String id){
        Connection conn =  getConnection();
        int result = dao.deleteMember(conn,id);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }


    public int changePw(String id, String pw){
        Connection conn = getConnection();
        int result = dao.changePw(conn,id,pw);
        close(conn);

        return result;
    }


}
