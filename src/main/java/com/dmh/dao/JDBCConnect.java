/**
 * Copyright (C), 2015-2018,
 * FileName: JDBCConnect
 * Author:   deng_yt
 * Date:     2018/8/13 9:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class JDBCConnect {

  private Connection conn = null;

  public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
    Properties info = new Properties();
    info.load(JDBCConnect.class.getClassLoader().getResourceAsStream("db.properties"));
    Class.forName(info.getProperty("jdbc.driver"));
    conn = (Connection) DriverManager
        .getConnection(info.getProperty("jdbc.url"), info.getProperty("jdbc.username"),
            info.getProperty("jdbc.password"));
    return conn;
  }
}
