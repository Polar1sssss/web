package com.abc.jdbc;

import com.abc.common.JdbcUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @author hujtb
 * @create on 2018-08-21-18:21
 */
public class JdbcDemo2{
    public boolean login(String username, String pwd){
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try{
            String className = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/yiibai";
            String name = "root";
            String password = "123";
            Class.forName(className);
            conn = DriverManager.getConnection(url, name, password);
            String sql = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PWD = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, username);
            pstat.setString(2, pwd);

            rs = pstat.executeQuery();
            return rs.next();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(rs != null) rs.close();
                if(pstat != null) pstat.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void func1(){
        String username = "zhangsan";
        String pwd = "1234";
        System.out.println(login(username, pwd));
    }

    @Test
    public void func2() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }
}
