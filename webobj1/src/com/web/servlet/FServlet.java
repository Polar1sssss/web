package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-09-10:59
 */
public class FServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FServlet");
        String s = "hello";
        byte[] bs = s.getBytes();
        resp.getOutputStream().write(bs);
        System.out.println(req.getRemoteAddr());

        /*String path = "D://baidu.jpg";
        FileInputStream fis = new FileInputStream(path);
        byte[] bs1 = IOUtils.toByteArray(fis);
        resp.getOutputStream().write(bs1);*/
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
