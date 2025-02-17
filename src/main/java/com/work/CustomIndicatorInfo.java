package com.work;

import com.work.indicator.*;
import java.io.*;
import java.util.*;
import lombok.*;

@Data
public class CustomIndicatorInfo implements Serializable {

  /**
   * 主键ID
   */
  private Integer id;

  /**
   * 指标名称
   */
  private String indicatorName;

  /**
   * 已选指标名称
   */
  private String selectedIndicatorName;

  /**
   * 公式
   */
  private String formula;

  /**
   * 运算方式
   */
  private IndicatorCalculationMethodEnum calculationMethod;

  /**
   * 运算符
   */
  private OperatorEnum operator;

  /**
   * 价格类型
   */
  private PriceTypeEnum priceType;


  /**
   * 目标指标名称
   */
  private String targetIndicatorName;

  /**
   * 常数
   */
  private Integer constantValue;

  /**
   * 观测值数量
   */
  private Integer observationCount;

  /**
   * 空值处理
   */
  private SampleTypeEnum sampleType;

  /**
   * 是否更新标识
   */
  private Boolean isUpdateFlag;

  /**
   * 已选指标
   */
  private CustomIndicatorInfo leftNode;

  /**
   * 目标指标
   */
  private CustomIndicatorInfo rightNode;

  /**
   * 指标计算结果缓存
   */
  private Map<String, List<IndicatorHistoryDataResponseVO>> cacheIndicatorResult;
}