package com.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTemplate {
    public static SqlSession getSession(){
        SqlSession session = null;
        String resource = "/mybatis-config.xml";
        try{
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            SqlSessionFactory sf =sfb.build(is);

            session = sf.openSession(false);
        }catch (IOException e){
            e.printStackTrace();
        }

        return session;
    }
}
