/**
 * Copyright (C), 2015-2018,
 * FileName: LoginServlet
 * Author:   deng_yt
 * Date:     2018/8/13 12:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.servlet;

import com.dmh.dao.CustomerTable;
import com.dmh.dao.impl.CustomerTableImpl;
import com.dmh.entity.Customer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 获得提交的名字
    String name = req.getParameter("name");
    // 调用 dao 层，然后进行数据判断
    CustomerTable ct = new CustomerTableImpl();
    Customer customerByFirstName = null;
    try {
      customerByFirstName = ct.findCustomerByFirstName(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if(customerByFirstName != null){
      // 表示登录成功。
      Cookie cookie = new Cookie("exam_web",customerByFirstName.getCustomer_id().toString());
      cookie.setMaxAge(60*60);
      cookie.setHttpOnly(true);
      resp.addCookie(cookie);
      getServletContext().setAttribute("name",customerByFirstName);
      resp.sendRedirect("index.jsp");
    }else{
      getServletContext().setAttribute("message","用户名不正确");
      resp.sendRedirect("login.jsp");
    }

  }
}
