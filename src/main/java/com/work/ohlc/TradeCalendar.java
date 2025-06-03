package com.work.ohlc;

import java.io.*;
import lombok.*;

/**
 * 交易日历信息
 * generate with jinja2
 */
@Data
public class TradeCalendar implements Serializable {

  /**
   * id
   */
  private Integer id;

  /**
   * 交易日历名称
   */
  private String name;

  /**
   * 时区
   */
  private String timeZone;

  /**
   * 交易日历描述
   */
  private String calendarDesc;

  /**
   * 是否开启冬夏令时
   */
  private Boolean daylightSwitch;

  /**
   * 夏令时时间
   */
  private java.time.Instant summerDaylight;

  /**
   * 夏令时调整类型
   */
  private DaylightShaft summerDaylightShaft;

  /**
   * 夏令时时间增量
   */
  private Integer summerDeltaTime;

  /**
   * 冬令时时间
   */
  private java.time.Instant winterDaylight;

  /**
   * 冬令时调整类型
   */
  private DaylightShaft winterDaylightShaft;

  /**
   * 冬令时时间增量
   */
  private Integer winterDeltaTime;

  /**
   * 是否设置夜盘
   */
  private Boolean nightTradeSwitch;

  /**
   * 多币种假日标识
   */
  private Boolean currencyFlag;

  /**
   * 币种
   */
  private String currency;

}