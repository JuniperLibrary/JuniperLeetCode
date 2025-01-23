package com.work.indicator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author songyang
 * @date 2024/12/13
 */
@Slf4j
public class ExpUtil {

  public static final String MULTIPLY = "*";
  public static final String ADD = "+";
  public static final String SUBTRACT = "-";
  public static final String DIVIDE = "/";
  public static final String MOD = "%";
  /**
   * 乘方
   */
  public static final String POWER = "^";
  /**
   * 移动平均
   */
  public static final String AVG = "mean";
  /**
   * 方差
   */
  public static final String VARIANCE = "variance";
  /**
   * 开方
   */
  public static final String INDICATOR_BEGIN = "R";
  public static final String CODE_BEGIN = "BOND\\[\\d+\\]\\[[a-zA-Z]+\\]";

  /**
   * 指标集合
   */
  private static final Map<String, ExpInfo> variableMap = new HashMap<>();
  private static final Set<String> constantsToQuery = new HashSet<>();

  private static final Map<String, List<BigDecimal>> resolvedMap = new HashMap<>();

  /**
   * 空值处理集合
   */
  private static final Map<String, SampleTypeEnum> sampleTypeMap = new HashMap<>();

  @Setter
  private static SampleTypeEnum sampleType;

  @Data
  @AllArgsConstructor
  static class ExpInfo {

    String expression;
    SampleTypeEnum sampleType;
  }

  public static void setVariable(String variable, ExpInfo expression) {
    variableMap.put(variable, expression);
  }


  public static Set<String> extractConstants(String expression) {
    constantsToQuery.clear();
    resolveExpression(expression, false, null, 0);
    return constantsToQuery;
  }

  public static BigDecimal calculate(String expression, Map<String, List<BigDecimal>> constants, int i) {
    return resolveExpression(expression, true, constants, i);
  }

  private static BigDecimal resolveExpression(String expression, boolean calculate, Map<String, List<BigDecimal>> constants,
      int i) {
    String replacedExpression = replaceVariables(expression);
    // 提取或替换常量
    if (calculate) {
      replacedExpression = parseExpression(replacedExpression, constants, i);
    } else {
      extractConstantsFromExpression(replacedExpression);
    }

    log.info("resolve exp:{}", replacedExpression);
    // 执行计算
    return calculate ? evaluateExpression(replacedExpression) : null;
  }

  private static String parseExpression(String expression, Map<String, List<BigDecimal>> samples, int i) {
    // 递归解析统计函数
    while (expression.contains(ExpUtil.AVG) || expression.contains(ExpUtil.VARIANCE)) {
      expression = processFunctions(expression, samples, i);
    }
    return replaceConstants(expression, samples, i);
  }

  private static String replaceVariables(String expression) {
    boolean replaceFlag = true;
    while (replaceFlag) {
      replaceFlag = false;
      for (Map.Entry<String, ExpInfo> entry : variableMap.entrySet()) {
        String variable = entry.getKey();
        if (expression.contains(variable)) {
          replaceFlag = true;
          String replacement = entry.getValue().getExpression();
          expression = expression.replace(variable, "(" + replacement + ")");
        }
      }
    }
    return expression;
  }

  private static String processFunctions(String expression, Map<String, List<BigDecimal>> samples, int i) {
    int startIndex = expression.indexOf(ExpUtil.AVG);
    if (startIndex == -1) {
      startIndex = expression.indexOf(ExpUtil.VARIANCE);
    }

    while (startIndex != -1) {
      // 找到函数名和括号范围
      String functionName = expression.startsWith(ExpUtil.AVG, startIndex) ? ExpUtil.AVG : ExpUtil.VARIANCE;
      int openParenIndex = expression.indexOf("(", startIndex);
      int closeParenIndex = findClosingParen(expression, openParenIndex);

      if (closeParenIndex == -1) {
        throw new IllegalArgumentException("Invalid function syntax for: " + functionName);
      }

      // 提取参数并解析
      String parameter = expression.substring(openParenIndex + 1, closeParenIndex);
      BigDecimal result =
          functionName.equals(ExpUtil.AVG) ? calculateMoveAvg(parameter, samples, i) : calculateVariance(parameter, samples, i);

      // 替换函数调用为计算结果
      expression = expression.substring(0, startIndex) + result.toPlainString() +
          expression.substring(closeParenIndex + 1);

      startIndex = expression.indexOf(functionName);
    }
    return expression;
  }

