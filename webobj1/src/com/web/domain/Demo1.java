package com.web.domain;

import com.web.common.CommonUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hujtb
 * @create on 2018-08-16-18:04
 */
public class Demo1 {
    @Test
    public void fun1() throws Exception {
        String className = "com.web.domain.Person";
        Class c = Class.forName(className);
        Object bean = c.newInstance();

        BeanUtils.setProperty(bean, "name", "zhangsan");
        BeanUtils.setProperty(bean, "age", "23");
        BeanUtils.setProperty(bean, "sex", "man");
    }
    @Test
    public void fun2() throws Exception {
        Person p = new Person();
        BeanUtils.setProperty(p, "name", "zhangsan");
        System.out.println(p);
    }
    @Test
    public void fun3() throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zhangsan");
        Person p = CommonUtils.toBean(map, Person.class);
        System.out.println(p);
    }
}
