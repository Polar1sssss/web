<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/17
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="com.web.domain.*" pageEncoding="UTF-8" %>
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
    <%
        Address addr = new Address();
        addr.setSttreet("aaa");
        addr.setDoorNum("333");

        Employee emp = new Employee();
        emp.setAddr(addr);
        emp.setCity("beijing");
        emp.setSalary(10000.00);

        request.setAttribute("emp", emp);
    %>
    ${emp.addr.sttreet}
</body>
</html>
