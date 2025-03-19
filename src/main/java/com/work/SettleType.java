package com.work;

import java.time.*;
import java.util.*;

/**
 * 清算速度 generate with jinja2
 */

public enum SettleType {
  /**
   * T+0
   */
  T0(0),
  /**
   * T+1
   */
  T1(1),
  /**
   * T+2
   */
  T2(2),
  /**
   * T+3
   */
  T3(3),
  /**
   * T+4
   */
  T4(4),
  /**
   * T+5
   */
  T5(5),
  /**
   * T+6
   */
  T6(6),
  /**
   * T+7
   */
  T7(7),
  /**
   * T+8
   */
  T8(8),
  /**
   * T+9
   */
  T9(9),
  /**
   * T+10
   */
  T10(10),
  /**
   * T+11
   */
  T11(11),
  /**
   * T+12
   */
  T12(12),
  /**
   * T+13
   */
  T13(13),
  /**
   * T+14
   */
  T14(14),
  /**
   * T+15
   */
  T15(15),
  ;
  private int days;

  SettleType(int days) {
    this.days = days;
  }

  public int getDays() {
    return days;
  }

  public static Map<SettleType, String> valueMap = new HashMap<>();

  static {
    valueMap.put(T0, "T+0");
    valueMap.put(T1, "T+1");
    valueMap.put(T2, "T+2");
    valueMap.put(T3, "T+3");
    valueMap.put(T4, "T+4");
    valueMap.put(T5, "T+5");
    valueMap.put(T6, "T+6");
    valueMap.put(T7, "T+7");
    valueMap.put(T8, "T+8");
    valueMap.put(T9, "T+9");
    valueMap.put(T10, "T+10");
    valueMap.put(T11, "T+11");
    valueMap.put(T12, "T+12");
    valueMap.put(T13, "T+13");
    valueMap.put(T14, "T+14");
    valueMap.put(T15, "T+15");
  }

  public static Map<SettleType, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(SettleType value) {
    return valueMap.get(value);
  }

  public static String formatString() {
    return "T0, T1, T2, T3, T4";
  }

  public static LocalDate calculateSettlementDate(SettleType settleType) {
    LocalDate currentDate = LocalDate.now();
    return currentDate.plusDays(settleType.getDays());
  }

  public static SettleType getDays(String value) {
    SettleType key = null;
    for (Map.Entry<SettleType, String> entry : valueMap.entrySet()) {
      if (entry.getValue().equals(value)) {
        key = entry.getKey();
      }
    }
    return key;
  }

  public static SettleType getDays(int days) {
    SettleType key = null;
    for (SettleType settleType : values()) {
        if (settleType.getDays() == days){
          return settleType;
        }
    }
    return key;
  }

  public static void main(String[] args) {
    String value = "T+7";
    System.out.println(getDays(value));
  }
}
