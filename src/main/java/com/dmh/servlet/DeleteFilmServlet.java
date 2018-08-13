/**
 * Copyright (C), 2015-2018,
 * FileName: DeleteFilmServlet
 * Author:   deng_yt
 * Date:     2018/8/13 15:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.servlet;

import com.dmh.dao.FilmTable;
import com.dmh.dao.impl.FilmTableImpl;
import com.dmh.entity.Film;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
@WebServlet(urlPatterns = "/deleteFilm")
public class DeleteFilmServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String result = null;
    boolean b = true;
    String id = req.getParameter("id");
    if (id.length() != 0) {
      FilmTable ft = new FilmTableImpl();
      // 是否存在该id
      Film filmById = ft.findFilmById(Integer.parseInt(id));
      if (filmById != null) {
        // 可以删除
        try {
          ft.delete(Integer.parseInt(id));
          b = false;
        } catch (Exception e) {
          e.printStackTrace();
          b = true;
          // 删除失败
          result = "删除失败！";
        }
      } else {
        b = true;
        result = "没有对应的id！";
      }
      if (b) {
        OutputStream outputStream = resp.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        osw.write(result);
        osw.close();
        outputStream.close();
      } else {
        resp.sendRedirect("showFilm.jsp");
      }
    }else{
    resp.sendRedirect("showFilm.jsp");
    }
  }
}
