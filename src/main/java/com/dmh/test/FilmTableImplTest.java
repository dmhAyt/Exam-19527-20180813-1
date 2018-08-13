package com.dmh.test;


import com.dmh.dao.FilmTable;
import com.dmh.dao.impl.FilmTableImpl;
import com.dmh.entity.Film;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Created by deng_yt on 2018/8/13.
 */
public class FilmTableImplTest {

  public static void main(String[] args) {
    Film film = new Film();
    film.setFilm_id(2);
    film.setLanguage_id(1);
    film.setTitle("侠盗猎车手");
    film.setDescription("超级炫酷");
    film.setLast_update(new Date());
    FilmTable ft = new FilmTableImpl();
    List<Film> filmAll = ft.findFilmAll();
    System.out.println(filmAll.toString());
//  ft.addFilm(film);
//    ft.updateFilm(film);
//    ft.delete(2);
//    Film filmById = ft.findFilmById(3);
//    System.out.println(filmById.toString());


  }


}