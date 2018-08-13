/**
 * Copyright (C), 2015-2018,
 * FileName: Film
 * Author:   deng_yt
 * Date:     2018/8/13 10:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.entity;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class Film {
  private Integer film_id;
  private String title;
  private String description;
  private Integer language_id;
  private String language;
  private Date last_update;

  public Integer getFilm_id() {
    return film_id;
  }

  public void setFilm_id(Integer film_id) {
    this.film_id = film_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getLanguage_id() {
    return language_id;
  }

  public void setLanguage_id(Integer language_id) {
    this.language_id = language_id;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Date getLast_update() {
    return last_update;
  }

  public void setLast_update(Date last_update) {
    this.last_update = last_update;
  }

  @Override
  public String toString() {
    return "Film{" +
        "film_id=" + film_id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", language_id=" + language_id +
        ", language='" + language + '\'' +
        ", last_update=" + last_update +
        '}';
  }
}
