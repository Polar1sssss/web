package com.abc.common;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * @author hujtb
 * @create on 2018-08-15-17:00
 */
public class CommonUtils {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
    public static <T> T toBean(Map map, Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
