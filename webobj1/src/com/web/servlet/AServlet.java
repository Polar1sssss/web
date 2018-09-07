package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * �����������̰߳�ȫ��
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
        System.out.println("��ʼ������P1��Ӧ��ֵ:" + servletConfig.getInitParameter("p1") + "\n"
                +"servlet�����֣�" + servletConfig.getServletName() + "\n");
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
