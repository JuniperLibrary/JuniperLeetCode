package com.work;

import java.util.*;

/**
 * 结算方式 generate with jinja2
 */
public enum DeliveryType {
  /**
   * 券款对付
   */
  DVP,
  /**
   * 见券付款
   */
  PUD,
  /**
   * 见款付券
   */
  DUP,
  ;

  public static Map<DeliveryType, String> valueMap = new HashMap<>();
  static {
    valueMap.put(DVP, "券款对付");
    valueMap.put(PUD, "见券付款");
    valueMap.put(DUP, "见款付券");
  }

  public static Map<DeliveryType, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(DeliveryType value) {
    return valueMap.get(value);
  }
}