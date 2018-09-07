<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/16
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%--设置错误后跳转的页面，错误页面需要设置isErrorPage属性才会出现500错误--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">

    <title>a.jsp</title>

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
    <h1>a.jsp</h1>
    <%--<%@include file="b.jsp"%>--%>
    <%--<jsp:include page="b.jsp"/>--%>
    <!--静态包含：相当于将b.jsp插入到a的jsp中，生成一个jsp文件，之后产生一个java文件，编译出一个class文件；
        动态包含：相当于requestDispatcher的include方法，两个不同的jsp文件，两个java，生成两个class文件，只是在执行的时候a.class会调用b.class
     -->
    <%request.setAttribute("request_xxx","request_xxxx");%>
    ${request_xxx}
</body>
</html>