  private static BigDecimal calculateMoveAvg(String parameter, Map<String, List<BigDecimal>> samples, int i) {
    // 解析样本并计算移动平均
    String key = AVG + "(" + parameter + ")";
    if (sampleTypeMap.containsKey(key)) {
      sampleType = sampleTypeMap.get(key);
    }
    List<BigDecimal> values = resolveParameterToSamples(parameter, samples, i);
    List<BigDecimal> list = values.subList(0, i + 1);
    list = handleSampleList(list, sampleType);
    return IndicatorCalculatorUtil.avg(list, 5);
  }

  private static BigDecimal calculateVariance(String parameter, Map<String, List<BigDecimal>> samples, int i) {
    // 解析样本并计算方差
    String key = AVG + "(" + parameter + ")";
    if (variableMap.containsKey(key)) {
      sampleType = variableMap.get(key).getSampleType();
    }
    List<BigDecimal> values = resolveParameterToSamples(parameter, samples, i);
    List<BigDecimal> list = values.subList(0, i + 1);
    list = handleSampleList(list, sampleType);
    return IndicatorCalculatorUtil.variance(list, 5);
  }

  private static List<BigDecimal> handleSampleList(List<BigDecimal> list, SampleTypeEnum sampleType) {
    List<BigDecimal> result = new ArrayList<>(list);
    if (SampleTypeEnum.IGNORE_BLANK.equals(sampleType)) {
      result.removeIf(Objects::isNull);
    }
    if (SampleTypeEnum.ADD_PRE_VALUE.equals(sampleType)) {
      for (int i = 0; i < result.size(); i++) {
        if (result.get(i) == null && i > 0) {
          result.set(i, result.get(i - 1));
        }
      }
    }
    return result;
  }

  private static List<BigDecimal> resolveParameterToSamples(String parameter, Map<String, List<BigDecimal>> constants, int i) {
    if (constants.containsKey(parameter)) {
      return constants.get(parameter);
    } else {
      resolvedMap.putIfAbsent(parameter, new ArrayList<>());
      BigDecimal calculate = calculate(parameter, constants, i);
      log.info("calculate exp:{},result:{}", parameter, calculate);
      resolvedMap.get(parameter).add(calculate);
      return resolvedMap.get(parameter);
    }
  }

