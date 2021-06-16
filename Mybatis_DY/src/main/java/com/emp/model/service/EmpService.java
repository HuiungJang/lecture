package com.emp.model.service;

import com.emp.model.dao.EmpDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import static com.common.SessionTemplate.getSession;

public class EmpService {
    private EmpDao dao = new EmpDao();

    public List<Map> getList(){
        SqlSession session = getSession();
        List<Map> list = dao.getList(session);

        session.close();

        return list;
    }
    public List<Map> searchEmp(Map<String,Object> param){
        SqlSession session = getSession();
        List<Map> searchEmp = dao.searchEmp(session,param);

        session.close();

        return searchEmp;
    }

}
