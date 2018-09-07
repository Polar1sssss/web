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
        //���ñ����ʽ
        request.setCharacterEncoding("utf-8");
        //������Ӧ�ı����ʽ
        response.setContentType("text/html;charset=utf-8");
        //��ȡ���ύ�Ĳ���ֵ
        String name = request.getParameter("username");

        if(!"itcast".equalsIgnoreCase(name)){
            request.setAttribute("flag", "success");

            //�õ�session���󣬲�����������name����
            //����servlet�����request��session��application��ServletContext��
            HttpSession session = request.getSession();
            session.setAttribute("name", name);

            Cookie cookie = new Cookie("uname", name);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

            //�ض��򵽳ɹ�ҳ��
            response.sendRedirect("/webobj1/session/succ.jsp");
        }else{
            request.setAttribute("msg", "�û������������");
            //ת������¼ҳ��
            request.getRequestDispatcher("/session/login.jsp").forward(request, response);
        }

    }

}
