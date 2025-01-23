package com.work.indicator;

import java.util.*;

/**
 * 价格类型 generate with jinja2
 */
public enum PriceTypeEnum {
  /**
   * 收益率
   */
  YIELD,
  /**
   * 净价
   */
  PRICE,
  ;

  public static Map<PriceTypeEnum, String> valueMap = new HashMap<>();
  static {
    valueMap.put(YIELD, "收益率");
    valueMap.put(PRICE, "净价");
  }

  public static Map<PriceTypeEnum, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(PriceTypeEnum value) {
    return valueMap.get(value);
  }
}