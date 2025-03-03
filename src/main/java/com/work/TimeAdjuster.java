package com.work;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class TimeAdjuster {
//  public static void main(String[] args) throws ParseException {
//    String dateStr = "2023-03-01 15:45:55";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Date currentTime = sdf.parse(dateStr);
//
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(currentTime);
//
//    int minute = calendar.get(Calendar.MINUTE);
//
//    // 结束时间
//    if (minute >= 30) {
//      calendar.set(Calendar.MINUTE, 45); // 设置结束时间为45分钟
//    } else {
//      calendar.set(Calendar.MINUTE, 15); // 设置结束时间为15分钟
//    }
//    calendar.set(Calendar.SECOND, 0);
//    calendar.set(Calendar.MILLISECOND, 0);
//    Date endTime = calendar.getTime();
//
//    // 起始时间
//    if (minute >= 30) {
//      calendar.set(Calendar.MINUTE, 15); // 设置起始时间为15分钟
//    } else {
//      calendar.set(Calendar.MINUTE, 0); // 设置起始时间为0分钟
//    }
//    Date beginTime = calendar.getTime();
//
//    System.out.println("Begin Time: " + sdf.format(beginTime));
//    System.out.println("End Time: " + sdf.format(endTime));
//  }

  public static void main(String[] args) throws ParseException {
//    String dateStr = "2023-03-01 15:45:55";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Date currentTime = sdf.parse(dateStr);
//
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(currentTime);
//
//    int minute = calendar.get(Calendar.MINUTE);
//
//    // 计算结束时间
//    Calendar endCalendar = (Calendar) calendar.clone(); // 克隆 Calendar
//    if (minute >= 30) {
//      endCalendar.set(Calendar.MINUTE, 15);
//      endCalendar.add(Calendar.HOUR_OF_DAY, 1); // 增加1小时
//    } else {
//      endCalendar.set(Calendar.MINUTE, 45);
//    }
//    endCalendar.set(Calendar.SECOND, 0);
//    endCalendar.set(Calendar.MILLISECOND, 0);
//    Date endTime = endCalendar.getTime();
//
//    // 计算起始时间
//    Calendar beginCalendar = (Calendar) calendar.clone(); // 克隆 Calendar
//    if (minute >= 30) {
//      beginCalendar.set(Calendar.MINUTE, 45);
//    } else {
//      beginCalendar.set(Calendar.MINUTE, 15);
//    }
//    beginCalendar.set(Calendar.SECOND, 0);
//    beginCalendar.set(Calendar.MILLISECOND, 0);
//    Date beginTime = beginCalendar.getTime();
//
//    System.out.println("Begin Time: " + sdf.format(beginTime));
//    System.out.println("End Time: " + sdf.format(endTime));

    String dateStr = "2023-03-01 15:44:55"; // 目标时间
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentTime = sdf.parse(dateStr);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentTime);

    // 计算当前分钟数
    int minute = calendar.get(Calendar.MINUTE);

    // 窗口起点：找到离当前时间最近的 15 或 45
    if (minute >= 30) {
      calendar.set(Calendar.MINUTE, 45);
    } else {
      calendar.set(Calendar.MINUTE, 15);
    }
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Date beginTime = calendar.getTime();

    // 计算窗口终点（起点 + 30 分钟）
    calendar.add(Calendar.MINUTE, 30);
    Date endTime = calendar.getTime();

    System.out.println("Begin Time: " + sdf.format(beginTime));
    System.out.println("End Time: " + sdf.format(endTime));
  }
}

