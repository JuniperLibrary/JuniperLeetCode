package com.work.baseline;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // 假设当前日期是没有时间部分的 Date
    Date currentDate = new Date();

    // 将 Date 转换为 LocalDate
    LocalDate localDate = currentDate.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();

    // 获取前一天的 LocalDate
    LocalDate previousLocalDate = localDate.minusDays(1);

    // 转换为 ZonedDateTime，并设置时区
    ZonedDateTime zonedDateTime = previousLocalDate.atStartOfDay(ZoneId.of("GMT+8"));

    // 使用 DateTimeFormatter 格式化输出
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedPreviousDate = zonedDateTime.format(formatter);

    // 同样方式格式化当前日期
    ZonedDateTime currentZonedDateTime = localDate.atStartOfDay(ZoneId.of("GMT+8"));
    String formattedCurrentDate = currentZonedDateTime.format(formatter);

    System.out.println("当前日期: " + formattedCurrentDate);
    System.out.println("前一天日期: " + formattedPreviousDate);
  }
}


