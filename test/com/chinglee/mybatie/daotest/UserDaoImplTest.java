package com.chinglee.mybatie.daotest;

import com.chinglee.mybatis.dao.UserDao;
import com.chinglee.mybatis.dao.UserDaoImpl;
import com.chinglee.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;
    //此方法是在执行test方法之前执行
    @Before
    public void setUp() throws Exception {
        String resource="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void findUserById() throws Exception {
        //创建UserDao对象
        UserDao userDao=new UserDaoImpl( sqlSessionFactory);
        //调用UserDao的方法
        User user=userDao.findUserById(1);
        System.out.println(user);

    }

    @Test
    public void insertUser() throws Exception {
        //创建UserDao对象
        UserDao userDao=new UserDaoImpl( sqlSessionFactory);
        //调用UserDao的方法
        User user=new User();
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("河南郑州");
        userDao.insertUser(user);

    }

    @Test
    public void deleteUser() throws Exception {
        //创建UserDao对象
        UserDao userDao=new UserDaoImpl( sqlSessionFactory);
        userDao.deleteUser(30);
    }

}