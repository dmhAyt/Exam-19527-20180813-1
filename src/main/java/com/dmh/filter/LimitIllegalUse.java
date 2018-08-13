/**
 * Copyright (C), 2015-2018,
 * FileName: LimitIllegalUse
 * Author:   deng_yt
 * Date:     2018/8/13 16:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.filter;


import com.dmh.dao.CustomerTable;
import com.dmh.dao.impl.CustomerTableImpl;
import com.dmh.entity.Customer;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
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
@WebFilter(urlPatterns = "/*")
public class LimitIllegalUse implements Filter {

  private static String login = "login.jsp";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    String str = req.getServletPath();
    String[] strs = str.split("/");
    if(strs[strs.length - 1]==null||login.equals(strs[strs.length - 1])){
      chain.doFilter(request,response);
    } else if (!login.equals(strs[strs.length - 1])&&strs[strs.length - 1]!=null) {
      Cookie[] cookies = req.getCookies();
      boolean b = false;
      if (cookies != null) {
        for (Cookie co : cookies) {
          if ("exam_web".equals(co.getName())) {
            String value = co.getValue();
            CustomerTable ct = new CustomerTableImpl();
            try {
              Customer customerById = ct.findCustomerById(Integer.parseInt(value));
              if (customerById != null) {
                b = true;
                break;
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }
      }
      if (b) {
        chain.doFilter(request, response);
      } else {
        resp.sendRedirect("login.jsp");
      }
    }
  }
  @Override
  public void destroy() {
  }
}
