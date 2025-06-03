package com.work.ohlc;

import java.io.*;
import lombok.*;

/**
 * 交易日历详细信息
 * generate with jinja2
 */
@Data
public class TradeCalendarDetail implements Serializable {

  /**
   * id
   */
  private Integer id;

  /**
   * 交易日历id
   */
  private Integer calendarId;

  /**
   * 交易日
   */
  private java.util.Date tradeDate;

  /**
   * 是否夜盘交易
   */
  private Boolean nightTrade;

}