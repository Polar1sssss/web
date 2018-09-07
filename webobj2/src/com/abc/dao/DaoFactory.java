package com.abc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取UserDao实现类的工厂
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
     * 返回一个具体的UserDao实例对象
     * @return
     */
    public static UserDao getUserDao(){
        /**
         * 给出一个配置文件，文件中的UserDao接口的实现类的名称；
         * 获取实现类的类名，通过反射创建对象
         */
        try{
            Class clazz = Class.forName(prop.getProperty("com.abc.dao.UserDao"));
            return (UserDao) clazz.newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
