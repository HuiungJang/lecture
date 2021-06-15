package com.mybatis.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTemplate {
    public static SqlSession getSession(){
        SqlSession session = null;
        String resource ="/mybatis-config.xml";

        // mybatis 설정 xml을 불러옴
        try{
            // mybatis-config.xml 파일을 inputStream을 이용해서 가져옴
            InputStream is = Resources.getResourceAsStream(resource);
            // SqlSessionFactoryBuilder 클래스를 생성
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            //SqlSessionFactory 클래스 생성, sfb.build(mybatis-config.xml);
            SqlSessionFactory sf = sfb.build(is);

            //sqlSession 생성하기
            session=sf.openSession(false);

        }catch (IOException e){
            e.printStackTrace();
        }

        return session;
    }
}
