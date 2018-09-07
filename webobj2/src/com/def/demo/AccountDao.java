package com.def.demo;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hujtb
 * @create on 2018-08-23-16:51
 */
public class AccountDao {
    /**
     * ÐÞ¸ÄÓà¶î
     * @param conn
     * @param name
     * @param balance
     */
    public void updateBalance(Connection conn, String name, double balance){
        PreparedStatement pstat = null;
        try{
            String sql = "update account set balance = balance + ? where name = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setDouble(1, balance);
            pstat.setString(2, name);
            pstat.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(pstat != null){
                    pstat.close();
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
