package com.work;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import lombok.*;

/**
 * 行情条目
 * generate with jinja2
 */
@Data
public class MdEntry implements Serializable {

  /**
   * 数量
   */
  private Long size;

  /**
   * SWAP 买单总量
   */
  private Long totalSize;
  /**
   * 价格
   */
  private java.math.BigDecimal price;

  /**
   * 报价方式
   */
  private QuotePrcType quotePrcType;

  /**
   * 对手方编码
   */
  private String provider;

  /**
   * 对手方名称
   */
  private String providerName;

  /**
   * 报价ID
   */
  private String quoteId;

  /**
   * 报价时间
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "GMT+8")
  private java.time.Instant quoteTime;

  /**
   * 清算速度
   */
  private SettleType settleType;

  /**
   * 实时承接标识
   */
  private RealTimeTakeOver realTimeTakeOver;

  /**
   * 收益率
   */
  private java.math.BigDecimal yield;

  /**
   * 清算类型
   */
  private ClearMethod clearMethod;

  /**
   * 结算方式
   */
  private DeliveryType deliveryType;

  /**
   * 数据源
   */
  private String dataSource;

  /**
   * 行情发送时间
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "GMT+8")
  private java.time.Instant sourceTime;

  /**
   * 原始价格档位
   */
  private Integer orgPriceLevel;

}