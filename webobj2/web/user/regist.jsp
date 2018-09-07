<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/20
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">

    <title>registPage</title>

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
    <p style="color:yellow">${msg}</p>

    <form action="${pageContext.request.contextPath}/RegistServlet" method="post">
        用户名：<input type="text" name="name" value="${user.name}"/> ${error.name} <br/>
        密码：<input type="password" name="password" value="${user.password}"/> ${error.name} <br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
