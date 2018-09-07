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
        //��װ������
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        Map<String, String> map = new HashMap<String, String>();
        String name = form.getName();
        String password = form.getPassword();
        if(name == null || name.trim().isEmpty()){
            map.put("name","�û�������Ϊ��");
        }else if(name.length() > 15 || name.length() < 3){
            map.put("name", "�û�������Ӧ��3~15֮��");
        }
        if(password == null || password.trim().isEmpty()){
            map.put("password","���벻��Ϊ��");
        }else if(name.length() > 15 || name.length() < 3){
            map.put("name", "���볤��Ӧ��3~15֮��");
        }
        if(map != null && map.size() > 0){
            request.setAttribute("error", map);
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
            return;
        }

        try {
            us1.regist(form);
            response.getWriter().print("<h1>ע��ɹ�!!!</h1><br/><a href='" +
                    request.getContextPath() + "/user/login.jsp'>��������¼</a>");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
        }
    }
}
