package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hujtb
 * @create on 2018-08-09-10:55
 * 重定向
 */
public class EServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EServlet");
        //设置响应头，重定向到FServlet
        resp.setHeader("Location", "/webobj1/FServlet");
        resp.setStatus(302);

        //自动刷新
        PrintWriter pw = resp.getWriter();
        pw.print("欢迎登陆，5秒后自动跳转。。。");
        resp.setHeader("Refresh", "5;URL=/webobj1/FServlet");

        //禁用浏览器缓存
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("pragma", "no-cache");
        resp.setDateHeader("expires",-1);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