  private static int findClosingParen(String expression, int openParenIndex) {
    Stack<Character> stack = new Stack<>();
    for (int i = openParenIndex; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        stack.pop();
        if (stack.isEmpty()) {
          return i;
        }
      }
    }
    return -1;
  }

  private static String replaceConstants(String expression, Map<String, List<BigDecimal>> constants, int i) {
    for (String constant : constantsToQuery) {
      if (!constants.containsKey(constant)) {
        throw new IllegalStateException("Sample values not provided for constant: " + constant);
      } else {
        List<BigDecimal> bigDecimals = constants.get(constant);
        BigDecimal bigDecimal = bigDecimals.get(i);
        if (bigDecimal != null) {
          expression = expression.replace(constant, bigDecimal.toString());
        }
      }
    }
    return expression;
  }

  private static void extractConstantsFromExpression(String expression) {
    // 定义正则匹配规则：BOND[数字][标识符]
    Matcher matcher = Pattern.compile(CODE_BEGIN).matcher(expression);

    while (matcher.find()) {
      String constant = matcher.group(); // 提取完整匹配的常量
      constantsToQuery.add(constant);
    }
  }

  private static BigDecimal evaluateExpression(String expression) {
    Deque<BigDecimal> values = new LinkedList<>();
    Deque<String> operators = new LinkedList<>();
    Deque<Integer> parentheses = new LinkedList<>(); // 记录括号的位置

    StringBuilder token = new StringBuilder();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (Character.isDigit(c) || c == '.') {
        token.append(c);
      } else if (c == '(') {
        // 将当前积累的数字入栈，并记录括号起点
        if (token.length() > 0) {
          values.push(new BigDecimal(token.toString()));
          token.setLength(0);
        }
        parentheses.push(operators.size()); // 标记括号内的运算符数量
      } else if (c == ')') {
        // 将当前积累的数字入栈
        if (token.length() > 0) {
          values.push(new BigDecimal(token.toString()));
          token.setLength(0);
        }

        // 处理括号内的表达式
        int operatorCountInParentheses = operators.size() - parentheses.pop();
        while (operatorCountInParentheses-- > 0) {
          values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
      } else if (isOperator(c)) {
        // 将当前积累的数字入栈
        if (token.length() > 0) {
          values.push(new BigDecimal(token.toString()));
          token.setLength(0);
        }

        // 处理操作符优先级
        while (!operators.isEmpty() && precedence(String.valueOf(c)) <= precedence(operators.peek())) {
          values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
        operators.push(String.valueOf(c));
      }
    }

    // 将剩余的数字入栈
    if (token.length() > 0) {
      values.push(new BigDecimal(token.toString()));
    }

    // 处理栈中的剩余操作符
    while (!operators.isEmpty()) {
      values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
    }

    return values.pop();
  }

  private static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
  }

  private static BigDecimal applyOperator(String operator, BigDecimal b, BigDecimal a) {
    switch (operator) {
      case "+":
        return IndicatorCalculatorUtil.add(a, b);
      case "-":
        return IndicatorCalculatorUtil.subtract(a, b);
      case "*":
        return IndicatorCalculatorUtil.multiply(a, b);
      case "/":
        return IndicatorCalculatorUtil.divide(a, b);
      case "%":
        return IndicatorCalculatorUtil.mod(a, b, 10);
      case "^":
        return IndicatorCalculatorUtil.pow(a, b, 10);
      default:
        throw new IllegalArgumentException("Unsupported operator: " + operator);
    }
  }

  private static int precedence(String operator) {
    switch (operator) {
      case ADD:
      case SUBTRACT:
        return 1;
      case MULTIPLY:
      case DIVIDE:
        return 2;
      default:
        return 0;
    }
  }


  public static void main(String[] args) {
//    System.out.println(IndicatorCalculatorUtil.pow(BigDecimal.valueOf(9), BigDecimal.valueOf(1 / 2), 10));
//    ExpUtil.setVariable("R1", new ExpInfo("R3-4", null));
//    ExpUtil.setVariable("R2", new ExpInfo("R5*R3", null));
//    ExpUtil.setVariable("R3", new ExpInfo("avg(BOND[220210][PRICE])", SampleTypeEnum.IGNORE_BLANK));
//    ExpUtil.setVariable("R5", new ExpInfo("avg(BOND[220210][YIELD])", SampleTypeEnum.ADD_PRE_VALUE));
//    ExpUtil.setVariable("R6", new ExpInfo("R1*R2", null));
//    String exp = "avg(R6)";
//    sampleTypeMap.put("avg(BOND[220210][PRICE])", SampleTypeEnum.IGNORE_BLANK);
//    sampleTypeMap.put("avg(BOND[220210][YIELD])", SampleTypeEnum.ADD_PRE_VALUE);
//    Set<String> constants = extractConstants(exp);
//    System.out.println("Constants to query: " + constants); // 输出: [B1]
//
//    // 合约 净价或者 收益率的值
//    Map<String, List<BigDecimal>> sampleData = new HashMap<>();
//    sampleData.put("BOND[220210][PRICE]",
//        Arrays.asList(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("40"),
//            new BigDecimal("50")));
//    sampleData.put("BOND[220210][YIELD]",
//        Arrays.asList(new BigDecimal("5"), new BigDecimal("10"), new BigDecimal("15"), new BigDecimal("20"),
//            new BigDecimal("25")));
//    ExpUtil.setSampleType(SampleTypeEnum.ADD_PRE_VALUE);
//    for (int i = 0; i < 5; i++) {
//      System.out.println(ExpUtil.calculate(exp, sampleData, i));
//    }

    evaluateExpression("variance(210210,220220).YIELD");
  }
}

