package com.work.indicator;

import cn.hutool.core.collection.*;
import java.math.*;
import java.time.*;
import java.util.*;

public class ObserventCalTest3 {

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
    localDateListHashMap.put(LocalDate.of(2025, 1, 7), Arrays.asList(new BigDecimal("12")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 8), Arrays.asList(new BigDecimal("15")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 9), Arrays.asList(new BigDecimal("18")));
    localDateListHashMap.put(LocalDate.of(2025, 1, 10), Arrays.asList(new BigDecimal("21")));

    // 输出原始数据
    System.out.println("Original Data:");
    localDateListHashMap.forEach((date, list) -> {
      System.out.println("Date: " + date + ", Values: " + list);
    });

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
      Set<LocalDate> observedDates = new HashSet<>();  // 用于追踪已经添加的数据日期
      boolean hasValidData = false;

      // 如果当前日期的数据为 null，尝试查找前面的有效数据
      if (localDateListHashMap.get(currentDate) == null || CollUtil.isEmpty(localDateListHashMap.get(currentDate))) {
        // 查找前面的有效数据
        for (int j = 1; j <= observationCount; j++) {
          LocalDate observationDate = sortedDates.get(i - j);

          if (localDateListHashMap.get(observationDate) != null && !CollUtil.isEmpty(localDateListHashMap.get(observationDate))) {
            // 如果找到有效数据，且该日期未被添加过
            if (!observedDates.contains(observationDate)) {
              observationList.addAll(localDateListHashMap.get(observationDate));
              observedDates.add(observationDate);
            }
          }

          // 如果已经找到足够的数据，跳出循环
          if (observationList.size() >= observationCount) {
            break;  // 找到足够数据后，跳出内部循环
          }
        }
      } else {
        // 如果当前日期的数据有效，直接添加到 observationList 中
        observationList.addAll(localDateListHashMap.get(currentDate));
        observedDates.add(currentDate);
      }

      // 如果数据集合足够才计算平均值
      if (observationList.size() >= observationCount) {
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

