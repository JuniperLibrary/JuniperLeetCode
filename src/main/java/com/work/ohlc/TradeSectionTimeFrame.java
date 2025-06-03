package com.work.ohlc;

import java.time.*;
import lombok.*;

/**
 * 交易时间段
 */
@Data
public class TradeSectionTimeFrame {

  /**
   * 起始时间
   */
  private Instant beginTime;

  /**
   * 结束时间
   */
  private Instant endTime;

}