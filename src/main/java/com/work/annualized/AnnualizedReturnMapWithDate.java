package com.work.annualized;

import java.math.*;
import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class AnnualizedReturnMapWithDate {

  public static Map<LocalDate, BigDecimal> calculateAnnualizedReturn(Map<LocalDate, BigDecimal> dailyTotalIncome,
      Map<LocalDate, BigDecimal> dailyTotalPosition, LocalDate startDate, LocalDate endDate, LocalDate baselineDate) {
    // 检查输入合法性：开始日期不能晚于结束日期
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("开始日期不能晚于结束日期！");
    }

    // 结果Map，用于存储每个日期的年化收益率
    Map<LocalDate, BigDecimal> annualizedReturns = new HashMap<>();

    // 获取基准日期的总持仓（默认为 0）
    BigDecimal baselinePosition = dailyTotalPosition.getOrDefault(baselineDate, BigDecimal.ZERO);

    // 初始化累计总持仓和累计总收益
    BigDecimal totalPosition = baselinePosition; // 加入基准日期的持仓
    BigDecimal totalIncome = BigDecimal.ZERO;

    // 遍历每日数据，计算每个日期的年化收益率
    for (LocalDate currentDate = startDate; !currentDate.isAfter(endDate); currentDate = currentDate.plusDays(1)) {
      // 获取每日持仓，如果没有数据，默认为 0
      BigDecimal dailyPosition = dailyTotalPosition.getOrDefault(currentDate, BigDecimal.ZERO);
      totalPosition = totalPosition.add(dailyPosition);

      // 获取每日收益，如果没有数据，默认为 0
      BigDecimal dailyIncome = dailyTotalIncome.getOrDefault(currentDate, BigDecimal.ZERO);
      totalIncome = totalIncome.add(dailyIncome);

      // 计算时间区间的天数（包含基准日到当前日期）
      long daysBetween = ChronoUnit.DAYS.between(startDate, currentDate) + 1;
      BigDecimal daysBetweenBD = BigDecimal.valueOf(daysBetween);

      // 计算日均持仓 = ∑每日总持仓 / (天数 + 1)（包含基准日）
      BigDecimal averagePosition = totalPosition.divide(daysBetweenBD.add(BigDecimal.ONE), MathContext.DECIMAL128);

      // 计算 R（累计收益率） = ∑每日总收益 / 日均持仓
      BigDecimal totalR = totalIncome.divide(averagePosition, MathContext.DECIMAL128);

      // 计算时间比例 t：区间天数 / 365
      BigDecimal t = daysBetweenBD.divide(BigDecimal.valueOf(365), MathContext.DECIMAL128);

      // 年化收益率公式：Annualized Return = (1 + R)^(1/t) - 1
      BigDecimal one = BigDecimal.ONE;
      BigDecimal annualizedReturn = BigDecimal.valueOf(
          Math.pow(one.add(totalR).doubleValue(), one.divide(t, MathContext.DECIMAL128).doubleValue())
      ).subtract(one);

      // 保存到结果Map，保留6位小数
      annualizedReturns.put(currentDate, annualizedReturn.setScale(2, RoundingMode.HALF_UP));
    }

    return annualizedReturns;
  }

  public static void main(String[] args) {
    // 定义测试数据
    Map<LocalDate, BigDecimal> dailyTotalIncome = Map.of(
        LocalDate.of(2024, 12, 18), new BigDecimal("100"),
        LocalDate.of(2024, 12, 19), new BigDecimal("150"),
        LocalDate.of(2024, 12, 20), new BigDecimal("200")
    );

    Map<LocalDate, BigDecimal> dailyTotalPosition = Map.of(
        LocalDate.of(2024, 12, 18), new BigDecimal("10000000"),
        LocalDate.of(2024, 12, 19), new BigDecimal("12000000"),
        LocalDate.of(2024, 12, 20), new BigDecimal("15000000")
    );

    LocalDate startDate = LocalDate.of(2024, 12, 18);
    LocalDate endDate = LocalDate.of(2024, 12, 20);
    LocalDate baselineDate = LocalDate.of(2024, 12, 17);

    // 调用方法
    Map<LocalDate, BigDecimal> annualizedReturns = calculateAnnualizedReturn(
        dailyTotalIncome, dailyTotalPosition, startDate, endDate, baselineDate
    );

    // 输出结果
    annualizedReturns.forEach((date, returnRate) ->
        System.out.println("Date: " + date + ", Annualized Return: " + returnRate)
    );
  }
}
