package com.ljs.testjdbc;

import java.sql.*;

/**
 * @Author ljs
 * @Description 测试Statement接口的用法，执行sql语句，以及sql注入问题
 * @Date 2018/10/8 9:16
 **/
public class Demo02 {

    public static void main(String[] args) {

        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //3、执行sql
            String sql = "insert into jdbc_user (username, pwd, regTime) values ('赵六',123456,now())";
            String sql2 = "insert into jdbc_user (username, pwd, regTime) values ('赵六','123456',now())";
            String name = "赵六";
            //sql拼接比较麻烦
//            String sql3 = "insert into jdbc_user (username, pwd, regTime) values ('"+name+"',123456,now())";
            Statement stmt = conn.createStatement();
//            stmt.execute(sql3);



            //sql注入问题,如果需要传递参数，他们可能会传递一些恶意代码例如or 1=1
            //你数据库所有数据都会被删除，操作你的数据库，不安全
            String id = "5 or 1=1";
            String sql4 = "delete from jdbc_user where id=" + id;
            stmt.execute(sql4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
