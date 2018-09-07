package com.def.test;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 感知监听
 * 钝化：User随着session钝化到磁盘
 * 活化：User随着session活化到内存
 * @author hujtb
 * @create on 2018-08-29-10:59
 */
public class User implements HttpSessionActivationListener, Serializable {
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("活化");
    }
}
