package com.work.ohlc;

import java.time.*;
import java.util.*;
import java.util.concurrent.*;

public class SystemTime {

  // 与本地时钟的偏差
  private static long milliseconds = 0L;

  public static Instant nowInstant() {
    Instant now = Instant.now();
    if (milliseconds == 0) {
      return now;
    }
    return Instant.ofEpochMilli(now.toEpochMilli() + milliseconds);
  }

  public static Date now() {
    Date now = new Date();
    if (milliseconds == 0) {
      return now;
    }
    return new Date(now.getTime() + milliseconds);
  }

  public static long currentTimeMillis() {
    return nowInstant().toEpochMilli();
  }

  public static void set(Date date) {
    milliseconds = date.getTime() - SystemTime.now().getTime();
  }

  public static void setShift(long n, TimeUnit timeUnit) {
    switch (timeUnit) {
      case DAYS:
        milliseconds = n * 24 * 3600 * 1000;
        break;
      case HOURS:
        milliseconds = n * 3600 * 1000;
        break;
    }
  }

  public static long getShift(){
    return milliseconds;
  }
  
}
