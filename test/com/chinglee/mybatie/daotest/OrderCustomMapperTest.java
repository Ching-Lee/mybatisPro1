package com.chinglee.mybatie.daotest;

import com.chinglee.mybatis.mapper.OrderCustomMapper;
import com.chinglee.mybatis.mapper.UserMapper;
import com.chinglee.mybatis.pojo.OrderCustom;
import com.chinglee.mybatis.pojo.Orders;
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
 * Created by Administrator on 2017/10/26 0026.
 */
public class OrderCustomMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);


    }

    @Test
    public void findOrdersUserTest() throws Exception {
      SqlSession sqlSession=sqlSessionFactory.openSession();
      //创建代理对象
      OrderCustomMapper orderCustomMapper= sqlSession.getMapper(OrderCustomMapper.class);
      //调用mapper的方法
        List<OrderCustom> list =orderCustomMapper.findOrdersUser();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void findOrdersUserResultMapTest() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建代理对象
        OrderCustomMapper orderCustomMapper= sqlSession.getMapper(OrderCustomMapper.class);
        //调用mapper的方法
        List<Orders> list =orderCustomMapper.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void findOrdersAndOrderDetailResultMapTest() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建代理对象
        OrderCustomMapper orderCustomMapper= sqlSession.getMapper(OrderCustomMapper.class);
        //调用mapper的方法
        List<Orders> list =orderCustomMapper.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void findUserAndItemsResultMapTest() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建代理对象
        OrderCustomMapper orderCustomMapper= sqlSession.getMapper(OrderCustomMapper.class);
        //调用mapper的方法
        List<User> list =orderCustomMapper.findUserAndItemsResultMap();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    //查询订单关联查询用户延迟加载
    public void findOrdersUserLazyLoadingTest() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建代理对象
        OrderCustomMapper orderCustomMapper= sqlSession.getMapper(OrderCustomMapper.class);
        //调用mapper的方法
        List<Orders> list =orderCustomMapper.findOrdersUserLazyLoading();
        //遍历上边的订单列表
        for(Orders orders:list){
            //执行getUser
            User user=orders.getUser();
            System.out.println(user);
        }
        sqlSession.close();
    }

    //测试echcache
    @Test
    public void testCache() throws Exception{
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        SqlSession sqlSession2=sqlSessionFactory.openSession();
        UserMapper userMapper1=sqlSession1.getMapper(UserMapper.class);
        User user1=userMapper1.findUserById(1);
        System.out.println(user1);
        sqlSession1.close();
       //第二次发起请求，查询id为1的用户
        UserMapper userMapper2=sqlSession2.getMapper(UserMapper.class);
        User user2=userMapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }

}