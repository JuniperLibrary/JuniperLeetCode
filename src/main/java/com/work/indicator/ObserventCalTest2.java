package com.work.indicator;

import cn.hutool.core.collection.CollUtil;
import java.math.*;
import java.time.*;
import java.util.*;

public class ObserventCalTest2 {

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

    // 计算移动平均
    for (int i = 0; i < sortedDates.size(); i++) {
      LocalDate currentDate = sortedDates.get(i);

      // 判断是否有连续3天的数据
      List<BigDecimal> observationList = new ArrayList<>();
      for (int j = 0; j < observationCount; j++) {
        LocalDate observationDate = sortedDates.get(i - j);
        List<BigDecimal> currentData = localDateListHashMap.get(observationDate);

        // 如果当前日期的数据为空，则往前查找
        if (currentData == null || CollUtil.isEmpty(currentData)) {
          // 查找前一日期的数据
          int searchIndex = i - j - 1;
          while (searchIndex >= 0 && observationList.size() < observationCount) {
            LocalDate previousDate = sortedDates.get(searchIndex);
            List<BigDecimal> previousData = localDateListHashMap.get(previousDate);

            if (previousData != null && !previousData.isEmpty()) {
              observationList.addAll(previousData);
            }
            searchIndex--;
          }

          // 如果没有找到足够的数据，则跳过当前日期
          if (observationList.size() < observationCount) {
            movingAverages.put(currentDate, BigDecimal.ZERO);
            break;
          }
        } else {
          // 当前日期的数据有效，直接加入观察数据
          observationList.addAll(currentData);
        }
        if (observationList.size() == observationCount){
          break;
        }
      }

      // 如果数据集合足够才计算平均值
      if (observationList.size() == observationCount) {
        BigDecimal sum = observationList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal average = sum.divide(new BigDecimal(observationCount), 2, BigDecimal.ROUND_HALF_UP);
        movingAverages.put(currentDate, average);
      } else {
        movingAverages.put(currentDate, BigDecimal.ZERO);
      }
    }

    // 输出计算结果
    System.out.println("\nMoving Averages:");
    movingAverages.forEach((date, avg) -> {
      System.out.println("Date: " + date + ", Moving Average: " + avg);
    });
  }
}

