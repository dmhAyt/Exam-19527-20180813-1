package com.dmh.test;

import com.dmh.dao.LanguageTable;
import com.dmh.dao.impl.LanguageTableImpl;

/**
 * Created by deng_yt on 2018/8/13.
 */
public class LanguageTableImplTest  {

  public static void main(String[] args) {
    LanguageTable languageTable = new LanguageTableImpl();
    System.out.println(languageTable.getLanguageById(1).toString());
  }

}