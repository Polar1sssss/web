package com.abc.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * DDL：对表结构的增删改
 * DML：对表记录的增删改
 * DQL：对表记录的查询
 * DCL：用户创建及授权
 * @author hujtb
 * @create on 2018-08-21-17:16
 */
public class JdbcDemo {
    /**
     * 增删改
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void func1() throws ClassNotFoundException, SQLException {
        //com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        //DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver");//加载驱动类
        //使用url、用户名、密码获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiibai", "root", "123");
        //System.out.println(conn);
        //通过Connection创建statement
        Statement stmt = conn.createStatement();
        String insertSql = "INSERT INTO USER(ID, NAME, DEPT, WEBSITE, PHONE) " +
                "VALUES(2, 'zhangsan', 'aa', 'baidu', '123423')";
        String updateSql = "UPDATE USER SET NAME = 'lisi' WHERE ID = 2";
        int count = stmt.executeUpdate(insertSql);
        System.out.println(count);
    }

    /**
     * 查询
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void func2() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");//加载驱动类
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiibai", "root", "123");
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM USER";
        ResultSet rs = stat.executeQuery(sql);
        //获取元素据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取结果集列数
        int count = rsmd.getColumnCount();
        //获取表中所有数据
        while(rs.next()){
            for(int i = 1; i <= count; i++){
                System.out.print(rs.getString(i));
                if(i < count){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        rs.close();
        stat.close();
        conn.close();
    }

    /**
     * jdbc规范化
     */
    //@Test
    public void func3(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            String driverCLassname = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/yiibai";
            String username = "root";
            String pwd = "123";
            Class.forName(driverCLassname);
            conn = DriverManager.getConnection(url, username, pwd);
            stat = conn.createStatement();
            String sql = "SELECT * from USER";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String website = rs.getString("website");
                System.out.println("name:" + name + ", website:" + website);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(rs != null) rs.close();
                if(stat != null) stat.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
