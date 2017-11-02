package com.chinglee.mybatis.mapper;

import com.chinglee.mybatis.pojo.User;

import java.util.List;


public interface UserMapper {
    public User findUserById(int id);
    public void insertUser(User user);
    public void deleteUser(Integer id);
    public List<User> findUserByName(String name);
}
