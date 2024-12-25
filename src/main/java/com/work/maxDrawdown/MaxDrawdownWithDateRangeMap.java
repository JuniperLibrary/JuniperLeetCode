package com.work.maxDrawdown;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;
import lombok.extern.slf4j.*;

/**
 * 最大回测率
 */
@Slf4j
public class MaxDrawdownWithDateRangeMap {

  /**
   * 定义收益率数据的实体类
   */

  public static Map<LocalDate, BigDecimal> calculateMaxDrawdown(Map<LocalDate, BigDecimal> rateDataList) {
    // 如果数据为空，抛出异常
    if (rateDataList.isEmpty()) {
      throw new IllegalArgumentException("没有收益率数据！");
    }

    // 初始化
    Map<LocalDate, BigDecimal> drawdownMap = new HashMap<>();
    BigDecimal highestRate = BigDecimal.ZERO; // 初始化历史最高点

    // 遍历数据计算每天的最大回撤值
    for (Map.Entry<LocalDate, BigDecimal> entry : rateDataList.entrySet()) {
      LocalDate date = entry.getKey();
      BigDecimal rate = entry.getValue();

      BigDecimal drawdown;

      // 如果当前值高于或等于历史最高值，则更新最高值，并将回撤设为0
      if (rate.compareTo(highestRate) >= 0) {
        highestRate = rate;
        drawdown = BigDecimal.ZERO;
      } else {
        // 如果当前值低于历史最高值，计算回撤率
        drawdown = highestRate.subtract(rate);
      }

      // 存储回撤值到结果Map
      drawdownMap.put(date, drawdown);
    }

    return drawdownMap;
  }

  public static void main(String[] args) {
    // 示例1：连续上涨，没有回撤
    Map<LocalDate, BigDecimal> rateDataList1 = new HashMap<>();
    rateDataList1.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    rateDataList1.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    rateDataList1.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.3"));
    rateDataList1.put(LocalDate.of(2024, 12, 4), new BigDecimal("1.4"));
    rateDataList1.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.5"));
    Map<LocalDate, BigDecimal> result1 = calculateMaxDrawdown(rateDataList1);
    result1.forEach((date, value) -> System.out.println("date:" + date + ", value:" + value + " %"));

    System.out.println("======================");

//    // 示例2：有回撤
//    Map<LocalDate, BigDecimal> rateDataList2 = new HashMap<>();
//    rateDataList2.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
//    rateDataList2.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
//    rateDataList2.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.1"));
//    rateDataList2.put(LocalDate.of(2024, 12, 4), new BigDecimal("0.9"));
//    rateDataList2.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"));
//    Map<LocalDate, BigDecimal> result2 = calculateMaxDrawdown(rateDataList2);
//    result2.forEach((date, value) -> System.out.println("date:" + date + ", value:" + value + " %"));
//
//    System.out.println("==========================");
//
//    // 示例3：回撤发生在下降后
//    Map<LocalDate, BigDecimal> rateDataList3 = new HashMap<>();
//    rateDataList3.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
//    rateDataList3.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
//    rateDataList3.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.3"));
//    rateDataList3.put(LocalDate.of(2024, 12, 4), new BigDecimal("1.4"));
//    rateDataList3.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"));
//    Map<LocalDate, BigDecimal> result3 = calculateMaxDrawdown(rateDataList3);
//    result3.forEach((date, value) -> System.out.println("date:" + date + ", value:" + value + " %"));
  }
}
