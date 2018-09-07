package com.abc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡUserDaoʵ����Ĺ���
 * @author hujtb
 * @create on 2018-08-22-17:26
 */
public class DaoFactory {
    private static Properties prop = null;
    static{
        try{
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            prop = new Properties();
            prop.load(in);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * ����һ�������UserDaoʵ������
     * @return
     */
    public static UserDao getUserDao(){
        /**
         * ����һ�������ļ����ļ��е�UserDao�ӿڵ�ʵ��������ƣ�
         * ��ȡʵ�����������ͨ�����䴴������
         */
        try{
            Class clazz = Class.forName(prop.getProperty("com.abc.dao.UserDao"));
            return (UserDao) clazz.newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
