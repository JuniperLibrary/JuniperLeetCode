package com.work;

import java.util.*;

/**
 * 实时承接标识 generate with jinja2
 */
public enum RealTimeTakeOver {
  /**
   * 非实时承接
   */
  URT,
  /**
   * 实时承接
   */
  RT,
  ;

  public static Map<RealTimeTakeOver, String> valueMap = new HashMap<>();
  static {
    valueMap.put(URT, "非实时承接");
    valueMap.put(RT, "实时承接");
  }

  public static Map<RealTimeTakeOver, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(RealTimeTakeOver value) {
    return valueMap.get(value);
  }
}