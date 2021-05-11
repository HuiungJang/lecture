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

    // 내가한 공지사항 수정로직
//    public int reviseNotice(int contentNo, String title, String filePath,String content){
//        Connection conn = getConnection();
//        int result = dao.reviseNotice(conn,contentNo,title,filePath,content);
//
//        if(result>0) commit(conn);
//        else rollback(conn);
//
//        close(conn);
//
//        return result;
//    }
    public int reviseNotice(Notice n){
        Connection conn = getConnection();
        int result = dao.reviseNotice(conn,n);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }

    // 내가한거
//    public int enrollNotice(String title, String writer,String filePath, String content){
//        Connection conn = getConnection();
//        int result = dao.enrollNotice(conn,title,writer,filePath,content);
//
//        if(result>0) commit(conn);
//        else rollback(conn);
//
//        close(conn);
//
//        return result;
//    }
    // 샘이 한거
    public int insertNotice(Notice n){
        Connection conn = getConnection();
        int result = dao.insertNotice(conn,n);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }

    public int deleteNotice(int noticeNo){
        Connection conn = getConnection();
        int result = dao.deleteNotice(conn,noticeNo);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }
}
