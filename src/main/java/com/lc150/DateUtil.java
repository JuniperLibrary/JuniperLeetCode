package com.lc150;


import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 时间工具类
 */
@Slf4j
public class DateUtil {

  private DateUtil() {
  }

  /**
   * 获取明天开始时间
   *
   * @return Date 时间
   */
  public static Date getDateEndTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }
}
