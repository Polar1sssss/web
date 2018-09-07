package com.web.domain;

/**
 * @author hujtb
 * @create on 2018-08-16-17:06
 * 必须要为成员提供get/set方法，必须要有默认构造器（无参的）
 * 就算一个属性没有对应的成员变量，只有get/set方法也是可以的
 * 属性名称就是get/set方法去掉get/set后，再把首字母小写
 */
public class Person {
    private String name;
    private int age;
    private boolean bool;

    public boolean isBool(){
        return bool;
    }

    public String getId(){
        return "asdfasdf";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", bool=" + bool + '}';
    }
}
