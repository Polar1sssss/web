package com.def.demo;

import com.def.common.JdbcUtils;
import com.mysql.jdbc.Connection;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author hujtb
 * @create on 2018-08-23-16:51
 */
public class Demo {
    public void zz(String from, String to, double money) throws SQLException {
        Connection conn = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            AccountDao acdao = new AccountDao();
            acdao.updateBalance(conn, from, -money);
            acdao.updateBalance(conn, to, money);
            conn.commit();
            conn.close();
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.close();
            }catch(SQLException e1){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fun1() throws SQLException {
        Demo demo = new Demo();
        demo.zz("zhangsan", "lisi", 1000);
    }
}
