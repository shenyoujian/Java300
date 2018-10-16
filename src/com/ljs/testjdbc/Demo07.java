package com.ljs.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * @Author ljs
 * @Description 测试时间处理(java.sql.Date，Time,TimeStamp)
 * @Date 2018/10/8 10:38
 **/
public class Demo07 {

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

            //随机生成日期,插入10000000条数据
            for(int i=0;i<1000;i++){
                ps = conn.prepareStatement("insert into jdbc_user (username,pwd,regTime,loginTime) values (?,?,?,?)");
                ps.setObject(1, "李建生" + i);
                ps.setObject(2, 123456);

                //随机数,生成0到一百亿之间的任意数
                int rand = new Random().nextInt(1000000000);


                //java.sql.Date插入日期，java.sql.Time插入时分秒，
                // java.sql.TimeStamp插入日期和时分秒，开发主要使用这两个类Date和TimeStamp
                //他们分别对应mysql里的Date和Time和TimeStamp
                java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis()-rand);
                ps.setObject(3,timestamp);

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                ps.setObject(4, date);
                ps.execute();
            }

            System.out.println("插入一个用户李建生");
            conn.commit();

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

