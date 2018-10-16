package com.ljs.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author ljs
 * @Description 使用jdbc连接mysql数据库
 * @Date 2018/10/7 21:53
 **/
public class Demo01 {
    public static void main(String[] args) {
        try {
            //1、加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            //2、建立连接，连接类对象内部其实有一个socket对象，是一个远程的连接，比较耗时，这是Connection对象管理的一个要点
            //真正开始，为了提高效率都会使用连接池来管理这些对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc",
                    "root","123456");
            System.out.println(conn);
            long end = System.currentTimeMillis();
            System.out.println("建立连接的时间为：" + (end-start) + "ms毫秒");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
