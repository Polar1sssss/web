package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-15-11:28
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取表单提交的参数值
        String name = request.getParameter("username");

        if(!"itcast".equalsIgnoreCase(name)){
            request.setAttribute("flag", "success");

            //得到session对象，并在其中设置name属性
            //三大servlet域对象：request，session，application（ServletContext）
            HttpSession session = request.getSession();
            session.setAttribute("name", name);

            Cookie cookie = new Cookie("uname", name);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

            //重定向到成功页面
            response.sendRedirect("/webobj1/session/succ.jsp");
        }else{
            request.setAttribute("msg", "用户名或密码错误");
            //转发到登录页面
            request.getRequestDispatcher("/session/login.jsp").forward(request, response);
        }

    }

}
