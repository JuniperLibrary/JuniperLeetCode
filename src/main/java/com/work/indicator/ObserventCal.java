package com.work.indicator;

import java.math.*;
import java.time.*;
import java.util.*;

public class ObserventCal {

  public static void main(String[] args) {
    // 创建一个 HashMap，用于存储 LocalDate 和对应的 BigDecimal 列表
    Map<LocalDate, List<BigDecimal>> localDateListHashMap = new HashMap<>();

    // 填充示例数据：1月1日到1月10日的数据
    localDateListHashMap.put(LocalDate.of(2025, 1, 1), null);
    localDateListHashMap.put(LocalDate.of(2025, 1, 2), null);
    localDateListHashMap.put(LocalDate.of(2025, 1, 3), List.of(new BigDecimal("3")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 4), List.of(new BigDecimal("6")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 5), List.of(new BigDecimal("9")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 6), null);
    localDateListHashMap.put(LocalDate.of(2025, 1, 7), null);
    localDateListHashMap.put(LocalDate.of(2025, 1, 8), Arrays.asList(new BigDecimal("15")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 9), Arrays.asList(new BigDecimal("18")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 10), Arrays.asList(new BigDecimal("21")));

    // 输出原始数据
    System.out.println("Original Data:");
    localDateListHashMap.forEach((date, list) -> {
      System.out.println("Date: " + date + ", Values: " + list);
    });

    SampleTypeEnum sampleType = SampleTypeEnum.ADD_PRE_VALUE;

    // 假设我们想计算连续3天的移动平均
    int observationCount = 3;
    Map<LocalDate, BigDecimal> movingAverages = new HashMap<>();

    // 按日期排序
    List<LocalDate> sortedDates = new ArrayList<>(localDateListHashMap.keySet());
    Collections.sort(sortedDates);

    // 创建一个缓存，用于存储连续的有效数据
    List<BigDecimal> observationList = new ArrayList<>();

    // 计算移动平均
    for (int i = 0; i < sortedDates.size(); i++) {
      LocalDate currentDate = sortedDates.get(i);
      List<BigDecimal> currentData = localDateListHashMap.get(currentDate);

      // 如果当前日期的数据有效，则加入观察数据
      if (currentData != null && !currentData.isEmpty()) {
        observationList.addAll(currentData);
      }

      // 当观察数据集满了 observationCount 后，进行计算
      if (observationList.size() >= observationCount) {
        // 取最近的 observationCount 个数据
        List<BigDecimal> validData = observationList.subList(observationList.size() - observationCount, observationList.size());

        // 计算移动平均
        BigDecimal sum = validData.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal average = sum.divide(new BigDecimal(observationCount), 2, BigDecimal.ROUND_HALF_UP);
        movingAverages.put(currentDate, average);
      } else {
        movingAverages.put(currentDate, BigDecimal.ZERO);
      }

      // 如果观察数据超过了 observationCount，删除最早的元素
      if (observationList.size() > observationCount) {
        observationList.remove(0);
      }
    }

    // 输出计算结果
    System.out.println("\nMoving Averages:");
    movingAverages.forEach((date, avg) -> {
      System.out.println("Date: " + date + ", Moving Average: " + avg);
    });
  }
}
