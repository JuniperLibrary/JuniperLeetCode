package com.work.indicator;

import cn.hutool.core.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class appendFormula {

  public static void main(String[] args) {
    log.info("指标间运算 ：{}",appendFormula("220220", "210210", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.ADD, null, null, PriceTypeEnum.PRICE,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R2", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.MULTIPLY, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.SUBTRACT, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.DIVIDE, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.SUBTRACT, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.PERCENTAGE, null, null, null,null));

    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.ADD, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("R3", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.MULTIPLY, 10, null, null,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.MULTIPLY, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.DIVIDE, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("210210", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.POWER, 19, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.ADD, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.ROOT, 10, null, PriceTypeEnum.PRICE,null));


    log.info("指标与常数运算 :{}",appendFormula("220220", getOrDefault(null, ""), IndicatorCalculationMethodEnum.MEAN, null, null, 6, PriceTypeEnum.PRICE,SampleTypeEnum.IGNORE_BLANK));
    log.info("指标与常数运算 :{}",appendFormula("R5", getOrDefault(null, ""), IndicatorCalculationMethodEnum.MEAN, null, null, 6, null,SampleTypeEnum.ADD_PRE_VALUE));
  }

  public static String appendFormula(String selectedIndicatorId, String targetIndicatorId,
      IndicatorCalculationMethodEnum calculationMethodEnum, OperatorEnum operatorEnum, Integer constantValue,
      Integer observationCount, PriceTypeEnum priceTypeEnum, SampleTypeEnum sampleType) {
    String selectedIndicatorName = selectedIndicatorId;
    String targetIndicatorName = targetIndicatorId;
/*
    // 合约code 和 主键id 理论不会重复
    CustomIndicatorStatisticsEntity selectedIndicator = daoService.getCustomIndicatorNameById(selectedIndicatorId);
    if (ObjectUtil.isNull(selectedIndicator)) {
      // 合约
      selectedIndicatorName = selectedIndicatorId;
    } else {
      // 指标
      selectedIndicatorName = selectedIndicator.getIndicatorName();
    }
    CustomIndicatorStatisticsEntity targetIndicator = null;
    if (ObjectUtil.isNotNull(targetIndicatorId)) {
      targetIndicator = daoService.getCustomIndicatorNameById(targetIndicatorId);
      if (ObjectUtil.isNull(targetIndicator)) {
        // 合约 code
        targetIndicatorName = targetIndicatorId;
      } else {
        targetIndicatorName = targetIndicator.getIndicatorName();
      }
    }*/

    if (IndicatorCalculationMethodEnum.INTER_INDICATOR.equals(calculationMethodEnum)) {
      String format = String.format("%s %s %s.%s", selectedIndicatorName, operatorConverter(operatorEnum),
          getOrDefault(targetIndicatorName, ""), getOrDefault(priceTypeEnum, ""));
      return formatWithOptionalSuffix(format);
    } else if (IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT.equals(calculationMethodEnum)) {
      if (OperatorEnum.POWER.equals(operatorEnum)) {
        String format = String.format("%s ^ %s.%s", selectedIndicatorName, getOrDefault(constantValue, ""),
            getOrDefault(priceTypeEnum, ""));
        return formatWithOptionalSuffix(format);
      } else if (OperatorEnum.ROOT.equals(operatorEnum)) {
        String format = String.format("√(%s, %s).%s", selectedIndicatorName, getOrDefault(constantValue, ""),
            getOrDefault(priceTypeEnum, ""));
        return formatWithOptionalSuffix(format);
      }
      String format = String.format("%s %s %s.%s", selectedIndicatorName, operatorConverter(operatorEnum),
          getOrDefault(constantValue, ""), getOrDefault(priceTypeEnum, ""));
      return formatWithOptionalSuffix(format);
    } else if (IndicatorCalculationMethodEnum.MEAN.equals(calculationMethodEnum)) {
      String format = String.format("mean(%s,%s).%s.%s", selectedIndicatorName, observationCount, getOrDefault(priceTypeEnum, ""),getOrDefault(sampleType,""));
      return formatWithOptionalSuffix(format);
    } else if (IndicatorCalculationMethodEnum.VARIANCE.equals(calculationMethodEnum)) {
      String format = String.format("variance(%s,%s).%s.%s", selectedIndicatorName, observationCount, getOrDefault(priceTypeEnum, ""),getOrDefault(sampleType,""));
      return formatWithOptionalSuffix(format);
    }
    return "";
  }

  public static <T> String getOrDefault(T value, String defaultValue) {
    return value == null ? defaultValue : value.toString();
  }

  private static String formatWithOptionalSuffix(String template) {
    if (template == null || template.isEmpty()) {
      return "";
    }
    String result = template.replaceAll("\\.+", ".");
    if (result.endsWith(".")) {
      result = result.substring(0, result.length() - 1);
    }
    return result;
  }

  public static String operatorConverter(OperatorEnum operatorEnum) {
    if (operatorEnum == null) {
      throw new IllegalArgumentException("OperatorEnum cannot be null");
    }

    switch (operatorEnum) {
      case ADD:
        return "+";
      case SUBTRACT:
        return "-";
      case MULTIPLY:
        return "*";
      case DIVIDE:
        return "/";
      case PERCENTAGE:
        return "%";
      case POWER:
        return "^";
      case ROOT:
        return "√";
      default:
        throw new UnsupportedOperationException("Unknown operator: " + operatorEnum);
    }
  }
}
