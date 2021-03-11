package com.member.model.service;

import com.common.JDBCTemplate;
import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;

public class MemberService {
    // Connection 객체를 관리하는 기능
    // connection 객체 반환, 트랜젝션 처리함.
    private MemberDao dao = new MemberDao();

    public List<Member> selectAll(){
        // 1. Connection 객체 가져오기
        Connection conn = JDBCTemplate.getConnection();
        // 가져온 connection을 dao에 전달
        List<Member> list = dao.selectAll(conn);

        JDBCTemplate.close(conn);

        return list;
    }

    public int enrollMember(Member m){
        Connection conn = JDBCTemplate.getConnection();
       int result = dao.enrollMember(conn,m);

       if(result>0) JDBCTemplate.commit(conn);
       else JDBCTemplate.rollback(conn);

       JDBCTemplate.close(conn);

       return result;
    }

}
