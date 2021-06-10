package com.mybatis.model.service;

import com.mybatis.model.dao.MybatisDao;
import org.apache.ibatis.session.SqlSession;
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
}
