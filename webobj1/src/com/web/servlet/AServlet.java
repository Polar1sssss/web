package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 单例，不是线程安全的
 * @author hujtb
 * @create on 2018-08-07-14:06
 */
public class AServlet implements Servlet {

    /**
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()....");
        System.out.println("初始化参数P1对应的值:" + servletConfig.getInitParameter("p1") + "\n"
                +"servlet的名字：" + servletConfig.getServletName() + "\n");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()....");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()....");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()....");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()....");
    }
}
