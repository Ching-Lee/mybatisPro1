package com.chinglee.mybatis.first;

import com.chinglee.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public class MybatisFirst {
   //根据id查询用户信息，得到一条记录结果
   @Test
   public void findUserByIdTest() throws IOException {
      //mybatis配置文件
      String resource="SqlMapConfig.xml";
      InputStream inputStream=Resources.getResourceAsStream(resource);
      //创建会话工厂
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      //通过会化工厂得到sqlSession
      SqlSession sqlSession=sqlSessionFactory.openSession();
      //通过sqlSession操作数据库
      //第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
      //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
      //sqlSession.selectOne()结果就是与映射文件中所匹配的resultType类型的对象
      User user=sqlSession.selectOne("user.findUserById",1);
      System.out.println(user);
      //释放资源
      sqlSession.close();
   }

   //根据用户名称模糊查询用户列表
   @Test
   public void findUserByNameTest() throws IOException {
      //获取mybatis配置文件
      String resource="SqlMapConfig.xml";
      InputStream inputStream=Resources.getResourceAsStream(resource);
      //创建会话工厂
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      //通过会话工厂得到会话sqlsession
      SqlSession sqlSession=sqlSessionFactory.openSession();
      List<User> list=sqlSession.selectList("user.findUserByName","小明");
      System.out.println(list);
      sqlSession.close();

   }

   //添加用户信息
   @Test
   public void addUserTest() throws IOException {
      //获取mybatis配置文件
      String resource="SqlMapConfig.xml";
      InputStream inputStream=Resources.getResourceAsStream(resource);
      //创建会话工厂
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      //通过会话工厂得到会话sqlsession
      SqlSession sqlSession=sqlSessionFactory.openSession();
      //插入用户对象
      User user=new User();
      user.setUsername("王小军");
      user.setBirthday(new Date());
      user.setSex("1");
      user.setAddress("河南郑州");
      sqlSession.insert("user.insertUser",user);
      //提交事务
      sqlSession.commit();
      System.out.println(user.getId());
      //关闭会话
      sqlSession.close();

   }

   @Test
   public void deleteUserTest() throws IOException {
      String resource="SqlMapConfig.xml";
      InputStream inputStream=Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession sqlSession=sqlSessionFactory.openSession();
      sqlSession.delete("user.deleteUser",28);
      //提交事务
      sqlSession.commit();
      //关闭会话
      sqlSession.close();
   }

   @Test
   public void updateUserTest() throws IOException {
      String resouce="SqlMapConfig.xml";
      InputStream inputStream=Resources.getResourceAsStream(resouce);
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession sqlSession=sqlSessionFactory.openSession();
      User user=new User();
      user.setId(29);
      user.setUsername("王大军");
      user.setBirthday(new Date());
      user.setSex("1");
      user.setAddress("河南郑州");
      sqlSession.update("user.updateUser", user );
      //提交事务
      sqlSession.commit();
      //关闭会话
      sqlSession.close();
   }


}
