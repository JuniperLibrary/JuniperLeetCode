package com.work.indicator;

import java.util.*;

/**
 * 运算符 generate with jinja2
 */
public enum OperatorEnum {
  /**
   * 加
   */
  ADD,
  /**
   * 减
   */
  SUBTRACT,
  /**
   * 乘
   */
  MULTIPLY,
  /**
   * 除
   */
  DIVIDE,
  /**
   * 百分比
   */
  PERCENTAGE,
  /**
   * 乘方
   */
  POWER,
  /**
   * 开方
   */
  ROOT,
  /**
   * 移动平均
   */
  MA,
  /**
   * 方差
   */
  VAR,
  ;

  public static Map<OperatorEnum, String> valueMap = new HashMap<>();

  static {
    valueMap.put(ADD, "加");
    valueMap.put(SUBTRACT, "减");
    valueMap.put(MULTIPLY, "乘");
    valueMap.put(DIVIDE, "除");
    valueMap.put(PERCENTAGE, "百分比");
    valueMap.put(POWER, "乘方");
    valueMap.put(ROOT, "开方");
    valueMap.put(MA, "移动平均");
    valueMap.put(VAR, "方差");
  }

  public static Map<OperatorEnum, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(OperatorEnum value) {
    return valueMap.get(value);
  }
}