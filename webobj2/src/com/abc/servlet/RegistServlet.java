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
import java.util.HashMap;
import java.util.Map;

/**
 * @author hujtb
 * @create on 2018-08-20-14:13
 */
@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        UserService us1 = new UserService();
        //封装表单数据
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        Map<String, String> map = new HashMap<String, String>();
        String name = form.getName();
        String password = form.getPassword();
        if(name == null || name.trim().isEmpty()){
            map.put("name","用户名不能为空");
        }else if(name.length() > 15 || name.length() < 3){
            map.put("name", "用户名长度应在3~15之间");
        }
        if(password == null || password.trim().isEmpty()){
            map.put("password","密码不能为空");
        }else if(name.length() > 15 || name.length() < 3){
            map.put("name", "密码长度应在3~15之间");
        }
        if(map != null && map.size() > 0){
            request.setAttribute("error", map);
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
            return;
        }

        try {
            us1.regist(form);
            response.getWriter().print("<h1>注册成功!!!</h1><br/><a href='" +
                    request.getContextPath() + "/user/login.jsp'>点击这里登录</a>");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
        }
    }
}
