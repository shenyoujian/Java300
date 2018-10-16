package com.ljs.testjdbc;

import java.io.*;
import java.sql.*;

/**
 * @Author ljs
 * @Description 测试Blob，二进制大对象使用
 * 包含：将字符串、文件内容插入数据库中的BLOB字段、将BLOB字段值取出来的操作。
 * @Date 2018/10/10 15:42
 **/
public class Demo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try{
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //执行sql
//            String sql = "insert into jdbc_user(username, img) VALUES (?,?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1,"李建生");
//            stmt.setBlob(2, new FileInputStream("f://a.jpg"));
//            stmt.execute();

            //读取blob
            String sql = "select img from jdbc_user";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Blob b = rs.getBlob("img");
                is  = b.getBinaryStream();
                os = new FileOutputStream("e://b.jpg");
                int temp = 0;
                while((temp=is.read())!=-1){
                    os.write(temp);
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
                if(is!=null){
                    is.close();
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
