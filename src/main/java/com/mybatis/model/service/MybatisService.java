package com.mybatis.model.service;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.vo.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.mybatis.common.SqlSessionTemplate.getSession;
public class MybatisService {
    private MybatisDao dao = new MybatisDao();

    public int insertStudent(){
        SqlSession session = getSession();
        int result = dao.insertStudent(session);

        if(result>0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public int insertParam(String name,String email){
        SqlSession session =getSession();
        int result = dao.insertParam(session,name,email);

        if(result>0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public int insertParamAll(Student s){
        SqlSession session = getSession();
        int result = dao.insertParamAll(session,s);

        if(result>0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public int insertParamMap(Map<String,String> param){
        SqlSession session = getSession();
        int result = dao.insertParamMap(session,param);

        if(result>0) session.commit();
        else session.rollback();

        session.close();

        return result;
    }

    public List<Map<String,Object>> getInfo(){
        SqlSession session = getSession();
        List<Map<String,Object>> result = dao.getInfo(session);

        session.close();

        return result;
    }

    public int updateInfo(Map<String,String> param){
        SqlSession session =getSession();
        int result = dao.updateInfo(session,param);

        if(result>0) session.commit();
        else session.rollback();

        return result;
    }

    public Student selectStudent(int no){
        SqlSession session =getSession();
        Student s = dao.selectStudent(session,no);

        session.close();

        return s;
    }
}
