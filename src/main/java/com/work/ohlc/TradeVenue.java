package com.work.ohlc;

import java.io.*;
import lombok.*;

/**
 * 交易场所
 * generate with jinja2
 */
@Data
public class TradeVenue implements Serializable {

  /**
   * id
   */
  private Integer id;

  /**
   * 交易场所代码
   */
  private TradeVenueCode code;

  /**
   * 交易场所名称
   */
  private String name;

  /**
   * 交易场所类型
   */
  private TradeVenueType type;

  /**
   * 交易日历id
   */
  private Integer calendarId;

  /**
   * 交易日历名称
   */
  private String calendarName;

  /**
   * 日切时间
   */
  private String cutoffTime;

  /**
   * 是否夜盘交易
   */
  private Boolean nightTrade;

  /**
   * 有效开始时间
   */
  private java.time.Instant validTimeBegin;

  /**
   * 有效截止时间
   */
  private java.time.Instant validTimeEnd;

}