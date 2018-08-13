/**
 * Copyright (C), 2015-2018,
 * FileName: CustomerTableImpl
 * Author:   deng_yt
 * Date:     2018/8/13 10:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao.impl;

import com.dmh.dao.CustomerTable;
import com.dmh.dao.JDBCConnect;
import com.dmh.entity.Customer;
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
public class CustomerTableImpl implements CustomerTable {

  @Override
  public Customer findCustomerByFirstName(String firstName)throws Exception{
    Customer customer =null;
    String sql = "select customer_id,first_name from customer where first_name = ?";
    JDBCConnect jc = new JDBCConnect();
      Connection connection = jc.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, firstName);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet == null) {
        customer = null;
      } else {
        while (resultSet.next()){
          customer =  new Customer();
          customer.setCustomer_id(resultSet.getInt("customer_id"));
          customer.setFirst_name(resultSet.getString("first_name"));
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

    return customer;
  }

  @Override
  public Customer findCustomerById(Integer id) throws Exception {
    Customer customer =null;
    String sql = "select customer_id,first_name from customer where customer_id = ?";
    JDBCConnect jc = new JDBCConnect();
    Connection connection = jc.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    if (resultSet == null) {
      customer = null;
    } else {
      while (resultSet.next()){
        customer =  new Customer();
        customer.setCustomer_id(resultSet.getInt("customer_id"));
        customer.setFirst_name(resultSet.getString("first_name"));
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
    return customer;
  }
}
