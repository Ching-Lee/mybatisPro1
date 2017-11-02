package com.chinglee.mybatis.mapper;

import com.chinglee.mybatis.pojo.OrderCustom;
import com.chinglee.mybatis.pojo.Orders;
import com.chinglee.mybatis.pojo.User;

import java.util.List;

/**
 * 订单的mapper
 */
public interface OrderCustomMapper {
    //查询订单关联查询用户信息
    public List<OrderCustom> findOrdersUser() throws Exception;
    public List<Orders> findOrdersUserResultMap() throws Exception;
    //查询订单（关联用户）及订单明细
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //查询用户购买的商品信息
    public List<User> findUserAndItemsResultMap() throws Exception;

    //查询订单关联查询用户，用户信息延迟加载
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
