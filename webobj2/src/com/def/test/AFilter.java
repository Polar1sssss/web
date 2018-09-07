package com.def.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-29-14:32
 */
@WebFilter(filterName = "AFilter")
public class AFilter implements Filter {
    //����֮ǰִ�У��ڷ������ر�ʱ����
    public void destroy() {
        System.out.println("A END");
    }

    //ÿ�ι��˶���ִ��
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("A ����");
        //���У��൱�ڵ�����Ŀ����Դ��service()����
        chain.doFilter(req, resp);
    }

    //����֮������ִ�У�Filter���ڷ���������ʱ����
    public void init(FilterConfig config) throws ServletException {
        System.out.println("A START");
    }

}
