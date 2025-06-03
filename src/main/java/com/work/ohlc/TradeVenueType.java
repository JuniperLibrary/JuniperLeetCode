package com.work.ohlc;

import java.util.*;

/**
 * 交易场所类型 generate with jinja2
 */
public enum TradeVenueType {
  /**
   * 交易所
   */
  EXCHANGE,
  /**
   * 多银行平台
   */
  MULTI_BANK,
  /**
   * 单银行平台
   */
  UNI_BANK,
  ;

  public static Map<TradeVenueType, String> valueMap = new HashMap<>();
  static {
    valueMap.put(EXCHANGE, "交易所");
    valueMap.put(MULTI_BANK, "多银行平台");
    valueMap.put(UNI_BANK, "单银行平台");
  }

  public static Map<TradeVenueType, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(TradeVenueType value) {
    return valueMap.get(value);
  }
}