package com.def.test;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * ��֪����
 * �ۻ���User����session�ۻ�������
 * ���User����session����ڴ�
 * @author hujtb
 * @create on 2018-08-29-10:59
 */
public class User implements HttpSessionActivationListener, Serializable {
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("�ۻ�");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("�");
    }
}
