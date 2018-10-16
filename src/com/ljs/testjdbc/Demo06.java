package com.ljs.testjdbc;

import java.sql.*;

/**
 * @Author ljs
 * @Description 测试事务
 * @Date 2018/10/8 10:38
 **/
public class Demo06 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
            //3、执行sql
            conn.setAutoCommit(false);  //取消默认提交
            ps = conn.prepareStatement("insert into jdbc_user (username,pwd) values (?,?)");
            ps.setObject(1, "李建生");
            ps.setObject(2, 123456);
            ps.execute();
            System.out.println("插入一个用户李建生");


            //睡一下
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //ps2 = conn.prepareStatement("insert into jdbc_user (username,pwd) values (?,?)");
            ps2 = conn.prepareStatement("insert into jdbc_user (username,pwd) values (?,?,?)");
            ps2.setObject(1, "陈舒研");
            ps2.setObject(2, 123456);
            ps2.execute();
            System.out.println("插入一个用户陈舒研");

            conn.commit(); //手动提交

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {

            //遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (ps2 != null) {
                    ps2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

