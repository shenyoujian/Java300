package com.ljs.testjdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @Author ljs
 * @Description 测试取出指定时间段的数据
 * @Date 2018/10/8 10:38
 **/
public class Demo08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //3、执行sql
//            String sql = "select * from jdbc_user where regTime>? and regTime<? ORDER BY regTime";
//            stmt = conn.prepareStatement(sql);
//            //4、处理结果集
//            long start = Convert("2018-10-09 00:00:00");
//            long end = Convert("2018-10-09 08:41:01");
//            stmt.setObject(1,new Timestamp(start));
//            stmt.setObject(2,new Timestamp(end));
//            rs = stmt.executeQuery();
//            while (rs.next()){
//                System.out.println(rs.getInt("id") + "---" + rs.getString("username")+ "---" +
//                        rs.getString("pwd")+ "---" +rs.getTimestamp("regTime"));
//            }


            String sql = "select * from jdbc_user where loginTime>? and loginTime<? order by loginTime";
            stmt = conn.prepareStatement(sql);
            long start = Convert("2018-10-8 00:00:00");
            long end = Convert("2018-10-9 00:00:00");
            stmt.setObject(1,new Date(start));
            stmt.setObject(2,new Date(end));
            rs = stmt.executeQuery();
            //处理结果集
            while (rs.next()){
                System.out.println(rs.getInt("id") + "---" + rs.getDate("loginTime"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           try{
               if(rs!=null){
                   rs.close();
               }
           }catch (SQLException e) {
               e.printStackTrace();
           }

            try{
                if(stmt!=null){
                    rs.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                if(conn!=null){
                    rs.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Author ljs
     * Description 字符串日期转换为long型
     * Date 2018/10/9 21:45
     **/
    public static long Convert(String date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

