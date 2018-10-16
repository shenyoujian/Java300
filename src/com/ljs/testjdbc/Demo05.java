package com.ljs.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author ljs
 * @Description 批处理的基本用法
 * @Date 2018/10/8 11:18
 **/
public class Demo05 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //3、执行sql
            //进行批处理之前需要手动关闭事务
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            long start = System.currentTimeMillis();
            for(int i=0;i<20000;i++){
                stmt.addBatch("insert into jdbc_user (username, pwd, regTime) values ('李建生" + i + "', 666666, now())");
            }
            stmt.executeBatch();
            conn.commit();//最后再提交
            long end = System.currentTimeMillis();
            System.out.println("插入2w条数据耗时：" + (end-start) + "ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null){
                    stmt.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
