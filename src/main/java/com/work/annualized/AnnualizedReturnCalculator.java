package com.work.annualized;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class AnnualizedReturnCalculator {

  /**
   * 计算年化收益率
   *
   * @param dailyTotalIncome   每日的总收益（债券+衍生品），key 为日期，value 为收益
   * @param dailyTotalPosition 每日的总持仓，key 为日期，value 为持仓
   * @param startDate          开始日期
   * @param endDate            结束日期
   * @return 年化收益率（BigDecimal）
   */
  public static BigDecimal calculateAnnualizedReturn(Map<LocalDate, BigDecimal> dailyTotalIncome,
      Map<LocalDate, BigDecimal> dailyTotalPosition, LocalDate startDate, LocalDate endDate) {
    // 检查输入合法性：开始日期不能晚于结束日期
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("开始日期不能晚于结束日期！");
    }

    // 计算时间区间的天数（包含起始和结束日期）
    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
    BigDecimal daysBetweenBD = BigDecimal.valueOf(daysBetween);

    // 初始化累计总持仓和累计总收益
    BigDecimal totalPosition = BigDecimal.ZERO;
    BigDecimal totalIncome = BigDecimal.ZERO;

    // 遍历每日数据，计算累计总持仓和累计总收益
    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
      // 获取每日持仓，如果没有数据，默认为0
      BigDecimal dailyPosition = dailyTotalPosition.getOrDefault(date, BigDecimal.ZERO);
      totalPosition = totalPosition.add(dailyPosition);

      // 获取每日收益，如果没有数据，默认为0
      BigDecimal dailyIncome = dailyTotalIncome.getOrDefault(date, BigDecimal.ZERO);
      totalIncome = totalIncome.add(dailyIncome);
    }

    // 计算日均持仓 = ∑每日总持仓 / 天数
    BigDecimal averagePosition = totalPosition.divide(daysBetweenBD, MathContext.DECIMAL128);

    // 计算 R（累计收益率） = ∑每日总收益 / 日均持仓
    BigDecimal totalR = totalIncome.divide(averagePosition, MathContext.DECIMAL128);

    // 计算时间比例 t：区间天数 / 365
    BigDecimal t = daysBetweenBD.divide(BigDecimal.valueOf(365), MathContext.DECIMAL128);

    // 年化收益率公式：Annualized Return = (1 + R)^(1/t) - 1
    BigDecimal one = BigDecimal.ONE;
    BigDecimal annualizedReturn = (one.add(totalR)) // 1 + R
        .pow(one.divide(t, MathContext.DECIMAL128).intValue(), MathContext.DECIMAL128) // ^(1/t)
        .subtract(one); // - 1

    // 返回结果，保留6位小数
    return annualizedReturn.setScale(6, RoundingMode.HALF_UP);
  }

  public static void main(String[] args) {
    // 示例数据
    Map<LocalDate, BigDecimal> dailyTotalIncome = new HashMap<>();
    Map<LocalDate, BigDecimal> dailyTotalPosition = new HashMap<>();

    // 初始化每日总收益和每日总持仓
    dailyTotalIncome.put(LocalDate.of(2024, 6, 1), new BigDecimal("100.0"));
    dailyTotalIncome.put(LocalDate.of(2024, 6, 2), new BigDecimal("100.0"));
    dailyTotalIncome.put(LocalDate.of(2024, 6, 3), new BigDecimal("100.0"));

    dailyTotalPosition.put(LocalDate.of(2024, 5, 31), new BigDecimal("9000000.0")); // 基准日持仓
    dailyTotalPosition.put(LocalDate.of(2024, 6, 1), new BigDecimal("10000000.0"));
    dailyTotalPosition.put(LocalDate.of(2024, 6, 2), new BigDecimal("12000000.0"));
    dailyTotalPosition.put(LocalDate.of(2024, 6, 3), new BigDecimal("11000000.0"));

    // 起始日期和结束日期
    LocalDate startDate = LocalDate.of(2024, 6, 1);
    LocalDate endDate = LocalDate.of(2024, 6, 3);

    // 计算年化收益率
    BigDecimal annualizedReturn = calculateAnnualizedReturn(dailyTotalIncome, dailyTotalPosition, startDate, endDate);

    // 输出结果
    System.out.printf("从 %s 到 %s 的年化收益率为: %.6f%%\n", startDate, endDate, annualizedReturn.multiply(new BigDecimal("100")));
  }
}
