package com.web.domain;

/**
 * @author hujtb
 * @create on 2018-08-16-17:06
 * ����ҪΪ��Ա�ṩget/set����������Ҫ��Ĭ�Ϲ��������޲εģ�
 * ����һ������û�ж�Ӧ�ĳ�Ա������ֻ��get/set����Ҳ�ǿ��Ե�
 * �������ƾ���get/set����ȥ��get/set���ٰ�����ĸСд
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
