package com.work;

import java.text.*;
import java.util.*;

public class TimeIntervalGenerator {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 获取当前时间
    Date currentTime = new Date();
    System.out.println("当前时间: " + sdf.format(currentTime));

    // 生成每隔30分钟的时间区间
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentTime);
      calendar.add(Calendar.MINUTE, 0);
      Date beginTime = calendar.getTime();

      calendar.add(Calendar.MINUTE, 30);
      Date endTime = calendar.getTime();

      System.out.println("BeginTime: " + sdf.format(beginTime) + " | EndTime: " + sdf.format(endTime));
  }
}
