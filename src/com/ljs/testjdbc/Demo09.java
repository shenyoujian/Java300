package com.ljs.testjdbc;

import java.io.*;
import java.sql.*;

/**
 * @Author ljs
 * @Description 测试Clob，文本大对象使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值取出来的操作。
 * @Date 2018/10/10 15:42
 **/
public class Demo09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reader r = null;
        try{
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //执行sql
//            String sql = "insert into jdbc_user(username, myinfo) VALUES (?,?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1,"李建生");
//            stmt.setClob(2,new FileReader(new File("e://a.txt")));
//            stmt.execute();

            //读取clob
            String sql = "select myinfo from jdbc_user";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Clob c = rs.getClob("myinfo");
                r  = c.getCharacterStream();
                int temp = 0;
                while((temp=r.read())!=-1){
                    System.out.print((char)temp);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try{
                if(r!=null){
                    r.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
