package com.chinglee.mybatis.dao;

        import com.chinglee.mybatis.pojo.User;
        import org.apache.ibatis.session.SqlSession;
        import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl implements UserDao {
    SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }
    @Override
    public User findUserById(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("user.findUserById",id);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();

    }
}
