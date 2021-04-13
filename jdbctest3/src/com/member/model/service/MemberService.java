package com.member.model.service;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static com.member.common.JDBCTemplate.close;
import static com.member.common.JDBCTemplate.getConnection;
// getConnection < 이게 나오면 무조건 JDBCTemplate 의 getConnection 이걸로 인식
public class MemberService {
    private MemberDao dao = new MemberDao();

    public List<Member> selectAll(){
        Connection conn = getConnection();
        List<Member> list = dao.selectAll(conn);
        close(conn);

        return  list;
    }

    public List<Member> searchName(String name){
        Connection conn = getConnection();

        List<Member> list = dao.searchName(conn,name);

        close(conn);

        return list;
    }

    public List<Member> choiceSearch(Map<String,String> param){
        Connection conn = getConnection();
        List<Member> list = dao.choiceSearch(conn,param);
        close(conn);

        return list;
    }


}
