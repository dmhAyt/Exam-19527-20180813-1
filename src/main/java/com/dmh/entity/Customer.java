/**
 * Copyright (C), 2015-2018,
 * FileName: Customer
 * Author:   deng_yt
 * Date:     2018/8/13 10:21
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
public class Customer {
  private Integer customer_id;
  private String  first_name ;

  public Integer getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(Integer customer_id) {
    this.customer_id = customer_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customer_id=" + customer_id +
        ", first_name='" + first_name + '\'' +
        '}';
  }
}
