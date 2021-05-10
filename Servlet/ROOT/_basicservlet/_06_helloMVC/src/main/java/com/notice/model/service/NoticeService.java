package com.notice.model.service;

import com.notice.model.dao.NoticeDao;
import com.notice.model.vo.Notice;

import java.sql.Connection;
import java.util.List;
import static com.common.JDBCTemplate.*;

public class NoticeService {
    private NoticeDao dao = new NoticeDao();

    public List<Notice> viewList(int cPage, int numPerPage){
        Connection conn = getConnection();
        List<Notice> result =dao.viewList(conn,cPage,numPerPage);
        close(conn);

        return result;
    }

    public int countList(){
        Connection conn = getConnection();
        int result = dao.countList(conn);
        close(conn);

        return result;
    }

    public Notice viewContent(int contentNo){
        Connection conn = getConnection();
        Notice result =dao.viewContent(conn, contentNo);
        close(conn);

        return result;
    }
}
