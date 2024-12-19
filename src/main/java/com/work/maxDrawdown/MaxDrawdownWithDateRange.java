package com.work.maxDrawdown;

import java.math.*;
import java.time.*;
import java.util.*;

/**
 * 最大回测率
 */
public class MaxDrawdownWithDateRange {

  /**
   * 定义收益率数据的实体类
   */
  static class RateData {

    private LocalDate date; // 日期
    private BigDecimal rate; // 收益率

    public RateData(LocalDate date, BigDecimal rate) {
      this.date = date;
      this.rate = rate;
    }

    public LocalDate getDate() {
      return date;
    }

    public BigDecimal getRate() {
      return rate;
    }
  }

  /**
   * 计算最大回撤率（按时间范围筛选）
   *
   * @param rateDataList 收益率数据列表
   * @param startDate    开始日期
   * @param endDate      结束日期
   * @return 最大回撤率（小数表示，使用 BigDecimal 返回）
   */
  public static BigDecimal calculateMaxDrawdown(List<RateData> rateDataList, LocalDate startDate, LocalDate endDate) {
    // 筛选时间范围内的数据
    List<RateData> filteredData = new ArrayList<>();
    for (RateData data : rateDataList) {
      if (!data.getDate().isBefore(startDate) && !data.getDate().isAfter(endDate)) {
        filteredData.add(data);
      }
    }

    if (filteredData.isEmpty()) {
      throw new IllegalArgumentException("指定时间范围内没有收益率数据！");
    }

    // 开始计算最大回撤率
    BigDecimal maxRate = BigDecimal.ZERO; // 当前的最高收益率
    BigDecimal maxDrawdown = BigDecimal.ZERO; // 最大回撤率
    boolean hasDrawdown = false; // 是否出现过回撤

    for (RateData data : filteredData) {
      BigDecimal rate = data.getRate();
      // 更新当前最高收益率
      if (rate.compareTo(maxRate) > 0) {
        maxRate = rate;
      }
      // 计算当前回撤率：(maxRate - rate) / maxRate
      if (maxRate.compareTo(BigDecimal.ZERO) > 0) { // 避免除以零
        BigDecimal drawdown = maxRate.subtract(rate).divide(maxRate, 8, BigDecimal.ROUND_HALF_UP);
        // 更新最大回撤率
        if (drawdown.compareTo(maxDrawdown) > 0) {
          maxDrawdown = drawdown;
          hasDrawdown = true; // 记录出现了回撤
        }
      }
    }

    // 如果收益率一直上升，没有回撤，最大回撤率为 0
    return hasDrawdown ? maxDrawdown : BigDecimal.ZERO;
  }

  public static void main(String[] args) {
    // 示例收益率数据
    List<RateData> rateDataList = new ArrayList<>();
    rateDataList.add(new RateData(LocalDate.of(2024, 12, 1), new BigDecimal("1.0")));
    rateDataList.add(new RateData(LocalDate.of(2024, 12, 2), new BigDecimal("1.2")));
    rateDataList.add(new RateData(LocalDate.of(2024, 12, 3), new BigDecimal("1.3")));
    rateDataList.add(new RateData(LocalDate.of(2024, 12, 4), new BigDecimal("1.4")));
    rateDataList.add(new RateData(LocalDate.of(2024, 12, 5), new BigDecimal("1.5"))); // 一直上升

    // 输入时间范围
    LocalDate startDate = LocalDate.of(2024, 12, 1);
    LocalDate endDate = LocalDate.of(2024, 12, 5);

    // 计算时间范围内的最大回撤率
    BigDecimal maxDrawdown = calculateMaxDrawdown(rateDataList, startDate, endDate);

    // 输出结果
    System.out.println("最大回撤率为: " + maxDrawdown.multiply(new BigDecimal("100")) + "%");

    // 示例收益率数据（有升有降）
    List<RateData> rateDataList2 = new ArrayList<>();
    rateDataList2.add(new RateData(LocalDate.of(2024, 12, 1), new BigDecimal("1.0")));
    rateDataList2.add(new RateData(LocalDate.of(2024, 12, 2), new BigDecimal("1.2")));
    rateDataList2.add(new RateData(LocalDate.of(2024, 12, 3), new BigDecimal("1.1")));
    rateDataList2.add(new RateData(LocalDate.of(2024, 12, 4), new BigDecimal("0.9")));
    rateDataList2.add(new RateData(LocalDate.of(2024, 12, 5), new BigDecimal("1.3"))); // 收益率有升有降

    // 输入时间范围
    LocalDate startDate2 = LocalDate.of(2024, 12, 1);
    LocalDate endDate2 = LocalDate.of(2024, 12, 5);

    // 计算时间范围内的最大回撤率
    BigDecimal maxDrawdown2 = calculateMaxDrawdown(rateDataList2, startDate2, endDate2);

    // 输出结果
    System.out.println("最大回撤率为: " + maxDrawdown2.multiply(new BigDecimal("100")) + "%");
  }
}
