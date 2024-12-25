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

    System.out.println("第一种情况:");
    calculateMaxDrawdown(bigDecimalHashMap);

    // 第二种情况
    Map<LocalDate, BigDecimal> bigDecimalHashMap2 = new LinkedHashMap<>();
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.1"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 4), new BigDecimal("0.9"));
    bigDecimalHashMap2.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"));

    System.out.println("\n第二种情况:");
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
  }

  private static void calculateMaxDrawdown(Map<LocalDate, BigDecimal> data) {
    List<LocalDate> dates = new ArrayList<>(data.keySet());
    List<BigDecimal> values = new ArrayList<>(data.values());

    BigDecimal maxSeen = BigDecimal.ZERO;
    Map<LocalDate, BigDecimal> drawdowns = new LinkedHashMap<>();

    for (int i = 0; i < values.size(); i++) {
      BigDecimal current = values.get(i);
      maxSeen = maxSeen.max(current);
      BigDecimal drawdown = BigDecimal.ZERO;
      if (maxSeen.compareTo(BigDecimal.ZERO) > 0) {
        drawdown = maxSeen.subtract(current);
      }
      drawdowns.put(dates.get(i), drawdown);
    }

    // 倒序输出结果
    drawdowns.entrySet().stream()
        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
        .forEach(entry -> System.out.println("date:" + entry.getKey() + ",value:" + entry.getValue() + " %"));
  }
}
