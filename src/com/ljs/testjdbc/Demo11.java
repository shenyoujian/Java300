package com.ljs.testjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author ljs
 * @Description 测试Jdbc封装类
 * @Date 2018/10/10 17:40
 **/
public class Demo11 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select username from jdbc_user";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getObject("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
