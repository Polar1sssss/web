package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-14-11:44
 */
@WebServlet(name = "FormServlet")
public class FormServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String zs1 = request.getParameter("zs1");
        String zs2 = request.getParameter("zs2");
        int num1 = Integer.parseInt(zs1);
        int num2 = Integer.parseInt(zs2);
        int num = num1 + num2;

        request.setAttribute("result", num);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
