<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/15
  Time: 11:19
  登录成功之后跳转到succ.jsp页面，失败则返回到login.jsp页面
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%--等同于response.setContentType("text/html;charset=utf-8")%>
<%--pageEncoding和contentType仅有一个存在，按照存在的那个的编码格式--%>
<%@ page contentType="text/html; charset=utf-8" %>



<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
    <%
        String uname = "";
        Cookie[] ck = request.getCookies();
        if(ck != null){
            for(Cookie c : ck){
                if("uname".equals(c.getName())){
                    uname = c.getValue();
                }
            }
        }
    %>
    <%
        String message = "";
        String msg = (String)request.getAttribute("msg");
        if(msg != null){
            message = msg;
        }
    %>
    <h1 style="color:red"><%=message %></h1>
    <form action="/webobj1/LoginServlet" method="post">
        姓名： <input type="text" name="username" value="<%=uname %>"><br/>
        密码： <input type="password" name="pwd"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
