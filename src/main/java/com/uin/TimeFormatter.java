package com.uin;

import lombok.extern.slf4j.*;

@Slf4j
public class TimeFormatter {

  public static String formatTime(int seconds) {
    int hours = seconds / 3600;
    int minutes = (seconds % 3600) / 60;
    int secs = seconds % 60;

    StringBuilder result = new StringBuilder();
    if (hours > 0) {
      result.append(hours).append("小时");
    }
    if (minutes > 0) {
      result.append(minutes).append("分");
    }
    if (secs > 0 || result.length() == 0) {
      result.append(secs).append("秒");
    }

    return result.toString();
  }

  public static void main(String[] args) {
    log.info(formatTime(1));
    log.info(formatTime(61));
    log.info(formatTime(3661));
    log.info(formatTime(3661));
    log.info(formatTime(4999));
  }
}

