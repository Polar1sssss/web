package com.abc.dao;

import com.abc.domain.User;

/**
 * @author hujtb
 * @create on 2018-08-22-17:19
 */
public interface UserDao {
    public User findByUsername(String name);
    public void addUser(User user);
}
