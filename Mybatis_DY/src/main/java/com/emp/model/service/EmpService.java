package com.emp.model.service;

import com.emp.model.dao.EmpDao;
import com.emp.model.vo.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import static com.common.SessionTemplate.getSession;

public class EmpService {
    private EmpDao dao = new EmpDao();

    public List<Map> getList(int cPage, int numPerPage){
        SqlSession session = getSession();
        List<Map> list = dao.getList(session,cPage,numPerPage);

        session.close();

        return list;
    }
    public List<Map> searchEmp(Map<String,Object> param){
        SqlSession session = getSession();
        List<Map> searchEmp = dao.searchEmp(session,param);

        session.close();

        return searchEmp;
    }

    public List<Map> searchEmpPaging(Map<String,Object> param,int cPage,int numPerPage){
        SqlSession session = getSession();
        List<Map> searchEmp = dao.searchEmpPaging(session,param,cPage,numPerPage);

        session.close();

        return searchEmp;
    }

    public int empCount(){
        SqlSession session = getSession();
        int count = dao.empCount(session);

        session.close();

        return count;
    }

    public Employee selectOneEmp(String no){
        SqlSession session = getSession();
        Employee selectOneEmp = dao.selectOneEmp(session,no);

        session.close();

        return selectOneEmp;
    }

}
