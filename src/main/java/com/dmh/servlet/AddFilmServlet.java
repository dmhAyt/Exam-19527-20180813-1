/**
 * Copyright (C), 2015-2018,
 * FileName: AddFilmServlet
 * Author:   deng_yt
 * Date:     2018/8/13 13:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.servlet;

import com.dmh.dao.FilmTable;
import com.dmh.dao.LanguageTable;
import com.dmh.dao.impl.FilmTableImpl;
import com.dmh.dao.impl.LanguageTableImpl;
import com.dmh.entity.Film;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
@WebServlet(urlPatterns = "/addFilm")
public class AddFilmServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    boolean b = true;
    String message = null;
    System.out.println(req.getCharacterEncoding());

    // 获得提交的数据
    String title = new String(req.getParameter("title"));
    String description = req.getParameter("description");
    String language = req.getParameter("language");
    if(title.length()!=0&&description.length()!=0&&language.length()!=0) {
      System.out.println(title + " " + description + " " + language);
      Film film = new Film();
      film.setLanguage(language);
      film.setTitle(title);
      film.setDescription(description);
      // 查询出语言的id
      LanguageTable lt = new LanguageTableImpl();
      Integer index = lt.getLanguageIdByName(language);
      if(index!=-1) {
        film.setLanguage_id(index);
        film.setLast_update(new Date());
        // 进行插入数据库
        FilmTable ft = new FilmTableImpl();
        System.out.println(film.toString()+"  ========================");
        try{
            ft.addFilm(film);
            b = false;
        }catch (Exception e){
          e.printStackTrace();
            // 插入失败
          b = true;
          message = "新增失败！";
        }
      }else {
        // 没有这种语言
        message = "没有这种语言！";
      }
      if(b){
        System.out.println("ksjfas;kljfasljf;l");
        getServletContext().setAttribute("message",message);
        resp.sendRedirect("addFilm.jsp");
      }else{
        resp.sendRedirect("showFilm.jsp");
      }
    }else{

    resp.sendRedirect("addFilm.jsp");
    }
  }
}
