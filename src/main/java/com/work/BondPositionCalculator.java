package com.work;

import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BondPositionCalculator {

  public static void main(String[] args) {
    // 模拟 bondBundlePositionMap (日期 -> 持仓量)
    Map<Date, BigDecimal> bondBundlePositionMap = new HashMap<>();
    bondBundlePositionMap.put(DateUtil.parse("2025-01-01"), new BigDecimal("100"));
    bondBundlePositionMap.put(DateUtil.parse("2025-01-02"), new BigDecimal("200"));
    bondBundlePositionMap.put(DateUtil.parse("2025-01-03"), new BigDecimal("300"));
    bondBundlePositionMap.put(DateUtil.parse("2025-01-04"), new BigDecimal("400"));

    // 模拟 dateSet
    Set<Date> dateSet = new HashSet<>(bondBundlePositionMap.keySet());

    // 设置 dateKey
    Date dateKey = DateUtil.parse("2025-01-04");

    // 设置 requestVO (包含 startDate)
    RequestVO requestVO = new RequestVO();
    requestVO.setStartDate(DateUtil.parse("2025-01-01"));

    // 计算每日平均持仓
    BondBundlePnlResponseVO responseVO = new BondBundlePnlResponseVO();
    calculateDailyAveragePosition(bondBundlePositionMap, dateSet, dateKey, requestVO, responseVO);

    // 打印结果
    System.out.println("datekey:"+dateKey+"每日平均持仓（万元）: " + responseVO.getDailyAveragePosition());
  }

  public static void calculateDailyAveragePosition(
      Map<Date, BigDecimal> bondBundlePositionMap,
      Set<Date> dateSet,
      Date dateKey,
      RequestVO requestVO,
      BondBundlePnlResponseVO bondBundlePnlResponseVO
  ) {
    BigDecimal totalPosition = BigDecimal.ZERO;
    Date first = dateSet.stream().min(Date::compareTo).orElse(null);
    if (first == null) {
      throw new IllegalArgumentException("dateSet 不能为空");
    }

    Date currentDate = dateKey;
    while (!currentDate.before(first)) {
      totalPosition = totalPosition.add(bondBundlePositionMap.getOrDefault(currentDate, BigDecimal.ZERO));
      currentDate = DateUtil.offsetDay(currentDate, -1);
    }

    long totalDays = Math.max(
        ChronoUnit.DAYS.between(
            requestVO.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            dateKey.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        ), 0
    );

    BigDecimal divisor = BigDecimal.valueOf(Math.max(totalDays + 1, 1));
    BigDecimal bondDailyAveragePosition = totalPosition
        .divide(divisor, 10, RoundingMode.HALF_UP)
        .divide(BigDecimal.valueOf(10000), 4, RoundingMode.HALF_UP);

    bondBundlePnlResponseVO.setDailyAveragePosition(bondDailyAveragePosition);
  }
}

// 模拟 RequestVO 类
class RequestVO {

  private Date startDate;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
}

// 模拟 BondBundlePnlResponseVO 类
class BondBundlePnlResponseVO {

  private BigDecimal dailyAveragePosition;

  public BigDecimal getDailyAveragePosition() {
    return dailyAveragePosition;
  }

  public void setDailyAveragePosition(BigDecimal dailyAveragePosition) {
    this.dailyAveragePosition = dailyAveragePosition;
  }
}

