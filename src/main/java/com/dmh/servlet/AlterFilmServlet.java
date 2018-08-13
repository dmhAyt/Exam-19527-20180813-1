/**
 * Copyright (C), 2015-2018,
 * FileName: AlterFilmServlet
 * Author:   deng_yt
 * Date:     2018/8/13 15:57
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
@WebServlet(urlPatterns = "/alterFilm")
public class AlterFilmServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    boolean b = true;
    String result = null;
    String id = req.getParameter("id");
    String title = req.getParameter("title");
    String description = req.getParameter("description");
    String language = req.getParameter("language");
    if(id.length()!=0&&title.length()!=0&&description.length()!=0&&language.length()!=0){
      // 查询 id 对应的值是否存在
      FilmTable ft = new FilmTableImpl();
      Film filmById = ft.findFilmById(Integer.parseInt(id));
      if(filmById!=null){
      // 判断是否有该语言
        LanguageTable lt = new LanguageTableImpl();
        Integer languageIdByName = lt.getLanguageIdByName(language);
        if(languageIdByName!=-1){
          // 可以
          try{
            Film film = new Film();
            film.setLanguage_id(languageIdByName);
            film.setLast_update(new Date());
            film.setFilm_id(Integer.parseInt(id));
            film.setTitle(title);
            film.setDescription(description);
            ft.updateFilm(film);
            b = false;
          }catch (Exception e){
            b = true;
            result = "修改失败";
          }
        }else{
          b = true;
          result = "不存在该语言！";
        }
      }else{
        b = true;
        result = "不存在该电影信息！";
      }
      if(b){
        OutputStream outputStream = resp.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        osw.write(result);
        osw.close();
        outputStream.close();
      }else{
        resp.sendRedirect("showFilm.jsp");
      }

    }else{
      result = "输入有误！";
    }


  }
}
