/**
 * Copyright (C), 2015-2018,
 * FileName: SetCharacterEncodingFilter
 * Author:   deng_yt
 * Date:     2018/8/13 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public class SetCharacterEncodingFilter implements Filter {
  private String edcoding = null;
  private FilterConfig filterConfig = null;
  private boolean ignore = true;

  @Override
  public void destroy() {
    edcoding = null;
    filterConfig = null;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    if (ignore == true || request.getCharacterEncoding() == null) {
      String encoding = setCharacterEncoding(request);
      if (encoding != null) {
        request.setCharacterEncoding(encoding);

      }
    }
    filterChain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    this.edcoding = filterConfig.getInitParameter("encoding");
    String value = filterConfig.getInitParameter("ignore");
    if (value == null) {
      this.ignore = true;
    } else if (value.equalsIgnoreCase("true")) {
      this.ignore = true;

    } else {
      this.ignore = false;
    }

  }

  public String setCharacterEncoding(ServletRequest request) {
    return this.edcoding;
  }
}