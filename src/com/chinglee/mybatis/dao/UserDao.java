package com.chinglee.mybatis.dao;

import com.chinglee.mybatis.pojo.User;


public interface UserDao {
    public User findUserById(int id);
    public void insertUser(User user);
    public void deleteUser(int id);
}
