<%@ page import="com.dmh.dao.FilmTable" %>
<%@ page import="com.dmh.dao.impl.FilmTableImpl" %>
<%@ page import="com.dmh.entity.Film" %><%--
  Created by IntelliJ IDEA.
  User: deng_yt
  Date: 2018/8/13
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>alter Film</title>
    <style>
        div {
            width: 600px;
            height: 580px;
            margin: 50px auto;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div>
    <% String id = request.getParameter("id");
        if (id.length() != 0) {
            FilmTable ft = new FilmTableImpl();
            Film filmById = ft.findFilmById(Integer.parseInt(id));
            if (filmById != null) {
    %>
    <form action="/alterFilm" method="post">
        <input type="hidden" name="id" value="<%=filmById.getFilm_id()%>">
        <p>标题：<input type="text" name="title" value="<%=filmById.getTitle()%>"></p>
        <p>描述：<textarea name="description"><%=filmById.getDescription()%></textarea></p>
        <p>语言：<select name="language" id="language">
            <option disabled="disabled">选择语言</option>
            <option id="1" <% if (filmById.getLanguage_id()
                    == 1) {%><%="selected='selected'"%><%}%> >English
            </option>
            <option id="2" <% if (filmById.getLanguage_id()
                    == 2) {%><%="selected='selected'"%><%}%> >Italian
            </option>
            <option id="3" <% if (filmById.getLanguage_id()
                    == 3) {%><%="selected='selected'"%><%}%> >Japanese
            </option>
            <option id="4" <% if (filmById.getLanguage_id()
                    == 4) {%><%="selected='selected'"%><%}%> >Mandarin
            </option>
            <option id="5" <% if (filmById.getLanguage_id()
                    == 5) {%><%="selected='selected'"%><%}%> >French
            </option>
            <option id="6" <% if (filmById.getLanguage_id()
                    == 6) {%><%="selected='selected'"%><%}%> >German
            </option>
        </select></p>
        <input type="submit">
    </form>
    <%} else {%>
    <%="不存在该ID"%>
    <%
        }
    } else {
    %><%="输入有误"%><%}%>
</div>
</body>
</html>
