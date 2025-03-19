package com.work.maxDrawdown;

import java.math.*;
import java.time.*;
import java.util.*;

public class MaxDrawdownCalculator {
  public static void main(String[] args) {
    // 第一种情况
    Map<LocalDate, BigDecimal> bigDecimalHashMap = new LinkedHashMap<>();
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.3"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 4), new BigDecimal("1.4"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.5"));

    System.out.println("第一种情况: 连续上涨");
    calculateMaxDrawdown(bigDecimalHashMap);

    // 第二种情况
    Map<LocalDate, BigDecimal> bigDecimalHashMap2 = new LinkedHashMap<>();
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.1"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 4), new BigDecimal("0.9"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"));

    System.out.println("\n第二种情况: 有升有降");
    calculateMaxDrawdown(bigDecimalHashMap2);

    // 第三种情况
    Map<LocalDate, BigDecimal> rateDataList = new LinkedHashMap<>();
    rateDataList.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    rateDataList.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    rateDataList.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.3"));
    rateDataList.put(LocalDate.of(2024, 12, 4), new BigDecimal("1.4"));
    rateDataList.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"));

    System.out.println("\n第三种情况:");
    calculateMaxDrawdown(rateDataList);

    // 第四种情况
    Map<LocalDate, BigDecimal> rateDataList4 = new LinkedHashMap<>();
    rateDataList4.put(LocalDate.of(2024, 12, 1), new BigDecimal("21426847933248172"));
    rateDataList4.put(LocalDate.of(2024, 12, 2), new BigDecimal("4593709851352.566"));
    rateDataList4.put(LocalDate.of(2024, 12, 3), new BigDecimal("304893143.520776"));
    rateDataList4.put(LocalDate.of(2024, 12, 4), new BigDecimal("67610963844.86082"));
//    rateDataList4.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.1"));
//    rateDataList4.put(LocalDate.of(2024, 12, 6), new BigDecimal("1.5"));
//    rateDataList4.put(LocalDate.of(2024, 12, 7), new BigDecimal("1.9"));
//    rateDataList4.put(LocalDate.of(2024, 12, 8), new BigDecimal("1.3"));

    System.out.println("\n第四种情况:");
    calculateMaxDrawdown(rateDataList4);
  }

  private static void calculateMaxDrawdown(Map<LocalDate, BigDecimal> data) {
    // 获取日期和对应的值，确保顺序一致
    List<LocalDate> dates = new ArrayList<>(data.keySet());
    List<BigDecimal> values = new ArrayList<>(data.values());

    // 记录历史最高点（初始为最小值）
    BigDecimal maxSeen = values.get(0);
    // 记录当前最大回撤值
    BigDecimal maxDrawdown = BigDecimal.ZERO;
    // 存储每个日期对应的回撤值
    Map<LocalDate, BigDecimal> drawdowns = new LinkedHashMap<>();

    for (int i = 0; i < values.size(); i++) {
      BigDecimal current = values.get(i);

      // 更新历史最高点
      maxSeen = maxSeen.max(current);

      // 计算当前回撤值（如果当前值小于最高点）
      BigDecimal drawdown = maxSeen.equals(current) ? maxDrawdown : maxSeen.subtract(current);

      // 记录历史最大回撤
      maxDrawdown = maxDrawdown.max(drawdown);

      // 存储当前日期的最大回撤值
      LocalDate localDate = dates.get(i);
      drawdowns.put(localDate, maxDrawdown.setScale(4, RoundingMode.HALF_UP));
    }

    drawdowns.entrySet().forEach(entry -> System.out.println("date: " + entry.getKey() + ", value: " + entry.getValue() + " %"));
  }
}
