package com.ljs.testjdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author ljs
 * @Description 封装JDBC
 * @Date 2018/10/10 17:26
 **/
public class JDBCUtil {

    static Properties properties;

    //确保在加载JDBCUtil类的时候只加载一次
    static {
        properties = new Properties();
        try {
            //读取bin下的db文件
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Author ljs
     * Description 封装jdbc连接
     * Date 2018/10/10 17:35
     **/
    public static Connection getConnection() {
        try {
            Class.forName(properties.getProperty("driver"));
            Connection conn = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("root"), properties.getProperty("pwd"));
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Author ljs
     * Description 封装流关闭
     * Date 2018/10/10 17:39
     **/
    public static void close(ResultSet rs, Connection conn, PreparedStatement stmt) {
        try{
            if(rs!=null){
                rs.close();
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

        try{
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(Connection conn, PreparedStatement stmt) {
        try{
            if(stmt!=null){
                stmt.close();
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

    public static void close(Connection conn) {
        try{
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
