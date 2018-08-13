/**
 * Copyright (C), 2015-2018,
 * FileName: FilmTable
 * Author:   deng_yt
 * Date:     2018/8/13 10:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao;

import com.dmh.entity.Film;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface FilmTable {
  void addFilm(Film film);
  List<Film> findFilmAll();
  void updateFilm(Film film);
  void delete(Integer filmId) throws Exception;
  Film findFilmById(Integer filmId);
}
