package com.ljs.testjdbc;

import java.sql.*;

/**
 * @Author ljs
 * @Description ResultSet接口的基本用法，以及关闭数据库资源
 * @Date 2018/10/8 10:38
 **/
public class Demo04 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
            //3、执行sql
            String sql = "select id,username,pwd from jdbc_user where id>?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 2);
            //4、返回结果集
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getInt(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
           try{
               if(rs!=null){
                   rs.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           try{
               if(ps!=null){
                   ps.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           try{
               if(conn!=null){
                   conn.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
        }
    }
}
