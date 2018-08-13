/**
 * Copyright (C), 2015-2018,
 * FileName: LanguageTable
 * Author:   deng_yt
 * Date:     2018/8/13 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao;

import com.dmh.entity.Language;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/13
 * @since 1.0.0
 */
public interface LanguageTable {
  Language getLanguageById(Integer id);
  Integer getLanguageIdByName(String name);
}
