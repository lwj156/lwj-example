package com.lwj.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //加载配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行查询
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
//        System.out.println(userMapper.selectUser(1).getId());
//
//        sqlSession.commit();
//
//        SqlSession sqlSession2=sqlSessionFactory.openSession();
//        UserMapper userMapper2 =sqlSession2.getMapper(UserMapper.class);
//        System.out.println(userMapper2.selectUser(1).getId());

        PageHelper.startPage(1,2);
        System.out.println(userMapper.selectAll());
    }
}
