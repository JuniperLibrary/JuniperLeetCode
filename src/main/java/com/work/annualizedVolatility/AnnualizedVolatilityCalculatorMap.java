package com.work.annualizedVolatility;

import cn.hutool.core.lang.hash.*;
import com.alibaba.easyexcel.support.cglib.core.*;
import java.math.*;
import java.time.*;
import java.util.*;
import java.util.Map.*;

/**
 * 年化波动率
 */
public class AnnualizedVolatilityCalculatorMap {
  public static Map<LocalDate, BigDecimal> calculateDailyStandardDeviation(Map<LocalDate, BigDecimal> dailyDataList) {
    Map<LocalDate, BigDecimal> dailyStdDevMap = new LinkedHashMap<>(); // 保证按日期顺序输出
    List<BigDecimal> cumulativeValues = new ArrayList<>();

    for (Map.Entry<LocalDate, BigDecimal> entry : dailyDataList.entrySet()) {
      LocalDate date = entry.getKey();
      BigDecimal dailyReturn = entry.getValue();

      // 累积数据到当前日期
      cumulativeValues.add(dailyReturn);

      // 计算当前累积数据的平均值
      BigDecimal meanReturn = calculateMean(cumulativeValues);

      // 计算当前累积数据的方差
      BigDecimal variance = calculateVariance(cumulativeValues, meanReturn);

      // 计算标准差并存入结果Map
      BigDecimal stdDev = variance.sqrt(MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
      dailyStdDevMap.put(date, stdDev);
    }

    return dailyStdDevMap;
  }

  private static BigDecimal calculateMean(List<BigDecimal> values) {
    BigDecimal sum = BigDecimal.ZERO;
    for (BigDecimal value : values) {
      sum = sum.add(value);
    }
    return sum.divide(new BigDecimal(values.size()), 10, RoundingMode.HALF_UP);
  }

  private static BigDecimal calculateVariance(List<BigDecimal> values, BigDecimal mean) {
    BigDecimal varianceSum = BigDecimal.ZERO;
    for (BigDecimal value : values) {
      BigDecimal diff = value.subtract(mean);
      varianceSum = varianceSum.add(diff.pow(2));
    }
    return varianceSum.divide(new BigDecimal(values.size()), 10, RoundingMode.HALF_UP);
  }

  // 自定义平方根方法
  public static BigDecimal sqrt(BigDecimal value, int scale) {
    BigDecimal x0 = new BigDecimal("0");
    BigDecimal x1 = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
    while (!x0.equals(x1)) {
      x0 = x1;
      x1 = value.divide(x0, scale, RoundingMode.HALF_UP);
      x1 = x1.add(x0);
      x1 = x1.divide(new BigDecimal(2), scale, RoundingMode.HALF_UP);
    }
    return x1;
  }

  public static void main(String[] args) {
    Map<LocalDate, BigDecimal> bigDecimalHashMap = new LinkedHashMap<>();
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 1), new BigDecimal("1.0"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 2), new BigDecimal("1.2"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 3), new BigDecimal("1.3"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 4), new BigDecimal("1.4"));
    bigDecimalHashMap.put(LocalDate.of(2024, 12, 5), new BigDecimal("1.5"));

    Map<LocalDate, BigDecimal> result = calculateDailyStandardDeviation(bigDecimalHashMap);
    result.forEach((date, stdDev) -> System.out.println(date + ": " + stdDev));
  }
}
