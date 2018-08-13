/**
 * Copyright (C), 2015-2018,
 * FileName: LanguageTable
 * Author:   deng_yt
 * Date:     2018/8/13 10:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.entity;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class Language {
  private Integer language_id;
  private String  language;

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

  @Override
  public String toString() {
    return "LanguageTable{" +
        "language_id=" + language_id +
        ", language='" + language + '\'' +
        '}';
  }
}
