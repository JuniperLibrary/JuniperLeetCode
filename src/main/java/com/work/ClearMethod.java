package com.work;

import java.util.*;

/**
 * 清算类型 generate with jinja2
 */
public enum ClearMethod {
  /**
   * 净额清算
   */
  NET,
  /**
   * 全额清算
   */
  FULL,
  /**
   * 净额清算或全额清算
   */
  NET_FULL,
  ;

  public static Map<ClearMethod, String> valueMap = new HashMap<>();
  static {
    valueMap.put(NET, "净额清算");
    valueMap.put(FULL, "全额清算");
    valueMap.put(NET_FULL, "净额清算或全额清算");
  }

  public static Map<ClearMethod, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(ClearMethod value) {
    return valueMap.get(value);
  }
}