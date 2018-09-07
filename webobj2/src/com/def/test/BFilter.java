package com.def.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-29-14:32
 */
@WebFilter(filterName = "AFilter")
public class BFilter implements Filter {
    //销毁之前执行，在服务器关闭时销毁
    public void destroy() {
        System.out.println("B END");
    }

    //每次过滤都会执行
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("B 拦截");
        //放行，相当于调用了目标资源的service()方法
        chain.doFilter(req, resp);
    }

    //创建之后马上执行，Filter会在服务器启动时创建
    public void init(FilterConfig config) throws ServletException {
        System.out.println("B START");
    }

}
