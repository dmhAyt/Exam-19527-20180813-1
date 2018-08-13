<%@ page import="com.dmh.entity.Customer" %>
<%@ page import="com.dmh.dao.CustomerTable" %>
<%@ page import="com.dmh.dao.impl.CustomerTableImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>index</title>
    <meta charset="UTF-8">
    <style>
        div{
            width: 500px;
            height: 480px;
            margin: 50px auto;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div>
    <% Customer cu = (Customer) application.getAttribute("name");
    if(cu == null){
      Cookie[] cookies = request.getCookies();
        for (Cookie co : cookies) {
            if ("exam_web".equals(co.getName())) {
                String value = co.getValue();
                CustomerTable ct = new CustomerTableImpl();
                try {
                   cu = ct.findCustomerById(Integer.parseInt(value));
                    if (cu != null) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    %>
    <p> 欢迎：<%= cu.getFirst_name()%></p>
    <p><a href="login.jsp">登录</a></p>
    <p><a href="addFilm.jsp">添加</a></p>
    <p><a href="showFilm.jsp">显示电影</a></p>
</div>
</body>
</html>
