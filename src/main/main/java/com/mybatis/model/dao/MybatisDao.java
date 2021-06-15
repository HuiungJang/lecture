package com.mybatis.model.dao;

import com.mybatis.model.vo.Student;
import org.apache.ibatis.session.SqlSession;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisDao {
    public int insertStudent(SqlSession session){
        // session이 제공하는 sql 실행 메소드를 호출하면 끝
        // mapper 선택하기 -> namespace.태그(insert,update,delete,select)id 값
        int result = session.insert("student.insertStudent");
        return result;
    }

    public int insertParam(SqlSession session, String name,String email){
        Map<String,String> tmp = new HashMap<>();
        tmp.put("name",name);
        tmp.put("email",email);

        List<Map<String,String>> list = new ArrayList<>();
        list.add(tmp);

        int result = session.update("student.insertParamName",list);
        return result;
    }

    public int insertParamAll(SqlSession session, Student s){
        int result = session.insert("student.insertParamAll",s);
        return result;
    }

    public int insertParamMap(SqlSession session, Map<String,String> param){
        int result = session.insert("student.insertParamMap",param);
        return result;
    }

    public List<Map<String,Object>> getInfo(SqlSession session){
        List<Map<String,Object>> result = session.selectList("student.getInfo");

        return result;
    }

    public int updateInfo(SqlSession session,Map<String,String> param){
        int result =session.insert("student.updateInfo",param);
        return result;
    }

    public Student selectStudent(SqlSession session, int no){
        Student s = session.selectOne("student.selectStudent",no);

        return s;
    }

    public List<Student> selectList(SqlSession session){
        return session.selectList("student.selectList");
    }

    public List<Student> searchStudent(SqlSession session,String email){
        return session.selectList("student.searchStudent",email);
    }

    public Map selectStudentMap(SqlSession session, int no){
        return session.selectOne("student.selectStudentMap",no);
    }

//    public Map selectStudentListMap(SqlSession session){
//        return session.sel("student.selectStudentListMap");
//    }
}
