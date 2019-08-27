package com.lwj.mybatis;

import com.lwj.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Linwj
 * @date 2019/7/26 10:08
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        Class resource1=MybatisTest.class;
        System.out.println(resource1.getName());
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUser(1).getId());
    }
}
