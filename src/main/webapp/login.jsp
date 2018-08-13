<%--
  Created by IntelliJ IDEA.
  User: deng_yt
  Date: 2018/8/13
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <style>
        div{
            background-color: #f0f0f0;
            width: 200px;
            height: 100px;
            margin: 200px auto;
        }
        .input{
            width: 200px;
            height: 28px;
            line-height: 24px;
            font-size: 14px;
            padding: 2px 5px;
            text-align: left;
            border-radius: 3px;
            margin:  5px 0px;
        }
        .submit{
            width: 100px;
            height: 28px;
            line-height: 24px;
            font-size: 14px;
            padding: 2px 5px;
            text-align: center;
            border-radius: 3px;
            margin-left: 40px;
            margin-top:10px;
        }
    </style>
</head>
<body>
<div>
<form method="post" action="/login">
    <input class="input" name="name" type="text" placeholder="请输入用户"><br/>
    <input class="submit" name="submit" type="submit" value="登录">
</form>
<p><% String message = (String) application.getAttribute("message");
    if (message != null) {
%>
    <%= message%>
    <%
        }
    %>
</p>
</div>
</body>
</html>
