package com.abc.service;

import com.abc.dao.DaoFactory;
import com.abc.dao.UserDao;
import com.abc.domain.User;

/**
 * @author hujtb
 * @create on 2018-08-20-10:48
 */
public class UserService {

    //�Ѿ���ʵ����Ĵ������ص�����
    UserDao ud1 = DaoFactory.getUserDao();

    /**
     * ע��
     * @param user
     * @throws UserException
     */
    public void regist(User user) throws UserException{
        User _user = ud1.findByUsername(user.getName());
        if(_user != null) throw new UserException("�û���" + user.getName() + "�Ѿ���ע��");
        ud1.addUser(user);
    }

    /**
     * ��¼
     * @param form
     * @return
     * @throws UserException
     */
    public User login(User form) throws UserException{
        String name = form.getName();
        String password = form.getPassword();

        User _user =  ud1.findByUsername(name);
        if(_user == null) throw new UserException("�û���������");

        String _password = _user.getPassword();
        if(!password.equals( _password)){
            throw new UserException("�������");
        }
        return _user;
    }
}
