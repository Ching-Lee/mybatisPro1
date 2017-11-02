package com.chinglee.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        //准备数据库的连接
        Connection connection=null;
        //预编译的Statement,提高数据库性能
        PreparedStatement preparedStatement=null;
        //查询结果集
        ResultSet resultSet=null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8","root","19940905");
            String sql="select * from user where username = ?";
            preparedStatement=connection.prepareStatement(sql);
            //设置参数索引（从1开始），参数值："王五"
            preparedStatement.setString(1,"王五");
            //查询得到结果集
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" "+resultSet.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(preparedStatement!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }
}
