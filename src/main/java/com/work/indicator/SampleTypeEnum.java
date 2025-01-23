package com.work.indicator;

import java.util.*;

/**
 * 空值处理类型 generate with jinja2
 */
public enum SampleTypeEnum {
  /**
   * 剔除空值
   */
  IGNORE_BLANK,
  /**
   * 填充前值
   */
  ADD_PRE_VALUE,
  ;

  public static Map<SampleTypeEnum, String> valueMap = new HashMap<>();
  static {
    valueMap.put(IGNORE_BLANK, "剔除空值");
    valueMap.put(ADD_PRE_VALUE, "填充前值");
  }

  public static Map<SampleTypeEnum, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(SampleTypeEnum value) {
    return valueMap.get(value);
  }
}