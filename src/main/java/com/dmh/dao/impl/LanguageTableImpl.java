/**
 * Copyright (C), 2015-2018,
 * FileName: LanguageTableImpl
 * Author:   deng_yt
 * Date:     2018/8/13 12:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao.impl;

import com.dmh.dao.JDBCConnect;
import com.dmh.dao.LanguageTable;
import com.dmh.entity.Customer;
import com.dmh.entity.Language;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class LanguageTableImpl implements LanguageTable {

  @Override
  public Language getLanguageById(Integer id) {
    Language lan = new Language();
    String sql = "select language_id,name from language where language_id = ?";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet == null) {
        lan = null;
      } else {
        while (resultSet.next()){
          lan.setLanguage_id(resultSet.getInt("language_id"));
          lan.setLanguage(resultSet.getString("name"));
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
    return lan;
  }

  @Override
  public Integer getLanguageIdByName(String name) {
    Integer i = -1;
    String sql = "select language_id from language where name = ?";
    JDBCConnect jc = new JDBCConnect();
    try {
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet == null) {
        i = -1;
      } else {
        while (resultSet.next()){
         i =resultSet.getInt("language_id");
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
    return i;
  }
}
