package com.emp.model.dao;

import com.emp.model.vo.Employee;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class EmpDao {
    public List<Map> getList(SqlSession session, int cPage, int numPerPage){
//        페이징 처리를 해보자
//        파라미터가 없을 때는 null을 넣어야만 한다.
        RowBounds rb = new RowBounds((cPage-1)*numPerPage,numPerPage);
        // 생성할 때 매개변수 값으로 page의 범위를 결정
        // 2개의 매개변수를 가짐
        // 1: offset -> 시작값 -> (cPage-1)*numPerPage
        // 2: limit -> 범위(한개 페이지에 출력될 개수 ) -> numPerPage

        return session.selectList("kh.getList",null,rb);
    }

    public List<Map> searchEmp(SqlSession session,Map<String,Object> param){
        return session.selectList("kh.searchEmp",param);
    }
    public List<Map> searchEmpPaging(SqlSession session,Map<String,Object> param,int cPage, int numPerPage){
        RowBounds rb = new RowBounds((cPage-1)*numPerPage,numPerPage);

        return session.selectList("kh.searchEmp",param,rb);
    }

    public int empCount(SqlSession session){
        return session.selectOne("kh.empCount");
    }

    public Employee selectOneEmp(SqlSession session,String no){
        return session.selectOne("kh.selectOneEmp",no);
    }

}
