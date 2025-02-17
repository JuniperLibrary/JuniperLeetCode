package com.work;

import java.util.*;
import java.util.regex.*;

public class FormulaParser {

  public enum OperatorEnum {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, PERCENTAGE, POWER, ROOT
  }

  public static class CustomIndicatorParsedFormula {
    OperatorEnum operator;
    String selectedIndicatorName;
    String targetIndicatorName;

    Integer constantValue;
    String priceType;
  }


  public List<CustomIndicatorParsedFormula> parseFormulas(List<String> formulas) {
    List<CustomIndicatorParsedFormula> parsedFormulas = new ArrayList<>();
    Pattern pattern = Pattern.compile("([A-Za-z0-9]+(?:[.][A-Za-z]+)?)\\s*([+\\-*/%^√])\\s*([A-Za-z0-9]+(?:[.][A-Za-z]+)?)");

    for (String formula : formulas) {
      Matcher matcher = pattern.matcher(formula);
      if (matcher.find()) {
        CustomIndicatorParsedFormula parsedFormula = new CustomIndicatorParsedFormula();
        parsedFormula.selectedIndicatorName = matcher.group(1);
        parsedFormula.operator = getOperatorEnum(matcher.group(2));
        parsedFormula.targetIndicatorName = extractContract(parsedFormula.selectedIndicatorName);

        parsedFormula.priceType = extractPriceType(parsedFormula.selectedIndicatorName);
        parsedFormulas.add(parsedFormula);
      }
    }

    return parsedFormulas;
  }

  private OperatorEnum getOperatorEnum(String operator) {
    switch (operator) {
      case "+": return OperatorEnum.ADD;
      case "-": return OperatorEnum.SUBTRACT;
      case "*": return OperatorEnum.MULTIPLY;
      case "/": return OperatorEnum.DIVIDE;
      case "%": return OperatorEnum.PERCENTAGE;
      case "^": return OperatorEnum.POWER;
      case "ROOT": return OperatorEnum.ROOT;
      default: throw new IllegalArgumentException("Unknown operator: " + operator);
    }
  }

  private String extractContract(String indicator) {
    return indicator.replaceAll("[^0-9]", "");
  }

  private String extractPriceType(String indicator) {
    if (indicator.contains(".PRICE")) {
      return "PRICE";
    } else if (indicator.contains(".YIELD")) {
      return "YIELD";
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    FormulaParser parser = new FormulaParser();
    List<String> formulas = Arrays.asList(
        "220220 + 210210.PRICE",
        "R1 * R2",
        "R1 - R3",
        "R1 / R3",
        "R1 % R3",
        "220220 + 10.YIELD",
        "R3 - 10",
        "220220 * 10.PRICE",
        "220220 / 10.PRICE",
        "210210 ^ 19.PRICE",
        "√(220220, 10).PRICE"
    );

    List<CustomIndicatorParsedFormula> parsedFormulas = parser.parseFormulas(formulas);
    for (CustomIndicatorParsedFormula parsedFormula : parsedFormulas) {
      System.out.println("operator: " + parsedFormula.operator +
          ", selectedIndicatorName: " + parsedFormula.selectedIndicatorName +
          ", targetIndicatorName: " + parsedFormula.targetIndicatorName +
          ", priceType: " + parsedFormula.priceType);
    }
  }
}
