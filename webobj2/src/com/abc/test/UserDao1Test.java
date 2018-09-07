package com.abc.test;

import com.abc.dao.DaoFactory;
import com.abc.dao.UserDao;
import com.abc.domain.User;
import org.junit.Test;

/**
 * UserDao1≤‚ ‘¿‡
 * @author hujtb
 * @create on 2018-08-20-12:08
 */
public class UserDao1Test {
    @Test
    public void testFind(){
        UserDao ud = DaoFactory.getUserDao();
        User user = ud.findByUsername("zhangsan");
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        User user1 = new User();
        UserDao ud1 = DaoFactory.getUserDao();
        user1.setName("wangwu");
        user1.setPassword("789");
        ud1.addUser(user1);
    }
}
