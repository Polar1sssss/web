<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/17
  Time: 11:41
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

    <title>Param</title>

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
    <!--http://localhost:8080/webobj1/el/param.jsp?username=sdfasf&gender=1 -->
    ${param.username}
    <hr/>
    <!--写项目名要用这种动态的方式-->
    <a href="${pageContext.request.contextPath}/el/a.jsp">点击这里</a>
    <form action="${pageContext.request.contextPath}/AServlet" method="post">
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
