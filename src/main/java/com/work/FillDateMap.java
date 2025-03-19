package com.work;

import java.math.*;
import java.text.*;
import java.util.*;

public class FillDateMap {
  public static void main(String[] args) throws Exception {
    // 已有数据
    Map<Date, List<BigDecimal>> bAnalYieldCnbdMap = new TreeMap<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    bAnalYieldCnbdMap.put(sdf.parse("2025-02-10"), List.of(BigDecimal.ONE));
    bAnalYieldCnbdMap.put(sdf.parse("2025-02-11"), List.of(BigDecimal.valueOf(5.5)));
    bAnalYieldCnbdMap.put(sdf.parse("2025-02-12"), List.of(BigDecimal.ZERO));

    // 设置开始和结束时间
    Date beginTime = sdf.parse("2025-02-10");
    Date endTime = sdf.parse("2025-02-28");

    // 生成所有日期，并填充缺失的值
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(beginTime);

    while (!calendar.getTime().after(endTime)) {
      bAnalYieldCnbdMap.putIfAbsent(calendar.getTime(), null);
      calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    // 打印结果
    for (Date date : new TreeSet<>(bAnalYieldCnbdMap.keySet())) {
      System.out.println(sdf.format(date) + " -> " + bAnalYieldCnbdMap.get(date));
    }
  }
}
