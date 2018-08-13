/**
 * Copyright (C), 2015-2018,
 * FileName: CustomerTable
 * Author:   deng_yt
 * Date:     2018/8/13 10:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao;

import com.dmh.entity.Customer;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface CustomerTable {
  Customer findCustomerByFirstName(String firstName) throws Exception;
  Customer findCustomerById(Integer id) throws Exception;

}
