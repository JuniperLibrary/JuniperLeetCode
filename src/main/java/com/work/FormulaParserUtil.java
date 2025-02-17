package com.work;


import com.work.indicator.*;
import java.util.regex.*;
import lombok.extern.slf4j.*;


@Slf4j
public class FormulaParserUtil {

  public static CustomIndicatorParsedFormula parseFormulas(String formula,
      IndicatorCalculationMethodEnum indicatorCalculationMethodEnum) {
    CustomIndicatorParsedFormula parsedFormulas = new CustomIndicatorParsedFormula();
    Pattern pattern = Pattern.compile("([A-Za-z0-9]+(?:[.][A-Za-z]+)?)\\s*(root|[+\\-*/%^])\\s*([A-Za-z0-9]+(?:[.][A-Za-z]+)?)");
    // 指标与常数运算 指标或者合约 与 常数的 计算
    if (IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT.equals(indicatorCalculationMethodEnum)) {
      Matcher matcher = pattern.matcher(formula);
      if (matcher.find()) {
        parsedFormulas.setSelectedIndicatorName(matcher.group(1));
        parsedFormulas.setOperator(getOperatorEnum(matcher.group(2)));
        String secondPart = matcher.group(3);
        // 去除 .PRICE 或 .YIELD 后缀
        secondPart = removePriceTypeSuffix(secondPart);
        parsedFormulas.setConstantValue(Integer.valueOf(secondPart));
        parsedFormulas.setPriceType(extractPriceType(formula));
      }
    } else if (IndicatorCalculationMethodEnum.INTER_INDICATOR.equals(indicatorCalculationMethodEnum)) {
      // 存在已选指标或者合约 和 目标指标(或合约)
      Matcher matcher = pattern.matcher(formula);
      if (matcher.find()) {
        parsedFormulas.setSelectedIndicatorName(matcher.group(1));
        parsedFormulas.setOperator(getOperatorEnum(matcher.group(2)));
        String group = matcher.group(3);
        group = removePriceTypeSuffix(group);
        parsedFormulas.setTargetIndicatorName(group);
        parsedFormulas.setPriceType(extractPriceType(formula));
      }
    }
    return parsedFormulas;
  }

  public static OperatorEnum getOperatorEnum(String operator) {
    switch (operator) {
      case "+":
        return OperatorEnum.ADD;
      case "-":
        return OperatorEnum.SUBTRACT;
      case "*":
        return OperatorEnum.MULTIPLY;
      case "/":
        return OperatorEnum.DIVIDE;
      case "%":
        return OperatorEnum.PERCENTAGE;
      case "^":
        return OperatorEnum.POWER;
      case "root":
        return OperatorEnum.ROOT;
      default:
        throw new IllegalArgumentException("Unknown operator: " + operator);
    }
  }

  public static String extractPriceType(String indicator) {
    if (indicator.contains(".PRICE")) {
      return "PRICE";
    } else if (indicator.contains(".YIELD")) {
      return "YIELD";
    } else {
      return null;
    }
  }

  public static String removePriceTypeSuffix(String indicator) {
    if (indicator.contains(".PRICE") || indicator.contains(".YIELD")) {
      return indicator.split("\\.")[0];
    }
    return indicator;
  }

  public static void main(String[] args) {
    log.info("指标间运算 解析公式：{}", parseFormulas("220220 + 210210.PRICE", IndicatorCalculationMethodEnum.INTER_INDICATOR));
    log.info("指标间运算 解析公式：{}", parseFormulas("2R1 * R2", IndicatorCalculationMethodEnum.INTER_INDICATOR));
    log.info("指标间运算 解析公式：{}", parseFormulas("R1 - R3", IndicatorCalculationMethodEnum.INTER_INDICATOR));
    log.info("指标间运算 解析公式：{}", parseFormulas("R1 / R3", IndicatorCalculationMethodEnum.INTER_INDICATOR));

    System.out.println("=================================");
    log.info("指标与常数运算 解析公式：{}", parseFormulas("220220 root 10.PRICE", IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT));
    log.info("指标与常数运算 解析公式：{}", parseFormulas("210210 ^ 19.PRICE", IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT));
    log.info("指标与常数运算 解析公式：{}", parseFormulas("210210 ^ 19.PRICE", IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT));
    log.info("指标与常数运算 解析公式：{}", parseFormulas("220220 + 10.YIELD", IndicatorCalculationMethodEnum.INDICATOR_AND_CONSTANT));
  }
}
