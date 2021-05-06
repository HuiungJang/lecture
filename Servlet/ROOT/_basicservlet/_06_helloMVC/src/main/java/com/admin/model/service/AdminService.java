package com.admin.model.service;

import com.admin.model.dao.AdminDao;
import com.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;
import static com.common.JDBCTemplate.*;

public class AdminService {
    private AdminDao dao = new AdminDao();

    public List<Member> viewMember(){
        Connection conn = getConnection();
        List<Member> list = dao.viewMember(conn);

        close(conn);

        return list;
    }

}
