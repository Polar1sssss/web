<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/8/30
  Time: 10:41
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

    <title>注册页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        function createXMLHttpRequest(){
            try{
                return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Maxml2.XMLHTTP");
                }catch(e){
                    try{
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    }catch(e){
                        throw e;
                    }
                }
            }
        }

        window.onload = function() {
            debugger;
            var userEle = document.getElementById("username");
            var xmlHttp = createXMLHttpRequest();
            //给用户名文本框添加失去焦点事件
            userEle.onblur = function() {
                //打开与服务器的连接
                xmlHttp.open("POST", "<c:url value='/CServlet'/>", true);
                //设置请求头
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                //发送请求
                xmlHttp.send("username=" + userEle.value);
                //当xmlHttp对象状态改变时触发
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        var text = xmlHttp.responseText;
                        var spanEle = document.getElementById("errorSpan");
                        spanEle.innerHTML = text;
                     }
                };
            };
        };
    </script>
</head>

<body>
    <br action="${pageContext.request.contextPath}" method="POST">
        用户名：<input id="username" type="text" name="usrn"/><span id="errorSpan"></span></br>
        密码：<input id="pwd" type="text" name="pwd"/></br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
