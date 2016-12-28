package com.bob.stu.mybatis.jdbc;


import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 原生jdbc练习
 *
 * @author bob Tel:15811588260
 * @version 1.0
 * @since 2016/12/3
 */
public class JdbcMain {
    private final static Logger _log = Logger.getLogger(JdbcMain.class);
    private final static ResourceBundle rb = ResourceBundle.getBundle("jdbc");

    public static void main(String[] args) {
        //定义sql语句 ?表示占位符
        String sql = "SELECT * FROM user WHERE username = ?";
        String password = rb.getString("password");
        String user = rb.getString("username");
        String url = rb.getString("url");
        String driver = rb.getString("driver");
        //1.加载数据库驱动
        try {
            Class<?> aClass = Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            _log.error("加载数据库驱动失败");
        }
        //2.通过数据库驱动类获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(sql);//预编译sql
        } catch (SQLException e) {
            e.printStackTrace();
            _log.error("获取数据库连接失败");
            return;
        }

        try {
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                _log.info("查询结果为===>>>" + resultSet.getString("id") + "  " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            _log.error("查询失败！");
        }

        try {//释放资源
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            _log.error("释放资源失败！");
        }


    }

}
