package com.work.ohlc;

import java.util.*;

/**
 * 时间模式调整类型 generate with jinja2
 */
public enum DaylightShaft {
  /**
   * 向前
   */
  FORWARD,
  /**
   * 向后
   */
  BACKWARD,
  ;

  public static Map<DaylightShaft, String> valueMap = new HashMap<>();
  static {
    valueMap.put(FORWARD, "向前");
    valueMap.put(BACKWARD, "向后");
  }

  public static Map<DaylightShaft, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(DaylightShaft value) {
    return valueMap.get(value);
  }
}