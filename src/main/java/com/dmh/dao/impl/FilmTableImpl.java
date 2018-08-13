/**
 * Copyright (C), 2015-2018,
 * FileName: FilmTableImpl
 * Author:   deng_yt
 * Date:     2018/8/13 11:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao.impl;

import com.dmh.dao.FilmTable;
import com.dmh.dao.JDBCConnect;
import com.dmh.entity.Customer;
import com.dmh.entity.Film;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class FilmTableImpl implements FilmTable {

  @Override
  public void addFilm(Film film) {
    String sql = "insert into film (title,description,language_id,last_update)"
        + "values (?,?,?,?)";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
//      preparedStatement.setInt(1, film.getFilm_id());
      preparedStatement.setString(1, film.getTitle());
      preparedStatement.setString(2, film.getDescription());
      preparedStatement.setInt(3, film.getLanguage_id());
      preparedStatement.setDate(4, new Date(film.getLast_update().getTime()));
      int i = preparedStatement.executeUpdate();
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Film> findFilmAll() {
    List<Film> list = new ArrayList<Film>();
    String sql = "select film_id,title,description,f.language_id,name from film f,language l"
        + " where f.language_id = l.language_id ";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet == null) {
        list = null;
      } else {
        Film film = null;
        while (resultSet.next()) {
          film = new Film();
          film.setFilm_id(resultSet.getInt("film_id"));
          film.setTitle(resultSet.getString("title"));
          film.setDescription(resultSet.getString("description"));
          film.setLanguage_id(resultSet.getInt("language_id"));
          film.setLanguage(resultSet.getString("name"));
          list.add(film);
        }
      }
      if (resultSet != null) {
        resultSet.close();
      }
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public void updateFilm(Film film) {
    String sql = "update film set title=?,description=?,language_id=?,last_update=?"
        + "where film_id = ?";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, film.getTitle());
      preparedStatement.setString(2, film.getDescription());
      preparedStatement.setInt(3, film.getLanguage_id());
      preparedStatement.setDate(4, new Date(film.getLast_update().getTime()));
      preparedStatement.setInt(5, film.getFilm_id());
      int i = preparedStatement.executeUpdate();
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer filmId)throws Exception {
    String sql = "delete from film where film_id = ?";
    JDBCConnect jc = new JDBCConnect();
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1,filmId);
      int i = preparedStatement.executeUpdate();
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }

  }

  @Override
  public Film findFilmById(Integer filmId) {
    Film film =null;
    String sql = "select film_id,title,description,language_id from film where  film_id = ?";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, filmId);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet == null) {
        film = null;
      } else {
        while (resultSet.next()){
          film = new Film();
          film.setFilm_id(resultSet.getInt("film_id"));
          film.setTitle(resultSet.getString("title"));
          film.setDescription(resultSet.getString("description"));
          film.setLanguage_id(resultSet.getInt("language_id"));
        }
      }
      if(resultSet!=null) {
        resultSet.close();
      }
      if(preparedStatement != null){
        preparedStatement.close();
      }
      if(connection != null){
        connection.close();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return film;
  }
}
