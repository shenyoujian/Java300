package com.ljs.testjdbc;

import java.sql.*;

/**
 * @Author ljs
 * @Description 测试PreparedStatement接口的基本用法
 * @Date 2018/10/8 10:05
 **/
public class Demo03 {

    public static void main(String[] args) {


        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //3、执行sql,使用PreparedStatement进行预处理避免sql注入，使用占位符减少拼接，
            String sql = "insert into jdbc_user (username, pwd, regTime) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            //传入参数，注意jdbc的索引是从1开始的
//            ps.setString(1,"李建生");
//            ps.setInt(2,123456);
//            //注意Date是sql包下的
//            ps.setDate(3,new Date(System.currentTimeMillis()));

//            //同样也可以使用Object
            ps.setObject(1,"李建生");
            ps.setObject(2,123456);
            //注意Date是sql包下的
            ps.setObject(3,new Date(System.currentTimeMillis()));
            //最后记得执行
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
