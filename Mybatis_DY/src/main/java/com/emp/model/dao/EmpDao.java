package com.emp.model.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class EmpDao {
    public List<Map> getList(SqlSession session){
        return session.selectList("kh.getList");
    }
    public List<Map> searchEmp(SqlSession session,Map<String,Object> param){
        return session.selectList("kh.searchEmp",param);
    }
}
