<%@ page import="com.dmh.entity.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dmh.dao.FilmTable" %>
<%@ page import="com.dmh.dao.impl.FilmTableImpl" %><%--
  Created by IntelliJ IDEA.
  User: deng_yt
  Date: 2018/8/13
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示全部</title>
    <meta charset="utf-8">
    <style>
        div {
            text-align: center;
            width: 100%;
            height: auto;
            margin: 50px auto;
        }
        table {
            margin: 0 auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            height: 30px;
            line-height: 25px;
            text-align: center;
        }

        .index {
            width: 50px;
        }

        .title {
            width: 250px;
        }

        .description {
            width: 500px;
        }
    </style>
</head>
<body>
<div>
    <%
        FilmTable ft = new FilmTableImpl();
        List<Film> list = ft.findFilmAll();
        int len = list.size();
    %>
    <table>
        <th>序号</th>
        <th>film_id</th>
        <th>title</th>
        <th>description</th>
        <th>language</th>
        <th>修改</th>
        <th>删除</th>
        <% for (int i = 0; i < len; i++) { %>
        <tr>
            <td class="index"><%=(i + 1)%>
            </td>
            <td class="index"><%= list.get(i).getFilm_id()%>
            </td>
            <td class="title"><%= list.get(i).getTitle()%>
            </td>
            <td class="description"><%= list.get(i).getDescription()%>
            </td>
            <td><%= list.get(i).getLanguage()%>
            </td>
            <td class="index"><a href="<%="/alterFilm.jsp?id="+list.get(i).getFilm_id() %>">修改</a>
            </td>
            <td class="index"><a href="<%="/deleteFilm?id="+list.get(i).getFilm_id() %>">删除</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
