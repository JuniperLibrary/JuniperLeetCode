package com.work.annualizedVolatility;

import java.math.*;
import java.util.*;

/**
 * 年化波动率
 */
public class AnnualizedVolatilityCalculator {

  static class DailyData {

    BigDecimal totalRevenue; // 每日总收益
    BigDecimal holding;      // 每日总持仓

    public DailyData(BigDecimal totalRevenue, BigDecimal holding) {
      this.totalRevenue = totalRevenue;
      this.holding = holding;
    }
  }

  public static BigDecimal calculateAnnualizedVolatility(List<DailyData> dailyDataList) {
    // Step 1: 计算每日收益率
    List<BigDecimal> dailyReturns = new ArrayList<>();
    for (DailyData data : dailyDataList) {
      if (data.holding.compareTo(BigDecimal.ZERO) > 0) {
        dailyReturns.add(data.totalRevenue.divide(data.holding, 10, RoundingMode.HALF_UP));
      } else {
        dailyReturns.add(BigDecimal.ZERO); // 如果持仓为0，收益率为0
      }
    }

    // Step 2: 计算平均收益率
    BigDecimal sumReturns = BigDecimal.ZERO;
    for (BigDecimal dailyReturn : dailyReturns) {
      sumReturns = sumReturns.add(dailyReturn);
    }
    BigDecimal meanReturn = sumReturns.divide(new BigDecimal(dailyReturns.size()), 10, RoundingMode.HALF_UP);

    // Step 3: 计算标准差（波动率）
    BigDecimal varianceSum = BigDecimal.ZERO;
    for (BigDecimal dailyReturn : dailyReturns) {
      BigDecimal diff = dailyReturn.subtract(meanReturn);
      varianceSum = varianceSum.add(diff.pow(2));
    }
    BigDecimal variance = varianceSum.divide(new BigDecimal(dailyReturns.size()), 10, RoundingMode.HALF_UP);
    BigDecimal standardDeviation = sqrt(variance, 10); // 自定义平方根方法

    // Step 4: 年化波动率
//    BigDecimal annualizedVolatility = standardDeviation.multiply(sqrt(new BigDecimal(annualTradingDays), 10));
    return standardDeviation;
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
    // 示例数据
    List<DailyData> dailyDataList = List.of(
        new DailyData(new BigDecimal("0"), new BigDecimal("900")),    // 2024-05-31
        new DailyData(new BigDecimal("100"), new BigDecimal("1000")), // 2024-06-01
        new DailyData(new BigDecimal("150"), new BigDecimal("1200")), // 2024-06-02
        new DailyData(new BigDecimal("200"), new BigDecimal("1100")), // 2024-06-03
        new DailyData(new BigDecimal("300"), new BigDecimal("1300")), // 2024-06-04
        new DailyData(new BigDecimal("250"), new BigDecimal("1250")), // 2024-06-05
        new DailyData(new BigDecimal("100"), new BigDecimal("1150")), // 2024-06-06
        new DailyData(new BigDecimal("50"), new BigDecimal("1000"))   // 2024-06-07
    );

    // 计算年化波动率（假设一年有252个交易日）
    BigDecimal annualizedVolatility = calculateAnnualizedVolatility(dailyDataList);
    System.out.println("年化波动率: " + annualizedVolatility);
  }
}
