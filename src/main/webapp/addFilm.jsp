<%--
  Created by IntelliJ IDEA.
  User: deng_yt
  Date: 2018/8/13
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>添加电影</title>
    <meta name="content-type" content="text/html; charset=UTF-8">
    <style>
        div{
            width: 600px;
            height: 580px;
            margin: 50px auto;
            border-radius: 5px;
        }
        input,select,textarea{
            margin-top: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div>
    <form action="/addFilm" method="post">
        <input type="text" name="title" placeholder="标题"><br/>
        <textarea name="description" placeholder="描述"></textarea><br/>
        <select name="language" id="languagu">
            <option selected="selected" disabled="disabled">选择语言</option>
            <option id="1">English</option>
            <option id="2">Italian</option>
            <option id="3">Japanese</option>
            <option id="4">Mandarin</option>
            <option id="5">French</option>
            <option id="6">German</option>
        </select><br/>
        <input type="submit" name="submit">
    </form>
    <p><% String message = (String) application.getAttribute("message");
        if (message != null) {
    %>
        <%= message%>
        <%}%>
    </p>
</div>
</body>
</html>
