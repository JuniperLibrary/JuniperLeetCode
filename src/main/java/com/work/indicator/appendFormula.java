package com.work.indicator;

import cn.hutool.core.util.*;
import java.util.regex.*;
import lombok.extern.slf4j.*;

@Slf4j
public class appendFormula {

  public static void main(String[] args) {
    log.info("指标间运算 ：{}",appendFormula("220220", "210210", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.ADD, null, null, PriceTypeEnum.PRICE,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R2", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.MULTIPLY, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.SUBTRACT, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.DIVIDE, null, null, null,null));
    log.info("指标间运算 ：{}",appendFormula("R1", "R3", IndicatorCalculationMethodEnum.INTER_INDICATOR, OperatorEnum.PERCENTAGE, null, null, null,null));

    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.ADD, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("R3", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.SUBTRACT, 10, null, null,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.MULTIPLY, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.DIVIDE, 10, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("210210", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.POWER, 19, null, PriceTypeEnum.PRICE,null));
    log.info("指标与常数运算 :{}",appendFormula("220220", null, IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT, OperatorEnum.ROOT, 10, null, PriceTypeEnum.PRICE,null));


    log.info("移动平均值 :{}",appendFormula("220220", getOrDefault(null, ""), IndicatorCalculationMethodEnum.MEAN, null, null, 6, PriceTypeEnum.PRICE,SampleTypeEnum.IGNORE_BLANK));
    log.info("移动平均值 :{}",appendFormula("R5", getOrDefault(null, ""), IndicatorCalculationMethodEnum.MEAN, null, null, 6, null,SampleTypeEnum.ADD_PRE_VALUE));


    log.info("方差计算 :{}",appendFormula("R5", getOrDefault(null, ""), IndicatorCalculationMethodEnum.VARIANCE, null, null, 6, null,SampleTypeEnum.IGNORE_BLANK));
    log.info("方差计算 :{}",appendFormula("R5", getOrDefault(null, ""), IndicatorCalculationMethodEnum.VARIANCE, null, null, 6, null,SampleTypeEnum.ADD_PRE_VALUE));

    String[] contracts = {
        "FR007_1M", "FR007_3M", "FR007_6M", "FR007_9M", "FR007_3Y",
        "FR007_4Y", "FR007_7Y", "FR007_10Y", "Shibor3M_6M", "Shibor3M_9M",
        "Shibor3M_3Y", "Shibor3M_7Y", "Shibor3M_10Y", "Shibor3M_6M*9M",
        "ShiborO/N_1M", "ShiborO/N_3M", "ShiborO/N_6M", "ShiborO/N_9M"
    };

    for (String contract : contracts) {
      String[] result = extractContractAndPeriod(contract);
      System.out.print("合约: " + result[0] + ", 期限: ");
      String[] periods = result[1].split(" ");
      for (String period : periods) {
        System.out.print(period + " ");
      }
    }


  }

  public static String[] extractContractAndPeriod(String contract) {
    Pattern pattern = Pattern.compile("_(\\d+[A-Za-z]+(?:\\*\\d+[A-Za-z]+)?)");  // 匹配期限部分
    Matcher matcher = pattern.matcher(contract);

    if (matcher.find()) {
      String period = matcher.group(1);  // 获取完整的期限部分
      String[] periods = period.split("\\*");  // 拆分期限部分

      // 去掉期限部分，得到合约名称主体
      String contractName = contract.split("_")[0];
      return new String[] {contractName, String.join(" ", periods)};
    }

    return new String[] {contract, "未找到期限"};  // 如果没有期限部分，返回原合约和提示信息
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
        String format = String.format("%s root %s.%s", selectedIndicatorName, getOrDefault(constantValue, ""),
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
