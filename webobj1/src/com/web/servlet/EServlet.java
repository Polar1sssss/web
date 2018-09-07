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
 * �ض���
 */
public class EServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EServlet");
        //������Ӧͷ���ض���FServlet
        resp.setHeader("Location", "/webobj1/FServlet");
        resp.setStatus(302);

        //�Զ�ˢ��
        PrintWriter pw = resp.getWriter();
        pw.print("��ӭ��½��5����Զ���ת������");
        resp.setHeader("Refresh", "5;URL=/webobj1/FServlet");

        //�������������
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("pragma", "no-cache");
        resp.setDateHeader("expires",-1);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
