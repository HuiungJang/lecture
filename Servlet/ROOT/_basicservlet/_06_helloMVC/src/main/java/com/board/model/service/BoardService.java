package com.board.model.service;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;

import java.sql.Connection;
import java.util.List;

import static com.common.JDBCTemplate.*;


public class BoardService {
    private BoardDao dao = new BoardDao();

    public List<Board> viewList(int cPage,int numPerPage){
        Connection conn = getConnection();
        List<Board> result = dao.viewList(conn,cPage,numPerPage);

        close(conn);

        return result;
    }

    public int boardCount(){
        Connection conn = getConnection();
        int result = dao.boardCount(conn);

        close(conn);

        return result;
    }

    public Board viewBoard(int boardNo,Boolean boardFlag){
        Connection conn = getConnection();
        Board result = dao.viewBoard(conn,boardNo);

        // 조회 수 증가 로직
        // 조회했을 때 무조건 1씩 증가시키면 됨.
        // 디비에서 +1 시켜주자 update 문 사용하자
        // ex
        /*

        update 테이블 명 set 컬럼명 = 컬럼명 + 1 where 조건문
        업데이트 되면 하나씩 증가시킴

         */
        if( !boardFlag && result != null){
            int count =dao.updateBoardReadCount(conn,boardNo);

            if(count>0)commit(conn);
            else rollback(conn);
        }

        close(conn);

        return result;
    }

    public int boardInsert(Board b){
        Connection conn = getConnection();
        int result = dao.boardInsert(conn,b);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }

    public int insertBoardComment(BoardComment bc){
        Connection conn =getConnection();
        int result = dao.insertBoardComment(conn,bc);

        if(result>0) commit(conn);
        else rollback(conn);

        return result;
    }

    public List<BoardComment> selectBoardComment(int boardNo){
        Connection conn = getConnection();
        List<BoardComment> list = dao.selectBoardComment(conn,boardNo);

        close(conn);

        return  list;
    }
}
