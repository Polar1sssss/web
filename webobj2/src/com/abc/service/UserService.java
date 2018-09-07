package com.abc.service;

import com.abc.dao.DaoFactory;
import com.abc.dao.UserDao;
import com.abc.domain.User;

/**
 * @author hujtb
 * @create on 2018-08-20-10:48
 */
public class UserService {

    //把具体实现类的创建隐藏到工厂
    UserDao ud1 = DaoFactory.getUserDao();

    /**
     * 注册
     * @param user
     * @throws UserException
     */
    public void regist(User user) throws UserException{
        User _user = ud1.findByUsername(user.getName());
        if(_user != null) throw new UserException("用户名" + user.getName() + "已经被注册");
        ud1.addUser(user);
    }

    /**
     * 登录
     * @param form
     * @return
     * @throws UserException
     */
    public User login(User form) throws UserException{
        String name = form.getName();
        String password = form.getPassword();

        User _user =  ud1.findByUsername(name);
        if(_user == null) throw new UserException("用户名不存在");

        String _password = _user.getPassword();
        if(!password.equals( _password)){
            throw new UserException("密码错误");
        }
        return _user;
    }
}
