package com.abc.servlet;

import com.abc.common.CommonUtils;
import com.abc.domain.User;
import com.abc.service.UserException;
import com.abc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hujtb
 * @create on 2018-08-20-17:42
 */
@WebServlet(name = "DLServlet")
public class DLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us1 = new UserService();
        //封装对象表单数据
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        try{
            User user = us1.login(form);
            request.getSession().setAttribute("sessionUser", user);
            response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
        }catch(UserException e){
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }

    }

}
