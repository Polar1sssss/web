package com.abc.dao;

import com.abc.common.JdbcUtils;
import com.abc.domain.User;

import java.sql.*;

/**
 * @author hujtb
 * @create on 2018-08-23-10:15
 */
public class JdbcUserDaoImpl implements UserDao{

    @Override
    public User findByUsername(String name) {
        Connection conn = null;
        PreparedStatement pstat = null;
        conn = JdbcUtils.getConnection();
        String sql = "SELECT * FROM LOGIN WHERE USERNAME = ?";

        try{
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, name);
            ResultSet resultSet = pstat.executeQuery();

            if(resultSet.next()){
                User user = new User();
                user.setPassword(resultSet.getString("pwd"));
                user.setName(resultSet.getString("username"));
                return user;
            }else {
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(pstat != null)  {
                    pstat.close();
                }
                if(conn != null)  {
                    conn.close();
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement pstat = null;
        conn = JdbcUtils.getConnection();
        String sql = "INSERT INTO LOGIN(USERNAME, PWD) VALUES(?, ?)";
        try{
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getPassword());
            int count = pstat.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(pstat != null)  {
                    pstat.close();
                }
                if(conn != null)  {
                    conn.close();
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
