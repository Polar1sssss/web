package com.abc.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hujtb
 * @create on 2018-08-22-14:32
 */
public class JdbcUtils {
    private static Properties prop = null;

    static{
        //��prop���г�ʼ���������������ļ���prop������
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop = new Properties();
            prop.load(in);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        //����������
        try{
            Class.forName(prop.getProperty("driverClassName"));
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try{
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            return DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
