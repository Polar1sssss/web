<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/15
  Time: 17:38
  重写url方法获取session对象
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

    <title>Title</title>

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
    <!--把页面中的所有路径用response.encodeURL(".."),即可将sessionid当作参数传递给服务器-->
    <a href="/webobj1/AServlet";JSESSIONID=<%=session.getId()%>>点击这里</a>
    <%
        response.encodeURL("/webobj1/AServlet");//会去找cookie，如果没有找到，会在url中加入jsessionid参数
    %>
</body>
</html>
