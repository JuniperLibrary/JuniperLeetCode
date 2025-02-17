package com.work;

import java.util.*;

/**
 * 指标运算方式枚举 generate with jinja2
 */
public enum IndicatorCalculationMethodEnum {
  /**
   * 指标间运算
   */
  INTER_INDICATOR,
  /**
   * 指标与常数运算
   */
  INDICATOR_AND_CONSTANT,
  /**
   * 移动平均值
   */
  MEAN,
  /**
   * 方差
   */
  VARIANCE,
  ;

  public static Map<IndicatorCalculationMethodEnum, String> valueMap = new HashMap<>();
  static {
    valueMap.put(INTER_INDICATOR, "指标间运算");
    valueMap.put(INDICATOR_AND_CONSTANT, "指标与常数运算");
    valueMap.put(MEAN, "移动平均值");
    valueMap.put(VARIANCE, "方差");
  }

  public static Map<IndicatorCalculationMethodEnum, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(IndicatorCalculationMethodEnum value) {
    return valueMap.get(value);
  }
}