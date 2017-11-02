package com.chinglee.mybatie.daotest;

import com.chinglee.mybatis.mapper.UserMapper;
import com.chinglee.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/10/21 0021.
 */
public class UserMapperTest {
    private  SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        User user=userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("小李子");
        user.setAddress("北京");
        user.setSex("1");
        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(29);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void testFindUserByName(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList= userMapper.findUserByName("小明");
        sqlSession.close();
        System.out.print(userList);
    }

}